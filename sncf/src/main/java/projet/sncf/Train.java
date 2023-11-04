package projet.sncf;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Train")
public class Train {
	@Id
	@Column(name = "idTrain")
	private int id;
	private int retard = 0;
	private boolean annule = false;
	
	@ManyToMany(mappedBy = "trains")
	private Set<Trajet> trajets;
	
	public Train(Set<Trajet> trajets) {
		this.trajets = trajets;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getRetard() {
		return retard;
	}
	
	public void setRetard(int retard) {
		this.retard = retard;
	}
	
	public boolean getAnnule() {
		return annule;
	}
	
	public void setAnnule(boolean annule) {
		this.annule = annule;
	}	
}
