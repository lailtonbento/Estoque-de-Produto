package br.com.estoqueproduto.model.dto;


import br.com.estoqueproduto.model.Product;
import br.com.estoqueproduto.model.Vendedor;
import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendedorDTO {

	public Long id;

	@NotBlank(message = "Nome do vendedor é necessário.")
	public String nome;


	public Set<Product> produtos = new HashSet<>();

	public Vendedor toEntity() {
		return Vendedor.builder()
				.id(id)
				.nome(nome)
				.produtos(produtos)
				.build();
	}

}
