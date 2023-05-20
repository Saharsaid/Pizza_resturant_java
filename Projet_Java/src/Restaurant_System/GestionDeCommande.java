package Restaurant_System;

public interface GestionDeCommande {
	
public void commander(int id_plate, String size,User user);
    
public void reserver(int nbrPersonnes, User user);
public void Unreserve(User user);
}
