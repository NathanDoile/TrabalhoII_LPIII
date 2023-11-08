package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Deputado;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Evento;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository.DeputadoRepository;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class DesinscreverEventoService {

    @Autowired
    private DeputadoRepository deputadoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Transactional
    public void desinscrever(Long idDeputado, Long idEvento) {

        if(!deputadoRepository.existsById(idDeputado)){
            throw new ResponseStatusException(NOT_FOUND, "Deputado não encontrado.");
        }

        if(!eventoRepository.existsById(idEvento)){
            throw new ResponseStatusException(NOT_FOUND, "Evento não encontrado.");
        }

        Deputado deputado = deputadoRepository.findById(idDeputado).get();

        Evento evento = eventoRepository.findById(idEvento).get();

        if(eventoRepository.existsByIdAndDeputadosNot(idEvento, deputado)){
            throw new ResponseStatusException(BAD_REQUEST, "Deputado não está inscrito nesse evento.");
        }

        List<Evento> eventosDeputado = eventoRepository.findAllByDeputados(deputado);

        List<Deputado> deputadosEvento = deputadoRepository.findAllByEventos(evento);

        eventosDeputado.remove(evento);

        deputadosEvento.remove(deputado);

        deputado.setEventos(eventosDeputado);

        evento.setDeputados(deputadosEvento);

        deputadoRepository.save(deputado);

        eventoRepository.save(evento);
    }
}
