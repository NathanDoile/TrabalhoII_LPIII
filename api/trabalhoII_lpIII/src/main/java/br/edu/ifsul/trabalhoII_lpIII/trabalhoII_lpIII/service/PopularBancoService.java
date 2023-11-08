package br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.service;

import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Deputado;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.domain.Evento;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository.DeputadoRepository;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.repository.EventoRepository;
import br.edu.ifsul.trabalhoII_lpIII.trabalhoII_lpIII.utils.LocalDateTimeDeserializer;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PopularBancoService {


    @Autowired
    private DeputadoRepository deputadoRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @PostConstruct
    @Transactional
    public void popularDeputados() throws IOException {

        if(deputadoRepository.findAll().isEmpty()){

            GsonBuilder gsonBuilder = new GsonBuilder();

            gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

            Gson gson = gsonBuilder.setPrettyPrinting().create();

            String jsonText = readJson("deputados.json");

            Type type = new TypeToken<List<Deputado>>(){}.getType();

            List<Deputado> deputados = gson.fromJson(jsonText, type);

            for(Deputado deputado : deputados){
                deputado.setId(null);
                deputadoRepository.save(deputado);
            }

        }

    }

    @PostConstruct
    @Transactional
    public void popularEvento() throws IOException {

        if(eventoRepository.findAll().isEmpty()){

            GsonBuilder gsonBuilder = new GsonBuilder();

            gsonBuilder.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer());

            Gson gson = gsonBuilder.setPrettyPrinting().create();

            String jsonText = readJson("eventos.json");

            Type type = new TypeToken<List<Evento>>(){}.getType();

            List<Evento> eventos = gson.fromJson(jsonText, type);

            for(Evento evento : eventos){
                eventoRepository.save(evento);
            }

        }

    }

    public static String readJson(String path) throws IOException {

        String json = String.join(" ",
                Files.readAllLines(
                        Paths.get(path),
                        StandardCharsets.UTF_8)
        );

        return json;
    }
}
