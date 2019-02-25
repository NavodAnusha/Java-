package com.springws.client;

import com.genwebservice.Weatherpersons;
import com.genwebservice.Webservicerequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;


@ComponentScan
public class CommandLine implements CommandLineRunner {

    @Autowired
    private Jaxb2Marshaller marshaller;

    @Override
    public void run(String... strings) throws Exception {

        // ***********************************************
        String URI = "http://localhost:8080/ws/mywebservice";
        Webservicerequest webservicerequest = new Webservicerequest();
        webservicerequest.setItemId("2");
        webservicerequest.setItemDesc("desc");
        webservicerequest.setItemName("name");

        // ***********************************************

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);

        for(int x=1; x<10;x++) {
            Weatherpersons weatherpersons = (Weatherpersons) webServiceTemplate.marshalSendAndReceive(URI, webservicerequest);

            System.out.println("Response token: " + weatherpersons.getToken());
        }

    }


}
