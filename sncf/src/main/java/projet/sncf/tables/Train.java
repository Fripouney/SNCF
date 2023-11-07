package projet.sncf.tables;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer delay;

    @Column(nullable = false)
    private Boolean isCanceled;

    @ManyToMany(mappedBy = "trains")
    private List<Trajet> trajets;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getDelay() { return delay; }
    public void setDelay(Integer delay) { this.delay = delay; }

    public Boolean getIsCanceled() { return isCanceled; }
    public void setIsCanceled(Boolean canceled) { isCanceled = canceled; }

    public List<Trajet> getTrajets() { return trajets; }
    public void setTrajets(List<Trajet> trajets) { this.trajets = trajets; }
}
