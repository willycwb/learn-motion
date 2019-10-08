package br.com.learnmotion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.learnmotion.services.NivelService;

@RestController
@RequestMapping("/app/v1/publico-nivel")
public class PublicoNivelController {

	@Autowired
	private NivelService nivelService;

	@RequestMapping(value = "/nivel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaNiveis() {
		return nivelService.buscaTodosNiveis();
	}

	@RequestMapping(value = "/nivel/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaNivel(@PathVariable(required = true) String id) {
		return nivelService.buscaUmNivel(id);
	}
}
