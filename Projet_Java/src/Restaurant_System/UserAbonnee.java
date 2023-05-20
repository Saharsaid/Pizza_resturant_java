package Restaurant_System;

import java.util.Date;

public class UserAbonnee extends User {
   
    private String mail;
    private String motDePasse;
    private Date dateAbonnement;
    
    public UserAbonnee( String nom, String prenom, String numeroTelephone, String adresse, String mail, String motDePasse) {
        super(nom, prenom, numeroTelephone,adresse);
        this.mail = mail;
        this.motDePasse = motDePasse;
        this.dateAbonnement = new Date(System.currentTimeMillis());
    }
    
    // getters et setters pour tous les attributs
    
 
    
    public String getMail() {
        return mail;
    }
    
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getMotDePasse() {
        return motDePasse;
    }
    
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    
    public Date getDateAbonnement() {
        return dateAbonnement;
    }
    
    public void setDateAbonnement(Date dateAbonnement) {
        this.dateAbonnement = dateAbonnement;
    }
    
    // autres méthodes spécifiques aux abonnés
}
