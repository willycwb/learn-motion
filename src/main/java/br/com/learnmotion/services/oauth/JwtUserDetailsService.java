package br.com.learnmotion.services.oauth;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.learnmotion.models.Usuario;
import br.com.learnmotion.models.dtos.UsuarioDto;
import br.com.learnmotion.repositories.UsuarioRepository;

@Service
@Transactional(readOnly = true)
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByEmail(email);

		if (usuario == null) {
			throw new UsernameNotFoundException("Campo(s) de login e/ou senha inválidos.");
		}

		return new org.springframework.security.core.userdetails.User(usuario.getNome(), usuario.getSenha(),
				new ArrayList<>());
	}

	@Transactional
	public Usuario save(UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setSenha(bcryptEncoder.encode(usuarioDto.getSenha()));
		usuario.setNome(usuarioDto.getNome());
		return usuarioRepository.save(usuario);
	}

}