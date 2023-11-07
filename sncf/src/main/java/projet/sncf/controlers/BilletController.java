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

    @GetMapping("/client/{clientId}")
    public List<Billet> getAllBilletsByUser(@PathVariable Long userId) {
        return billetRepository.findByUserId(userId);
    }
    
    @GetMapping("/{id}")
    public Billet getBilletById(@PathVariable Long id) {
        return billetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Billet non trouvé avec l'id " + id));
    }
    
    @GetMapping("/my-billets")
    public String viewMyBillets(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            Set<Billet> userBillets = user.getBillets();
            model.addAttribute("billets", userBillets);
        }
        return "my-tickets";
    }

    @PostMapping
    public Billet createBillet(@RequestBody Billet billet) {
        return billetRepository.save(billet);
    }

    @PutMapping("/{id}")
    public Billet updateBillet(@PathVariable Long id, @RequestBody Billet billetDetails) {
        Billet billet = billetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Billet non trouvé avec l'id " + id));

        billet.setUser(billetDetails.getUser());
        billet.setTrajet(billetDetails.getTrajet());
        billet.setDate(billetDetails.getDate());
        billet.setPrice(billetDetails.getPrice());

        return billetRepository.save(billet);
    }

    @DeleteMapping("/{id}")
    public void deleteBillet(@PathVariable Long id) {
        billetRepository.deleteById(id);
    }
}
