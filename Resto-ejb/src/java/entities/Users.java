package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
   
    @Id
    private String pin;
    
    private String nom;
    private Boolean rh;
    private Boolean caissier;
    private Boolean chef;
    private Boolean serveur;
    private Boolean active;

    //<editor-fold defaultstate="collapsed" desc="Contructeur">
    public Users() {
    }
    
    public Users(String pin, String nom, Boolean RH, Boolean caissier, Boolean chef, Boolean serveur, Boolean isActive) {
        this.pin = pin;
        this.nom = nom;
        this.rh = RH;
        this.caissier = caissier;
        this.chef = chef;
        this.serveur = serveur;
        this.active = isActive;
    }
//</editor-fold>
    
    
    //<editor-fold defaultstate="collapsed" desc="Getter/Setter">    

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Boolean getRh() {
        return rh;
    }

    public void setRh(Boolean rh) {
        this.rh = rh;
    }

    public Boolean getCaissier() {
        return caissier;
    }

    public void setCaissier(Boolean caissier) {
        this.caissier = caissier;
    }

    public Boolean getChef() {
        return chef;
    }

    public void setChef(Boolean chef) {
        this.chef = chef;
    }

    public Boolean getServeur() {
        return serveur;
    }

    public void setServeur(Boolean serveur) {
        this.serveur = serveur;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
 
    
    
    
//</editor-fold>

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.pin);
        hash = 53 * hash + Objects.hashCode(this.nom);
        hash = 53 * hash + Objects.hashCode(this.rh);
        hash = 53 * hash + Objects.hashCode(this.caissier);
        hash = 53 * hash + Objects.hashCode(this.chef);
        hash = 53 * hash + Objects.hashCode(this.serveur);
        hash = 53 * hash + Objects.hashCode(this.active);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Users other = (Users) obj;
        if (!Objects.equals(this.pin, other.pin)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.rh, other.rh)) {
            return false;
        }
        if (!Objects.equals(this.caissier, other.caissier)) {
            return false;
        }
        if (!Objects.equals(this.chef, other.chef)) {
            return false;
        }
        if (!Objects.equals(this.serveur, other.serveur)) {
            return false;
        }
        if (!Objects.equals(this.active, other.active)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nom= " + nom + "Fonctions : rh =" + rh + ", caissier = " + caissier +", chef = " + chef + ", serveur = " + serveur;
    }
    
    
    
    
    
}
