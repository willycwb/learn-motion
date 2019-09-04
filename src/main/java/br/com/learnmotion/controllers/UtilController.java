package br.com.learnmotion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.learnmotion.services.NivelService;

@RestController
@RequestMapping("/app/v1/util")
public class UtilController {

	@Autowired
	private NivelService nivelService;

	@RequestMapping(value = "/nivel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<?> buscaPessoas() {
		return nivelService.buscaTodasPessoas();
	}

//	@RequestMapping(value = "/nivel/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public ResponseEntity<?> buscaPessoa(@RequestParam(required = true) Long id) {
//		return testeService.buscaUmaPessoa(id);
//	}

//	@RequestMapping(value = "/pessoa", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public ResponseEntity<?> cadastraPessoa(@RequestBody PessoaDto pessoa) {
//		return testeService.cadastraUmaPessoa(pessoa);
//	}
//
//	@RequestMapping(value = "/pessoa", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public ResponseEntity<?> alterarPessoa() {
//		return null;
//	}
//
//	@RequestMapping(value = "/pessoa/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public ResponseEntity<?> deletarPessoa() {
//		return null;
//	}
//
//	@RequestMapping(value = "/pessoa", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public ResponseEntity<?> deletarPessoas() {
//		return null;
//	}

}
