package bourse.models;

import java.util.List;

public class Client {

	private String name;
	private Brocker brocker;
	private List<SaleCommand> soldCommands; // commandes vendu
	private List<BuyCommand> boughtCommands; // commandes achetés
	private Wallet wallet;
	private Account account;
	
	public  String getName() {
		return name;
	}
public void connexionCourtier() {
	
}

public void SRD_Acquittement() {
	
}
// Le client envoi en même temps les actions qu'il veut acheter et vendre ? 
	public void envoiCommande(Command c ) {
		// dépend protocle 
		
	}
}
