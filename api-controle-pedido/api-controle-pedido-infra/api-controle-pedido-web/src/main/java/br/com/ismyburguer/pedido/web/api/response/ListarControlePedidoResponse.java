package br.com.ismyburguer.pedido.web.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListarControlePedidoResponse {

    private String pedidoId;
    private String status;
    private LocalDateTime recebidoEm;
    private LocalDateTime inicioDaPreparacao;
    private LocalDateTime fimDaPreparacao;

}
