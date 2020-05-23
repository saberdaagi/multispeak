package com.teck.up.rest.service;

import com.teck.up.rest.domain.ReservationEntity;
import com.teck.up.rest.dto.ReservationDTO;

import java.util.List;

public interface ReservationService {
    void add(ReservationEntity reservation);

    String delete(Long id);

    ReservationEntity getReservation(Long id);

    List<ReservationEntity> getAllReservations();

    List<ReservationDTO> getAll();

    void update(ReservationEntity reservation);
}
