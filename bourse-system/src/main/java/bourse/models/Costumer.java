package bourse.models;
import java.io.*;
import java.net.*;
import java.util.List;

public class Costumer {

	
	
	
	private String name;
	private int idClient ;
	private Brocker brocker;
	private int idBrocker= 0; // Si on a pas de brocker, l'id brocker est 0
	private List<SaleCommand> soldCommands; // commandes vendu
	private List<BuyCommand> boughtCommands; // commandes achetés
	private Wallet wallet;
	private Account account;
	
	/*******COMMUNICATION TCP ******/
	
	int port=4020;  // idClient ?
    InetAddress hote=null;
    Socket sc=null;
    BufferedReader in;
    PrintWriter out;
    
    /*************/

	public Costumer(String name) {
		this.name=name;
		this.idClient= idClient++;
		this.wallet= new Wallet();
		this.account = new Account(0);
	}

	public Costumer(String name, double moneyInTheAccount) {
		this.name=name;
		this.idClient= idClient++;
		this.wallet= new Wallet();
		this.account = new Account(moneyInTheAccount);
	}

	// faire maj du compte des que reception accord du courtie

	public void brockerSubscription() {
		
                try {
					hote =InetAddress.getLocalHost();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				}
      
        
        try{
            
            sc = new Socket(hote,port);
            in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
            out =new PrintWriter(sc.getOutputStream(),true);
            System.out.println("Demande de connexion au serveur Courtier");
            out.println("Bonjour, je suis le client "+ getIdClient()+" je souhaite m'inscrire à vos services de courtier");

            String rep=in.readLine();

            
        }
        catch(IOException e){
            System.err.println("Impossible de faire la demande de connexion, problème de socket client : " +e);
        }
        finally{
            try{
                sc.close();
            }
            catch (IOException e){}
        }	      
  
	}
	public void SurReceptionDe_Market() {

	}
	public void SurReceptionDe_Ack() {

	}

	public void SurReceptionDe_AnswerBrocker(boolean answer, Command c, String message) {
		 
if( answer == true) {
	
	if ( c instanceof BuyCommand) { // il a acheté des actions
		// MajCompte
		this.getAccount().withdraw(c.getCompany().getStock().getStockPrice()*c.getActionsNbr()*( 1+ this.getBroker().getBuyRate() ));
		
	}
	
	if ( c instanceof SaleCommand) { // il a vendu des actions
		// MajCompte
		this.getAccount().addSolde(c.getCompany().getStock().getStockPrice()*c.getActionsNbr()*( 1- this.getBroker().getSaleRate() ));
		
		
	}
	// Maj  Wallet
	getWallet().changeNbAction(c.getCompany(), c.getActionsNbr());
	
	System.out.println(message);
}

else {
	System.out.println("Refus de commande car : "+message);
}
	}

	public void sendCommand(Command c) {  
		if (idBrocker!= 0) {
			System.out.println("Impossible de passer une commande si vous n'avez pas de courtier. Faite une demande de connexion à un courtier avant de passer commande ");
		}
		else { // on a un courtier, on envoie la requete à ce courtier.
		if ( c instanceof BuyCommand ) {
			/* on vérifie qu'on a assez d'argent. 
			 * Si le prix que le client est pret a payé par action* nombre action qu'il veut + commision du courtier 
			 * est supérieur aux prix des cations alors son peut envoyer la commande
			 */
			BuyCommand b= (BuyCommand)c;
		  if ( this.getAccount().getSolde() >= b.getPrice()*b.getActionsNbr()*1.10 ) {
			  // on envoie la commande au courtier pour validation
		  }
		  else {
			  System.out.println(" \n Vous voulez "+ c.getActionsNbr()+" pour un prix unitaire de "+ b.getPrice() );
			  System.out.println("\n soit pour un total avec commission de 10% de "+ b.getPrice()*b.getActionsNbr()*1.10);
			  System.out.println("\n Vous n'avez pas assez d'argent");
			 
		  }		  
		}
		if ( c instanceof SaleCommand ) {
			// on vérifie qu'on a assez d'action à vendre dans notre portefeuille
			if ( c.getActionsNbr() <= getWallet().getWallet().get(c.getCompany())) {
				// on envoie la commande a courtier
			}
			else {
				  System.out.println(" \n Vous voulez vendre "+ c.getActionsNbr()+ " actions de l'entreprise "+c.getCompany() );
				  System.out.println("\n Mais il ne vous reste plus que  "+ getWallet().getWallet().get(c.getCompany())+"de cette entreprise");
			}
		}
			
		}

	}

	public void closeDay() {
// envoie au serveur message de fin de connexion
	}
	
	
	/*********setter et getter pour la classe costumer ***********/

	public  String getName() {
		return name;
	}
	public  int getIdClient() {
		return idClient;
	}
	public int getIdBroker() {
		return idBrocker;
	}
	public Brocker getBroker() {
		return brocker;
	}
	public  List<SaleCommand> getSoldCommands() {
		return soldCommands;
	}
	public  List<BuyCommand> getBoughtCommands() {
		return boughtCommands;
	}
	public  Wallet getWallet() {
		return wallet;
	}
	public  Account getAccount() {
		return account;
	}

	public  void setAccount(Account a) {
		this.account=a;
	}
	public  void setName(String n) {
		this.name=n;
	}
	public  void setIdClient(int id) {
		this.idClient=id;
	}
	public void setIdBroker(int b) {
		this.idBrocker= b;
	}
	public void  setSoldCommands(List<SaleCommand> l) {
		this.soldCommands =l ;
	}
	public void  setBoughtCommands(List<BuyCommand> l) {
		this.boughtCommands=l;
	}
	public void setWallet(Wallet w) {
		this.wallet=w;
	}

	public static void main (String[] args ) {

	}
}
