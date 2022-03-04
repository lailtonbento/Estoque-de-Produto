package br.com.Estoquedeproduto.service;


import br.com.Estoquedeproduto.exception.ProductNotFoundException;
import br.com.Estoquedeproduto.mapper.ProductMapper;
import br.com.Estoquedeproduto.model.Product;

import br.com.Estoquedeproduto.model.dto.ProductDTO;
import br.com.Estoquedeproduto.repository.ProductRepository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getProductByNameContains(Pageable pageable, String nome) {

        if (nome == null) {
            return productRepository.findAll(pageable);
        }
        return productRepository.findAllByNameContains(pageable, nome);
    }

    public List<ProductDTO> findAll() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(productMapper::converToDto)
                .collect(Collectors.toList());
    }

    public ProductDTO createProduct(ProductDTO productDto) {
        Product productSave = productMapper.convertToModel(productDto);
        Product savedProduct = productRepository.save(productSave);

        return productMapper.converToDto(savedProduct);
    }

    public ProductDTO findById(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id);
        }
        return productMapper.converToDto(optionalProduct.get());
    }


    public ProductDTO update(Long id, ProductDTO productDTO) throws ProductNotFoundException {
        verifyIfExists(id);
        productDTO.setId(id);
        Product saveProduct = productMapper.convertToModel(productDTO);
        Product savedProduct = productRepository.save(saveProduct);
        return productMapper.converToDto(savedProduct);
    }

    public void deleteById(Long id) throws ProductNotFoundException {
        verifyIfExists(id);
        productRepository.deleteById(id);
    }


    private Product verifyIfExists(Long id) throws ProductNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }


}
