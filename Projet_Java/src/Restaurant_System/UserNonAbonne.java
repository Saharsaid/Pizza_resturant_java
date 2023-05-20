package Restaurant_System;

public class UserNonAbonne extends User {
    // constructeur avec les mêmes arguments que la classe User
    
    public UserNonAbonne(String nom, String prenom, String numeroTelephone,String adresse) {
        super( nom, prenom, numeroTelephone,adresse);
    }
    
    // autres méthodes spécifiques aux non-abonnés
}