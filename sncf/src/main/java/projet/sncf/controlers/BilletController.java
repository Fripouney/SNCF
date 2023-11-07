package projet.sncf.controlers;

import projet.sncf.repositories.*;
import projet.sncf.tables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/billets")
public class BilletController {

    @Autowired
    private BilletRepository billetRepository;

    // Get all billets for a user
    @GetMapping("/client/{clientId}")
    public List<Billet> getAllBilletsByUser(@PathVariable Long userId) {
        return billetRepository.findByUserId(userId);
    }

    // Get details for a single billet
    @GetMapping("/{id}")
    public Billet getBilletById(@PathVariable Long id) {
        return billetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Billet not found with id " + id));
    }
    
    @GetMapping("/my-billets")
    public String viewMyBillets(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Set<Billet> userBillets = user.getBillets();
            model.addAttribute("billets", userBillets);
        }
        return "my-tickets"; // This should be the name of your Thymeleaf template
    }


    // Create a new billet
    @PostMapping
    public Billet createBillet(@RequestBody Billet billet) {
        return billetRepository.save(billet);
    }

    // Update a billet
    @PutMapping("/{id}")
    public Billet updateBillet(@PathVariable Long id, @RequestBody Billet billetDetails) {
        Billet billet = billetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Billet not found with id " + id));

        billet.setUser(billetDetails.getUser());
        billet.setTrajet(billetDetails.getTrajet());
        billet.setDate(billetDetails.getDate());
        billet.setPrice(billetDetails.getPrice());

        return billetRepository.save(billet);
    }

    // Delete a billet
    @DeleteMapping("/{id}")
    public void deleteBillet(@PathVariable Long id) {
        billetRepository.deleteById(id);
    }
}