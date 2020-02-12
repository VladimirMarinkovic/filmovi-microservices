package vlada.spring.microservice.filmovikatalogservice.resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import vlada.spring.microservice.filmovikatalogservice.model.Film;
import vlada.spring.microservice.filmovikatalogservice.model.KatalogStavka;
import vlada.spring.microservice.filmovikatalogservice.model.KorisnikRaitingLista;
import vlada.spring.microservice.filmovikatalogservice.model.Raiting;
import vlada.spring.microservice.filmovikatalogservice.service.FilmoviInfoService;
import vlada.spring.microservice.filmovikatalogservice.service.RaitingPodaciService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/katalog")
public class FilmoviKatalogResource {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    FilmoviInfoService filmoviInfoService;

    @Autowired
    RaitingPodaciService raitingPodaciService;






    @RequestMapping("/{korisnikId}")
    public List<KatalogStavka> getKatalog(@PathVariable("korisnikId") String korisnikId) {

        KorisnikRaitingLista korisnikRaitingLista = raitingPodaciService.getKorisnikRaiting(korisnikId);

        return korisnikRaitingLista.getKorisnikRaiting().stream()
                .map(rating -> filmoviInfoService.getKatalogStavka(rating))
                .collect(Collectors.toList());

    }














//    @RequestMapping("/{korisnikId}")
//    public List<KatalogStavka> prikaziKatalog(@PathVariable("korisnikId") String korisnikId) {
//
//        KorisnikRaitingLista korisnikRaitingLista = restTemplate.getForObject("http://raiting-podaci-service/raitingpodaci/korisnik/"+korisnikId, KorisnikRaitingLista.class);
//        return korisnikRaitingLista.getKorisnikRaiting().stream().map(raiting -> {
//            // Za svaki Film ID poziva se film-info-service i vracaju podaci
//            Film film = restTemplate.getForObject("http://filmovi-info-service/filmovi/" + raiting.getFilmId(), Film.class);
//            // Kolektovanje podataka
//            return  new KatalogStavka(film.getNazivFilma(), "AAAAAAA", raiting.getRating());
//       })
//               .collect(Collectors.toList());
//
//    }
//



    // WEB CLIENT _ REACTIV

//    @RequestMapping("/{korisnikId}")
//    public List<KatalogStavka> prikaziKatalog(@PathVariable("korisnikId") String korisnikId) {
//
//        List<Raiting> raitings = Arrays.asList(
//                new Raiting("1234",4),
//                new Raiting("5678",3)
//        );
//
//        return raitings.stream().map(raiting -> {
//
//            Film film = webClientBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/filmovi/" + raiting.getFilmId())
//                    .retrieve()
//                    .bodyToMono(Film.class)
//                    .block();
//
//            return  new KatalogStavka(film.getNazivFilma(), "TestOpis", raiting.getRating());
//        })
//                .collect(Collectors.toList());
//    }



}
