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

import br.com.learnmotion.models.dtos.SubConteudoDto;
import br.com.learnmotion.services.SubConteudoService;

@RestController
@RequestMapping("/app/v1/util")
public class SubConteudoController {

	@Autowired
	private SubConteudoService subConteudoService;

	@RequestMapping(value = "/subConteudo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaSubConteudos() {
		return subConteudoService.buscaTodosSubConteudos();
	}

	@RequestMapping(value = "/subConteudo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaSubConteudo(@RequestParam(required = true) Long id) {
		return subConteudoService.buscaUmSubConteudo(id);
	}

	@RequestMapping(value = "/subConteudo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> cadastraSubConteudo(@RequestBody SubConteudoDto subConteudo) {
		return subConteudoService.cadastraUmSubConteudo(subConteudo);
	}

	@RequestMapping(value = "/subConteudo", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> alterarSubConteudo(@RequestBody SubConteudoDto subConteudo) {
		return subConteudoService.alteraSubConteudo(subConteudo);
	}

	@RequestMapping(value = "/subConteudo/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> deletarSubConteudo(@PathVariable(required = true) String id) {
		return subConteudoService.deletaSubConteudo(id);
	}

	@RequestMapping(value = "/subConteudo", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> deletarSubConteudos() {
		return subConteudoService.deletaSubConteudos();
	}

}