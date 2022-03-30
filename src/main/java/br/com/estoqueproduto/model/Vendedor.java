package br.com.estoqueproduto.model;

import br.com.estoqueproduto.model.dto.VendedorDTO;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table
public class Vendedor {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	@Column(name = "id")
	public Long id;

	@Column(nullable = false)
	public String nome;

	@ManyToMany
	@JoinTable(name = "vendedor_produto",
			joinColumns = {@JoinColumn(name = "vendedor_id")},
			inverseJoinColumns = {@JoinColumn(name = "produto_id")})
	public Set<Product> produtos = new HashSet<>();


	public VendedorDTO toDTO() {
		return VendedorDTO.builder()
				.id(id)
				.nome(nome)
				.produtos(produtos)
				.build();
	}
}
