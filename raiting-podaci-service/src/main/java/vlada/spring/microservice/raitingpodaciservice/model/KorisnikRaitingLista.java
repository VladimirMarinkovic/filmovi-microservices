package vlada.spring.microservice.raitingpodaciservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KorisnikRaitingLista {


    private String korisnikId;
    private List<Raiting> korisnikRaiting;



    public void initData(String korisnikId) {
        this.setKorisnikId(korisnikId);
        this.setKorisnikRaiting(Arrays.asList(
                new Raiting("100", 3),
                new Raiting("200", 4)
        ));
    }

}
