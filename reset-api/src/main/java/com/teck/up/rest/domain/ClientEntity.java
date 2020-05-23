package com.teck.up.rest.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.teck.up.rest.dto.ClientDTO;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "client")
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_client;
	@NotBlank
	private String nom;
	@NotBlank
	private String prenom;
	
	@OneToMany(mappedBy = "client",fetch=FetchType.EAGER)

	
	private List<ReservationEntity> resevations;

	
	
	//******************Mode Mapper*************************
	public ClientDTO toClientDTO(ClientEntity client) {
		ModelMapper mapper = new ModelMapper();
		return mapper.map(client, ClientDTO.class);
	}

}
