package bourse.models;

public class Account {

	private double solde;

	public Account(double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Account [solde=" + solde + "]";
	}

	/* Ajouter de l'argent */
	public void addSolde(double amount) {
		this.setSolde(this.getSolde() + amount); // add amount to sold
	}

	/* debiter le compte */

	public void withdraw(double amount) {
		if (amount <= this.getSolde())
			this.setSolde(this.getSolde() - amount); // subtract amount to sold

	}

	private void setSolde(double amount) {
		this.solde = amount;

	}

	private double getSolde() {
		return this.solde;
	}

}
