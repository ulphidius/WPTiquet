package ovh.workparadise.classedb;

public class ServiceCommand {
	    private int id;
	    private String serviceType;
	    private String information;
	    private float price;
	    private int quantity;
	    private int site;

	    public ServiceCommand(int id, String serviceType, String information, float price, int quantity, int site){
	        this.id = id;
	        this.serviceType = serviceType;
	        this.information = information;
	        this.price = price;
	        this.quantity = quantity;
	        this.site = site;
	    }

		public int getId() {
			return this.id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getServiceType() {
			return this.serviceType;
		}

		public void setServiceType(String serviceType) {
			this.serviceType = serviceType;
		}

		public String getInformation() {
			return this.information;
		}

		public void setInformation(String information) {
			this.information = information;
		}

		public float getPrice() {
			return this.price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public int getQuantity() {
			return this.quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public int getSite() {
			return this.site;
		}

		public void setSite(int site) {
			this.site = site;
		}
	    
	    
}
