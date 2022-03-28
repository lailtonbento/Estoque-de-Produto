package br.com.estoqueproduto.model;

import br.com.estoqueproduto.model.dto.VendedorDTO;
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
	public Long id;

	@Column(nullable = false)
	public String nome;


	public VendedorDTO toDTO() {
		return VendedorDTO.builder()
				.id(id)
				.nome(nome)
				.build();
	}
}
