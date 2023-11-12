package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class DeputadoResponse {

	private Long id;
	
	private String nome;
	
	private String siglaPartido;
	
	private String siglaUf;
	
	private String email;
	
	private String urlFoto;
	
}
