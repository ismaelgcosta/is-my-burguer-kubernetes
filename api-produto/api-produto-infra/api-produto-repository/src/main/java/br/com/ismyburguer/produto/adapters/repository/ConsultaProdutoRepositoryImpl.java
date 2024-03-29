package br.com.ismyburguer.produto.adapters.repository;

import br.com.ismyburguer.core.adapter.out.PersistenceAdapter;
import br.com.ismyburguer.produto.adapters.converter.ProdutoEntityToProdutoConverter;
import br.com.ismyburguer.produto.adapters.model.ProdutoModel;
import br.com.ismyburguer.produto.entity.Produto;
import br.com.ismyburguer.produto.gateway.out.ConsultaProdutoRepository;

import java.util.Optional;
import java.util.UUID;

@PersistenceAdapter
public class ConsultaProdutoRepositoryImpl implements ConsultaProdutoRepository {
    private final ProdutoRepository produtoRepository;
    private final ProdutoEntityToProdutoConverter converter;

    public ConsultaProdutoRepositoryImpl(ProdutoRepository produtoRepository,
                                         ProdutoEntityToProdutoConverter converter) {
        this.produtoRepository = produtoRepository;
        this.converter = converter;
    }

    @Override
    public Optional<Produto> obterPeloProdutoId(UUID produtoId) {
        Optional<ProdutoModel> produtoEntity = produtoRepository.findByProdutoIdAndAtivo(produtoId, true);
        return produtoEntity.map(converter::convert);
    }

    @Override
    public boolean existsById(UUID produtoId) {
        return produtoRepository.existsByProdutoIdAndAtivo(produtoId, true);
    }

}
