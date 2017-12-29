package bourse.models;

public class BuyCommand extends Command{
 private double price; 
	public BuyCommand(double price, int actionsNbr, Company company, Brocker brocker, Costumer client) {
		super( actionsNbr, company, client);
		this.price= price;
	}

	@Override
	public String toString() {
		return "Command [price=" + price + ", actionsNbr=" + getActionsNbr() + ", company=" + getCompany() + ", brocker="
				+ getBrocker() + ", client=" + getClient() + "]";
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
