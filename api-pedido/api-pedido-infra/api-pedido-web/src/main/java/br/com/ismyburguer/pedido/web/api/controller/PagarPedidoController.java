package br.com.ismyburguer.pedido.web.api.controller;


import br.com.ismyburguer.core.adapter.in.WebAdapter;
import br.com.ismyburguer.pedido.entity.Pedido;
import br.com.ismyburguer.pedido.adapter.interfaces.in.PagarPedidoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hibernate.validator.constraints.UUID;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pedido", description = "Gerenciamento de Pedidos")
@WebAdapter
@RequestMapping("/pedidos")
public class PagarPedidoController {
    private final PagarPedidoUseCase useCase;

    public PagarPedidoController(PagarPedidoUseCase useCase) {
        this.useCase = useCase;
    }

    @Operation(description = "Pagar Pedido")
    @PutMapping("/{pedidoId}/pagamento")
    public String pagarPedido(
            @PathVariable @Valid @UUID(message = "O código do pedido informado está num formato inválido") String pedidoId
    ) {
        return useCase.pagar(new Pedido.PedidoId(pedidoId));
    }

}
