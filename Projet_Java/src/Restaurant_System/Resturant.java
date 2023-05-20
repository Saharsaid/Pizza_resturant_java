



package Restaurant_System;
import Restaurant_System.Pizza;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
public class Resturant implements GestionDeCommande {
 private int id;
 private String name;
 private String address;
 private ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
 private ArrayList<Table> tables = new ArrayList<Table>();
 private ArrayList<UserAbonnee> users = new ArrayList<UserAbonnee>();


 //TODO : zid zid anwe3 pizza mte3ik fil constructeur
 //constucteur
public Resturant(int id, String name, String address) {
	this.id = id;
	this.name = name;
	this.address = address;
	prepareRestau();
}
//gettes  et setters
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public Pizza getPizzaById(int id_pizza) {
	for (Pizza pizza : pizzas) {
		if(pizza.getId_pizza()==id_pizza) {
			return pizza;
		}
	}
	return null;
}
public Table getTableById(int id_table) {
	for (Table table : tables) {
		if(table.getNumero()==id_table) {
			return table;
		}
	}
	return null;
}
public void addUser(UserAbonnee user) {
	this.users.add(user);
}
public ArrayList<UserAbonnee> getUsers() {
	return users;
}

 public String menuPizza(){
	 
	 String menu= "+-------------------------------+\n| Pizzas List\n+-------------------------------+\n";
	 for(Pizza pizza:pizzas) {
		 menu+= pizza.toStringMenu();
	 }
	 return menu;
 }
 
 public String TableList(){
	 
	 String tablesMenu= "+-------------------------------+\n|  Available Tables List \n+-------------------------------+\n";
	 for(Table table:tables) {
		 tablesMenu+= table.toStringMenu();
	 }
	 return tablesMenu;
 }
 
 
// public List<Table> prepareTable(): retourner la liste tables disponible pour les afficher System.out 

//methode imlplementes
@Override
public void commander(int id_pizza, String size, User user) {
    // Récupérer le plat à commander à partir de l'ID
    Pizza pizza = getPizzaById (id_pizza);
    if (pizza == null) {
        System.out.println("Pizza with ID " + id_pizza + " does not exist.");
        return;
    }
    
    // Vérifier si la taille demandée est valide
    if (!Arrays.asList("small", "medium", "large").contains(size)) {
        System.out.println("Invalid size.");
        return;
    }
    
    // Calculer le prix total en fonction de la taille demandée
    Scanner sc = new Scanner(System.in);
    double price = pizza.getPrice();
    System.out.print("Enter the quantity: ");
    int quantite = sc.nextInt();
    if(quantite>pizza.getStock()) {
    	System.out.println("la quantité demandé ne peut pas etre preparé pour le moment , essayez de commander moin");
    	return;
    }

    
    // Appliquer une réduction de 5% pour les abonnés
    //TODO: raka7ha
   /* if (is_subscriber) {
        price *= 0.95;
    }*/
    
    // Confirmer la commande
    System.out.println("voulez vous confirmer la commande ?\ntapez 1 pour valider\ntapez0 pour annuler");
    
    Scanner scan = new Scanner(System.in);
    int choix = scan.nextInt();
    if (choix == 1) {
        System.out.println("Commande : " + pizza.getName() + " (" + size + ")");
        System.out.println("Prix : " + price + " DT");
        boolean isAbonnee = user instanceof UserAbonnee;
        user.ajoutCommande(new Commande(pizza,size,quantite,isAbonnee));
    } else {
    	
        System.out.println("commande annulé");
    }
}

@Override
public void reserver(int nbrPersonnes , User user) {
	// TODO Auto-generated method stub
	for (Table t : tables) {
		if(t.getUser() == user) {
			System.out.println("you have already reserved table " + t.getNumero());
			return;
		}
	}
	for (Table t : tables) {
		if(!t.isReserved()&&t.getNombrePlaces()>=nbrPersonnes) {
			t.reserve(user);
			System.out.println("you have reserved the table number "+t.getNumero());
			return;
		}
	}
	System.out.println("we don't have available tables with "+nbrPersonnes+" chairs");
}
@Override
public void Unreserve(User user) {
	// TODO Auto-generated method stub
	for (Table t : tables) {
		if(t.getUser() == user) {
			t.unreserve();
			System.out.println("you have unreserved the table number " + t.getNumero());
			return;
		}
	}
	System.out.println("you have no tables to unreserve");
}

public ArrayList<Table> getTables() {
	return tables;
}

public void prepareRestau() {
	pizzas.add(new Pizza(1,"margerita",10000,10));
	pizzas.add(new Pizza(2,"4 saisons",14000,12));
	pizzas.add(new Pizza(3,"pepperoni",12000,5));
	pizzas.add(new Pizza(4,"vegetarienne",12000,100));
	tables.add(new Table(1,2));
	tables.add(new Table(2,2));
	tables.add(new Table(3,2));
	tables.add(new Table(4,4));
	tables.add(new Table(5,4));
	tables.add(new Table(6,4));
	tables.add(new Table(7,8));
	tables.add(new Table(8,8));
	tables.add(new Table(9,8));
}

}
