package br.com.estoque_de_produto.model;



import br.com.estoque_de_produto.model.dto.ProductDTO;
import lombok.*;

import javax.persistence.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produtos")
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String revendedor;

    public ProductDTO toDTO(){
        return ProductDTO.builder()
                .id(id)
                .marca(marca)
                .nome(nome)
                .revendedor(revendedor)
                .build();
    }



}
