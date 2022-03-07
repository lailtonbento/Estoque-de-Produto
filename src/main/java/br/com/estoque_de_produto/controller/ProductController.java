package br.com.estoque_de_produto.controller;

import br.com.estoque_de_produto.model.dto.ProductDTO;
import br.com.estoque_de_produto.service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/api/v1/produtos")
@RestController
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

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
