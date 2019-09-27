package br.com.learnmotion.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.learnmotion.common.constants.Constants;
import br.com.learnmotion.common.enums.Status;
import br.com.learnmotion.models.TipoConteudo;
import br.com.learnmotion.models.dtos.ResponseDto;
import br.com.learnmotion.models.dtos.TipoConteudoDto;
import br.com.learnmotion.repositories.TipoConteudoRepository;

@Service
public class TipoConteudoService extends ParentService {

	@Autowired
	private TipoConteudoRepository tipoConteudoRepository;

	private List<TipoConteudo> findTipoConteudos() {
		return tipoConteudoRepository.findAll();
	}

	private TipoConteudo findTipoConteudo(Long id) {
		return tipoConteudoRepository.findById(id).get();
	}

	public TipoConteudo buscaTipoConteudo(Long id) {
		return findTipoConteudo(id);
	}

	@Transactional
	private TipoConteudo cadastrarTipoConteudo(TipoConteudoDto tipoConteudoDto) {
		TipoConteudo tipoConteudo = new TipoConteudo();
		tipoConteudo.setNome(tipoConteudoDto.getNome());
		tipoConteudo.setDescricao(tipoConteudoDto.getDescricao());
		tipoConteudo = tipoConteudoRepository.save(tipoConteudo);
		return tipoConteudo;
	}

	@Modifying
	private TipoConteudo alterarTipoConteudo(TipoConteudoDto tipoConteudoDto) {
		TipoConteudo tipoConteudo = findTipoConteudo(tipoConteudoDto.getId());
		tipoConteudo.setNome(tipoConteudoDto.getNome());
		tipoConteudo.setDescricao(tipoConteudoDto.getDescricao());
		tipoConteudo = tipoConteudoRepository.save(tipoConteudo);
		return tipoConteudo;
	}

	@Transactional
	private TipoConteudo deletarTipoConteudo(Long id) {
		TipoConteudo tipoConteudo = findTipoConteudo(id);
		tipoConteudoRepository.delete(tipoConteudo);
		return tipoConteudo;
	}

	@Transactional
	private void deletarTipoConteudos() {
		tipoConteudoRepository.deleteAll();
	}

	public ResponseEntity<?> buscaTodosTiposConteudos() {
		List<TipoConteudo> tipoConteudo = findTipoConteudos();

		if (tipoConteudo == null) {
			return ResponseEntity.noContent().build();
		}

		List<TipoConteudoDto> tipoConteudoDto = tipoConteudo.stream()
				.map(item -> mapper.map(item, TipoConteudoDto.class)).collect(Collectors.toList());

		return ResponseEntity.ok(Map.of("result", tipoConteudoDto));

	}

	public ResponseEntity<?> buscaUmTipoConteudo(String id) {
		TipoConteudo tipoConteudo = buscaTipoConteudo(Long.valueOf(id));

		if (tipoConteudo == null) {
			return ResponseEntity.noContent().build();
		}

		TipoConteudoDto tipoConteudoDto = mapper.map(tipoConteudo, TipoConteudoDto.class);

		return ResponseEntity.ok(Map.of("result", tipoConteudoDto));
	}

	public ResponseEntity<?> cadastraUmTipoConteudo(TipoConteudoDto tipoConteudoDto) {
		TipoConteudo tipoConteudo = cadastrarTipoConteudo(tipoConteudoDto);
		TipoConteudoDto TipoConteudoResponse = mapper.map(tipoConteudo, TipoConteudoDto.class);
		ResponseDto response = new ResponseDto();
		response.setResult(TipoConteudoResponse);
		response.setMsg(Constants.CADASTRADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<?> alteraTipoConteudo(TipoConteudoDto tipoConteudoDto) {
		TipoConteudo tipoConteudo = alterarTipoConteudo(tipoConteudoDto);
		TipoConteudoDto TipoConteudoResponse = mapper.map(tipoConteudo, TipoConteudoDto.class);
		ResponseDto response = new ResponseDto();
		response.setResult(TipoConteudoResponse);
		response.setMsg(Constants.ALTERADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<?> deletaTipoConteudo(String id) {
		deletarTipoConteudo(Long.valueOf(id));
		ResponseDto response = new ResponseDto();
		response.setMsg(Constants.DELETADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);

	}

	public ResponseEntity<?> deletaTipoConteudos() {
		deletarTipoConteudos();
		ResponseDto response = new ResponseDto();
		response.setMsg(Constants.DELETADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);
	}

}
