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
import br.com.learnmotion.models.SubConteudo;
import br.com.learnmotion.models.TipoConteudo;
import br.com.learnmotion.models.dtos.ResponseDto;
import br.com.learnmotion.models.dtos.SubConteudoDto;
import br.com.learnmotion.repositories.SubConteudoRepository;

@Service
public class SubConteudoService extends ParentService {

	@Autowired
	private SubConteudoRepository subConteudoRepository;

	@Autowired
	private TipoConteudoService tipoConteudoService;

	private List<SubConteudo> findSubConteudos() {
		return subConteudoRepository.findAll();
	}

	private SubConteudo findSubConteudo(Long id) {
		return subConteudoRepository.findById(id).get();
	}

	public SubConteudo buscaSubConteudo(Long id) {
		return findSubConteudo(id);
	}

	@Transactional
	private SubConteudo cadastrarSubConteudo(SubConteudoDto subConteudoDto) {
		SubConteudo subConteudo = new SubConteudo();
		TipoConteudo tipoConteudo = tipoConteudoService.buscaTipoConteudo(subConteudoDto.getTipoConteudo().getId());
		subConteudo.setTipoConteudo(tipoConteudo);
		subConteudo.setValorStringMaior(subConteudoDto.getValorStringMaior());
		subConteudo.setValorStringMedio(subConteudoDto.getValorStringMedio());
		subConteudo.setValorStringMenor(subConteudoDto.getValorStringMenor());
		subConteudo.setValorBlobImagem(subConteudoDto.getValorBlobImagem());
		subConteudo.setValorBlobExemplo(subConteudoDto.getValorBlobExemplo());
		subConteudo = subConteudoRepository.save(subConteudo);
		return subConteudo;
	}

	@Modifying
	private SubConteudo alterarSubConteudo(SubConteudoDto subConteudoDto) {
		SubConteudo subConteudo = findSubConteudo(subConteudoDto.getId());
		TipoConteudo tipoConteudo = tipoConteudoService.buscaTipoConteudo(subConteudoDto.getTipoConteudo().getId());
		subConteudo.setTipoConteudo(tipoConteudo);
		subConteudo.setValorStringMaior(subConteudoDto.getValorStringMaior());
		subConteudo.setValorStringMedio(subConteudoDto.getValorStringMedio());
		subConteudo.setValorStringMenor(subConteudoDto.getValorStringMenor());
		subConteudo.setValorBlobImagem(subConteudoDto.getValorBlobImagem());
		subConteudo.setValorBlobExemplo(subConteudoDto.getValorBlobExemplo());
		subConteudo = subConteudoRepository.save(subConteudo);
		return subConteudo;
	}

	@Transactional
	private SubConteudo deletarSubConteudo(Long id) {
		SubConteudo subConteudo = findSubConteudo(id);
		subConteudoRepository.delete(subConteudo);
		return subConteudo;
	}

	@Transactional
	private void deletarSubConteudos() {
		subConteudoRepository.deleteAll();
	}

	public ResponseEntity<?> buscaTodosSubConteudos() {
		List<SubConteudo> subConteudos = findSubConteudos();

		if (subConteudos == null) {
			return ResponseEntity.noContent().build();
		}

		List<SubConteudoDto> subConteudoDto = subConteudos.stream().map(item -> mapper.map(item, SubConteudoDto.class))
				.collect(Collectors.toList());

		return ResponseEntity.ok(Map.of("result", subConteudoDto));

	}

	public ResponseEntity<?> buscaUmSubConteudo(String id) {
		SubConteudo subConteudo = buscaSubConteudo(Long.valueOf(id));

		if (subConteudo == null) {
			return ResponseEntity.noContent().build();
		}

		SubConteudoDto subConteudoDto = mapper.map(subConteudo, SubConteudoDto.class);

		return ResponseEntity.ok(Map.of("result", subConteudoDto));
	}

	public ResponseEntity<?> cadastraUmSubConteudo(SubConteudoDto subConteudoDto) {
		SubConteudo subConteudo = cadastrarSubConteudo(subConteudoDto);
		SubConteudoDto subConteudoResponse = mapper.map(subConteudo, SubConteudoDto.class);
		ResponseDto response = new ResponseDto();
		response.setResult(subConteudoResponse);
		response.setMsg(Constants.CADASTRADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<?> alteraSubConteudo(SubConteudoDto subConteudoDto) {
		SubConteudo subConteudo = alterarSubConteudo(subConteudoDto);
		SubConteudoDto subConteudoResponse = mapper.map(subConteudo, SubConteudoDto.class);
		ResponseDto response = new ResponseDto();
		response.setResult(subConteudoResponse);
		response.setMsg(Constants.ALTERADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);
	}

	public ResponseEntity<?> deletaSubConteudo(String id) {
		deletarSubConteudo(Long.valueOf(id));
		ResponseDto response = new ResponseDto();
		response.setMsg(Constants.DELETADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);

	}

	public ResponseEntity<?> deletaSubConteudos() {
		deletarSubConteudos();
		ResponseDto response = new ResponseDto();
		response.setMsg(Constants.DELETADO_SUCESSO);
		response.setStatus(Status.SUCESSO);
		return ResponseEntity.ok(response);
	}

}
