package controller; 

import java.util.*; 
import java.io.Serializable;

/**
* Une classe qui permet de créer un badge avec un idBagde
* @author © 2014 Gatien Chapon
*/
public class Badge implements Serializable
{
	private String idBadge; 
	
	/**
	* Constructeur de la classe Badge, qui crée un badge. 
	*/
	public Badge(String id)
	{
		idBadge = id; 
	}
	/**
	 * Retourne l'identifiant d'une salle
	 * @return idBadge
	 */
	public String getIdBadge()
	{
		return idBadge; 
	}
	/**
	 * Modifie l'identifiant d'un badge 
	 * @param newId
	 */
	public void setIdRoom(String newId)
	{
		idBadge = newId; 
	}
	
	/**
	* Affiche le badge.
	*/
	public String toString()
	{ 
		return "Identifiant du badge : " +getIdBadge(); 
	}
}
