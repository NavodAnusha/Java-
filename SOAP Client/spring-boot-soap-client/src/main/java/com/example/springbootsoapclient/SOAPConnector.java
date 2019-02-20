package com.example.springbootsoapclient;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class SOAPConnector extends WebServiceGatewaySupport {

	public Object callWebService(String url, Object request){
		return getWebServiceTemplate().marshalSendAndReceive(url, request);
	}
}