package ovh.workparadise.classedb;

public class ServiceCommandList {
	private int _id;
	private int _idService;
	private int _quantity;
	
	public ServiceCommandList(int id, int idService, int quantity) {
		this._id = id;
		this._idService = idService;
		this._quantity = quantity;
	}

	public int geId() {
		return this._id;
	}

	public void setId(int _id) {
		this._id = _id;
	}

	public int getIdService() {
		return this._idService;
	}

	public void setIdService(int _idService) {
		this._idService = _idService;
	}

	public int getQuantity() {
		return this._quantity;
	}

	public void setQuantity(int _quantity) {
		this._quantity = _quantity;
	}
	
}
