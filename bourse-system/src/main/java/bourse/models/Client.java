package bourse.models;

import java.util.List;

public class Client {

	private String name;
	private Brocker brocker;
	private List<SaleCommand> soldCommands; // commandes vendu
	private List<BuyCommand> boughtCommands; // commandes achetés
	private Wallet wallet;
	private Account account;

}
