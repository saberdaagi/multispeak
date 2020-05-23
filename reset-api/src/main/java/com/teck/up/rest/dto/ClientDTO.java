package com.teck.up.rest.dto;

import java.util.List;

import org.modelmapper.ModelMapper;

import com.teck.up.rest.domain.ClientEntity;
import com.teck.up.rest.domain.ReservationEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {
	
	private Long id_client;

	private String nom;

	private String prenom;
	

	private List<ReservationEntity> resevations;

	
	//******************Mode Mapper*************************
	public ClientEntity toClient(ClientDTO clientDTO) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(clientDTO, ClientEntity.class);
	}

}
