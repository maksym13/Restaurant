
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TableRestaurant implements Serializable
{
    private static final long serialVersionUID = 1L;
   
    @Id
    @Column(nullable = false, unique = true)
    private Integer numeroTable;
    @Column(nullable = false) transient 
    private Boolean disponible;
    @Column()
    private Integer nombreCouvert;
    @OneToOne(mappedBy = "table")
    private Commande commandeEnCours;
    
    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.numeroTable);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final TableRestaurant other = (TableRestaurant) obj;
        if (!Objects.equals(this.numeroTable, other.numeroTable))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "entites.Table[ numeroTable=" + numeroTable + " ]";
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="g/s">
    
    
    public Integer getNumeroTable()
    {
        return numeroTable;
}

    public void setNumeroTable(Integer numeroTable)
    {
        this.numeroTable = numeroTable;
    }

    public Boolean isDisponible()
    {
        return disponible;
    }

    public void setDisponible(Boolean disponible)
    {
        this.disponible = disponible;
    }

    public Commande getCommandeEnCours()
    {
        return commandeEnCours;
    }

    public void setCommandeEnCours(Commande commandeEnCours)
    {
        this.commandeEnCours = commandeEnCours;
    }

    public Integer getNombreCouvert()
    {
        return nombreCouvert;
    }

    public void setNombreCouvert(Integer nombreCouvert)
    {
        this.nombreCouvert = nombreCouvert;
    }
    
    
//</editor-fold>
    
}
