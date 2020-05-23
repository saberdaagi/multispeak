package com.teck.up.rest.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.teck.up.rest.repository.ClientRepository;
import com.teck.up.rest.domain.ClientEntity;
import com.teck.up.rest.dto.ClientDTO;
import com.teck.up.rest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {


	ClientEntity client =new ClientEntity();
	@Autowired
	ClientRepository clientRepository;
	
	
	@Override
	public void add(ClientEntity client) {
		ClientEntity c =clientRepository.FindById(client.getId_client());
		if(c ==null) 
			clientRepository.save(client);			
		else
			throw new RuntimeException( "Client déja existant");
		
		
	}

	@Override
	public void delete(Long id) {
		ClientEntity c =clientRepository.FindById(id);
		if(c!= null) 
			clientRepository.deleteById(id);	
		else throw new RuntimeException( "Ce client n'existe pas");

	}

	@Override
	public ClientEntity getClient(Long id) {
		return clientRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("client Introuvable"));

	}


	@Override
	public List<ClientEntity> getAllClients() {
		List<ClientEntity> ClientList = clientRepository.findAll();
		if (ClientList.size()>0)
			return clientRepository.findAll();
		else
			return Collections.emptyList();
	}


	@Override
	public List<ClientDTO> getAll() {
		
		List<ClientEntity> clients = clientRepository.findAll();
		if (clients.size()>0) {
			List<ClientDTO> listCrc=new ArrayList<ClientDTO>();
			for (ClientEntity client : clients) {
				listCrc.add(client.toClientDTO(client));
			}
			return listCrc;
		}else
			return Collections.emptyList();
			
	}


	@Override
	public void update(ClientEntity client) {
		ClientEntity c = clientRepository.FindById(client.getId_client());
		if(c == null)
			clientRepository.save(client);
			else {
				c.setId_client(client.getId_client());
				c.setNom(client.getNom());
				c.setPrenom(client.getPrenom());
				clientRepository.save(c);
			}
	}
}
