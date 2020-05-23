package com.teck.up.rest.api;

import com.teck.up.rest.domain.TrainEntity;
import com.teck.up.rest.dto.TrainDTO;
import com.teck.up.rest.service.TrainService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/train")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TrainController {

    final TrainService trainService;


    @GetMapping("/all")
    public List<TrainDTO> retriveListTrain() {

        return trainService.getAll();
    }

    @GetMapping("/get/{id}")
    public TrainDTO getTrain(@PathVariable Long id) {
        TrainEntity train = trainService.getTrain(id);
        return train.toTrainDTO(train);
    }


    @PostMapping(path = "/search")
    public List<TrainDTO> search(@RequestBody TrainDTO trainDTO) {

        List<TrainDTO> trainList = trainService.search(trainDTO.toTrain(trainDTO));

        return trainList;
    }

    @PostMapping("/add")
    public void add(@Valid @RequestBody TrainDTO trainDTO) {
        trainService.add(trainDTO.toTrain(trainDTO));
    }

    @DeleteMapping("/remove/{id}")
    public void remove(@PathVariable Long id) {
        trainService.delete(id);
    }

    @PutMapping("/update")
    public void update(@Valid @RequestBody TrainDTO trainDTO) {
        trainService.update(trainDTO.toTrain(trainDTO));
    }
}
