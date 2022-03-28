package br.com.estoqueproduto.model.dto;


import br.com.estoqueproduto.model.Vendedor;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VendedorDTO {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@NotBlank(message = "Nome do vendedor é necessário.")
	public String nome;


	public Vendedor toEntity() {
		return Vendedor.builder()
				.id(id)
				.nome(nome)
				.build();
	}

}
