package bourse.models;

import java.util.List;

public class Costumer {

	private String name;
	private int idClient ;
	private Brocker idBrocker;
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

	public void sendCommand(Command c) {  //  on peut envoyer qu'a un courtier 
		// dépend protocle . envoi req serveur = brocker

	}

	public void closeDay() {

	}

	public  String getName() {
		return name;
	}
	public  int getIdClient() {
		return idClient;
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

	public  void setName(String n) {
		this.name=n;
	}
	public  void setIdClient(int id) {
		this.idClient=id;
	}
	public void setBroker(Brocker b) {
		this.brocker= b;
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
