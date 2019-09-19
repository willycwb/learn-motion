package br.com.learnmotion.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.learnmotion.models.TipoNivel;
import br.com.learnmotion.models.dtos.TipoNivelDto;
import br.com.learnmotion.repositories.TipoNivelRepository;

@Service
public class TipoNivelService extends ParentService {

	@Autowired
	private TipoNivelRepository tipoNivelRepository;

	private List<TipoNivel> findNiveis() {
		return tipoNivelRepository.findAll();
	}

	private TipoNivel findNivel(Long id) {
		return tipoNivelRepository.findById(id).get();
	}

	public TipoNivel buscaTipoNivel(Long id) {
		return findNivel(id);
	}

	@Transactional
	private TipoNivel cadastrarTipoNivel(TipoNivelDto tipoNivelDto) {
		TipoNivel tipoNivel = new TipoNivel();
		tipoNivel.setNome(tipoNivelDto.getNome());
		tipoNivel.setDescricao(tipoNivelDto.getDescricao());
		tipoNivel = tipoNivelRepository.save(tipoNivel);
		return tipoNivel;
	}

	@Modifying
	private TipoNivel alterarTipoNivel(TipoNivelDto tipoNivelDto) {
		TipoNivel tipoNivel = findNivel(tipoNivelDto.getId());
		tipoNivel.setNome(tipoNivelDto.getNome());
		tipoNivel.setDescricao(tipoNivelDto.getDescricao());
		tipoNivel = tipoNivelRepository.save(tipoNivel);
		return tipoNivel;
	}

	@Transactional
	private TipoNivel deletarTipoNivel(Long id) {
		TipoNivel tipoNivel = findNivel(id);
		tipoNivelRepository.delete(tipoNivel);
		return tipoNivel;
	}

	@Transactional
	private void deletarTipoNiveis() {
		tipoNivelRepository.deleteAll();
	}

	public ResponseEntity<?> buscaTodosTiposNiveis() {
		List<TipoNivel> tipoNiveis = findNiveis();

		if (tipoNiveis == null) {
			return ResponseEntity.noContent().build();
		}

		List<TipoNivelDto> tipoNivelDto = tipoNiveis.stream().map(item -> mapper.map(item, TipoNivelDto.class))
				.collect(Collectors.toList());

		return ResponseEntity.ok(Map.of("result", tipoNivelDto));

	}

	public ResponseEntity<?> buscaUmTipoNivel(String id) {
		TipoNivel tipoNivel = findNivel(Long.valueOf(id));

		if (tipoNivel == null) {
			return ResponseEntity.noContent().build();
		}

		TipoNivelDto tipoNivelDto = mapper.map(tipoNivel, TipoNivelDto.class);

		return ResponseEntity.ok(Map.of("result", tipoNivelDto));
	}

	public ResponseEntity<?> cadastraUmTipoNivel(TipoNivelDto tipoNivelDto) {
		TipoNivel tipoNivel = cadastrarTipoNivel(tipoNivelDto);
		TipoNivelDto nivelTipoResponse = mapper.map(tipoNivel, TipoNivelDto.class);
		return ResponseEntity.ok(Map.of("result", nivelTipoResponse));
	}

	public ResponseEntity<?> alteraTipoNivel(TipoNivelDto tipoNivelDto) {
		TipoNivel tipoNivel = alterarTipoNivel(tipoNivelDto);
		TipoNivelDto nivelTipoResponse = mapper.map(tipoNivel, TipoNivelDto.class);
		return ResponseEntity.ok(Map.of("result", nivelTipoResponse));
	}

	public ResponseEntity<?> deletaTipoNivel(String id) {
		TipoNivel tipoNivel = deletarTipoNivel(Long.valueOf(id));

		if (tipoNivel == null) {
			return ResponseEntity.noContent().build();
		}

		TipoNivelDto tipoNivelDto = mapper.map(tipoNivel, TipoNivelDto.class);

		return ResponseEntity.ok(Map.of("result", tipoNivelDto));

	}

	public ResponseEntity<?> deletaTiposNiveis() {
		deletarTipoNiveis();
		return null;
	}

}
