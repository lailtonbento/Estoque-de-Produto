package br.com.estoque_de_produto.service;


import br.com.estoque_de_produto.exception.ProductNotFoundException;
import br.com.estoque_de_produto.model.Product;
import br.com.estoque_de_produto.model.dto.ProductDTO;
import br.com.estoque_de_produto.repository.ProductRepository;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductService {


    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public Page<ProductDTO> findAll(Pageable pageable) {
        return productRepository.findAll(pageable).map(Product::toDTO);
    }

    public ProductDTO createProduct(ProductDTO productDto) {
        return productRepository.save(productDto.toEntity()).toDTO();

    }

    @SneakyThrows
    public ProductDTO findById(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id))
                .toDTO();
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {
        existsById(id);
        productDTO.id = id;
        return productRepository.save(productDTO.toEntity()).toDTO();
    }

    public void deleteById(Long id) {
        existsById(id);
        productRepository.deleteById(id);

    }

    @SneakyThrows
    public boolean existsById(Long id) {
        if (productRepository.existsById(id)) {
            return true;
        }
        throw new ProductNotFoundException(id);
    }


}
