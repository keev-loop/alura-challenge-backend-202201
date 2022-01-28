package br.com.alura.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.alura.model.entity.Receita;
import br.com.alura.repository.ReceitaRepository;


@Service
public class ReceitaService {

	@Autowired
	private ReceitaRepository _receitaRepo;
	
	
	// READ ALL
	public ResponseEntity<Page<Receita>> readAll(Pageable paginacao) {
		Page<Receita> receitas = _receitaRepo.findAll(paginacao);
		return new ResponseEntity<Page<Receita>>(receitas, HttpStatus.OK);
	}
	
	
	// CREATE ONE
	public ResponseEntity<?> createOne(Receita receita) {
		try {
			return new ResponseEntity<>(_receitaRepo.save(receita), HttpStatus.CREATED);
		} catch(Exception err) {
			return new ResponseEntity<>("Fail: \n" + err.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	// READ ONE
	public ResponseEntity<?> readOne(Long receitaId) {
		Optional<Receita> receita = _receitaRepo.findById(receitaId);
		if(receita.isPresent()) {
			return new ResponseEntity<>(receita.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("ReceitaID "+receitaId+" Not Found!", HttpStatus.NOT_FOUND);
		}
	}
	
	
	// UPDATE ONE
	public ResponseEntity<?> updateOne(Long receitaId, Receita novaReceita) {
		Optional<Receita> receita = _receitaRepo.findById(receitaId);
		if(receita.isPresent()) {
			try {
				// update ...
				return new ResponseEntity<>("", HttpStatus.OK);
			} catch(Exception err) {
				return new ResponseEntity<>("Fail: \n" + err.getMessage(), HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<>("ReceitaID "+receitaId+" Not Found!", HttpStatus.NOT_FOUND);
		}
	}
	
	
	// DELETE ONE
	public ResponseEntity<?> deleteOne(Long receitaId) {
		Optional<Receita> receita = _receitaRepo.findById(receitaId);
		if(receita.isPresent()) {
			try {
				_receitaRepo.delete(receita.get());
				return new ResponseEntity<>(receita.get(), HttpStatus.OK);
			} catch(Exception err) {
				return new ResponseEntity<>("Fail: \n" + err.getMessage(), HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<>("ReceitaID "+receitaId+" Not Found!", HttpStatus.NOT_FOUND);
		}
	}

	
}
