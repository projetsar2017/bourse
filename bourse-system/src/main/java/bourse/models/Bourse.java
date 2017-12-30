package bourse.models;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bourse {

	public List<Company> campanies; // List des entreprises

	public List<Brocker> brockerConnecty ; // liste des courtiers ainsi que que
											// le nombre des clients servi
	
	public Bourse() {
		// TODO Auto-generated constructor stub
	}
	
	// methode pour recuperer les couriters connecter et les nombres client servant avec 
	// ilf aut creer une methode getnbclient dans courtier  .
	public String TotalBrockernbClient(){
		String message =  " les courtiers connectés et nombre de clients associés sont " ;
		for(Brocker brocker: brockerConnecty)
				 message = message + "le Courtier "+brocker.getName()+ " a  "+brocker.getNbClient()+" client(s)";
		return message;
	}
	
	
	//methode pour retourner toutes les informations concernant le prix actuel du stock et le nombre d'actions flottantes du stock pour chaque company 
	public String getFloatActionts(){
		String message = "" ;
		for(Company compagny: campanies)
			message = message + " " +compagny.toString();
	return message;	
	
	}
	
	public List<String> getSaleCommandWaiting(){
	String message = " les commandes de type vendu sont ";
	List<String> resultat = new ArrayList<String>();
		for(Company compagny: campanies)
			message = message + " Société" +compagny.getName()+" : " +compagny.getSoldCommand();
		     resultat.add(message);
			return resultat;
		
	}
	
	public List<String> getBuyCommandWaiting() {
		String message = " les commandes de type achat sont ";
		List<String> resultat = new ArrayList<String>();
		for(Company compagny: campanies)
			message = message + " Société" +compagny.getName()+" : " +compagny.getBoughtCommand();
			resultat.add(message);
			return resultat;		
	}

	public void updateActionsPrice(){
		int  deltaprix =0;
		int nvprix = 0;
		for(Company c : campanies) {
			  deltaprix = ((c.getStock().getbuy() - c.getStock().getsale()) / (c.getStock().getActionsNbr());
			  nvprix = c.getStock().getPrixAction() *(1 + deltaprix);
			  System.out.println("le prix de tous les actions est le suivant : "+nvprix);
		}}
			public void  SRD(Command c) {
				        System.out.println("\n Reception de la commande du  "+c.getBrocker().getName()+ " concernant le client " +c.getClient().getName()+ " : ");
				     // aps encore fini 
			}
			public void SendPricetoBrocker() {
				
			}
