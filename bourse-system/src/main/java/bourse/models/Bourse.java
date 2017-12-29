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
	 
	

	public static List<Brocker> recupererListeBrockers(String filename) {
		
		try{// creer un fichier file name concenrnant brocker 
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			String line = reader.readLine();
            
			if (line.equals(" brockers ")) {
				List<Brocker> brockerConnecty = new ArrayList<Brocker>();
                
				line = reader.readLine();
                
				while(!line.equals(" ")) {
                    
					String idBrocker = line.substring(0,2);  // 01 hajar
					String nomBrocker = line.substring(4);
                    
					Brocker b = new Brocker(nomBrocker,idBrocker);
					brockerConnecty.add(b);
					line = reader.readLine();
				}
                
				return brockerConnecty;
			}
			else{
				System.err.println( " vous etes trompé de fichier ." );
				return null;
			}
		}
		catch(Exception e) {
			return null;
		}
	}
    
	public static List<Client> recupererListeC(String filename) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			String line = reader.readLine();
            
			if (line.equals(" Clients")) {
				List<Client> listeClient= new ArrayList<Client>();
                
				line = reader.readLine();
                
				while(!line.equals(" ")) {
                    
					String idClient = line.substring(0,2);
					String nomClient = line.substring(4);
                    
					Client c = new Client(nomClient,idClient);
					listeClient.add(c);
					line = reader.readLine();
				}
                
				return listeClient;
			}
			else{
				System.err.println( " vous etes trompé de fichier  de client . " );
				return null;
			}
		}
		catch(Exception e) {
			return null; 
		}
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

    