package controller;

import model.room.Room;

public class Lesson {
	private String _name;
	private boolean _isPOO;
	private boolean _catchStudent;
	public Room _unnamed_Room_;
	public Student _unnamed_Student_;

	public String getName() {
		return this._name;
	}

	public void setName(String aName) {
		this._name = aName;
	}

	public boolean getIsPOO() {
		return this._isPOO;
	}

	public void setIsPOO(boolean aIsPOO) {
		this._isPOO = aIsPOO;
	}

	public boolean getCatchStudent() {
		return this._catchStudent;
	}

	public void setCatchStudent(boolean aCatchStudent) {
		this._catchStudent = aCatchStudent;
	}
}