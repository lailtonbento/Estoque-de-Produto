package br.com.estoque_de_produto;



import br.com.estoque_de_produto.model.Product;
import br.com.estoque_de_produto.repository.ProductRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


@SpringBootApplication
public class EstoqueDeProdutoApplication {
    public static void main(String[] args) {
        SpringApplication.run(EstoqueDeProdutoApplication.class, args);




    }
    @Bean
    public ApplicationRunner init(ProductRepository productRepository){
        return args -> productRepository.saveAll(Arrays.asList(
                Product.builder()
                        .nome("Monitor FullHD 24pol 244hz")
                        .marca("LG")
                        .revendedor("Marcinho")
                        .build()
        ));
    }

}
