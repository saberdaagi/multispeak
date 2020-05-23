package com.teck.up.rest.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.teck.up.rest.dto.ReservationDTO;
import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ReservationEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_reservation;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_client")
	//@JsonBackReference
	private ClientEntity client;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_train")
	//@JsonBackReference
	private TrainEntity train;
	
	
	
	//*************** Model Mapper ***************
	public ReservationDTO ToReservationDTO(ReservationEntity reservation) {
		ModelMapper mapper= new ModelMapper();
		return mapper.map(reservation, ReservationDTO.class);
	}


}
