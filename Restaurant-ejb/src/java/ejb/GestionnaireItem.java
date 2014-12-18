/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Item;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GestionnaireItem implements GestionnaireItemLocal {
    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;
    
    @Override
    public List getListe() {
        
        String r01 = "select i from Item i";
        System.out.println("------------------------------------------");
        System.out.println(em.createQuery(r01));
        Query qr = em.createQuery(r01);
        System.out.println("requete " + qr);
        return qr.getResultList();
    }

    
    @Override
    public List getListeEntrees() {
        String r02 = "select i from Item i"
                +" where i.categorie= :categorie"              
                ;
        Query qr = em.createQuery(r02);
        qr.setParameter("categorie", "entree");
        return qr.getResultList();
    }
    
    
    @Override
    public List getListePlats() {
        String r02 = "select i from Item i "
                +" where i.categorie= :categorie "              
                ;
        Query qr = em.createQuery(r02);
        qr.setParameter("categorie", "plat");
        return qr.getResultList();
    }

    /**
     *
     * @return
     */
    @Override
    public List getListeDesserts() {
        String r02 = "select i from Item i "
                +" where i.categorie= :categorie "              
                ;
        Query qr = em.createQuery(r02);
        qr.setParameter("categorie", "dessert");
        return qr.getResultList();
}
    
     @Override
    public List getListeFromages() {
        String r02 = "select i from Item i "
                +" where i.categorie= :categorie "              
                ;
        Query qr = em.createQuery(r02);
        qr.setParameter("categorie", "fromage");
        return qr.getResultList();
    }
    
    @Override
    public List getListeVins() {
        String r02 = "select i from Item i "
                +" where i.categorie= :categorie "              
                ;
        Query qr = em.createQuery(r02);
        qr.setParameter("categorie", "vin");
        return qr.getResultList();
    }
    
    
    @Override
     public List getListeActive() {
        
        String r01 = "select i from Item i "
                +" where i.Active=true "              
                ;
        System.out.println("------------------------------------------");
        System.out.println(em.createQuery(r01));
        Query qr = em.createQuery(r01);
        System.out.println("requete " + qr);
        return qr.getResultList();
    }
 
    @Override
     public void changerEtat(String nomItem){
         
         Item it=em.find(Item.class,nomItem );
         
        if(it.getActive())
            {
                it.setActive(false);
            }
        else
            {
                it.setActive(true);
            }
    
       
     }
        
        
        
        
    @Override
    public void createItem(String nomItem, String description, String imagePath, 
            BigDecimal TVA, BigDecimal prixHT, Boolean argCuisine,String categorie)
        {
        
            Item item = new Item(nomItem, description, imagePath, TVA, prixHT, argCuisine,categorie);
            save(item);
            

        }

    @Override
    public void save(Item argItem)
        {
            em.persist(argItem);
        }
       
}
