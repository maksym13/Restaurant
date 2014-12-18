package entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Commande implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    static Calendar dateEtHeureCourantes = Calendar.getInstance();
    private String refCommande;
    private Boolean closed=false;
    private String timeStampCommande
            = dateEtHeureCourantes.get(Calendar.YEAR) + "-"
            + dateEtHeureCourantes.get(Calendar.MONTH) + "-"
            + (dateEtHeureCourantes.get(Calendar.DATE) + 1) + " "
            + dateEtHeureCourantes.get(Calendar.HOUR_OF_DAY) + ":"
            + dateEtHeureCourantes.get(Calendar.MINUTE) + ":"
            + dateEtHeureCourantes.get(Calendar.SECOND);   //AJOUTER LE NUMERO de LA TABLE EN CONCATENATION

   @OneToMany(mappedBy = "commande")
   private Collection<Item> items;
   @OneToOne
   private TableRestaurant table;
    
    public Collection<Item> getItems() {
        return items;
    }

    public void setItems(Collection<Item> items) {
        this.items = items;
    }

    public Commande() 
    {
    }

    public Commande(String ref, Collection<Item> items) 
    {
        this.refCommande = ref;
        this.items = items;        
    }

    public void lireCommande(){
        for(Item it: items){
            
       System.out.println(it.getNomItem());
        }
        
    }
    
    
    public boolean pasDEntrees(){
        boolean reponse=true;
       for(Item it:items){
           if(it.getCategorie().equals("entree")) reponse=false;
           
       }
       return reponse;
    }
     public boolean pasDePlats(){
        boolean reponse=true;
       for(Item it:items){
           if(it.getCategorie().equals("plat")) reponse=false;
           
       }
       return reponse;
    }
     
      public boolean pasDeDessert(){
        boolean reponse=true;
       for(Item it:items){
           if(it.getCategorie().equals("dessert")) reponse=false;
           
       }
       return reponse;
    }
      public boolean pasDeFromages(){
        boolean reponse=true;
       for(Item it:items){
           if(it.getCategorie().equals("fromage")) reponse=false;
           
       }
       return reponse;
    }
     
      public boolean pasDeVins(){
        boolean reponse=true;
       for(Item it:items){
           if(it.getCategorie().equals("vin")) reponse=false;
           
       }
       return reponse;
    }
     
     
    
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande))
        {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
            return "Commande n° " + refCommande;
    }
    
    //<editor-fold defaultstate="collapsed" desc="g/s">
    
    
    public String getRefCommande() {
        return refCommande;
}

    public void setRefCommande(String refCommande) {
        this.refCommande = refCommande;
    }

    public Boolean getClosed() {
        return closed;
    }
    
    public void setClosed(Boolean closed) {    
        this.closed = closed;
    }

    public String getRef() {
        return refCommande;
    }
    
    public void setRef(String ref) {
        this.refCommande = ref;
    }
    
    public boolean isClosed() {
        return closed;
    }
    
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
    
    public static Calendar getDateEtHeureCourantes() {
        return dateEtHeureCourantes;
    }
    
    public static void setDateEtHeureCourantes(Calendar dateEtHeureCourantes) {
        Commande.dateEtHeureCourantes = dateEtHeureCourantes;
    }
    
    public String getTimeStampCommande() {
        return timeStampCommande;
    }
    
    public void setTimeStampCommande(String timeStampCommande) {
        this.timeStampCommande = timeStampCommande;
    }
    
//    public Collection<Produit> getItems() {
//        return items;
//    }
//    
//    public void setItems(Collection<Produit> items) {
//        this.items = items;
//    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public TableRestaurant getTable()
    {
        return table;
    }

    public void setTable(TableRestaurant table)
    {
        this.table = table;
    }
    
//</editor-fold>

}
