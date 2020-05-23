package com.teck.up.soap.soapendpoint;

import com.reseration.xml.*;
import com.teck.up.soap.services.impl.ReservationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@Slf4j
public class ReservationEndPoint {
    private static final String NAMESPACE_URI = "http://www.reseration.com/xml";

    @Autowired
    ReservationServiceImpl reservationServices;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ReservationsRequest")
    @ResponsePayload
    public ReservationDetailsResponse getAll(@RequestPayload ReservationsRequest request) {
        ReservationDetailsResponse response = new ReservationDetailsResponse();
        reservationServices.getRequestAllReservation().stream().forEach(reservationDTO -> {

            response.getReservations().add(reservationDTO.ToReservation(reservationDTO));

        });


        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddReservationRequest")
    @ResponsePayload
    public ReservationDetailsResponse add(@RequestPayload AddReservationRequest request) {
        ReservationDetailsResponse response = new ReservationDetailsResponse();
        reservationServices.addReservation(request);

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RemoveReservationRequest")
    @ResponsePayload
    public ReservationIdResponse remove(@RequestPayload RemoveReservationRequest reservationRequest) {
        reservationServices.removeReservation(reservationRequest);
        ReservationIdResponse response = new ReservationIdResponse();
        response.setId(reservationRequest.getId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateReservationRequest")
    @ResponsePayload
    public ClientIdResponse update(@RequestPayload UpdateReservationRequest reservation) {
        reservationServices.updateReservation(reservation);
        ClientIdResponse response = new ClientIdResponse();
        response.setId(reservation.getIdReservation());
        return response;
    }
}