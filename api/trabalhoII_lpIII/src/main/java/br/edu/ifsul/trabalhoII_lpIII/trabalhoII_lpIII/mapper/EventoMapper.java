package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.mapper;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Evento;

public class EventoMapper {
	
	public static EventoResponse toResponse(Evento evento) {
		
		return new EventoResponse(evento.getId(), evento.getDataHoraInicio(), evento.getDataHoraFim(), 
				evento.getSituacao(), evento.getDescricaoTipo(), evento.getDescricao(), evento.getLocalExterno(), 
				evento.getUrlRegistro());
	}

}
