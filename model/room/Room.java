
package model.room;

import java.util.ArrayList;

import controller.*;
import model.item.Item;

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