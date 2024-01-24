package br.com.ismyburguer.pagamento.adapter.repository;

import br.com.ismyburguer.pagamento.adapter.model.PagamentoModel;
import br.com.ismyburguer.core.adapter.out.PersistenceDriver;
import br.com.ismyburguer.pagamento.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

@PersistenceDriver
public interface PagamentoRepository extends JpaRepository<PagamentoModel, UUID> {

    List<Pagamento> findAllByStatusPagamento(Pagamento.StatusPagamento statusPagamento);
}
