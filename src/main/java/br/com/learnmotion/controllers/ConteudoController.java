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

import br.com.learnmotion.models.dtos.ConteudoDto;
import br.com.learnmotion.services.ConteudoService;

@RestController
@RequestMapping("/app/v1/conteudo")
public class ConteudoController {

	@Autowired
	private ConteudoService conteudoService;

	@RequestMapping(value = "/conteudo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaConteudos() {
		return conteudoService.buscaTodosConteudos();
	}

	@RequestMapping(value = "/conteudo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaConteudo(@PathVariable(required = true) String id) {
		return conteudoService.buscaUmConteudo(id);
	}

	@RequestMapping(value = "/conteudo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> cadastraConteudo(@RequestBody ConteudoDto conteudo) {
		return conteudoService.cadastraUmConteudo(conteudo);
	}

	@RequestMapping(value = "/conteudo", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> alterarConteudo(@RequestBody ConteudoDto conteudo) {
		return conteudoService.alteraConteudo(conteudo);
	}

	@RequestMapping(value = "/conteudo/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> deletarConteudo(@PathVariable(required = true) String id) {
		return conteudoService.deletaConteudo(id);
	}

	@RequestMapping(value = "/conteudo", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> deletarConteudos() {
		return conteudoService.deletaConteudos();
	}

}
