package br.com.ismyburguer.pagamento.adapter.repository;

import br.com.ismyburguer.pagamento.adapter.model.PagamentoModel;
import br.com.ismyburguer.core.adapter.out.PersistenceDriver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@PersistenceDriver
public interface PagamentoRepository extends JpaRepository<PagamentoModel, UUID> {
}
