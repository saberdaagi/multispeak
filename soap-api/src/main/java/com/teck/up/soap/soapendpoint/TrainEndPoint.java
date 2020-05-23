package com.teck.up.soap.soapendpoint;

import com.reseration.xml.*;
import com.teck.up.soap.UIModel.TrainDTO;
import com.teck.up.soap.services.impl.TrainServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@Slf4j
public class TrainEndPoint {
    private static final String NAMESPACE_URI = "http://www.reseration.com/xml";
    @Autowired
    TrainServiceImpl trainServices;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TrainsRequest")
    @ResponsePayload
    public TrainDetailsResponse getAll(@RequestPayload TrainsRequest request) {
        TrainDetailsResponse response = new TrainDetailsResponse();
        trainServices.getRequestAllTrains().stream().forEach(trainDTO -> {

            response.getTrains().add(trainDTO.toTrain(trainDTO));

        });


        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SearchedTrainRequest")
    @ResponsePayload
    public TrainDetailsResponse getsearchedTrain(@RequestPayload SearchedTrainRequest request) {
        TrainDetailsResponse response = new TrainDetailsResponse();
        trainServices.searchTrain(request).stream().forEach(trainDTO -> {

            response.getTrains().add(trainDTO.toTrain(trainDTO));

        });


        return response;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddTrainRequest")
    @ResponsePayload
    public TrainDetailsResponse addTrain(@RequestPayload AddTrainRequest train) {
        trainServices.addTrain(train);
        TrainDetailsResponse response = new TrainDetailsResponse();
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
        response.getTrains().add(trainDTO.toTrain(trainDTO));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "UpdateTrainRequest")
    @ResponsePayload
    public TrainDetailsResponse updateTrain(@RequestPayload UpdateTrainRequest train) {
        trainServices.updateTrain(train);
        TrainDetailsResponse response = new TrainDetailsResponse();
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
        response.getTrains().add(trainDTO.toTrain(trainDTO));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RemoveTrainRequest")
    @ResponsePayload
    public TrainIdResponse removeTrain(@RequestPayload RemoveTrainRequest train) {
        trainServices.removeTrain(train);
        TrainIdResponse response = new TrainIdResponse();
        response.setId(train.getId());

        return response;
    }
}