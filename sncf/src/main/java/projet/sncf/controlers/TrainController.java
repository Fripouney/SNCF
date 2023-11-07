package projet.sncf.controlers;

import projet.sncf.repositories.*;
import projet.sncf.tables.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    @Autowired
    private TrainRepository trainRepository;

    @GetMapping
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    @GetMapping("/{id}")
    public Train getTrainById(@PathVariable Long id) {
        return trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found with id " + id));
    }

    @PostMapping
    public Train createTrain(@RequestBody Train train) {
        return trainRepository.save(train);
    }

    @PutMapping("/{id}")
    public Train updateTrain(@PathVariable Long id, @RequestBody Train trainDetails) {
        Train train = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found with id " + id));

        train.setDelay(trainDetails.getDelay());
        train.setIsCanceled(trainDetails.getIsCanceled());

        return trainRepository.save(train);
    }

    @DeleteMapping("/{id}")
    public void deleteTrain(@PathVariable Long id) {
        Train existingTrain = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found with id " + id));
        trainRepository.delete(existingTrain);
    }
}

