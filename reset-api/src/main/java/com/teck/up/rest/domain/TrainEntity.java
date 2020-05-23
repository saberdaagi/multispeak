package com.teck.up.rest.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.teck.up.rest.dto.TrainDTO;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "train")
@Data
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class TrainEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_train;
	@NotBlank
	private String V_depart;
	@NotBlank
	private String V_arrive;
	@DateTimeFormat
	private LocalDateTime date_depart;
	@DateTimeFormat
	private LocalDateTime date_arrive;
	@Positive
	private int capacite;
	
	private int nbr_place_actuel;
	
	
	
	@OneToMany(mappedBy = "train",fetch=FetchType.EAGER)

	
	private List<ReservationEntity> resevations;
	
	
	//*************** Model Mapper ***************
	public TrainDTO toTrainDTO(TrainEntity train) {
		ModelMapper mapper= new ModelMapper();
		return mapper.map(train, TrainDTO.class);
	}


}
