package com.teck.up.rest.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.teck.up.rest.domain.TrainEntity;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TrainDTO {


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
	
	//*************** Model Mapper ***************
	public TrainEntity toTrain(TrainDTO trainDTO) {
		ModelMapper mapper= new ModelMapper();
		return mapper.map(trainDTO, TrainEntity.class);
	}

}
