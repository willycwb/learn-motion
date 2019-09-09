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

import br.com.learnmotion.models.dtos.TipoConteudoDto;
import br.com.learnmotion.services.TipoConteudoService;

@RestController
@RequestMapping("/app/v1/util")
public class TipoConteudoController {

	@Autowired
	private TipoConteudoService tipoConteudoService;

	@RequestMapping(value = "/tipoConteudo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaTipoConteudos() {
		return tipoConteudoService.buscaTodosTiposConteudos();
	}

	@RequestMapping(value = "/tipoConteudo/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaTipoConteudo(@RequestParam(required = true) Long id) {
		return tipoConteudoService.buscaUmTipoConteudo(id);
	}

	@RequestMapping(value = "/tipoConteudo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> cadastraTipoConteudo(@RequestBody TipoConteudoDto tipoConteudo) {
		return tipoConteudoService.cadastraUmTipoConteudo(tipoConteudo);
	}

	@RequestMapping(value = "/tipoConteudo", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> alterarSubConteudo(@RequestBody TipoConteudoDto tipoConteudo) {
		return tipoConteudoService.alteraTipoConteudo(tipoConteudo);
	}

	@RequestMapping(value = "/tipoConteudo/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> deletarTipoConteudo(@PathVariable(required = true) String id) {
		return tipoConteudoService.deletaTipoConteudo(id);
	}

	@RequestMapping(value = "/tipoConteudo", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> deletarTipoConteudos() {
		return tipoConteudoService.deletaTipoConteudos();
	}

}
