package vlada.spring.microservice.raitingpodaciservice.resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vlada.spring.microservice.raitingpodaciservice.model.KorisnikRaitingLista;
import vlada.spring.microservice.raitingpodaciservice.model.Raiting;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/raitingpodaci")
public class RaitingPodaciResource {

    @RequestMapping("/{filmId}")
    public Raiting prikaziRaiting(@PathVariable("filmId") String filmId) {
        return new Raiting(filmId,4);
    }


    @RequestMapping("/korisnik/{korisnikId}")
    public KorisnikRaitingLista prikaziKorisnikRaiting(@PathVariable("korisnikId") String korisnikId) {
        KorisnikRaitingLista korisnikRaitingLista = new KorisnikRaitingLista();
        korisnikRaitingLista.initData(korisnikId);
        return korisnikRaitingLista;

    }
}
