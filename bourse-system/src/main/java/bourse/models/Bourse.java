package bourse.models;

import java.util.List;

package bourse.models;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

package bourse.models;

import java.util.List;

package bourse.models;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bourse {

	public List<Company> campanies; // List des entreprises

	public List<Brocker> brockerConnecty  = null ; // liste des courtiers ainsi que que
											// le nombre des clients servis
	
	
	
	public Bourse() {
		// TODO Auto-generated constructor stub
	}
	 
	 public List<Integer> getResultatBoughtCommand() {
	        List<Integer> resultat = new ArrayList<Integer>();
	        
	        for(Company c : campanies) {
	            int cpt = 0;
	            System.out.println("la companie "+c.getName()+ "a l'ordre suivant :"+c.getBoughtCommand());
	                    cpt++;
	            resultat.add(cpt);
	        }
	        return resultat;
	    }
	 public List<Integer> getResultatCommandsold() {
	        List<Integer> resultat = new ArrayList<Integer>();
	        
	        for(Company c : campanies) {
	            int cpt = 0;
	            System.out.println("la companie "+c.getName()+ "a l'ordre suivant :"+c.getSoldCommand());
	                    cpt++;
	            resultat.add(cpt);
	        }
	        return resultat;
	    }
	 
	 public String afficheResultatCommand() {
	        List<Integer>  resultatbuy= getResultatBoughtCommand() ;
	        List<Integer>  resultatsold= getResultatCommandsold() ;
	        String commande = "\n---------"
	                + "\n  les commandes en attente  sont   "
	                + "\n----------------------------";
	        for(int i = 0; i < campanies.size(); i++) {
	        				if("c'est buy") {
	        					 commande+="\n "+ (i+1) + " " + campanies.get(i).getName() + " : " +resultatbuy.get(i)  ;
	        				}
	        				else {
	        					
	        					commande+="\n "+ (i+1) + " " + campanies.get(i).getName() + " : " +resultatsold.get(i)  ;
	        				}
	        }
	            
	        return commande;
	    }
	    

	
	 
	 // methode closeBourse () pour fermer la connexion 
	 
	 
}