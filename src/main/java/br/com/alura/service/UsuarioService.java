package br.com.alura.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.alura.model.entity.Usuario;
import br.com.alura.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository _usuarioRepo;

	
	// READ ALL
	public ResponseEntity<Page<Usuario>> readAll(Pageable paginacao) {
		return new ResponseEntity<Page<Usuario>>(_usuarioRepo.findAll(paginacao), HttpStatus.OK);
	}
	
	
	// CREATE ONE
	public ResponseEntity<?> createOne(Usuario usuario) {
		try {
			return new ResponseEntity<>(_usuarioRepo.save(usuario), HttpStatus.CREATED);
		} catch(Exception err) {
			return new ResponseEntity<>("Fail: \n" + err.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	
	// READ ONE
	public ResponseEntity<?> readOne(Long usuarioId) {
		Optional<Usuario> usuario = _usuarioRepo.findById(usuarioId);
		if(usuario.isPresent()) {
			return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("UsuarioID "+usuarioId+"Not Found!", HttpStatus.NOT_FOUND);
		}
	}
	
	
	// UPDATE ONE
	public ResponseEntity<?> updateOne(Long usuarioId, Usuario novaUsuario) {
		Optional<Usuario> usuario = _usuarioRepo.findById(usuarioId);
		if(usuario.isPresent()) {
			try {
				// update ...
				return new ResponseEntity<>("", HttpStatus.OK);
			} catch(Exception err) {
				return new ResponseEntity<>("Fail: \n" + err.getMessage(), HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<>("UsuarioID "+usuarioId+"Not Found!", HttpStatus.NOT_FOUND);
		}
	}
	
	
	// DELETE ONE
	public ResponseEntity<?> deleteOne(Long usuarioId) {
		Optional<Usuario> usuario = _usuarioRepo.findById(usuarioId);
		if(usuario.isPresent()) {
			try {
				_usuarioRepo.delete(usuario.get());
				return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
			} catch(Exception err) {
				return new ResponseEntity<>("Fail: \n" + err.getMessage(), HttpStatus.NOT_ACCEPTABLE);
			}
		} else {
			return new ResponseEntity<>("UsuarioID "+usuarioId+"Not Found!", HttpStatus.NOT_FOUND);
		}
	}

	
}
