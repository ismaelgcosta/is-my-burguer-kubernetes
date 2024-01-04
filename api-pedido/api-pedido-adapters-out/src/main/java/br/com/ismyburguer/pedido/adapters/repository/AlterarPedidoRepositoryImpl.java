package br.com.ismyburguer.pedido.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.core.exception.EntityNotFoundException;
import br.com.ismyburguer.pedido.adapters.converter.PedidoToPedidoEntityConverter;
import br.com.ismyburguer.pedido.adapters.entity.PedidoEntity;
import br.com.ismyburguer.pedido.adapters.entity.StatusPedidoEntity;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.out.AlterarPedidoRepository;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.UUID;

@Validated
@PersistenceAdapter
public class AlterarPedidoRepositoryImpl implements AlterarPedidoRepository {
    private final PedidoRepository pedidoRepository;
    private final PedidoToPedidoEntityConverter converter;

    public AlterarPedidoRepositoryImpl(PedidoRepository pedidoRepository,
                                        PedidoToPedidoEntityConverter converter) {
        this.pedidoRepository = pedidoRepository;
        this.converter = converter;
    }

    public void alterarPedido(String pedidoId, @Valid Pedido pedido) {
        UUID uuid = UUID.fromString(pedidoId);
        Optional<PedidoEntity> entity = pedidoRepository.findById(uuid);
        if(entity.isEmpty()) {
            throw new EntityNotFoundException("Pedido não foi encontrado");
        }
        PedidoEntity oldEntity = entity.get();
        oldEntity.limparItens();
        pedido.alterarStatus(entity.map(PedidoEntity::getStatusPedido).map(StatusPedidoEntity::name).map(Pedido.StatusPedido::valueOf).get());
        pedidoRepository.save(oldEntity);

        PedidoEntity pedidoEntity = converter.convert(pedido);
        pedidoEntity.setPedidoId(uuid);
        pedidoRepository.save(pedidoEntity);
    }
}
