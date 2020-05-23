package com.teck.up.soap.service;

import com.reseration.xml.AddClientRequest;
import com.reseration.xml.RemoveClientRequest;
import com.reseration.xml.UpdateClientRequest;
import com.teck.up.soap.UIModel.ClientDTO;

import java.util.List;

public interface ClientService {
    List<ClientDTO> getRequestAllClient();

    void addClient(AddClientRequest client);

    void removeClient(RemoveClientRequest client);

    void updateClient(UpdateClientRequest client);
}
