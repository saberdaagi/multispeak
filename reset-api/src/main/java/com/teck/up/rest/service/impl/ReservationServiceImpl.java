package com.teck.up.rest.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.teck.up.rest.repository.ReservationRepository;
import com.teck.up.rest.domain.ReservationEntity;
import com.teck.up.rest.domain.TrainEntity;
import com.teck.up.rest.dto.ReservationDTO;
import com.teck.up.rest.service.ReservationService;
import com.teck.up.rest.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReservationServiceImpl implements ReservationService {

	final ReservationRepository reservationRepository;

	final TrainService trainService;
	
	
	@Override
	public void add(ReservationEntity reservation) {
	  
	  if(reservation.getTrain().getNbr_place_actuel() < reservation.getTrain().getCapacite()) {
		  System.out.println(reservation.toString());
		  reservationRepository.save(reservation); 
		  TrainEntity train = reservation.getTrain();
		  train.setNbr_place_actuel(train.getNbr_place_actuel()+1);
		  trainService.update(train);
	  } else throw new RuntimeException("Aucune place disponible pour cette destination");
	  
	  }



	@Override
	public String delete(Long id) {
		ReservationEntity r =reservationRepository.FindById(id);
		if(r!= null) {	
			reservationRepository.deleteById(id);
			return "réservation supprimé ";}
		else
			return "Réservation introuvable ";
	}


	@Override
	public ReservationEntity getReservation(Long id) {
		
		ReservationEntity reservation = reservationRepository.FindById(id);
		if (reservation == null)
			return new ReservationEntity();
		else
			return reservation;
		
	}


	@Override
	public List<ReservationEntity> getAllReservations() {
		List<ReservationEntity> reservationList = reservationRepository.findAll();
		if (reservationList.size()>0)
			return reservationRepository.findAll();
		else
			return Collections.emptyList();
	}



	@Override
	public List<ReservationDTO> getAll() {
	  
	  List<ReservationEntity> reservations = reservationRepository.findAll(); if
	  (reservations.size()>0) { List<ReservationDTO> listReservationDTO=new
	  ArrayList<ReservationDTO>(); for (ReservationEntity reservation : reservations) {
	  listReservationDTO.add(reservation.ToReservationDTO(reservation)); } return
	  listReservationDTO; }else return new ArrayList<ReservationDTO>();
	  
	  }



	@Override
	public void update(ReservationEntity reservation) {
		ReservationEntity r = reservationRepository.FindById(reservation.getId_reservation());
		if(r == null)
			reservationRepository.save(reservation);
			else {
				r.setId_reservation(reservation.getId_reservation());
				r.setClient(reservation.getClient());
				r.setTrain(reservation.getTrain());
							
				reservationRepository.save(r);
			}
	}
}
