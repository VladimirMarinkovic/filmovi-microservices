package vlada.spring.microservice.filmoviinfoservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Film {

    private String filmId;
    private String nazivFilma;
    private String opisFilma;

}
