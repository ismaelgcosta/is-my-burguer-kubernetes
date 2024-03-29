package br.com.ismyburguer.pedido.usecase.impl;

import br.com.ismyburguer.pedido.entity.Pedido;
import br.com.ismyburguer.pedido.adapter.interfaces.in.CadastrarPedidoUseCase;
import br.com.ismyburguer.pedido.gateway.out.CadastrarPedidoRepository;
import br.com.ismyburguer.core.usecase.UseCase;
import br.com.ismyburguer.pedido.usecase.validation.PedidoValidator;
import jakarta.validation.Valid;

import java.util.UUID;

@UseCase
public class CadastrarPedidoUseCaseImpl implements CadastrarPedidoUseCase {
    private final CadastrarPedidoRepository repository;
    private final PedidoValidator validator;

    public CadastrarPedidoUseCaseImpl(CadastrarPedidoRepository repository, PedidoValidator validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public UUID cadastrar(@Valid Pedido pedido) {
        validator.validate(null, pedido);
        return repository.salvarPedido(pedido);
    }
}
