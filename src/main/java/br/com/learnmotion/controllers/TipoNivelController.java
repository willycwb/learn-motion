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

import br.com.learnmotion.models.dtos.TipoNivelDto;
import br.com.learnmotion.services.TipoNivelService;

@RestController
@RequestMapping("/app/v1/tiponivel")
public class TipoNivelController {

	@Autowired
	private TipoNivelService tipoNivelService;

	@RequestMapping(value = "/tiponivel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaTipoNiveis() {
		return tipoNivelService.buscaTodosTiposNiveis();
	}

	@RequestMapping(value = "/tiponivel/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaTipoNivel(@PathVariable(required = true) String id) {
		return tipoNivelService.buscaUmTipoNivel(id);// Esse nao deu certo
	}

	@RequestMapping(value = "/tiponivel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> cadastraTipoNivel(@RequestBody TipoNivelDto tipoNivel) {
		return tipoNivelService.cadastraUmTipoNivel(tipoNivel);
	}

	@RequestMapping(value = "/tiponivel", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> alterarTipoNivel(@RequestBody TipoNivelDto tipoNivel) {
		return tipoNivelService.alteraTipoNivel(tipoNivel);
	}

	@RequestMapping(value = "/tiponivel/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> deletarTipoNivel(@PathVariable(required = true) String id) {
		return tipoNivelService.deletaTipoNivel(id);
	}

	@RequestMapping(value = "/tiponivel", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> deletarTipoNiveis() {
		return tipoNivelService.deletaTiposNiveis();
	}

}
