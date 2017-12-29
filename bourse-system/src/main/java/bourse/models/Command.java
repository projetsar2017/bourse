package bourse.models;

public class Command {

	private double price;
	private int actionsNbr;

	private Company company;
	private Brocker brocker;
	private Costumer client;

	public Command(double price, int actionsNbr, Company company, Brocker brocker, Costumer client) {
		this.price = price;
		this.actionsNbr = actionsNbr;
		this.company = company;
		this.brocker = brocker;
		this.client = client;
	}

	@Override
	public String toString() {
		return "Command [price=" + price + ", actionsNbr=" + actionsNbr + ", company=" + company + ", brocker="
				+ brocker + ", client=" + client + "]";
	}

	/* Getters and Setters list */
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getActionsNbr() {
		return actionsNbr;
	}

	public void setActionsNbr(int actionsNbr) {
		this.actionsNbr = actionsNbr;
	}

	public Company getCompany() {
		return company;
	}

	public Brocker getBrocker() {
		return brocker;
	}

	public Costumer getClient() {
		return client;
	}

}
