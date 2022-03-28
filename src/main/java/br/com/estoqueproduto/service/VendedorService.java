package br.com.estoqueproduto.service;


import br.com.estoqueproduto.exception.VendedorNotFoundException;
import br.com.estoqueproduto.model.Vendedor;
import br.com.estoqueproduto.model.dto.VendedorDTO;
import br.com.estoqueproduto.repository.VendedorRepository;
import java.util.Arrays;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class VendedorService {

	private final VendedorRepository vendedorRepository;

	public Page<VendedorDTO> findAllPageable(Pageable pageable) {
		return vendedorRepository.findAll(pageable).map(Vendedor::toDTO);
	}

	public VendedorDTO createVendedor(VendedorDTO vendedorDTO) {
		return vendedorRepository.save(vendedorDTO.toEntity()).toDTO();
	}

	@SneakyThrows
	public VendedorDTO findById(Long id) {
		return vendedorRepository
				.findById(id)
				.orElseThrow(() -> new VendedorNotFoundException(id))
				.toDTO();
	}

	public VendedorDTO update(Long id, VendedorDTO vendedorDTO) {
		existsById(id);
		vendedorDTO.id = id;
		return vendedorRepository.save(vendedorDTO.toEntity()).toDTO();
	}

	public void deleteById(Long id) {
		existsById(id);
		vendedorRepository.deleteById(id);
	}

	@SneakyThrows
	private void existsById(Long id) {
		if (!vendedorRepository.existsById(id)) {
			throw new VendedorNotFoundException(id);
		}
	}

	@SneakyThrows
	private void existsByIds(Long[] ids) {
		if (!vendedorRepository.existsByIds(Arrays.stream(ids).collect(Collectors.toList()))) {
			throw new VendedorNotFoundException(Arrays.stream(ids).map(String::valueOf).collect(Collectors.joining(", ")));
		}
	}


	public void deleteByIds(Long[] ids) {
		existsByIds(ids);
		vendedorRepository.deleteAllById(Arrays.stream(ids).collect(Collectors.toList()));
	}


}
