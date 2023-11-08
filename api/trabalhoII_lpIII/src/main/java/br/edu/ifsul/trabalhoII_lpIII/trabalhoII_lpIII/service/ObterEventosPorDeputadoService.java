package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.controller.response.EventoResponse;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Deputado;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Evento;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.mapper.EventoMapper;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository.DeputadoRepository;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ObterEventosPorDeputadoService {

    @Autowired
    private DeputadoRepository deputadoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public List<EventoResponse> obter(Long id) {

        if(!deputadoRepository.existsById(id)){
            throw new ResponseStatusException(NOT_FOUND, "Deputado não encontrado.");
        }

        Deputado deputado = deputadoRepository.findById(id).get();

        List<Evento> eventos = eventoRepository.findAllByDeputados(deputado);

        return eventos
                .stream()
                .map(EventoMapper::toResponse)
                .toList();
    }
}
