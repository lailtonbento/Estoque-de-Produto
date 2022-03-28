package br.com.estoqueproduto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class VendedorNotFoundException extends Exception {

	public VendedorNotFoundException(Long id) {
		super("Vendedor não encontrado com ID" + id);
	}

	public VendedorNotFoundException(String ids) {
		super("ID de vendedor não encontrado" + ids);
	}
}
