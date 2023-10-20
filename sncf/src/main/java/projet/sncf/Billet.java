package projet.sncf;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Billet")
public class Billet {
	@Id
	private int id;
	private int prix;
	private Date date;
	
	@OneToMany
	@JoinColumn(name = "idUser")
	private User utilisateur;
	
	@OneToMany
	@JoinColumn(name = "idTrajet")
	private Trajet trajet;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
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
