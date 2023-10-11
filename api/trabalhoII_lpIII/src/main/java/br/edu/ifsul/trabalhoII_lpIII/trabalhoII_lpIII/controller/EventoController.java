package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service.ObterEventosService;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	private ObterEventosService obterEventosService;
	
	@GetMapping
	@ResponseStatus(OK)
	public Page<EventoResponse> obterEventos(Pageable pageable){
		return obterEventosService.obter(pageable);
	}

}
