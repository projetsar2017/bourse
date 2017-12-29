package bourse.models;

import java.util.List;

public class Costumer {

	private String name;
	private int idClient ;
	private Brocker brocker;
	private int idBrocker= 0; // Si on a pas de brocker, l'id brocker est 0
	private List<SaleCommand> soldCommands; // commandes vendu
	private List<BuyCommand> boughtCommands; // commandes achetés
	private Wallet wallet;
	private Account account;

	public Costumer(String name) {
		this.name=name;
		this.idClient= idClient++;
		this.wallet= new Wallet();
		this.account = new Account(0);
	}

	public Costumer(String name, double moneyInTheAccount) {
		this.name=name;
		this.idClient= idClient++;
		this.wallet= new Wallet();
		this.account = new Account(moneyInTheAccount);
	}

	// faire maj du compte des que reception accord du courtie

	public void brockerSubscription() {
  
	}
	public void SurReceptionDe_Market() {

	}
	public void SurReceptionDe_Ack() {

	}

	public void SurReceptionDe_AnswerBrocker() {

	}

	public void sendCommand(Command c) {  
		if (idBrocker!= 0) {
			System.out.println("Impossible de passer une commande si vous n'avez pas de courtier. Faite une demande de connexion à un courtier avant de passer commande ");
		}
		else { // on a un courtier, on envoie la requete à ce courtier.
		if ( c instanceof BuyCommand ) {
			/* on vérifie qu'on a assez d'argent. 
			 * Si le prix que le client est pret a payé par action* nombre action qu'il veut + commision du courtier 
			 * est supérieur aux prix des cations alors son peut envoyer la commande
			 */
		  if ( this.getAccount().getSolde() >= c.getPrice()*c.getActionsNbr()*1.10 ) {
			  // on envoie la commande au courtier pour validation
		  }
		  else {
			  System.out.println(" \n Vous voulez "+ c.getActionsNbr()+" pour un prix unitaire de "+ c.getPrice() );
			  System.out.println("\n soit pour un total avec commission de 10% de "+ c.getPrice()*c.getActionsNbr()*1.10);
			  System.out.println("\n Vous n'avez pas assez d'argent");
			 
		  }		  
		}
		if ( c instanceof SaleCommand ) {
			// on vérifie qu'on a assez d'action à vendre dans notre portefeuille
			if ( c.getActionsNbr() <= getWallet().getWallet().get(c.getCompany())) {
				// on envoie la commande a courtier
			}
			else {
				  System.out.println(" \n Vous voulez vendre "+ c.getActionsNbr()+ " actions de l'entreprise "+c.getCompany() );
				  System.out.println("\n Mais il ne vous reste plus que  "+ getWallet().getWallet().get(c.getCompany())+"de cette entreprise");
			}
		}
			
		}

	}

	public void closeDay() {

	}
	
	
	/*********setter et getter pour la classe costumer ***********/

	public  String getName() {
		return name;
	}
	public  int getIdClient() {
		return idClient;
	}
	public int getIdBroker() {
		return idBrocker;
	}
	public Brocker getBroker() {
		return brocker;
	}
	public  List<SaleCommand> getSoldCommands() {
		return soldCommands;
	}
	public  List<BuyCommand> getBoughtCommands() {
		return boughtCommands;
	}
	public  Wallet getWallet() {
		return wallet;
	}
	public  Account getAccount() {
		return account;
	}

	public  void setAccount(Account a) {
		this.account=a;
	}
	public  void setName(String n) {
		this.name=n;
	}
	public  void setIdClient(int id) {
		this.idClient=id;
	}
	public void setIdBroker(int b) {
		this.idBrocker= b;
	}
	public void  setSoldCommands(List<SaleCommand> l) {
		this.soldCommands =l ;
	}
	public void  setBoughtCommands(List<BuyCommand> l) {
		this.boughtCommands=l;
	}
	public void setWallet(Wallet w) {
		this.wallet=w;
	}

	public static void main (String[] args ) {

	}
}
