package ovh.workparadise.classedb;

public class TicketMessage {
	private int id;
	private int idTicket;
	private String content;
	private String dateSend;
	private boolean type;
	
	public TicketMessage(int id, int idTicket, String content, String dateSend, boolean type) {
		this.id = id;
		this.idTicket = idTicket;
		this.content = content;
		this.dateSend = dateSend;
		this.type = type;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDateSend() {
		return dateSend;
	}

	public void setDateSend(String dateSend) {
		this.dateSend = dateSend;
	}

	public boolean getType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TicketMessage [id=" + id + ", idTicket=" + idTicket + ", content=" + content + ", dateSend=" + dateSend
				+ ", type=" + type + "]";
	}
	
}
