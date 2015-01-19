import java.io.*;
import org.json.*;

/**
* Une classe qui permet de lire, de sauvegarder et d'écrire tout ce qui est rapporté au jeu (notamment le gestionnaire de badge) dans un fichier.
* @author © 2014 Gatien Chapon.
* @version 1.0 (04/12/2014). 
*/
public class Sauvegarde
{
	/**
	* Fonction qui sauvegarde le gestionnaire de badge passé en paramètre : Séréalisation.
	* @param GestionnaireBadge.
	*/
	public void sauvegarde(GestionnaireBadge patron)
	{
		   
		    ObjectOutputStream output;
		    
		    try 
		    {
			      output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("texte/serialisation.txt"))));
			      
			      //Ecriture de l'objet à serealizer
			      output.writeObject(patron);
			   
			      //Fermeture du flux
			      output.close();
			
			
		    } 
		    catch (FileNotFoundException e) 
		    {
		      e.printStackTrace();
		    } 
		    catch (IOException e) 
		    {
		      e.printStackTrace();
		    }    	
	}
	
	/**
	* Fonction qui écrit dans le fichier sauvegardeEcrit.txt
	* @param GestionnaireBadge.
	*/
	public void sauvegardeEcriture(GestionnaireBadge patron)
	{
		    File fichier = new File("texte/sauvegardeEcrit.txt");
		    try 
		    {
		    
			      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fichier)));
			      
			      // écriture dans le fichier
			      out.write(patron.toString()) ;
			   	
			      //Fermeture du flux
			      out.close();  
			
			
		    } 
		    catch (FileNotFoundException e) 
		    {
		      e.printStackTrace();
		    } 
		    catch (IOException e) 
		    {
		      e.printStackTrace();
		    }    	
	}
	
	/**
	* Fonction qui lit ce qu'il y a dans le fichier serealisation.txt et renvoie le gestionnaire de badge qui a été sauvegardé dans ce fichier.
	* @return GestionnaireBadge.
	*/
	public GestionnaireBadge lecture()
	{
		    ObjectInputStream input;
		    GestionnaireBadge nouveau= null; 
		    try 
		    {
			      //Récupèration des données contenues dans l'object 
			      input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("texte/serialisation.txt"))));
				    
			      try 
			      {
			      		nouveau = (GestionnaireBadge)input.readObject();
				
			      } 
			      catch (ClassNotFoundException e) 
			      {
				e.printStackTrace();
			      }
	
			      input.close();
			
		    } 
		    catch (FileNotFoundException e) 
		    {
		      e.printStackTrace();
		    } 
		    catch (IOException e) 
		    {
		      e.printStackTrace();
		    }   
		    return nouveau;   	
	}
	
	/**
	* Fonction qui écrit avec json dans json.json
	* @param GestionnaireBadge.
	*/
	public void sauvegardeJson(GestionnaireBadge patron)
	{	
		try 
		{
	 		JSONObject obj = new JSONObject().put(patron.toString(),true);
			FileWriter file = new FileWriter("texte/json.json");
			file.write(obj.toString());
			file.flush();
			file.close();
	 
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
		      e.printStackTrace();
		}    	
      	}
      	/**
      	* Fonction qui regarde si le fichier de serealisation existe, si oui on renvoie le gestionnaire de badge, sinon on crée un gestionnaire de badge vide.
      	* @return GestionnaireBadge.
      	*/
      	public GestionnaireBadge verifieExistanceFichier()
      	{
      		File projet = new File("texte/serialisation.txt");
      		GestionnaireBadge patron; 
		if(projet.exists()) // on vérifie que le fichier où l'on va sauvegarder existe si il exsite on récupère l'ancien gestionnaire de badge 
		{
			patron = lecture(); 
		}
		else // sinon on crée un Gestionnaire de Badge vide
		{
			 patron = new GestionnaireBadge(); 
		}
		return patron; 
	}
	
      	/**
      	* Sauvegarde toutes sortes de sauvegarde. 
	* @param GestionnaireBadge.
      	*/
      	public void sauvegardeTout(GestionnaireBadge nouveau)
	{
		sauvegarde(nouveau); 
		sauvegardeEcriture(nouveau); 
		sauvegardeJson(nouveau); 
	}		
}
