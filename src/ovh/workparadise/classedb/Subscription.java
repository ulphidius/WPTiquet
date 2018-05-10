package ovh.workparadise.classedb;

public class Subscription {
	private int _id;
	private String _name;
	private String _description;
	private float _hourRate;
	private float _dayRate;
	private float _studentRate;
	private float _engagementRate;
	private float _notEngagementRate;
	private int _engagementTime;
	private final int number = 9;
	
	public Subscription(int id, String name, String description, 
			float hourRate, float dayRate, float studentRate, float engagementRate, float notEngagementRate, 
			int engagementTime) {
		this._id = id;
		this._name = name;
		this._description = description;
		this._hourRate = hourRate;
		this._dayRate = dayRate;
		this._studentRate = studentRate;
		this._engagementRate = engagementRate;
		this._notEngagementRate = notEngagementRate;
		this._engagementTime = engagementTime;
	}

	public int get_id() {
		return this._id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String get_name() {
		return this._name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public String get_description() {
		return this._description;
	}

	public void set_description(String _description) {
		this._description = _description;
	}

	public float get_hourRate() {
		return this._hourRate;
	}

	public void set_hourRate(float _hourRate) {
		this._hourRate = _hourRate;
	}

	public float get_dayRate() {
		return this._dayRate;
	}

	public void set_dayRate(float _dayRate) {
		this._dayRate = _dayRate;
	}

	public float get_studentRate() {
		return this._studentRate;
	}

	public void set_studentRate(float _studentRate) {
		this._studentRate = _studentRate;
	}

	public float get_engagementRate() {
		return this._engagementRate;
	}

	public void set_engagementRate(float _engagementRate) {
		this._engagementRate = _engagementRate;
	}

	public float get_notEngagementRate() {
		return this._notEngagementRate;
	}

	public void set_notEngagementRate(float _notEngagementRate) {
		this._notEngagementRate = _notEngagementRate;
	}

	public int get_engagementTime() {
		return this._engagementTime;
	}

	public void set_engagementTime(int _engagementTime) {
		this._engagementTime = _engagementTime;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	
}