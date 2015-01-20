package controller;

import java.util.ArrayList;

import model.item.Item;

public class Student {
	private AdministratorBadge inventory;
	//private ArrayList<Item> itemList;
	private int physicEnergy;
	private int mentalEnergy;
	
	/**
	 * Constructeur d'un Student par d�faut
	 * 
	 */
	public Student(){
		inventory = new AdministratorBadge();
		//itemList = new ArrayList();
		physicEnergy = 100;
		mentalEnergy = 1000;
	}

	/**
	 * Permet d'ajouter l'item pass� en param�tre � l'inventaire 
	 *   du student
	 *   
	 * @param item item � ajouter
	 */
	public void addItem(Item item) {
		inventory.addItem(item);
	}
	
	/**
	 * Permet de retourner l'item dont l'indice est pass� en param�tre
	 * 
	 * @param i indice de l'item dans l'inventaire
	 * @return l'item correspond � i
	 */
	public Item getItem(int i){
		return inventory.getItem(i);
	}
	
	/**
	 * Permet de supprimer l'item de l'inventaire pass� en param�tre
	 * 
	 * @param item
	 */
	public void removeItem(Item item){
		inventory.removeItem(item);
	}
	
	/**
	 * Accesseurs de l'energie physique du student
	 * @return
	 */
	public int getPhysicEnergy() {
		return physicEnergy;
	}


	/**
	 * Accesseurs de l'energie physique du student
	 * @param physicEnergy
	 */
	public void setPhysicEnergy(int physicEnergy) {
		this.physicEnergy = physicEnergy;
	}

	
	/**
	 * Accesseurs de l'energie mental du student
	 * @return
	 */
	public int getMentalEnergy() {
		return mentalEnergy;
	}


	/**
	 * Accesseurs de l'energie physique du student 
	 * @param mentalEnergy
	 */
	public void setMentalEnergy(int mentalEnergy) {
		this.mentalEnergy = mentalEnergy;
	}

	
	/**
	 * Accesseurs de l'inventaire du student
	 * @return
	 */
	public AdministratorBadge getInventory() {
		return inventory;
	}


	/**
	 * Accesseurs de l'energie physique du student 
	 * @param inventory
	 */
	public void setInventory(AdministratorBadge inventory) {
		this.inventory = inventory;
	}

	
	/**
	 * Permet d'augmenter l'energie physique du student par le nombre pass� 
	 *   en param�tre
	 * @param number
	 */
	public void increaseEnergy(int number) {
		physicEnergy+=number;
	}
	
	/**
	 * Permet de diminuer l'energie physique du student par le nombre pass� 
	 *   en param�tre
	 * @param number
	 */
	
	public void decreaseEnergy(int number) {
		physicEnergy-=number;
	}
	
}