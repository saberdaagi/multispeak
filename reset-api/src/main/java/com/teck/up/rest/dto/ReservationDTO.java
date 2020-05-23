package com.teck.up.rest.dto;

import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import com.teck.up.rest.domain.ClientEntity;
import com.teck.up.rest.domain.ReservationEntity;
import com.teck.up.rest.domain.TrainEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationDTO {

	@Id

	private Long id_reservation;
	
	
	private ClientEntity client;
	

	private TrainEntity train;
	
	
	
	
	
	//*************** Model Mapper ***************
	public ReservationEntity ToReservation(ReservationDTO reservationDTO) {
		ModelMapper mapper= new ModelMapper();
		return mapper.map(reservationDTO, ReservationEntity.class);
	}

}
