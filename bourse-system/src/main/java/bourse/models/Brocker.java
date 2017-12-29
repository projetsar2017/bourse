package bourse.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Brocker {

	private String name;
	private Map<Client, List<BuyCommand>> buyOrderByClient;
	private Map<Client, List<SaleCommand>> saleOrderByClient;
	private double buyTaux = 0.1;
	private double saleTaux = 0.2;
	private Account account;

	public Brocker() {

	}

	/* ... Recieve a Command Method ... */

	public void recieveCommand(Command command) {
		if (command instanceof BuyCommand)
			recieveBuyCommand(command);

		if (command instanceof SaleCommand)
			recieveSaleCommand(command);
	}

	public void recieveBuyCommand(Command command) {
		/* Vérifier si on a ce Client dans la HashMap */
		if (!buyOrderByClient.containsKey(command.getClient())) {
			buyOrderByClient.put(command.getClient(), new ArrayList<BuyCommand>());
		}
		/* dans les deux cas on va rajouter la commande */
		buyOrderByClient.get(command.getClient()).add((BuyCommand) command);
	}

	public void recieveSaleCommand(Command command) {
		/* Vérifier si on a ce Client dans la HashMap */
		if (!saleOrderByClient.containsKey(command.getClient())) {
			saleOrderByClient.put(command.getClient(), new ArrayList<SaleCommand>());
		}
		/* dans les deux cas on va rajouter la commande */
		saleOrderByClient.get(command.getClient()).add((SaleCommand) command);
	}

	/* ... Calcul the amount of the comission ... */

	public double commandComission(Command command) {

		if (command instanceof BuyCommand)
			return buyComission((BuyCommand) command);
		// if (command instanceof SaleCommand)
		return saleComission((SaleCommand) command);

	}

	public double buyComission(BuyCommand command) {
		return command.getPrice() * buyTaux;
	}

	public double saleComission(SaleCommand command) {
		return command.getPrice() * saleTaux;
	}

	/* ... accumulate the money earned Method... */

	public void earnBrockerMoney(Command command) {
		this.getAccount().addSolde(this.commandComission(command));
	}

	/*
	 * .... Send the prices updated of Actions after recieve it from the Bource
	 * ....
	 */
	public void sendActionsPriceUpdated(List<Company> list) {
		String message;
		for (Entry<Client, List<BuyCommand>> client : this.buyOrderByClient.entrySet()) {
			{
				message = " c'est " + this.getName() + " Voila les prix des actions mise a jours : \n";
				for (Company compagny : list)
					message = message + compagny.getStock().toString() + ". \n";// l'etat
																				// du
																				// premier
																				// stock

				client.getKey(); // To accomplate ::: send it to each client
			}

		}
	}

	public void AccordCommand(Command command){
		String message = "Commande ";	
		 if (command instanceof BuyCommand)
				message = message + " d'achat "+ command.toString()+" est bien validé par la bourse";
			if (command instanceof SaleCommand)	
				message = message + " de vente "+ command.toString()+" est bien validé par la bourse";
			
			command.getClient() //  // To accomplate ::: send it to each client
	 }

	/*
	 * return "hesta luego" to finish work, when all clients are not connected,
	 * it means : if a clent deconnect, we remove all his commands from the list
	 * the twice waiting data
	 */

	public String goodBy(){
			 if(buyOrderByClient.isEmpty() && saleOrderByClient.isEmpty())
				 return "hesta luego";
				 
				 return null;
		 }

			 
			 
			 
			 
			 
	private String getName() {
		return this.name;
	}

	public Account getAccount() {
		return account;
	}
}
