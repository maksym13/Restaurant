package entities;


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Item implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    private String nomItem;

    private String description = "";
    private String imagePath = "";
    private BigDecimal TVA;
    private BigDecimal prixHT;
    private Boolean Cuisine;
    private Boolean Active;
    private String categorie;

        @ManyToOne
    private Commande commande;
        
    

    public Item()
    {
    }

    public Item(String nomItem, String description, String imagePath,
                BigDecimal TVA, BigDecimal prixHT, Boolean Cuisine, String categorie)
    {
        this.nomItem = nomItem;
        this.description = description;
        this.imagePath = imagePath;
        this.TVA = TVA;
        this.prixHT = prixHT;
        this.Cuisine = Cuisine;
        this.Active = true;
        this.categorie = categorie;
    }


    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (nomItem != null ? nomItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Item))
        {
            return false;
        }
        Item other = (Item) object;
        if ((this.nomItem == null && other.nomItem != null) || (this.nomItem != null && !this.nomItem.equals(other.nomItem)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "item =   " + this.nomItem + "\n "
                + "description =   " + this.description + "\n "
                + "chemin vers l'image=   " + this.imagePath + "\n "
                + "TVA=   " + this.TVA + "\n "
                + "prix hors taxe=   " + this.prixHT + "\n "
                + "entré en cuisine=   " + this.Cuisine + "\n "
                + "present sur la carte=   " + this.Active + "\n "
                + "categorie=   " + this.categorie + "\n ";
    }

    
    //<editor-fold defaultstate="collapsed" desc="g/s">

    public String getNomItem()
    {
        return nomItem;
    }

    public void setNomItem(String nomItem)
    {
        this.nomItem = nomItem;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getImagePath()
    {
        return imagePath;
    }

    public void setImagePath(String imagePath)
    {
        this.imagePath = imagePath;
    }

    public BigDecimal getTVA()
    {
        return TVA;
    }

    public void setTVA(BigDecimal TVA)
    {
        this.TVA = TVA;
    }

    public BigDecimal getPrixHT()
    {
        return prixHT;
    }

    public void setPrixHT(BigDecimal prixHT)
    {
        this.prixHT = prixHT;
    }

    public Boolean getCuisine()
    {
        return Cuisine;
    }

    public void setCuisine(Boolean Cuisine)
    {
        this.Cuisine = Cuisine;
    }

    public Boolean getActive()
    {
        return Active;
    }

    public void setActive(Boolean Active)
    {
        this.Active = Active;
    }

    public String getCategorie()
    {
        return categorie;
    }

    public void setCategorie(String categorie)
    {
        this.categorie = categorie;
    }

    public Commande getCommande()
    {
        return commande;
    }

    public void setCommande(Commande commande)
    {
        this.commande = commande;
    }
    
    //</editor-fold>
}
