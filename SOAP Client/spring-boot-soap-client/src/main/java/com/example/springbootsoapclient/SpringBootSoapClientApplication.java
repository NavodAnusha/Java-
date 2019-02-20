package com.example.springbootsoapclient;

import com.example.client.ClientDetailsRequest;
import com.example.client.ClientDetailsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@SpringBootApplication
public class SpringBootSoapClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapClientApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return (String... args) -> {
			String name = "Test";//Default Name
			if(args.length>0){
				name = args[0];
			}
			ClientDetailsRequest request = new ClientDetailsRequest();
			request.setName(name);
			ClientDetailsResponse response =(ClientDetailsResponse) soapConnector.callWebService("http://localhost:8081/service/client-details", request);
			System.out.println("Got Response As below ========= : ");
			System.out.println("Name : "+response.getClient().getName());
			System.out.println("Standard : "+response.getClient().getStandard());
			System.out.println("Address : "+response.getClient().getAddress());
		};
	}
}
