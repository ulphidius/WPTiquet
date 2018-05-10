package ovh.workparadise.classedb;

public class HardwareCommand {
    private int id;
    private String matricule;
    private String hardwareType;
    private String information;
    private String status;
    private float price;
    private int site;
    private final int number = 7;

    public HardwareCommand(int id, String matricule, String hardwareType, String information, String status, float price, int site){
        this.id = id;
        this.matricule = matricule;
        this.hardwareType = hardwareType;
        this.information = information;
        this.status = status;
        this.price = price;
        this.site = site;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getHardwareType() {
		return this.hardwareType;
	}

	public void setHardwareType(String hardwareType) {
		this.hardwareType = hardwareType;
	}

	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getSite() {
		return this.site;
	}

	public void setSite(int site) {
		this.site = site;
	}
	
	public int getNumber() {
		return this.number;
	}
}
