package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produit implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean Started = false;
    private Boolean Finished = false;
    private String commentaire = "";
    private Item item;
   
    public Produit(){}    
    
    public Produit(boolean Started, boolean Finished) {
        this.Started = Started;
        this.Finished = Finished;
    }
    
    public Produit(boolean Started, boolean Finished, String commentaire, Item item) {
        this.Started = Started;
        this.Finished = Finished;
        this.commentaire = commentaire;
        this.item = item;
    }
    
    public Produit(boolean Started, boolean Finished, String commentaire) {
        this.Started = Started;
        this.Finished = Finished;
        this.commentaire = commentaire;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Produit[ id=" + id + " ]";
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Boolean getStarted()
    {
        return Started;
    }

    public void setStarted(Boolean Started)
    {
        this.Started = Started;
    }

    public Boolean getFinished()
    {
        return Finished;
    }

    public void setFinished(Boolean Finished)
    {
        this.Finished = Finished;
    }

    public String getCommentaire()
    {
        return commentaire;
    }

    public void setCommentaire(String commentaire)
    {
        this.commentaire = commentaire;
    }

    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }
    
}
