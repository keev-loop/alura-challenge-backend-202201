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

import br.com.alura.model.entity.Receita;
import br.com.alura.service.ReceitaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/v1/receitas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "RECEITAS")
public class ReceitaController {

	
	@Autowired
	private ReceitaService _receitaServ;
	
	
	@ApiOperation(value = "Exibe todas as receitas!")
	@GetMapping
	public ResponseEntity<?> readAll(@PageableDefault(sort = "receitaId", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		return _receitaServ.readAll(paginacao);
	}
	
	
	@ApiOperation(value = "Cria uma nova receita com BODY/JSON!")
	@PostMapping
	public ResponseEntity<?> createOne(@RequestBody @Valid Receita receita) {
		return _receitaServ.createOne(receita);
	}
	
	
	@ApiOperation(value = "Exibe uma receita pelo ID!")
	@GetMapping(value="/{receitaId}")
	public ResponseEntity<?> readOne(@PathVariable(value = "receitaId") Long receitaId) {
		return _receitaServ.readOne(receitaId);
	}
	
	
	@ApiOperation(value = "Atualiza uma receita pelo ID com BODY/JSON!")
	@PutMapping(value="/{receitaId}")
	public ResponseEntity<?> updateOne(@PathVariable(value = "receitaId") Long receitaId, @RequestBody @Valid Receita novaReceita) {
		return _receitaServ.updateOne(receitaId, novaReceita);
	}
	
	
	@ApiOperation(value = "Apaga uma receita pelo ID!")
	@DeleteMapping(value="/{receitaId}")
	public ResponseEntity<?> deleteOne(@PathVariable(value = "receitaId") Long receitaId) {
		return _receitaServ.deleteOne(receitaId);
	}

	
}
