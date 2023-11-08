package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response.DeputadoResponse;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Deputado;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository.DeputadoRepository;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.mapper.DeputadoMapper.toResponse;

@Service
public class ObterDeputadoService {
	
	@Autowired
	private DeputadoRepository deputadoRepository;

	public DeputadoResponse obter(Long id) {
		
		if(!deputadoRepository.existsById(id)) {
			
			throw new ResponseStatusException(NOT_FOUND, "Deputado não existe.");
		}
		
		Deputado deputado = deputadoRepository.findById(id).get();
		
		return toResponse(deputado);
	}
}
