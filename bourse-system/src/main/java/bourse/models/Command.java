package bourse.models;

public class Command {

	private int actionsNbr;
	private int idStock;

	private Company company;
	private Brocker brocker;
	private Costumer client;

	public Command(int actionsNbr, Company company, Costumer client) {
		this.actionsNbr = actionsNbr;
		this.company = company;
		this.client = client;
		this.brocker = client.getBroker();
	}

	@Override
	public String toString() {
		return "Command  : actionsNbr=" + actionsNbr + ", company=" + company + ", brocker="
				+ brocker + ", client=" + client + "]";
	}

	/* Getters and Setters list */
	


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

	public Costumer getCostumer() {
		return client;
	}

}
