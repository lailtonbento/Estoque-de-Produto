package br.com.estoqueproduto.model;


import br.com.estoqueproduto.model.dto.ProductDTO;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "produto")
@Builder
public class Product {

	@ManyToMany(mappedBy = "produtos")
	public Set<Vendedor> vendedores = new HashSet<>();


	private String nome;

	@Column(nullable = false)
	private String marca;

	@Column(nullable = false)
	private String revendedor;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produto_id")
	private Long id;

	public ProductDTO toDTO() {
		return ProductDTO.builder()
				.id(id)
				.marca(marca)
				.nome(nome)
				.revendedor(revendedor)
				.vendedores(vendedores)
				.build();
	}


}
