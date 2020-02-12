package vlada.spring.microservice.filmoviinfoservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import vlada.spring.microservice.filmoviinfoservice.model.Film;
import vlada.spring.microservice.filmoviinfoservice.model.FilmRezime;

@RestController
@RequestMapping("/filmovi")
public class FilmResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{filmId}")
    public Film prikaziFilmInfo(@PathVariable("filmId") String filmId) {
        FilmRezime filmRezime = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+filmId+"?api_key="+apiKey, FilmRezime.class);
        return new Film(filmId, filmRezime.getTitle(), filmRezime.getOverview());

    }
}
