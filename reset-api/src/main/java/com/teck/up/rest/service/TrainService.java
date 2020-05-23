package com.teck.up.rest.service;

import com.teck.up.rest.domain.TrainEntity;
import com.teck.up.rest.dto.TrainDTO;

import java.util.List;

public interface TrainService {
    String add(TrainEntity train);

    String delete(Long id);

    TrainEntity getTrain(Long id);

    List<TrainDTO> search(TrainEntity trainEntity);

    List<TrainEntity> getAllTrains();

    List<TrainDTO> getAll();

    void update(TrainEntity train);
}
