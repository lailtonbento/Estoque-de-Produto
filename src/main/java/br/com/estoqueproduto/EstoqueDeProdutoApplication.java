package br.com.estoqueproduto;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EstoqueDeProdutoApplication {
	public static void main(String[] args) {
		SpringApplication.run(EstoqueDeProdutoApplication.class, args);


		//@Bean
		//public ApplicationRunner init(ProductRepository productRepository) {
		//	return args -> productRepository.saveAll(Arrays.asList(
		//			Product.builder()
		//		.nome("Monitor FullHD 24pol 244hz")
		//					.marca("LG")
		//					.revendedor("Marcinho")
		//				.vendedores(new HashSet<>())
		//					.build()
		//	));
	}

}
