package controller;

import java.util.ArrayList;

import model.IA;
import model.item.Item;
/**
 * La class Student représente un joueur réel ou controlé par l'ordinateur 
 *   permettant de ce déplacer dans la map du jeu
 *   
 * Il possède un inventory regroupant tous les badges représentant les récompenses
 *   pour avoir assisté à un cours, ainsi que tous les items
 *   
 * Version 0 : 
 * 		Edition 0 : - class initial, constructeur, accesseurs, action sur l'inventaire
 * 			
 *  
 * Version actuel : 0.0
 * 
 * @author loic
 *
 */
public class Student {
	private AdministratorBadge inventory;
	//private ArrayList<Item> itemList;
	private int physicEnergy;
	private int mentalEnergy;
	private boolean isIA;
	private IA ia;
	
	/**
	 * Constructeur d'un Student par défaut
	 * 
	 */
	public Student(){
		inventory = new AdministratorBadge();
		//itemList = new ArrayList();
		physicEnergy = 100;
		mentalEnergy = 1000;
		isIA = false;
	}
	
	public Student(IA ia){
		inventory = new AdministratorBadge();
		//itemList = new ArrayList();
		physicEnergy = 100;
		mentalEnergy = 1000;
		if(ia == null) isIA = false;
		else {
			isIA = true;
			this.ia = ia;
		}
	}
	
	public 

	/**
	 * Permet d'ajouter l'item passé en paramètre à l'inventaire 
	 *   du student
	 *   
	 * @param item item à ajouter
	 */
	public void addItem(Item item) {
		inventory.addItem(item);
	}
	
	/**
	 * Permet de retourner l'item dont l'indice est passé en paramètre
	 * 
	 * @param i indice de l'item dans l'inventaire
	 * @return l'item correspond à i
	 */
	public Item getItem(int i){
		return inventory.getItem(i);
	}
	
	/**
	 * Permet de supprimer l'item de l'inventaire passé en paramètre
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
	 * Permet d'augmenter l'energie physique du student par le nombre passé 
	 *   en paramètre
	 * @param number
	 */
	public void increaseEnergy(int number) {
		physicEnergy+=number;
	}
	
	/**
	 * Permet de diminuer l'energie physique du student par le nombre passé 
	 *   en paramètre
	 * @param number
	 */
	
	public void decreaseEnergy(int number) {
		physicEnergy-=number;
	}
	
}