package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static javax.persistence.CascadeType.PERSIST;
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

	@ManyToMany(mappedBy = "deputados", cascade = PERSIST)
	private List<Evento> eventos;

}
