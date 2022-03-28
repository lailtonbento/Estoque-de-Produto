package br.com.estoqueproduto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception {

	public ProductNotFoundException(Long id) {
		super("Produto não encontrado com ID" + id);
	}

	public ProductNotFoundException(String ids) {
		super("ID de produto não encontrado" + ids);
	}
}
