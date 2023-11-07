package projet.sncf.tables;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String start;

    @Column(nullable = false)
    private String finish;

    @Column(length = 500)
    private String notification;

    @ManyToMany
    @JoinTable(
        name = "train_trajet",
        joinColumns = @JoinColumn(name = "trajet_id"),
        inverseJoinColumns = @JoinColumn(name = "train_id")
    )
    private List<Train> trains;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getStart() { return start; }
    public void setStart(String start) { this.start = start; }

    public String getFinish() { return finish; }
    public void setFinish(String finish) { this.finish = finish; }

    public String getNotification() { return notification; }
    public void setNotification(String notification) { this.notification = notification; }

    public List<Train> getTrains() { return trains; }
    public void setTrains(List<Train> trains) { this.trains = trains; }
}
