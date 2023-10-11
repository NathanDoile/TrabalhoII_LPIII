package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response.DeputadoResponse;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service.ObterDeputadoService;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service.ObterDeputadosService;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/deputados")
public class DeputadoController {
	
	@Autowired
	private ObterDeputadosService obterDeputadosService;
	
	@Autowired
	private ObterDeputadoService obterDeputadoService;

	@GetMapping
	@ResponseStatus(OK)
	public Page<DeputadoResponse> obterLista(Pageable pageable){
		return obterDeputadosService.obter(pageable);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public DeputadoResponse obter(@PathVariable Long id) {
		return obterDeputadoService.obter(id);
	}
}
