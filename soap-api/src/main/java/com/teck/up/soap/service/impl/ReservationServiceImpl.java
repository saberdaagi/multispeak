package com.teck.up.soap.service.impl;

import com.reseration.xml.AddReservationRequest;
import com.reseration.xml.RemoveReservationRequest;
import com.reseration.xml.UpdateReservationRequest;
import com.teck.up.soap.UIModel.ReservationDTO;
import com.teck.up.soap.service.ReservationService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component("ReservationService")
public class ReservationServiceImpl implements ReservationService {

    private static final String PATH_API_TRAIN = "http://localhost:8082/api/reservation/";
    @Override
    public List<ReservationDTO> getRequestAllReservation() {
        RestTemplate restTemplate = new RestTemplate();
        ReservationDTO[] result = restTemplate.getForObject(PATH_API_TRAIN + "all", ReservationDTO[].class);
        return Arrays.asList(result);
    }
    @Override
    public void addReservation(AddReservationRequest request) {

        RestTemplate restTemplate = new RestTemplate();

        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setClient(Long.parseLong(request.getIdClient().toString()));
        reservationDTO.setTrain(Long.parseLong(request.getIdTrain().toString()));


        HttpEntity<ReservationDTO> requestBody = new HttpEntity<>(reservationDTO);

        // Send request with POST method.
        ResponseEntity<String> result
                = restTemplate.postForEntity(PATH_API_TRAIN + "add", requestBody, String.class);


    }
    @Override
    public void removeReservation(RemoveReservationRequest reservationRequest) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(PATH_API_TRAIN + "remove/" + reservationRequest.getId().toString());
    }
    @Override
    public void updateReservation(UpdateReservationRequest reservation) {
        RestTemplate restTemplate = new RestTemplate();


        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setClient(Long.parseLong(reservation.getIdClient().toString()));
        reservationDTO.setId_reservation(Long.parseLong(reservation.getIdReservation().toString()));
        reservationDTO.setTrain(Long.parseLong(reservation.getIdTrain().toString()));
        HttpEntity<ReservationDTO> requestBody = new HttpEntity<>(reservationDTO);

        restTemplate.put(PATH_API_TRAIN + "update", requestBody, new Object[]{});
    }
}
