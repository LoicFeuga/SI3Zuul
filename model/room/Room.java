
package model.room;

import java.util.ArrayList;

public class Room {
	private boolean isOpen;
	public Lesson lesson;
	public ArrayList<Item> itemList = new ArrayList<Item>();
	public Game createur;

	public boolean getIsOpen() {
		return this.isOpen;
	}

	public void setIsOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
}