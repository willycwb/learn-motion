package br.com.learnmotion.services;

import org.springframework.stereotype.Service;

@Service
public class TesteService extends ParentService {

//	@Autowired
//	private TesteRepository testeRepository;
//
//	private List<Pessoa> buscaPessoas() {
//		return testeRepository.findAll();
//	}
//
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
//
//	public ResponseEntity<?> buscaTodasPessoas() {
//		List<Pessoa> pessoas = buscaPessoas();
//
//		if (pessoas == null) {
//			return ResponseEntity.noContent().build();
//		}
//
//		List<PessoaDto> pessoasDto = pessoas.stream().map(item -> mapper.map(item, PessoaDto.class))
//				.collect(Collectors.toList());
//
//		return ResponseEntity.ok(Map.of("result", pessoasDto));
//
//	}
//
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
