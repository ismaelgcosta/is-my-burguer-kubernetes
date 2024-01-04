package br.com.ismyburguer.pedido.ports.in;

import br.com.ismyburguer.pedido.domain.model.Pedido;

public interface FecharPedidoUseCase {
    void fechar(Pedido.PedidoId pedidoId);
}
