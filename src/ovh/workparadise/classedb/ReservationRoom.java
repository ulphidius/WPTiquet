package ovh.workparadise.classedb;

import java.sql.Date;
import java.sql.Time;

public class ReservationRoom {
	    private int id;
	    private int idRoom;
	    private Date dateR;
	    private Time dateStart;
	    private Time dateEnd;
	    private String originalState;
	    private String afterState;
	    private final int number = 7;
	    
	    public ReservationRoom(int id, int idRoom, Date dateR, Time dateStart, Time dateEnd, String originalState, String afterState){
	        this.id = id;
	        this.idRoom = idRoom;
	        this.dateR = dateR;
	        this.dateStart = dateStart;
	        this.dateEnd = dateEnd;
	        this.originalState = originalState;
	        this.afterState = afterState;
	    }

		public int getId() {
			return this.id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getIdRoom() {
			return this.idRoom;
		}

		public void setIdRoom(int idRoom) {
			this.idRoom = idRoom;
		}

		public Date getDateR() {
			return this.dateR;
		}

		public void setDateR(Date dateR) {
			this.dateR = dateR;
		}

		public Time getDateStart() {
			return this.dateStart;
		}

		public void setDateStart(Time dateStart) {
			this.dateStart = dateStart;
		}

		public Time getDateEnd() {
			return this.dateEnd;
		}

		public void setDateEnd(Time dateEnd) {
			this.dateEnd = dateEnd;
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
