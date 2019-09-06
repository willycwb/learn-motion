package br.com.learnmotion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.learnmotion.models.TipoNivel;
import br.com.learnmotion.models.dtos.TipoNivelDto;
import br.com.learnmotion.repositories.TipoNivelRepository;

@Service
public class TipoNivelService extends ParentService {

	@Autowired
	private TipoNivelRepository tipoNivelRepository;

	// TODO - SHOW trocar para find
	// private List<TipoNivel> buscaNiveis() {
	// return tipoNivelRepository.findAll();
	// }

	private TipoNivel findNivel(Long id) {
		return tipoNivelRepository.findById(id).get();
	}

	public TipoNivel buscaNivel(Long id) {
		return findNivel(id);
	}

	@Transactional
	private TipoNivel cadastrarNivel(TipoNivelDto tipoNivelDto) {
		TipoNivel tipoNivel = new TipoNivel();
		tipoNivel.setNome(tipoNivelDto.getNome());
		tipoNivel.setDescricao(tipoNivelDto.getDescricao());
		tipoNivel = tipoNivelRepository.save(tipoNivel);
		return tipoNivel;
	}

//	@Modifying
//	private Nivel alterarNivel(NivelDto nivelDto) {
//		Nivel nivel = buscaNivel(nivelDto.getId());
//		//nivel.setTipoNivel(nivelDto.getTipoNivel());
//		nivel.setTitulo(nivelDto.getTitulo());
//		nivel.setSubTitulo(nivelDto.getSubTitulo());
//		nivel.setDescricao(nivelDto.getDescricao());
//		nivel.setBackgroud(nivelDto.getBackgroud());
//		nivel = nivelRepository.save(nivel);
//		return nivel;
//	}
//
//	@Transactional
//	private Nivel deletarNivel(Long id) {
//		Nivel nivel = buscaNivel(id);
//		nivelRepository.delete(nivel);		
//		return nivel;
//	}
//
//	@Transactional
//	private void deletarNiveis() {
//		nivelRepository.deleteAll();
//	}
//
//	public ResponseEntity<?> buscaTodosNiveis() {
//		List<Nivel> niveis = buscaNiveis();
//
//		if (niveis == null) {
//			return ResponseEntity.noContent().build();
//		}
//
//		List<NivelDto> nivelDto = niveis.stream().map(item -> mapper.map(item, NivelDto.class))
//				.collect(Collectors.toList());
//
//		return ResponseEntity.ok(Map.of("result", nivelDto));
//
//	}
//
//	public ResponseEntity<?> buscaUmNivel(Long id) {
//		Nivel nivel = buscaNivel(id);
//
//		if (nivel != null) {
//			return ResponseEntity.noContent().build();
//		}
//
//		NivelDto nivelDto = mapper.map(nivel,NivelDto.class);
//
//		return ResponseEntity.ok(Map.of("result", nivelDto));
//	}
//
//	public ResponseEntity<?> cadastraUmNivel(NivelDto nivelDto) {
//		Nivel nivel = cadastrarNivel(nivelDto);
//		NivelDto nivelResponse = mapper.map(nivel, NivelDto.class);
//		return ResponseEntity.ok(Map.of("result", nivelResponse));
//	}
//	
//    public ResponseEntity<?> alteraNivel(NivelDto nivelDto){
//		Nivel nivel = alterarNivel(nivelDto);
//		NivelDto nivelResponse = mapper.map(nivel, NivelDto.class);	
//    	return ResponseEntity.ok(Map.of("result", nivelResponse));
//	}
//    
//    public ResponseEntity<?> deletaNivel(String id){
//    	Nivel nivel = deletarNivel(Long.valueOf(id));
//    	
//    	if(nivel == null) {
//    		return ResponseEntity.noContent().build();
//    	}
//    	
//    	NivelDto nivelDto = mapper.map(nivel, NivelDto.class);
//    	
//    	return ResponseEntity.ok(Map.of("result", nivelDto));
//    	
//    }
//    
//    public ResponseEntity<?> deletaNiveis(){
//    	deletarNiveis();
//    	return null;
//    }

}
