package com.teck.up.soap.services;

import com.reseration.xml.AddTrainRequest;
import com.reseration.xml.RemoveTrainRequest;
import com.reseration.xml.SearchedTrainRequest;
import com.reseration.xml.UpdateTrainRequest;
import com.teck.up.soap.UIModel.TrainDTO;

import java.util.List;

public interface TrainService {
    List<TrainDTO> getRequestAllTrains();

    List<TrainDTO> searchTrain(SearchedTrainRequest train);

    void addTrain(AddTrainRequest train);

    void updateTrain(UpdateTrainRequest train);

    void removeTrain(RemoveTrainRequest train);
}
