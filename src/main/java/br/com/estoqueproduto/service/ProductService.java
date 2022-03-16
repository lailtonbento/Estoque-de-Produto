package br.com.estoqueproduto.service;


import br.com.estoqueproduto.exception.ProductNotFoundException;
import br.com.estoqueproduto.model.Product;
import br.com.estoqueproduto.model.dto.ProductDTO;
import br.com.estoqueproduto.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductService {

	private final ProductRepository productRepository;

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
	private void existsById(Long id) {
		if (!productRepository.existsById(id)) {
			throw new ProductNotFoundException(id);
		}
	}

}
