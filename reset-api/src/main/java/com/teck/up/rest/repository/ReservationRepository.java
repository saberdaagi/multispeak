package com.teck.up.rest.repository;

import com.teck.up.rest.domain.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
	
	@Query("select r from ReservationEntity r where r.id like :x")
    ReservationEntity FindById(@Param("x")Long id);

}
