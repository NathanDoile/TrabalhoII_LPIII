package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service.DesinscreverEventoService;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service.InscreverEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response.DeputadoResponse;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service.ObterDeputadoService;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service.ObterDeputadosService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/deputados")
public class DeputadoController {
	
	@Autowired
	private ObterDeputadosService obterDeputadosService;
	
	@Autowired
	private ObterDeputadoService obterDeputadoService;

	@Autowired
	private InscreverEventoService inscreverEventoService;

	@Autowired
	private DesinscreverEventoService desinscreverEventoService;

	@GetMapping
	@ResponseStatus(OK)
	public List<DeputadoResponse> obterLista(){
		return obterDeputadosService.obter();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public DeputadoResponse obter(@PathVariable Long id) {
		return obterDeputadoService.obter(id);
	}

	@PutMapping("/{idDeputado}/eventos/{idEvento}/inscrever")
	@ResponseStatus(OK)
	public void inscreverEvento(@PathVariable Long idDeputado, @PathVariable Long idEvento){
		inscreverEventoService.inscrever(idDeputado, idEvento);
	}

	@PutMapping("/{idDeputado}/eventos/{idEvento}/desinscrever")
	@ResponseStatus(OK)
	public void desinscreverEvento(@PathVariable Long idDeputado, @PathVariable Long idEvento){
		desinscreverEventoService.desinscrever(idDeputado, idEvento);
	}
}
