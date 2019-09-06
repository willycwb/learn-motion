package br.com.learnmotion.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.learnmotion.models.Nivel;
import br.com.learnmotion.models.TipoNivel;
import br.com.learnmotion.models.dtos.NivelDto;
import br.com.learnmotion.repositories.NivelRepository;

@Service
public class NivelService extends ParentService {

	@Autowired
	private NivelRepository nivelRepository;
	
	@Autowired
	private TipoNivelService tipoNivelService;

	private List<Nivel> buscaNiveis() {
		return nivelRepository.findAll();
	}

	private Nivel buscaNivel(Long id) {
		return nivelRepository.findById(id).get();
	}

	@Transactional
	private Nivel cadastrarNivel(NivelDto nivelDto) {
		Nivel nivel = new Nivel();
		TipoNivel tipoNivel = tipoNivelService.buscaNivel(nivelDto.getTipoNivel().getId());
		nivel.setTipoNivel(tipoNivel);
		nivel.setTitulo(nivelDto.getTitulo());
		nivel.setSubTitulo(nivelDto.getSubTitulo());
		nivel.setDescricao(nivelDto.getDescricao());
		nivel.setBackgroud(nivelDto.getBackgroud());
		nivel = nivelRepository.save(nivel);
		return nivel;
	}

	@Modifying
	private Nivel alterarNivel(NivelDto nivelDto) {
		Nivel nivel = buscaNivel(nivelDto.getId());
		TipoNivel tipoNivel = tipoNivelService.buscaNivel(nivelDto.getTipoNivel().getId());
		nivel.setTipoNivel(tipoNivel);
		nivel.setTitulo(nivelDto.getTitulo());
		nivel.setSubTitulo(nivelDto.getSubTitulo());
		nivel.setDescricao(nivelDto.getDescricao());
		nivel.setBackgroud(nivelDto.getBackgroud());
		nivel = nivelRepository.save(nivel);
		return nivel;
	}

	@Transactional
	private Nivel deletarNivel(Long id) {
		Nivel nivel = buscaNivel(id);
		nivelRepository.delete(nivel);		
		return nivel;
	}

	@Transactional
	private void deletarNiveis() {
		nivelRepository.deleteAll();
	}

	public ResponseEntity<?> buscaTodosNiveis() {
		List<Nivel> niveis = buscaNiveis();

		if (niveis == null) {
			return ResponseEntity.noContent().build();
		}

		List<NivelDto> nivelDto = niveis.stream().map(item -> mapper.map(item, NivelDto.class))
				.collect(Collectors.toList());

		return ResponseEntity.ok(Map.of("result", nivelDto));

	}

	public ResponseEntity<?> buscaUmNivel(Long id) {
		Nivel nivel = buscaNivel(id);

		if (nivel != null) {
			return ResponseEntity.noContent().build();
		}

		NivelDto nivelDto = mapper.map(nivel,NivelDto.class);

		return ResponseEntity.ok(Map.of("result", nivelDto));
	}

	public ResponseEntity<?> cadastraUmNivel(NivelDto nivelDto) {
		Nivel nivel = cadastrarNivel(nivelDto);
		NivelDto nivelResponse = mapper.map(nivel, NivelDto.class);
		return ResponseEntity.ok(Map.of("result", nivelResponse));
	}
	
    public ResponseEntity<?> alteraNivel(NivelDto nivelDto){
		Nivel nivel = alterarNivel(nivelDto);
		NivelDto nivelResponse = mapper.map(nivel, NivelDto.class);	
    	return ResponseEntity.ok(Map.of("result", nivelResponse));
	}
    
    public ResponseEntity<?> deletaNivel(String id){
    	Nivel nivel = deletarNivel(Long.valueOf(id));
    	
    	if(nivel == null) {
    		return ResponseEntity.noContent().build();
    	}
    	
    	NivelDto nivelDto = mapper.map(nivel, NivelDto.class);
    	
    	return ResponseEntity.ok(Map.of("result", nivelDto));
    	
    }
    
    public ResponseEntity<?> deletaNiveis(){
    	deletarNiveis();
    	return null;
    }

}
