package br.com.ismyburguer.pedido.web.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BuscarPedidoResponse {

    private String pedidoId;
    private String clienteId;
    private List<BuscarItemPedidoResponse> itens;
    private String status;
    private BigDecimal valorTotal;

}
