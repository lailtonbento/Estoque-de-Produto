package br.com.estoqueproduto.repository;

import br.com.estoqueproduto.model.Vendedor;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

	boolean existsById(Long id);

	boolean existsByIds(Collection<Long> ids);
}
