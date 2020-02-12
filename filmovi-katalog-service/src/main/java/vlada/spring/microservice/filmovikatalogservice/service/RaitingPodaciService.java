package vlada.spring.microservice.filmovikatalogservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import vlada.spring.microservice.filmovikatalogservice.model.KorisnikRaitingLista;
import vlada.spring.microservice.filmovikatalogservice.model.Raiting;

import java.util.Arrays;

@Service
public class RaitingPodaciService {



    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getFallbackKorisnikRaiting",
    threadPoolKey = "filmoviInfoPool",
            threadPoolProperties = {                                            // Bulkhead Pattern
            @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
            }
    )
    public KorisnikRaitingLista getKorisnikRaiting(@PathVariable("korisnikId") String korisnikId) {
        return restTemplate.getForObject("http://rating-podaci-service/raitingpodaci/korisnik/" + korisnikId, KorisnikRaitingLista.class);
    }


    // fallBack hystrix
    public KorisnikRaitingLista getFallbackKorisnikRaiting(@PathVariable("korisnikId") String korisnikId){
        KorisnikRaitingLista korisnikRaitingLista = new KorisnikRaitingLista();
        korisnikRaitingLista.setKorisnikId(korisnikId);
        korisnikRaitingLista.setKorisnikRaiting(Arrays.asList( new Raiting("0",0)));
        return korisnikRaitingLista;
    }
}
