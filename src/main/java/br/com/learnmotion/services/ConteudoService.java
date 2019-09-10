package br.com.learnmotion.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.learnmotion.models.Conteudo;
import br.com.learnmotion.models.Nivel;
import br.com.learnmotion.models.SubConteudo;
import br.com.learnmotion.models.dtos.ConteudoDto;
import br.com.learnmotion.repositories.ConteudoRepository;

@Service
public class ConteudoService extends ParentService {

	@Autowired
	private ConteudoRepository conteudoRepository;

	@Autowired
	private NivelService nivelService;
	
	private List<Conteudo> findConteudos() {
		return conteudoRepository.findAll();
	}

	private Conteudo findConteudo(Long id) {
		return conteudoRepository.findById(id).get();
	}

	public Conteudo buscaConteudo(Long id) {
		return findConteudo(id);
	}

	@Transactional
	private Conteudo cadastrarConteudo(ConteudoDto conteudoDto) {
		Conteudo conteudo = new Conteudo();
		Nivel nivel = nivelService.buscaNivel(conteudoDto.getNivel().getId());
		conteudo.setNivel(nivel);
		List<SubConteudo> listaSub = new ArrayList<>();
		conteudoDto.getConteudos().stream().forEach(sub -> {
			SubConteudo subConteudo = mapper.map(sub, SubConteudo.class);
			listaSub.add(subConteudo);
		});
		conteudo.setSubConteudos(new TreeSet<SubConteudo>(listaSub));
		conteudo = conteudoRepository.save(conteudo);
		return conteudo;
	}

	@Modifying
	private Conteudo alterarConteudo(ConteudoDto conteudoDto) {
		Conteudo conteudo = findConteudo(conteudoDto.getId());
		Nivel nivel = nivelService.buscaNivel(conteudoDto.getNivel().getId());
		conteudo.setNivel(nivel);
		List<SubConteudo> listaSub = new ArrayList<>();
		conteudoDto.getConteudos().stream().forEach(sub -> {
			SubConteudo subConteudo = mapper.map(sub, SubConteudo.class);
			listaSub.add(subConteudo);
		});
		conteudo.setSubConteudos(new TreeSet<SubConteudo>(listaSub));
		conteudo = conteudoRepository.save(conteudo);
		return conteudo;
	}

	@Transactional
	private Conteudo deletarConteudo(Long id) {
		Conteudo conteudo = findConteudo(id);
		conteudoRepository.delete(conteudo);
		return conteudo;
	}

	@Transactional
	private void deletarConteudos() {
		conteudoRepository.deleteAll();
	}

	public ResponseEntity<?> buscaTodosConteudos() {
		List<Conteudo> conteudos = findConteudos();

		if (conteudos == null) {
			return ResponseEntity.noContent().build();
		}

		List<ConteudoDto> conteudoDto = conteudos.stream().map(item -> mapper.map(item, ConteudoDto.class))
				.collect(Collectors.toList());

		return ResponseEntity.ok(Map.of("result", conteudoDto));

	}

	public ResponseEntity<?> buscaUmConteudo(Long id) {
		Conteudo conteudo = findConteudo(id);

		if (conteudo != null) {
			return ResponseEntity.noContent().build();
		}

		ConteudoDto conteudoDto = mapper.map(conteudo, ConteudoDto.class);

		return ResponseEntity.ok(Map.of("result", conteudoDto));
	}

	public ResponseEntity<?> cadastraUmConteudo(ConteudoDto conteudoDto) {
		Conteudo conteudo = cadastrarConteudo(conteudoDto);
		ConteudoDto conteudoResponse = mapper.map(conteudo, ConteudoDto.class);
		return ResponseEntity.ok(Map.of("result", conteudoResponse));
	}

	public ResponseEntity<?> alteraConteudo(ConteudoDto conteudoDto) {
		Conteudo conteudo = alterarConteudo(conteudoDto);
		ConteudoDto conteudoResponse = mapper.map(conteudo, ConteudoDto.class);
		return ResponseEntity.ok(Map.of("result", conteudoResponse));
	}

	public ResponseEntity<?> deletaConteudo(String id) {
		Conteudo conteudo = deletarConteudo(Long.valueOf(id));

		if (conteudo == null) {
			return ResponseEntity.noContent().build();
		}

		ConteudoDto conteudoDto = mapper.map(conteudo, ConteudoDto.class);

		return ResponseEntity.ok(Map.of("result", conteudoDto));

	}

	public ResponseEntity<?> deletaConteudos() {
		deletarConteudos();
		return null;
	}

}
