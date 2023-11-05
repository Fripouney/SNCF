package projet.sncf;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Billet")
public class Billet {
	@Id
	private long id;
	private int prix;
	private Date date;
	private User utilisateur;
	private Trajet trajet;
	
	public Billet(int prix, Date date, User user, Trajet trajet) {
		this.prix = prix;
		this.date = date;
		this.utilisateur = user;
		this.trajet = trajet;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getPrix() {
		return prix;
	}
	
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}	
}
