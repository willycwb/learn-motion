package br.com.learnmotion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.learnmotion.services.ConteudoService;

@RestController
@RequestMapping("/app/v1/publico-conteudo")
public class PublicoConteudoController {

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

}
