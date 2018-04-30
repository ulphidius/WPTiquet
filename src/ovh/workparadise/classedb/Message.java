package ovh.workparadise.classedb;

public class Message {
	    private int id;
	    private String email;
	    private String message;
	    private final int number = 3;

	    public Message(int id, String email, String message){
	        this.id = id;
	        this.email = email;
	        this.message = message;
	    }

		public int getId() {
			return this.id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getEmail() {
			return this.email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMessage() {
			return this.message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	    
		public int getNumber() {
			return this.number;
		}
	    
}
