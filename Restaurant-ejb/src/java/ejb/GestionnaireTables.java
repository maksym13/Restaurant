/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.TableRestaurant;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author cdi406
 */
@Stateless
public class GestionnaireTables implements GestionnaireTablesLocal
{
    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;
    private HashMap<Integer, TableRestaurant> listeTables;

    public GestionnaireTables()
    {
        this.listeTables = new HashMap();
    }
    
    @Override
    public void appelerServer(TableRestaurant table)
    {
        //a decrire
        //creer une nouvelle notification de "type" aide sur "this" table
    }
    
    @Override
    public void chargerListeTable()
    {
        String requete = "SELECT t FROM TableRestaurant t";
        Query qr = em.createQuery(requete);
        List<TableRestaurant> liste=qr.getResultList();
        for(TableRestaurant table:liste)
        {
            listeTables.put(table.getNumeroTable(), table);
        }
    }
    
    @Override
    public TableRestaurant getTable(Integer numeroTable)
    {
        return listeTables.get(numeroTable);
    }
    
    @Override
    public Collection<TableRestaurant> getListeTable()
    {
        return listeTables.values();
    }
    
    @Override
    public void persistTable(TableRestaurant table)
    {
        em.persist(table);
    }
    
    @Override
    public void persistEnsembleTables()
    {
        Collection<TableRestaurant> collection = listeTables.values();
        Iterator<TableRestaurant> iterateur = collection.iterator();
        while(iterateur.hasNext())
        {
            persistTable(iterateur.next());
        }
        //BiConsumer<Integer, TableRestaurant> biConsumer = (key, value) -> em.persist(value); 
        //listeTables.forEach(biConsumer);
        //listeTables.forEach((key, value) -> em.persist(value));
    }
    
    @Override
    public void ajouterTable(Integer numeroTable, Integer nombreCouvert)
    {
        TableRestaurant table = new TableRestaurant();
        table.setNumeroTable(numeroTable);
        table.setDisponible(true);
        table.setNombreCouvert(nombreCouvert);
        em.persist(table);
        listeTables.put(table.getNumeroTable(), table);
        
    }
    
    @Override
    public void retirerTable(TableRestaurant table)
    {
        listeTables.remove(table.getNumeroTable(), table);
    }
    
    @Override
    public void reserverTable(TableRestaurant table)
    {
        //pour une V2 ?
        //a definir ?
    }
    
    @Override
    public void occuperTable(TableRestaurant table)
    {
        table.setDisponible(false);
    }
    
    @Override
    public void libererTable(TableRestaurant table)
    {
        table.setDisponible(true);
    }
    
    @Override
    public void viderListeTable()
    {
        listeTables.clear();
    }
    
    @Override
    public void definirNombreCouvertsTable(TableRestaurant table, Integer nombreCouvert)
    {
        table.setNombreCouvert(nombreCouvert);
    }
}
