package br.com.estoqueproduto.controller;

import br.com.estoqueproduto.model.dto.ProductDTO;
import br.com.estoqueproduto.service.ProductService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/v1/produtos")
@RestController
@RequiredArgsConstructor
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public ResponseEntity<Page<ProductDTO>> findAllPageable(
			@PageableDefault(page = 0, sort = {"nome"}) Pageable pageable) {
		return ResponseEntity.ok(productService.findAll(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(productService.findById(id));
	}


	@PutMapping("/{id}")
	public ProductDTO update(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
		return productService.update(id, productDTO);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ProductDTO save(@Valid @RequestBody ProductDTO productDTO) {
		return productService.createProduct(productDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		productService.deleteById(id);
	}


}
