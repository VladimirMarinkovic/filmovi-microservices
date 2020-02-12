package vlada.spring.microservice.raitingpodaciservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Raiting {

    private String filmId;
    private int rating;
}
