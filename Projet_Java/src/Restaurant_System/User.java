package Restaurant_System;

import java.util.ArrayList;

public class User {
	//les attributs
	private int id;
    private String name;
    private String lastname;
    private String phone_number ;
    private String adresse;
    private ArrayList<Commande> commandes = new ArrayList<Commande>();
    private static int count = 0;

    //constructeur
	public User(String name, String lastname, String phone_number,String adresse) {
		this.id = count;
		this.name = name;
		this.lastname = lastname;
		this.phone_number = phone_number;
		this.setAdresse(adresse);
		count++;
	}
	//getters
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLastname() {
		return lastname;
	}
	public String getPhone_number() {
		return phone_number;
	}
	//setters
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	//
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", phone_number=" + phone_number + "]";
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public void ajoutCommande(Commande cmd) {
		this.commandes.add(cmd);
	}
	public void effacerCommande(Commande cmd) {
		this.commandes.remove(cmd);
	}
	public void displayCommandes() {
		for(Commande commande:commandes) {
			System.out.println(commande.toString());
			System.out.println("+-----------------------------+\n");
		}
	}
}
