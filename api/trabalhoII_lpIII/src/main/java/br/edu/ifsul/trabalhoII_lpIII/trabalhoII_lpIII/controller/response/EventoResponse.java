package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class EventoResponse {

	private Long id;
	
	private String descricaoTipo;

}
