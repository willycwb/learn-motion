package br.com.learnmotion.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.learnmotion.models.Nivel;
import br.com.learnmotion.models.dtos.NivelDto;
import br.com.learnmotion.repositories.NivelRepository;

@Service
public class NivelService extends ParentService {

	@Autowired
	private NivelRepository nivelRepository;

	private List<Nivel> buscaNiveis() {
		return nivelRepository.findAll();
	}

//	private Pessoa buscaPessoa(Long id) {
//		return testeRepository.findById(id).get();
//	}
//
//	@Transactional
//	private Pessoa cadastrarPessoa(PessoaDto pessoaDto) {
//		Pessoa pessoa = new Pessoa();
//		pessoa.setNome(pessoaDto.getNome());
//		pessoa.setIdade(pessoaDto.getIdade());
//		pessoa = testeRepository.save(pessoa);
//		return pessoa;
//	}
//
//	@Modifying
//	private Pessoa alterarPessoa(PessoaDto pessoaDto) {
//		Pessoa pessoa = buscaPessoa(pessoaDto.getId());
//		pessoa.setNome(pessoaDto.getNome());
//		pessoa.setIdade(pessoaDto.getIdade());
//		pessoa = testeRepository.save(pessoa);
//		return pessoa;
//	}
//
//	@Transactional
//	private void deletarPessoa(Long id) {
//		Pessoa pessoa = buscaPessoa(id);
//		testeRepository.delete(pessoa);
//	}
//
//	@Transactional
//	private void deletarPessoas() {
//		testeRepository.deleteAll();
//	}

	public ResponseEntity<?> buscaTodasPessoas() {
		List<Nivel> pessoas = buscaNiveis();

		if (pessoas == null) {
			return ResponseEntity.noContent().build();
		}

		List<NivelDto> pessoasDto = pessoas.stream().map(item -> mapper.map(item, NivelDto.class))
				.collect(Collectors.toList());

		return ResponseEntity.ok(Map.of("result", pessoasDto));

	}

//	public ResponseEntity<?> buscaUmaPessoa(Long id) {
//		Pessoa pessoa = buscaPessoa(id);
//
//		if (pessoa != null) {
//			return ResponseEntity.noContent().build();
//		}
//
//		PessoaDto pessoaDto = mapper.map(pessoa, PessoaDto.class);
//
//		return ResponseEntity.ok(Map.of("result", pessoaDto));
//	}
//
//	public ResponseEntity<?> cadastraUmaPessoa(PessoaDto pessoaDto) {
//		Pessoa pessoa = cadastrarPessoa(pessoaDto);
//		PessoaDto pessoaresponse = mapper.map(pessoa, PessoaDto.class);
//		return ResponseEntity.ok(Map.of("result", pessoaresponse));
//	}

}
