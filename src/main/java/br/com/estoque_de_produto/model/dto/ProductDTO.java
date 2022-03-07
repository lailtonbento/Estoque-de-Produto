package br.com.estoque_de_produto.model.dto;


import br.com.estoque_de_produto.model.Product;
import lombok.*;

import javax.validation.constraints.NotBlank;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    public Long id;

    @NotBlank(message = "Nome do produto é necessário.")
    public String nome;


    @NotBlank(message = "Nome da marca é necessário.")
    public String marca;


    @NotBlank(message = "Nome do revendedor é necessário.")
    public String revendedor;


    public Product toEntity(){
        return Product.builder()
                .id(id)
                .marca(marca)
                .nome(nome)
                .revendedor(revendedor)
                .build();
    }



}
