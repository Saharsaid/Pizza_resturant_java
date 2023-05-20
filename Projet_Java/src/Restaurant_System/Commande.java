package Restaurant_System;

public class Commande {
	private Pizza pizza;
	private double price;
	private String size;
	private int quantite;
	private boolean abonnee;
	
	public void calculerPrix(boolean abonnee) {
		double finale;
	    if (size.equals("medium")) {
	        finale =this.pizza.getPrice()*1.2*quantite;
	    } else if (size.equals("large")) {
	    	finale = this.pizza.getPrice()*1.4*quantite;
	    }else {
	    	finale =this.pizza.getPrice()*quantite;
	    }
	    if(abonnee==true) {
	    	finale = finale*0.95;
	    }
	    this.setPrice(finale);
	}
	
	public Commande(Pizza pizza,String size,int quantite,boolean abonnee) {
		this.pizza = pizza;
		this.size = size;
		setPrice(0.0);
		this.quantite = quantite;
		this.abonnee = abonnee;
		calculerPrix(abonnee);
		
	}
	
//getters and setters
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
		
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public String toString() {
		return "+-----------------------------+\n"
		+"\n|pizza : " + pizza.getName()
		+"\n|size : " + size
		+"\n|quantity : "+ quantite
		+"\n|price : " + price;
		
		
	}
}
