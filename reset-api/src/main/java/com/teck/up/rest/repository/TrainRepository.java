package com.teck.up.rest.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.teck.up.rest.domain.TrainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TrainRepository extends JpaRepository<TrainEntity, Long>{
	
	
	  @Query("select t from TrainEntity t where t.id like :x")
      TrainEntity
	  FindById(@Param("x")Long id);
	  
	  @Query("select t from TrainEntity t where t.V_depart like :x") List<TrainEntity>
	  findAllByV_depart(@Param("x") String V_depart);
	  
	  @Query("select t from TrainEntity t where t.V_arrive like :x") List<TrainEntity>
	  findAllByV_arrive(@Param("x") String V_arrive);
	  
	  @Query("select t from TrainEntity t where t.date_depart like :x") List<TrainEntity>
	  findAllByDate_depart(@Param("x") LocalDateTime date_depart);
	  
	  @Query("select t from TrainEntity t where t.date_arrive like :x") List<TrainEntity>
	  findAllByDate_arrive(@Param("x") LocalDateTime date_arrive);
	 

	
}
