package vlada.spring.microservice.filmovikatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import vlada.spring.microservice.filmovikatalogservice.model.Film;
import vlada.spring.microservice.filmovikatalogservice.model.KatalogStavka;
import vlada.spring.microservice.filmovikatalogservice.model.Raiting;

@Service
public class FilmoviInfoService {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getFallbackKatalogStavka")
    public KatalogStavka getKatalogStavka(Raiting rating) {
        Film film = restTemplate.getForObject("http://filmovi-info-service/filmovi/" + rating.getFilmId(), Film.class);
        return new KatalogStavka(film.getNazivFilma(), film.getOpisFilma(), rating.getRating());
    }
    // fallBack hystrix
    public KatalogStavka getFallbackKatalogStavka(Raiting rating) {
        return new KatalogStavka("Nije pronadjen naziv filma","/" , rating.getRating());
    }

}
