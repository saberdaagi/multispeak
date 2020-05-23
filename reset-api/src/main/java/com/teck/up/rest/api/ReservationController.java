package com.teck.up.rest.api;

import com.teck.up.rest.domain.ReservationEntity;
import com.teck.up.rest.dto.ReservationDTO;
import com.teck.up.rest.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ReservationController {

    final ReservationService reservationService;




    @GetMapping(path = "/all")
    public List<ReservationDTO> retriveListReservation() {

        return reservationService.getAll();
    }

    @GetMapping("/get/{id}")
    public ReservationDTO getReservation(@PathVariable Long id) {
        ReservationEntity reservation = reservationService.getReservation(id);
        return reservation.ToReservationDTO(reservation);
    }


    @PostMapping("/add")
    public void add(@RequestBody ReservationEntity reservation) {
        reservationService.add(reservation);
    }


    @DeleteMapping("/remove/{id}")
    public void removeReservation(@PathVariable Long id) {
        reservationService.delete(id);
    }

    @PutMapping("/update")
    public void updateReservation(@Valid @RequestBody ReservationDTO reservationDTO) {
        reservationService.update(reservationDTO.ToReservation(reservationDTO));
    }
}
