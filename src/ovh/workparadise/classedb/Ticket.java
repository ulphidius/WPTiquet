package ovh.workparadise.classedb;

public class Ticket {
	private int id;
	private int idUser;
	private String categorie;
	private String subject;
	private boolean status;
	
	public Ticket(int id, int idUser, String categorie, String subject, boolean status) {
		this.id = id;
		this.idUser = idUser;
		this.categorie = categorie;
		this.subject = subject;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", idUser=" + idUser + ", categorie=" + categorie + ", subject=" + subject
				+ ", status=" + status + "]";
	}
	
	
}
