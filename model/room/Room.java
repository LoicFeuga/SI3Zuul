
package model.room;

import java.util.ArrayList;
import java.util.HashMap;
import controller.Student;
import model.item.Item;

public abstract class Room {
	private boolean isOpen ;
    protected String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> inventory  = new  ArrayList<Item>();
    
    public Room(String description){
    	this.description=description  ;
    	this.isOpen=false ;  
    }
    
    /**
     * Define an exit from this room.
     * 
     * @param direction
     *            The direction of the exit.
     * @param neighbor
     *            The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }
    
	abstract public void act(Student Student);
    
    public void addItem(Item item){
    	this.inventory.add(item);
    }
    
    public boolean subItem(Item item){
    	return this.inventory.remove(item);
    }
    
    
    
    
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public HashMap<String, Room> getExits() {
		return exits;
	}
	public void setExits(HashMap<String, Room> exits) {
		this.exits = exits;
	}
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	

    
    
} 
