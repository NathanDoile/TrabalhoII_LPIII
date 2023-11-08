package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Deputado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Evento;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    boolean existsByIdAndDeputados(Long idEvento, Deputado deputado);

    List<Evento> findAllByDeputados(Deputado deputado);

    boolean existsByIdAndDeputadosNot(Long idEvento, Deputado deputado);
}
