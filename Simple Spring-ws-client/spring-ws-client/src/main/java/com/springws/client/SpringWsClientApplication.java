package com.springws.client;

import com.genwebservice.Weatherpersons;
import com.genwebservice.Webservicerequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@SpringBootApplication
public class SpringWsClientApplication {

    public static void main(String[] args) { SpringApplication.run(SpringWsClientApplication.class, args);

    }

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setClassesToBeBound(Webservicerequest.class, Weatherpersons.class);
        return jaxb2Marshaller;
    }
}
