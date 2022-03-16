package br.com.estoqueproduto.model;


import br.com.estoqueproduto.model.dto.ProductDTO;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

	public ProductDTO toDTO() {
		return ProductDTO.builder()
				.id(id)
				.marca(marca)
				.nome(nome)
				.revendedor(revendedor)
				.build();
	}


}
