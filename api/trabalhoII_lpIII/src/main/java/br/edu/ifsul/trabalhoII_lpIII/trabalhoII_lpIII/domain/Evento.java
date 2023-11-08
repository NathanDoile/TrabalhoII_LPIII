package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

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
    private Long id;
	
	private String descricaoTipo;

	@ManyToMany
	@JoinTable(name = "evento_deputado",
			joinColumns = @JoinColumn(name = "id_evento"),
			inverseJoinColumns = @JoinColumn(name = "id_deputado"))
	private List<Deputado> deputados;
}
