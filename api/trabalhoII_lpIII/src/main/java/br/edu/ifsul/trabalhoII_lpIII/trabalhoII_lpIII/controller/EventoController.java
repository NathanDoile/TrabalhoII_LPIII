package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service.ObterEventosPorDeputadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service.ObterEventosService;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/eventos")
public class EventoController {
	
	@Autowired
	private ObterEventosService obterEventosService;

	@Autowired
	private ObterEventosPorDeputadoService obterEventosPorDeputadoService;

	@GetMapping
	@ResponseStatus(OK)
	public List<EventoResponse> obterEventos(){
		return obterEventosService.obter();
	}

	@GetMapping("/deputado/{id}")
	@ResponseStatus(OK)
	public List<EventoResponse> obterEventosPorDeputado(@PathVariable Long id){
		return obterEventosPorDeputadoService.obter(id);
	}

}
