package bourse.models;

public class Stock {

	public int prixAction;
	public int actionsNbr;

	
	public Stock() {
		// TODO Auto-generated constructor stub
	}
	public double getStockPrice(){
		return prixAction*actionsNbr;
	}

}
