package com.teck.up.soap.services.impl;

import com.reseration.xml.AddClientRequest;
import com.reseration.xml.RemoveClientRequest;
import com.reseration.xml.UpdateClientRequest;
import com.teck.up.soap.UIModel.ClientDTO;
import com.teck.up.soap.services.ClientService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service("ClientService")
public class ClientServiceImpl implements ClientService {

    private static final String PATH_API_TRAIN = "http://localhost:8080/api/client/";

    @Override
    public List<ClientDTO> getRequestAllClient() {
        RestTemplate restTemplate = new RestTemplate();
        ClientDTO[] result = restTemplate.getForObject(PATH_API_TRAIN + "all", ClientDTO[].class);
        return Arrays.asList(result);
    }
    @Override
    public void addClient(AddClientRequest client) {
        RestTemplate restTemplate = new RestTemplate();

        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNom(client.getNom());
        clientDTO.setPrenom(client.getPrenom());
        HttpEntity<ClientDTO> requestBody = new HttpEntity<>(clientDTO);

        // Send request with POST method.
        ResponseEntity<String> result
                = restTemplate.postForEntity(PATH_API_TRAIN + "add", requestBody, String.class);

    }
    @Override
    public void removeClient(RemoveClientRequest client) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(PATH_API_TRAIN + "remove/" + client.getId().toString());

    }
    @Override
    public void updateClient(UpdateClientRequest client) {
        RestTemplate restTemplate = new RestTemplate();


        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setNom(client.getNom());
        clientDTO.setPrenom(client.getPrenom());
        clientDTO.setId_client(Long.parseLong(client.getId().toString()));
        HttpEntity<ClientDTO> requestBody = new HttpEntity<>(clientDTO);

        restTemplate.put(PATH_API_TRAIN + "update", requestBody, new Object[]{});
    }
}
