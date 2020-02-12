package vlada.spring.microservice.filmovikatalogservice.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {



    // Bean za WebClient (reaktivni pristup - umesto rest template)
    @Bean
    public WebClient.Builder getWebClientBuilder() {
        return  WebClient.builder();
    }


    // Load balance
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }




    //  Postavlja maksimalno vreme cekanja za izvrsavanje zahteva (niti)
//    @Bean
//    @LoadBalanced
//    public RestTemplate getRestTemplate() {
//
//        HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
//        httpComponentsClientHttpRequestFactory.setConnectTimeout(3000);
//        return new RestTemplate(httpComponentsClientHttpRequestFactory);
//    }



}
