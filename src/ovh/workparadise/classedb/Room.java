package ovh.workparadise.classedb;

public class Room {
	    private int id;
	    private int site;
	    private String type;
	    private String description;
	    private int roomNumber;
	    private String roomStatus;

	    public Room(int id, int site, String type, String description, int roomNumber, String roomStatus){
	        this.id = id;
	        this.site = site;
	        this.type = type;
	        this.description = description;
	        this.roomNumber = roomNumber;
	        this.roomStatus = roomStatus;
	    }

		public int getId() {
			return this.id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getSite() {
			return this.site;
		}

		public void setSite(int site) {
			this.site = site;
		}

		public String getType() {
			return this.type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getDescription() {
			return this.description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getRoomNumber() {
			return this.roomNumber;
		}

		public void setRoomNumber(int roomNumber) {
			this.roomNumber = roomNumber;
		}

		public String getRoomStatus() {
			return this.roomStatus;
		}

		public void setRoomStatus(String roomStatus) {
			this.roomStatus = roomStatus;
		}
	    
	    
}
