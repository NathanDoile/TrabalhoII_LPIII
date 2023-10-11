package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response.DeputadoResponse;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Deputado;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.mapper.DeputadoMapper;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository.DeputadoRepository;

@Service
public class ObterDeputadosService {
	
	@Autowired
	private DeputadoRepository deputadoRepository;

	public Page<DeputadoResponse> obter(Pageable pageable) {
		
		Page<Deputado> deputados = deputadoRepository.findAll(pageable);
		
		if(deputados.isEmpty()) {
			return null;
		}
		
		return deputados.map(DeputadoMapper::toResponse);
	}

}