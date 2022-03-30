package br.com.estoqueproduto;


import br.com.estoqueproduto.model.Product;
import br.com.estoqueproduto.repository.ProductRepository;
import java.util.Arrays;
import java.util.HashSet;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EstoqueDeProdutoApplication {
	public static void main(String[] args) {
		SpringApplication.run(EstoqueDeProdutoApplication.class, args);


	}

	@Bean
	public ApplicationRunner init(ProductRepository productRepository) {
		return args -> productRepository.saveAll(Arrays.asList(
				Product.builder()
						.nome("Monitor FullHD 24pol 244hz")
						.marca("LG")
						.revendedor("Marcinho")
						.vendedores(new HashSet<>())
						.build()
		));
	}

}
