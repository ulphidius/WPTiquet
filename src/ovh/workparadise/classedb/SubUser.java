package ovh.workparadise.classedb;

import java.sql.Date;

public class SubUser {
	private int _idUser;
	private int _idSub;
	private boolean _engaged;
	private Date _dateStart;
	private Date _dateEnd;
	private final int number = 5;
	
	public SubUser(int idUser, int idSub, boolean engaged, Date dateStart, Date dateEnd) {
		this._idUser = idUser;
		this._idSub = idSub;
		this._engaged = engaged;
		this._dateStart = dateStart;
		this._dateEnd = dateEnd;
	}

	public int get_idUser() {
		return this._idUser;
	}

	public void set_idUser(int _idUser) {
		this._idUser = _idUser;
	}

	public int get_idSub() {
		return this._idSub;
	}

	public void set_idSub(int _idSub) {
		this._idSub = _idSub;
	}

	public boolean get_engaged() {
		return this._engaged;
	}

	public void set_engaged(boolean _engaged) {
		this._engaged = _engaged;
	}

	public Date get_dateStart() {
		return this._dateStart;
	}

	public void set_dateStart(Date _dateStart) {
		this._dateStart = _dateStart;
	}

	public Date get_dateEnd() {
		return this._dateEnd;
	}

	public void set_dateEnd(Date _dateEnd) {
		this._dateEnd = _dateEnd;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	
}
