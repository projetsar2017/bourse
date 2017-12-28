package bourse.models;

import java.util.List;

public class Company {

	private String name;
	private List<SaleCommand> soldCommand; // commandes vendu
	private List<BuyCommand> boughtCommand; // commandes achetés
	private Stock stock;

	/* Two constructors types */

	public Company(String name) {
		this.name = name;
	}

	public Company(String name, Stock stock) {
		this.name = name;
		this.stock = stock;
	}

	
	@Override
	public String toString() {
		return "Company [name=" + name + ", stock=" + stock + "]";
	}

	/* add sales and boughts commands Methods */
	public void addSoldCommand(SaleCommand command) {
		this.getSoldCommand().add(command);
	}

	public void addBoughtCommand(BuyCommand command) {
		this.getBoughtCommand().add(command);
	}

	/* ..... getters and setters methods ...... */
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
