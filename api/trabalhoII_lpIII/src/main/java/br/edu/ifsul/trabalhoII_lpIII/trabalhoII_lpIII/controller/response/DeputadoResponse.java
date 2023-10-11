package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@Getter @Setter
public class DeputadoResponse {

	private Long id;
	
	private String nome;
	
	private String siglaPartido;
	
	private String siglaUf;
	
	private String email;
	
	private String urlFoto;

	public DeputadoResponse(Long id, String nome, String siglaPartido, String siglaUf, String email, String urlFoto) {
		super();
		this.id = id;
		this.nome = nome;
		this.siglaPartido = siglaPartido;
		this.siglaUf = siglaUf;
		this.email = email;
		this.urlFoto = urlFoto;
	}
	
	
}
