package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@Getter @Setter
public class EventoResponse {

	private Long id;
	
	private LocalDateTime dataHoraInicio;
	
	private LocalDateTime dataHoraFim;
	
	private String situacao;
	
	private String descricaoTipo;
	
	private String descricao;
	
	private String localExterno;
	
	private String urlRegistro;

	public EventoResponse(Long id, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String situacao,
			String descricaoTipo, String descricao, String localExterno, String urlRegistro) {
		super();
		this.id = id;
		this.dataHoraInicio = dataHoraInicio;
		this.dataHoraFim = dataHoraFim;
		this.situacao = situacao;
		this.descricaoTipo = descricaoTipo;
		this.descricao = descricao;
		this.localExterno = localExterno;
		this.urlRegistro = urlRegistro;
	}
	
	
}
