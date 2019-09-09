package br.com.learnmotion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.learnmotion.models.dtos.UsuarioDto;
import br.com.learnmotion.services.UsuarioService;

@RestController
@RequestMapping("/app/v1/util")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@RequestMapping(value = "/usuario", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaUsuarios() {
		return usuarioService.buscaTodosUsuarios();
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaUsuario(@RequestParam(required = true) Long id) {
		return usuarioService.buscaUmUsuario(id);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> cadastraUsuario(@RequestBody UsuarioDto usuario) {
		return usuarioService.cadastraUmUsuario(usuario);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> alterarUsuario(@RequestBody UsuarioDto usuario) {
		return usuarioService.alteraUsuario(usuario);
	}

	@RequestMapping(value = "/usuario/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> deletarUsuario(@PathVariable(required = true) String id) {
		return usuarioService.deletaUsuario(id);
	}

	@RequestMapping(value = "/usuario", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> deletarPessoas() {
		return usuarioService.deletaUsuarios();
	}

}
