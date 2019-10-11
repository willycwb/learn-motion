package br.com.learnmotion.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.learnmotion.common.constants.Constants;
import br.com.learnmotion.common.enums.Status;
import br.com.learnmotion.models.Usuario;
import br.com.learnmotion.models.dtos.ResponseDto;
import br.com.learnmotion.models.dtos.UsuarioDto;
import br.com.learnmotion.repositories.UsuarioRepository;

@Service
public class UsuarioService extends ParentService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	private List<Usuario> buscaUsuarios() {
		return usuarioRepository.findAll();
	}

	private Usuario findUsuario(Long id) {
		return usuarioRepository.findById(id).get();
	}

	public Usuario buscaUsuario(Long id) {
		return findUsuario(id);
	}

	@Transactional
	private Usuario cadastrarUsuario(UsuarioDto usuarioDto) {
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setSenha(usuarioDto.getSenha());
		usuario.setToken(usuarioDto.getToken());
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}

	@Modifying
	private Usuario alterarUsuario(UsuarioDto usuarioDto) {
		Usuario usuario = findUsuario(usuarioDto.getId());
		usuario.setNome(usuarioDto.getNome());
		usuario.setEmail(usuarioDto.getEmail());
		usuario.setSenha(usuarioDto.getSenha());
		usuario.setToken(usuarioDto.getToken());
		usuario = usuarioRepository.save(usuario);
		return usuario;
	}

	@Transactional
	private Usuario deletarUsuario(Long id) {
		Usuario usuario = findUsuario(id);
		usuarioRepository.delete(usuario);
		return usuario;
	}

	@Transactional
	private void deletarUsuarios() {
		usuarioRepository.deleteAll();
	}

	public ResponseEntity<?> buscaTodosUsuarios() {
		List<Usuario> usuarios = buscaUsuarios();

		if (usuarios == null) {
			return ResponseEntity.noContent().build();
		}

		List<UsuarioDto> usuarioDto = usuarios.stream().map(item -> mapper.map(item, UsuarioDto.class))
				.collect(Collectors.toList());

		ResponseDto response = new ResponseDto();
		response.setResult(usuarioDto);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);

	}

	public ResponseEntity<?> buscaUmUsuario(String id) {
		Usuario usuarios = findUsuario(Long.valueOf(id));

		if (usuarios != null) {
			return ResponseEntity.noContent().build();
		}

		UsuarioDto usuarioDto = mapper.map(usuarios, UsuarioDto.class);

		ResponseDto response = new ResponseDto();
		response.setResult(usuarioDto);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);

	}

	public ResponseEntity<?> cadastraUmUsuario(UsuarioDto usuarioDto) {
		Usuario usuario = cadastrarUsuario(usuarioDto);
		UsuarioDto usuarioResponse = mapper.map(usuario, UsuarioDto.class);
		ResponseDto response = new ResponseDto();
		response.setResult(usuarioResponse);
		response.setMsg(Constants.CADASTRADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<?> alteraUsuario(UsuarioDto usuarioDto) {
		Usuario usuario = alterarUsuario(usuarioDto);
		UsuarioDto usuarioResponse = mapper.map(usuario, UsuarioDto.class);
		ResponseDto response = new ResponseDto();
		response.setResult(usuarioResponse);
		response.setMsg(Constants.ALTERADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<?> deletaUsuario(String id) {
		deletarUsuario(Long.valueOf(id));
		ResponseDto response = new ResponseDto();
		response.setMsg(Constants.DELETADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);

	}

	public ResponseEntity<?> deletaUsuarios() {
		deletarUsuarios();
		ResponseDto response = new ResponseDto();
		response.setMsg(Constants.DELETADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);
	}

}
