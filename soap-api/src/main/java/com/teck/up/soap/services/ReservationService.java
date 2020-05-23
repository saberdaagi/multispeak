package com.teck.up.soap.services;

import com.reseration.xml.AddReservationRequest;
import com.reseration.xml.RemoveReservationRequest;
import com.reseration.xml.UpdateReservationRequest;
import com.teck.up.soap.UIModel.ReservationDTO;

import java.util.List;

public interface ReservationService {
    List<ReservationDTO> getRequestAllReservation();

    void addReservation(AddReservationRequest request);

    void removeReservation(RemoveReservationRequest reservationRequest);

    void updateReservation(UpdateReservationRequest reservation);
}
