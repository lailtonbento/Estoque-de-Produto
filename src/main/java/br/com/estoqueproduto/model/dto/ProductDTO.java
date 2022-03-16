package br.com.estoqueproduto.model.dto;


import br.com.estoqueproduto.model.Product;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


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


	public Product toEntity() {
		return Product.builder()
				.id(id)
				.marca(marca)
				.nome(nome)
				.revendedor(revendedor)
				.build();
	}


}
