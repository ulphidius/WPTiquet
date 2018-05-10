package ovh.workparadise.classedb;

public class MakeReservation {
	    private int idUser;
	    private int idReservation;
	    private String status;
	    private final int number = 3;
	    
	    public MakeReservation(int id, int idReservation, String status){
	        this.idUser = id;
	        this.idReservation = idReservation;
	        this.status = status;
	    }

		public int getIdUser() {
			return this.idUser;
		}

		public void setIdUser(int id) {
			this.idUser = id;
		}

		public int getIdReservation() {
			return this.idReservation;
		}

		public void setIdReservation(int idReservation) {
			this.idReservation = idReservation;
		}

		public String getStatus() {
			return this.status;
		}

		public void setStatus(String status) {
			this.status = status;
		}
		
		public int getNumber() {
			return this.number;
		}

	    
}
