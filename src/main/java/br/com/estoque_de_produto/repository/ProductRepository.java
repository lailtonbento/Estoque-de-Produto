package br.com.estoque_de_produto.repository;

import br.com.estoque_de_produto.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   // @Query("SELECT Product from Product where Product.id = ?1")
    // Product findById(Long id);

    // Caso seja optado por usar @query (apenas um exemplo para estudar querys)

    // @Query(value = "EXISTS (SELECT * from produtos where produtos.id = ?1)", nativeQuery = true)
    boolean existsById(Long id);

}
