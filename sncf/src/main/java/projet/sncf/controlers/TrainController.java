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

    // Get all trains
    @GetMapping
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }

    // Get a single train
    @GetMapping("/{id}")
    public Train getTrainById(@PathVariable Long id) {
        return trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found with id " + id));
    }

    // Create a new train
    @PostMapping
    public Train createTrain(@RequestBody Train train) {
        return trainRepository.save(train);
    }

    // Update a train
    @PutMapping("/{id}")
    public Train updateTrain(@PathVariable Long id, @RequestBody Train trainDetails) {
        Train train = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found with id " + id));

        train.setDelay(trainDetails.getDelay());
        train.setIsCanceled(trainDetails.getIsCanceled()); // This now correctly matches your entity

        return trainRepository.save(train);
    }

    // Delete a train
    @DeleteMapping("/{id}")
    public void deleteTrain(@PathVariable Long id) {
        Train existingTrain = trainRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Train not found with id " + id));
        trainRepository.delete(existingTrain);
    }
}

