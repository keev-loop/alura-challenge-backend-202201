package br.com.alura.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.model.entity.Usuario;
import br.com.alura.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/v1/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "USUARIOS")
public class UsuarioController {

	
	@Autowired
	private UsuarioService _usuarioServ;
	
	
	@ApiOperation(value = "Exibe todas as usuarios!")
	@GetMapping
	public ResponseEntity<?> readAll(@PageableDefault(sort = "usuarioId", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		return _usuarioServ.readAll(paginacao);
	}
	
	
	@ApiOperation(value = "Cria uma nova usuario com BODY/JSON!")
	@PostMapping
	public ResponseEntity<?> createOne(@RequestBody @Valid Usuario usuario) {
		return _usuarioServ.createOne(usuario);
	}
	
	
	@ApiOperation(value = "Exibe uma usuario pelo ID!")
	@GetMapping(value="/{usuarioId}")
	public ResponseEntity<?> readOne(@PathVariable(value = "usuarioId") Long usuarioId) {
		return _usuarioServ.readOne(usuarioId);
	}
	
	
	@ApiOperation(value = "Atualiza uma usuario pelo ID com BODY/JSON!")
	@PutMapping(value="/{usuarioId}")
	public ResponseEntity<?> updateOne(@PathVariable(value = "usuarioId") Long usuarioId, @RequestBody @Valid Usuario novaUsuario) {
		return _usuarioServ.updateOne(usuarioId, novaUsuario);
	}
	
	
	@ApiOperation(value = "Apaga uma usuario pelo ID!")
	@DeleteMapping(value="/{usuarioId}")
	public ResponseEntity<?> deleteOne(@PathVariable(value = "usuarioId") Long usuarioId) {
		return _usuarioServ.deleteOne(usuarioId);
	}


}
