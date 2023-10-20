package projet.sncf;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Train")
public class Train {
	@Id
	@Column(name = "idTrain")
	private int id;
	private int retard = 0;
	private boolean annule = false;

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
