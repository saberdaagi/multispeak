package com.teck.up.rest.service;

import com.teck.up.rest.domain.ClientEntity;
import com.teck.up.rest.dto.ClientDTO;

import java.util.List;

public interface ClientService {


    void add(ClientEntity client);

    void delete(Long id);

    ClientEntity getClient(Long id);

    List<ClientEntity> getAllClients();


    List<ClientDTO> getAll();

    void update(ClientEntity client);
}
