package Restaurant_System;

public class Table {

	private int numero;
	private boolean reserved;
	private int nombrePlaces;
	private User user = null;
	public Table(int numero, int nombrePlaces) {
		this.reserved = false;
		this.numero =numero;
		this.nombrePlaces = nombrePlaces;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public boolean isReserved() {
		return reserved;
	}
	//public void setReserved(boolean reserved) {
		//this.reserved = reserved;
	//}
	public int getNombrePlaces() {
		return nombrePlaces;
	}
	public void reserve(User user) {
		this.user = user;
		this.reserved = true;
	}
	public void unreserve() {
		this.user = null;
		this.reserved = false;
	}
	
	public String toStringMenu() {
		if (reserved==false) {
		return "| Table number : "+this.numero+"        \n"

				+"| A table for: "+this.nombrePlaces+"           \n"
				+"|-------------------------------|\n";
	}else
	{
		return "";
	}
		}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
