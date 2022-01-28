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

import br.com.alura.model.entity.Despesa;
import br.com.alura.service.DespesaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/v1/despesas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "DESPESAS")
public class DespesaController {

	
	@Autowired
	private DespesaService _despesaServ;
	
	
	@ApiOperation(value = "Exibe todas as despesas!")
	@GetMapping
	public ResponseEntity<?> readAll(@PageableDefault(sort = "despesaId", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {
		return _despesaServ.readAll(paginacao);
	}
	
	
	@ApiOperation(value = "Cria uma nova despesa com BODY/JSON!")
	@PostMapping
	public ResponseEntity<?> createOne(@RequestBody @Valid Despesa despesa) {
		return _despesaServ.createOne(despesa);
	}
	
	
	@ApiOperation(value = "Exibe uma despesa pelo ID!")
	@GetMapping(value="/{despesaId}")
	public ResponseEntity<?> readOne(@PathVariable(value = "despesaId") Long despesaId) {
		return _despesaServ.readOne(despesaId);
	}
	
	
	@ApiOperation(value = "Atualiza uma despesa pelo ID com BODY/JSON!")
	@PutMapping(value="/{despesaId}")
	public ResponseEntity<?> updateOne(@PathVariable(value = "despesaId") Long despesaId, @RequestBody @Valid Despesa novaDespesa) {
		return _despesaServ.updateOne(despesaId, novaDespesa);
	}
	
	
	@ApiOperation(value = "Apaga uma despesa pelo ID!")
	@DeleteMapping(value="/{despesaId}")
	public ResponseEntity<?> deleteOne(@PathVariable(value = "despesaId") Long despesaId) {
		return _despesaServ.deleteOne(despesaId);
	}


}
