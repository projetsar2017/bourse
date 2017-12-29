package bourse.models;

public class Stock {

	public int prixAction;
	public int actionsNbr;
	public int idStock;

	public Stock(int prixaction, int actionsnbr) {
		this.prixAction = prixaction;
		this.actionsNbr = actionsnbr;
	}

	/* modifier le nombre d'actions apres avoir vendu des actions */

	@Override
	public String toString() {
		return "Stock [prixAction=" + prixAction + ", actionsNbr=" + actionsNbr + "]";
	}

	public void stockActionsaled(int actionsSales) {
		this.setActionsNbr(this.getActionsNbr() - actionsSales);
	}

	/*
	 * modifier le nombre d'actions apres avoir achter des actions par la
	 * compagny
	 */
	public void stockActionBought(int actionsSales) {
		this.setActionsNbr(this.getActionsNbr() - actionsSales);
	}

	/* retourne le prix totale de tout le stock */
	public double getStockPrice() {
		return prixAction * actionsNbr;
	}

	/*
	 * .......... getters and setters list for PrixActions and ActionsNbr ......
	 */
	
	public int getPrixAction() {
		return prixAction;
	}

	public void setPrixAction(int prixAction) {
		this.prixAction = prixAction;
	}

	public int getActionsNbr() {
		return actionsNbr;
	}

	public void setActionsNbr(int actionsNbr) {
		this.actionsNbr = actionsNbr;
	}
}
