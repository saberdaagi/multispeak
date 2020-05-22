package com.teck.up.multispeak;

import com.hkeya.xml.train.AddTrainRequest;
import com.hkeya.xml.train.TrainDetailsRequest;
import com.hkeya.xml.train.TrainDetailsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
@Slf4j
public class TrainEndpoint {
    private static final String NAMESPACE_URI = "http://www.hkeya.com/xml/train";

    private TrainRepository TrainRepository;

    @Autowired
    public TrainEndpoint(TrainRepository TrainRepository) {
        this.TrainRepository = TrainRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "TrainDetailsRequest")
    @ResponsePayload
    public TrainDetailsResponse getTrain(@RequestPayload TrainDetailsRequest request) {
        TrainDetailsResponse response = new TrainDetailsResponse();
        response.setTrain(TrainRepository.findTrain(request.getId()));

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddTrainRequest")
    @ResponsePayload
    public TrainDetailsResponse addTrain(@RequestPayload AddTrainRequest request) {
        TrainDetailsResponse response = new TrainDetailsResponse();

        log.info("{}",request.getId());
        response.setTrain(TrainRepository.findTrain(request.getId()));
        return response;
    }


}