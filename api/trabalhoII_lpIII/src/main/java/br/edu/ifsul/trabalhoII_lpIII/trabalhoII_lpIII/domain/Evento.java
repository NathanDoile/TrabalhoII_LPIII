package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class Evento {

	@Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
	
	private LocalDateTime dataHoraInicio;
	
	private LocalDateTime dataHoraFim;
	
	private String situacao;
	
	private String descricaoTipo;
	
	private String descricao;
	
	private String localExterno;
	
	private String urlRegistro;

	public Long getId() {
		return id;
	}

	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public LocalDateTime getDataHoraFim() {
		return dataHoraFim;
	}

	public String getSituacao() {
		return situacao;
	}

	public String getDescricaoTipo() {
		return descricaoTipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getLocalExterno() {
		return localExterno;
	}

	public String getUrlRegistro() {
		return urlRegistro;
	}
}
