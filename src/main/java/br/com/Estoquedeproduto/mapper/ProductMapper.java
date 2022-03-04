package br.com.Estoquedeproduto.mapper;


import br.com.Estoquedeproduto.model.Product;

import br.com.Estoquedeproduto.model.dto.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO converToDto (Product product);
    Product convertToModel (ProductDTO getProductDTO);
}
