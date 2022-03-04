package br.com.Estoquedeproduto.controller;

import br.com.Estoquedeproduto.exception.ProductNotFoundException;
import br.com.Estoquedeproduto.model.Product;

import br.com.Estoquedeproduto.model.dto.ProductDTO;
import br.com.Estoquedeproduto.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/produtos")
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<Page<Product>> GetProductByNameContains(
            @PageableDefault(page = 1, size = 10, sort = {"nome"}) Pageable pageable, String nome) {
        return ResponseEntity.ok(productService.getProductByNameContains(pageable, nome));

    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping()
    public List<ProductDTO> findAll(){
        return productService.findAll();
    }

    @PutMapping("/{id}")
    public ProductDTO update (@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) throws ProductNotFoundException {
        return  productService.update(id, productDTO);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductDTO save(@Valid @RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById (@PathVariable Long id) throws ProductNotFoundException {
        productService.deleteById(id);
    }





}
