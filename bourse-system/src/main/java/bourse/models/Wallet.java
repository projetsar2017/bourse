package bourse.models;

import java.util.HashMap;
import java.util.Map;


public class Wallet {

	private Map<Company, Integer> wallet;

	/* ... Constructors ... */
	public Wallet() {
		wallet = new HashMap<Company, Integer>();
	}

	public Wallet(Map<Company, Integer> wallet) {
		this.wallet = wallet;
	}
	
public void changeNbAction( Company c, int nbActionAdded ) {
	int newNbAction = wallet.get(c)+ nbActionAdded ;
		wallet.put(c, newNbAction);
	}

	@Override
	public String toString() {
		return "Wallet [wallet=" + wallet.toString() + "]";
	}

	/* ... Getter ... */

	public Map<Company, Integer> getWallet() {
		return wallet;
	}
	

}
