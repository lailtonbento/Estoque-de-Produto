package br.com.Estoquedeproduto.model.dto;


import br.com.Estoquedeproduto.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    public Long id;

    @NotBlank(message = "Nome do produto é necessário.")
    private String nome;


    @NotBlank(message = "Nome da marca é necessário.")
    private String marca;


    @NotBlank(message = "Nome do revendedor é necessário.")
    private String revendedor;



    public static ProductDTO convertToDto(Product product) {
        return ProductDTO.builder()
                .nome(product.getNome())
                .marca(product.getMarca())
                .revendedor(product.getRevendedor())
                .build();
    }
}
