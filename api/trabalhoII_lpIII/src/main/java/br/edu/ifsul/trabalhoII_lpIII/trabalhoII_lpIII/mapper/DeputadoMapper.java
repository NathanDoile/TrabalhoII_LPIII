package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.mapper;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response.DeputadoResponse;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Deputado;

public class DeputadoMapper {
	
	public static DeputadoResponse toResponse(Deputado deputado) {
		
		return new DeputadoResponse(deputado.getId(), deputado.getNome(), deputado.getSiglaPartido(), 
				deputado.getSiglaUf(), deputado.getEmail(), deputado.getUrlFoto());
	}

}
