package br.com.alura.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.config.security.TokenService;
import br.com.alura.model.request.AuthRequest;
import br.com.alura.model.response.AuthResponse;
import io.swagger.annotations.Api;


@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "AUTH")
public class AutenticacaoController {

	
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private TokenService tokenService;
	
	
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid AuthRequest auth) {
		UsernamePasswordAuthenticationToken dadosLogin = auth.converter();
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new AuthResponse(token, "Bearer"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
	@PostMapping(value="/token")
	public ResponseEntity<?> validar(@RequestBody @Valid AuthResponse auth) {
		try {
			return new ResponseEntity<>(tokenService.isTokenValido(auth.getAuthUsuario()), HttpStatus.OK);
		} catch (Exception err) {
			return new ResponseEntity<>("Fail: \n" + err.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	
}
