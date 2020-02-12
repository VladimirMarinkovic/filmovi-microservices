package vlada.spring.microservice.filmovikatalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KatalogStavka {

    private String nazivStavke;
    private String opisStavke;
    private int rating;
}
