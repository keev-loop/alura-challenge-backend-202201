package br.com.alura.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.alura.model.entity.Usuario;
import br.com.alura.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {

	
	@Autowired
	private UsuarioRepository _usuarioRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Optional<Usuario> usuario = _usuarioRepo.findByUsuarioEmail(username);
		 if(usuario.isPresent()) {
			 return usuario.get();
		 }
		throw new UsernameNotFoundException("Dados inválidos!");
	}
	
	
}
