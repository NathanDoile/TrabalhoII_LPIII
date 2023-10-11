package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Deputado {

	@Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
	
	private String nome;
	
	private String siglaPartido;
	
	private String siglaUf;
	
	private String email;
	
	private String urlFoto;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getSiglaPartido() {
		return siglaPartido;
	}

	public String getSiglaUf() {
		return siglaUf;
	}

	public String getEmail() {
		return email;
	}

	public String getUrlFoto() {
		return urlFoto;
	}
	
	
}
