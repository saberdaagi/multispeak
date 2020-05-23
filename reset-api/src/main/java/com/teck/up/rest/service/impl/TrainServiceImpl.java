package com.teck.up.rest.service.impl;

import com.teck.up.rest.repository.TrainRepository;
import com.teck.up.rest.domain.TrainEntity;
import com.teck.up.rest.dto.TrainDTO;
import com.teck.up.rest.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TrainServiceImpl implements TrainService {

    final TrainRepository trainRepository;

    @Override
    public String add(TrainEntity train) {
        TrainEntity t = trainRepository.FindById(train.getId_train());
        if (t == null) {
            trainRepository.save(train);
            return "Train ajouté ";
        } else
            return "Train déja existant ";

    }

    @Override
    public String delete(Long id) {
        TrainEntity t = trainRepository.FindById(id);
        if (t != null) {
            trainRepository.deleteById(id);
            return "Train supprimé ";
        } else
            return "Ce Train n'existe pas ";
    }

    @Override
    public TrainEntity getTrain(Long id) {

        return trainRepository.findById(id).orElseThrow(() -> new RuntimeException("Train Introuvable"));

    }

    @Override
    public List<TrainDTO> search(TrainEntity trainEntity) {


        List<TrainDTO> result = new ArrayList<TrainDTO>();
        List<TrainEntity> trainList = trainRepository.findAll();

        for (TrainEntity train : trainList) {

            if (trainEntity.getV_depart() != null) {
                if (!train.getV_depart().equalsIgnoreCase(trainEntity.getV_depart())) {
                    continue;
                }
            }


            if (trainEntity.getV_arrive() != null) {
                if (!train.getV_arrive().equalsIgnoreCase(trainEntity.getV_arrive())) {
                    continue;
                }
            }
            if (trainEntity.getDate_depart() != null) {
                if (!trainEntity.getDate_depart().equals(LocalDateTime.parse(train.getDate_depart().toString()))) {
                    continue;

                }

            }
            if (trainEntity.getDate_arrive() != null) {
                if (!trainEntity.getDate_arrive().equals(LocalDateTime.parse(train.getDate_arrive().toString()))) {
                    continue;

                }

            }

            result.add(train.toTrainDTO(train));
        }
        return result;

    }

    @Override
    public List<TrainEntity> getAllTrains() {
        List<TrainEntity> trainList = trainRepository.findAll();
        if (trainList.size() > 0)
            return trainRepository.findAll();
        else
            return  Collections.emptyList();
    }

    @Override
    public List<TrainDTO> getAll() {

        List<TrainEntity> trains = trainRepository.findAll();
        if (trains.size() > 0) {
            List<TrainDTO> listTrainDTO = new ArrayList<TrainDTO>();
            for (TrainEntity train : trains) {
                listTrainDTO.add(train.toTrainDTO(train));
            }
            return listTrainDTO;
        } else
            return Collections.emptyList();

    }

    @Override
    public void update(TrainEntity train) {
        TrainEntity trainEntity = trainRepository.FindById(train.getId_train());
        if (trainEntity == null)
            trainRepository.save(train);
        else {
            trainEntity.setId_train(train.getId_train());
            trainEntity.setCapacite(train.getCapacite());
            trainEntity.setDate_arrive(train.getDate_arrive());
            trainEntity.setDate_depart(train.getDate_depart());
            trainEntity.setNbr_place_actuel(train.getNbr_place_actuel());
            trainEntity.setV_arrive(train.getV_arrive());
            trainEntity.setV_depart(train.getV_depart());
            trainRepository.save(trainEntity);
        }
    }
}
