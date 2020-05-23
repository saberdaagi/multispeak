package com.teck.up.soap.soapendpoint;

import com.reseration.xml.*;
import com.teck.up.soap.services.impl.ClientServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@Slf4j
public class ClientEndPoint {
    private static final String NAMESPACE_URI = "http://www.reseration.com/xml";

    @Autowired
    ClientServiceImpl clientServices;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ClientsRequest")
    @ResponsePayload
    public ClientDetailsResponse getAll(@RequestPayload ClientsRequest request) {
        ClientDetailsResponse response = new ClientDetailsResponse();
        clientServices.getRequestAllClient().stream().forEach(clientDTO -> {

            response.getClients().add(clientDTO.toClient(clientDTO));

        });


        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddClientRequest")
    @ResponsePayload
    public ClientDetailsResponse add(@RequestPayload AddClientRequest request) {
        ClientDetailsResponse response = new ClientDetailsResponse();
        clientServices.addClient(request);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RemoveClientRequest")
    @ResponsePayload
    public ClientIdResponse remove(@RequestPayload RemoveClientRequest client) {
        clientServices.removeClient(client);
        ClientIdResponse response = new ClientIdResponse();
        response.setId(client.getId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateClientRequest")
    @ResponsePayload
    public ClientIdResponse update(@RequestPayload UpdateClientRequest client) {
        clientServices.updateClient(client);
        ClientIdResponse response = new ClientIdResponse();
        response.setId(client.getId());
        return response;
    }
}