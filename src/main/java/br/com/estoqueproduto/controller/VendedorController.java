package br.com.estoqueproduto.controller;


import br.com.estoqueproduto.model.dto.VendedorDTO;
import br.com.estoqueproduto.service.VendedorService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/vendedores")
@RequiredArgsConstructor
@CrossOrigin
public class VendedorController {

	private final VendedorService vendedorService;

	@GetMapping
	public ResponseEntity<Page<VendedorDTO>> findAllPageable(
			@PageableDefault(sort = {"nome"}) Pageable pageable) {
		return ResponseEntity.ok(vendedorService.findAllPageable(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<VendedorDTO> findById(@PathVariable Long id) {
		return ResponseEntity.ok(vendedorService.findById(id));
	}


	@PutMapping("/{id}")
	public VendedorDTO update(@PathVariable Long id, @Valid @RequestBody VendedorDTO vendedorDTO) {
		return vendedorService.update(id, vendedorDTO);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public VendedorDTO save(@Valid @RequestBody VendedorDTO vendedorDTO) {
		return vendedorService.createVendedor(vendedorDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) {
		vendedorService.deleteById(id);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteByIds(@RequestParam Long[] ids) {
		vendedorService.deleteByIds(ids);
	}

}
