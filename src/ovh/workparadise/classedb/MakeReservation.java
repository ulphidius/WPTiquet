package ovh.workparadise.classedb;

public class MakeReservation {
	    private int id;
	    private int idReservation;
	    private String status;
	    
	    public MakeReservation(int id, int idReservation, String status){
	        this.id = id;
	        this.idReservation = idReservation;
	        this.status = status;
	    }

		public int getId() {
			return this.id;
		}

		public void setId(int id) {
			this.id = id;
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

	    
}
