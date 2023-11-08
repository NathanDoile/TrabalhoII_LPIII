package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Deputado;

import java.util.List;

public interface DeputadoRepository extends JpaRepository<Deputado, Long> {

    List<Deputado> findAllByEventos(Evento evento);
}
