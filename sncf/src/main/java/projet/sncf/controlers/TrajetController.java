package projet.sncf.controlers;

import projet.sncf.repositories.*;
import projet.sncf.tables.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trajets")
public class TrajetController {

    @Autowired
    private TrajetRepository trajetRepository;

    @GetMapping
    public List<Trajet> getAllTrajets() {
        return trajetRepository.findAll();
    }

    @GetMapping("/{id}")
    public Trajet getTrajetById(@PathVariable Long id) {
        return trajetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trajet not found with id " + id));
    }

    @GetMapping("/trajets")
    public String listTrajets(Model model) {
        List<Trajet> trajets = trajetRepository.findAll();
        model.addAttribute("trajets", trajets);
        return "trajets";
    }

    @PostMapping
    public Trajet createTrajet(@RequestBody Trajet trajet) {
        return trajetRepository.save(trajet);
    }

    @PutMapping("/{id}")
    public Trajet updateTrajet(@PathVariable Long id, @RequestBody Trajet trajetDetails) {
        Trajet trajet = trajetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trajet not found with id " + id));

        trajet.setStart(trajetDetails.getStart());
        trajet.setFinish(trajetDetails.getFinish());
        trajet.setNotification(trajetDetails.getNotification());

        return trajetRepository.save(trajet);
    }

    @DeleteMapping("/{id}")
    public void deleteTrajet(@PathVariable Long id) {
        trajetRepository.deleteById(id);
    }
}
