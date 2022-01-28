package br.com.alura.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.alura.model.entity.Despesa;
import br.com.alura.repository.DespesaRepository;


@Service
public class DespesaService {

	
	@Autowired
	private DespesaRepository _despesaRepo;
	
	
	// READ ALL
	public ResponseEntity<?> readAll(Pageable paginacao) {
		Page<Despesa> despesas = _despesaRepo.findAll(paginacao);
		return new ResponseEntity<>(despesas, HttpStatus.OK);
	}
	
	
	// CREATE ONE
	public ResponseEntity<?> createOne(Despesa despesa) {
		try {
			return new ResponseEntity<>(_despesaRepo.save(despesa), HttpStatus.CREATED);
		} catch(Exception err) {
			return new ResponseEntity<>("Fail: \n" + err.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	// READ ONE
	public ResponseEntity<?> readOne(Long despesaId) {
		Optional<Despesa> despesa = _despesaRepo.findById(despesaId);
		if(despesa.isPresent()) {
			return new ResponseEntity<>(despesa.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("DespesaID "+despesaId+" Not Found!", HttpStatus.NOT_FOUND);
		}
	}
	
	
	// UPDATE ONE
	public ResponseEntity<?> updateOne(Long despesaId, Despesa novaDespesa) {
		Optional<Despesa> despesa = _despesaRepo.findById(despesaId);
		if(despesa.isPresent()) {
			try {
				// update ...
				return new ResponseEntity<>("", HttpStatus.OK);
			} catch(Exception err) {
				return new ResponseEntity<>("Fail: \n" + err.getMessage(), HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<>("DespesaID "+despesaId+" Not Found!", HttpStatus.NOT_FOUND);
		}
	}
	
	
	// DELETE ONE
	public ResponseEntity<?> deleteOne(Long despesaId) {
		Optional<Despesa> despesa = _despesaRepo.findById(despesaId);
		if(despesa.isPresent()) {
			try {
				_despesaRepo.delete(despesa.get());
				return new ResponseEntity<>(despesa.get(), HttpStatus.OK);
			} catch(Exception err) {
				return new ResponseEntity<>("Fail: \n" + err.getMessage(), HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<>("DespesaID "+despesaId+" Not Found!", HttpStatus.NOT_FOUND);
		}
	}
	
	
}
