package ovh.workparadise.classedb;

import java.sql.Time;

public class Site {
	private int _id;
	private String _name;
	private String _address;
	private Time _openHourWeek;
	private Time _endHourWeek;
	private Time _openHourFriday;
	private Time _openHourWeekend;
	private Time _endHourWeekend;
	
	public Site(int id, String name, String address, Time openHourWeek, Time endHourWeek, Time openHourFriday, Time openHourWeekend, 
			Time endHourWeekend) {
		this._id = id;
		this._name = name;
		this._address = address;
		this._openHourWeek = openHourWeek;
		this._openHourFriday = openHourFriday;
		this._openHourWeekend = openHourWeekend;
		this._endHourWeek = endHourWeek;
		this._endHourWeekend = endHourWeekend;
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

	public String get_address() {
		return this._address;
	}

	public void set_address(String _address) {
		this._address = _address;
	}

	public Time get_openHourWeek() {
		return this._openHourWeek;
	}

	public void set_openHourWeek(Time _openHourWeek) {
		this._openHourWeek = _openHourWeek;
	}

	public Time get_endHourWeek() {
		return this._endHourWeek;
	}

	public void set_endHourWeek(Time _endHourWeek) {
		this._endHourWeek = _endHourWeek;
	}

	public Time get_openHourFriday() {
		return this._openHourFriday;
	}

	public void set_openHourFriday(Time _openHourFriday) {
		this._openHourFriday = _openHourFriday;
	}

	public Time get_openHourWeekend() {
		return this._openHourWeekend;
	}

	public void set_openHourWeekend(Time _openHourWeekend) {
		this._openHourWeekend = _openHourWeekend;
	}

	public Time get_endHourWeekend() {
		return this._endHourWeekend;
	}

	public void set_endHourWeekend(Time _endHourWeekend) {
		this._endHourWeekend = _endHourWeekend;
	}
	
}
