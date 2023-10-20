package projet.sncf;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Trajet")
public class Trajet {
	@Id
	@Column(name = "idTrajet")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String depart;
	private String arrivee;
	
	@OneToOne
	@JoinColumn(name = "idTrain")
	private Train train;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDepart() {
		return depart;
	}
	
	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	public String getArrivee() {
		return arrivee;
	}
	
	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}
	
	public Train getTrain() {
		return train;
	}
	
	public void setTrain(Train train) {
		this.train = train;
	}
	
	
}
