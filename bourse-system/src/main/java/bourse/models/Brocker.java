package bourse.models;

import java.util.List;
import java.util.Map;

public class Brocker {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTaux() {
		return taux;
	}

	public void setTaux(int taux) {
		this.taux = taux;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	private String name;
	private Map<Client, List<BuyCommand>> buyOrderByClient;
	private Map<Client, List<SaleCommand>> saleOrderByClient;
	private int taux;
	private Account account;

	public Brocker() {
		// TODO Auto-generated constructor stub
	}

}
