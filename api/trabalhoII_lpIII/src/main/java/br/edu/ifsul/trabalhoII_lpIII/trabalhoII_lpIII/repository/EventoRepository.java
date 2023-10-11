package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
