package br.com.ismyburguer.cliente.web.api;


import br.com.ismyburguer.cliente.adapter.interfaces.in.ConsultarClienteUseCase;
import br.com.ismyburguer.cliente.web.api.converter.BuscarClienteConverter;
import br.com.ismyburguer.cliente.web.api.response.BuscarClienteResponse;
import br.com.ismyburguer.core.adapter.in.WebAdapter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Cliente", description = "Gerenciamento de Clientes")
@WebAdapter
@RequestMapping("/clientes")
public class BuscarClienteAPI {
    private final ConsultarClienteUseCase consultarClienteUseCase;
    private final BuscarClienteConverter buscarClienteConverter;

    public BuscarClienteAPI(ConsultarClienteUseCase consultarClienteUseCase,
                            BuscarClienteConverter buscarClienteConverter) {
        this.consultarClienteUseCase = consultarClienteUseCase;
        this.buscarClienteConverter = buscarClienteConverter;
    }

    @Operation(method = "Consultar Cliente por Email", description = "Consultar Cliente por Email")
    @GetMapping("/email/{email}")
    public BuscarClienteResponse obterCliente(@PathVariable(name = "email") String email) {
        return buscarClienteConverter.convert(consultarClienteUseCase.buscar(new ConsultarClienteUseCase.ConsultaCliente(email)));
    }

    @Operation(method = "Consultar Cliente por Email", description = "Consultar Cliente por Email")
    @GetMapping("/{clienteId}")
    public BuscarClienteResponse obterClientePorId(@PathVariable(name = "clienteId") String clienteId) {
        return buscarClienteConverter.convert(consultarClienteUseCase.buscarPorId(new ConsultarClienteUseCase.ConsultaClientePorId(clienteId)));
    }

}
