package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Evento;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.mapper.EventoMapper;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository.EventoRepository;

@Service
public class ObterEventosService {
	
	@Autowired
	private EventoRepository eventoRepository;

	public Page<EventoResponse> obter(Pageable pageable) {
		
		Page<Evento> eventos = eventoRepository.findAll(pageable);
		
		if(eventos.isEmpty()) {
			return null;
		}
		
		return eventos.map(EventoMapper::toResponse);
	}

}
