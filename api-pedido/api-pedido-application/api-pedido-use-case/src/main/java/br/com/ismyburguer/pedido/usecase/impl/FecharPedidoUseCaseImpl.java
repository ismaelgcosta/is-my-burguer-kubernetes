package br.com.ismyburguer.pedido.usecase.impl;

import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pedido.domain.model.Pedido;
import br.com.ismyburguer.pedido.ports.in.AlterarStatusPedidoUseCase;
import br.com.ismyburguer.pedido.ports.in.FecharPedidoUseCase;

@UseCase
public class FecharPedidoUseCaseImpl implements FecharPedidoUseCase {
    private final AlterarStatusPedidoUseCase pedidoUseCase;

    public FecharPedidoUseCaseImpl(AlterarStatusPedidoUseCase pedidoUseCase) {
        this.pedidoUseCase = pedidoUseCase;
    }

    @Override
    public void fechar(Pedido.PedidoId pedidoId) {
        pedidoUseCase.alterar(pedidoId, Pedido.StatusPedido.FECHADO);
    }
}
