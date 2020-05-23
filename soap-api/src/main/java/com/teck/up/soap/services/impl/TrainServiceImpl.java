package com.teck.up.soap.services.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.reseration.xml.AddTrainRequest;
import com.reseration.xml.RemoveTrainRequest;
import com.reseration.xml.SearchedTrainRequest;
import com.reseration.xml.UpdateTrainRequest;
import com.teck.up.soap.UIModel.TrainDTO;
import com.teck.up.soap.services.TrainService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("TrainService")
public class TrainServiceImpl implements TrainService {

    private static final String PATH_API_TRAIN = "http://localhost:8080/api/train/";

    @Override
    public List<TrainDTO> getRequestAllTrains() {
        RestTemplate restTemplate = new RestTemplate();
        TrainDTO[] result = restTemplate.getForObject(PATH_API_TRAIN + "all", TrainDTO[].class);
        return Arrays.asList(result);
    }
    @Override
    public List<TrainDTO> searchTrain(SearchedTrainRequest train) {

        RestTemplate restTemplate = new RestTemplate();

        TrainDTO trainDTO = new TrainDTO();
        if (train.getCapacite() != null) {
            trainDTO.setCapacite(Integer.parseInt(train.getCapacite().toString()));
        }
        if (train.getDateArrive() != null)
            trainDTO.setDate_arrive(train.getDateArrive().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
        if (train.getDateDepart() != null)
            trainDTO.setDate_depart(train.getDateDepart().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
        if (train.getNbrPlaceActuel() != null)
            trainDTO.setNbr_place_actuel(Integer.parseInt(train.getNbrPlaceActuel().toString()));
        trainDTO.setV_arrive(train.getVArrive());
        trainDTO.setV_arrive(train.getVDepart());
        // Data attached to the request.
        HttpEntity<TrainDTO> requestBody = new HttpEntity<>(trainDTO);

        // Send request with POST method.
        ResponseEntity<TrainDTO[]> result
                = restTemplate.postForEntity(PATH_API_TRAIN + "search", requestBody, TrainDTO[].class);
        List<TrainDTO> listTrain = new ArrayList<>();
        listTrain.addAll(Arrays.asList(result.getBody()));
        return listTrain;
    }
    @Override
    public void addTrain(AddTrainRequest train) {
        RestTemplate restTemplate = new RestTemplate();

        TrainDTO trainDTO = new TrainDTO();
        if (train.getCapacite() != null) {
            trainDTO.setCapacite(Integer.parseInt(train.getCapacite().toString()));
        }
        if (train.getDateArrive() != null)
            trainDTO.setDate_arrive(train.getDateArrive().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
        if (train.getDateDepart() != null)
            trainDTO.setDate_depart(train.getDateDepart().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
        if (train.getNbrPlaceActuel() != null)
            trainDTO.setNbr_place_actuel(Integer.parseInt(train.getNbrPlaceActuel().toString()));
        trainDTO.setV_arrive(train.getVArrive());
        trainDTO.setV_arrive(train.getVDepart());
        // Data attached to the request.
        HttpEntity<TrainDTO> requestBody = new HttpEntity<>(trainDTO);

        // Send request with POST method.
        ResponseEntity<String> result
                = restTemplate.postForEntity(PATH_API_TRAIN + "add", requestBody, String.class);

    }
    @Override
    public void updateTrain(UpdateTrainRequest train) {
        RestTemplate restTemplate = new RestTemplate();

        TrainDTO trainDTO = new TrainDTO();
        if (train.getCapacite() != null) {
            trainDTO.setCapacite(Integer.parseInt(train.getCapacite().toString()));
        }
        if (train.getDateArrive() != null)
            trainDTO.setDate_arrive(train.getDateArrive().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
        if (train.getDateDepart() != null)
            trainDTO.setDate_depart(train.getDateDepart().toGregorianCalendar().toZonedDateTime().toLocalDateTime());
        if (train.getNbrPlaceActuel() != null)
            trainDTO.setNbr_place_actuel(Integer.parseInt(train.getNbrPlaceActuel().toString()));
        trainDTO.setV_arrive(train.getVArrive());
        trainDTO.setV_arrive(train.getVDepart());
        // Data attached to the request.
        HttpEntity<TrainDTO> requestBody = new HttpEntity<>(trainDTO);

        restTemplate.put(PATH_API_TRAIN + "update", requestBody, new Object[]{});

    }
    @Override
    public void removeTrain(RemoveTrainRequest train) {

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(PATH_API_TRAIN + "remove/" + train.getId().toString());
    }
}
