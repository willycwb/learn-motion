package br.com.learnmotion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.learnmotion.services.SubConteudoService;

@RestController
@RequestMapping("/app/v1/publico-subconteudo")
public class PublicoSubConteudoController {

	@Autowired
	private SubConteudoService subConteudoService;

	@RequestMapping(value = "/subconteudo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaSubConteudos() {
		return subConteudoService.buscaTodosSubConteudos();
	}

	@RequestMapping(value = "/subconteudo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaSubConteudo(@PathVariable(required = true) String id) {
		return subConteudoService.buscaUmSubConteudo(id);
	}
}
