package ovh.workparadise.classedb;

public class HardwareCommandList {
	    private int id;
	    private int idReservation;
	    private int idHardware;
	    private String originalState;
	    private String afterState;
	    private final int number = 5;

	    public HardwareCommandList(int id, int idReservation, int idHardware, String originalState, String afterState){
	        this.id = id;
	        this.idReservation = idReservation;
	        this.idHardware = idHardware;
	        this.originalState = originalState;
	        this.afterState = afterState;
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

		public int getIdHardware() {
			return this.idHardware;
		}

		public void setIdHardware(int idHardware) {
			this.idHardware = idHardware;
		}

		public String getOriginalState() {
			return this.originalState;
		}

		public void setOriginalState(String originalState) {
			this.originalState = originalState;
		}

		public String getAfterState() {
			return this.afterState;
		}

		public void setAfterState(String afterState) {
			this.afterState = afterState;
		}
		
		public int getNumber() {
			return this.number;
		}
	    
}
