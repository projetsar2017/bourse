package bourse.models;

import java.util.List;

public class Company {

	private String name;
	private List<SaleCommand> soldCommand; // commandes vendu
	private List<BuyCommand> boughtCommand; // commandes achetés
	private Stock stock;

	public Company() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SaleCommand> getSoldCommand() {
		return soldCommand;
	}

	public void setSoldCommand(List<SaleCommand> soldCommand) {
		this.soldCommand = soldCommand;
	}

	public List<BuyCommand> getBoughtCommand() {
		return boughtCommand;
	}

	public void setBoughtCommand(List<BuyCommand> boughtCommand) {
		this.boughtCommand = boughtCommand;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
