package com.teck.up.soap.UIModel;

import com.reseration.xml.Reservation;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
public class ReservationDTO {


    private Long id_reservation;


    private Long client;


    private Long train;


    //*************** Model Mapper ***************
    public Reservation ToReservation(ReservationDTO reservationDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(reservationDTO, Reservation.class);
    }

}
