package vlada.spring.microservice.filmovikatalogservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KorisnikRaitingLista {


    private String korisnikId;
    private List<Raiting> korisnikRaiting;

}
