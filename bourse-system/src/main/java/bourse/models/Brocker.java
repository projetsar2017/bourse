package bourse.models;

import java.util.List;
import java.util.Map;

public class Brocker {

	private String name;
	private Map<Client, List<BuyCommand>> buyOrderByClient;
	private Map<Client, List<SaleCommand>> saleOrderByClient;
	private int taux;
	private Account account;

	
	
	
	
	
	public Brocker() {
		// TODO Auto-generated constructor stub
	}

}
