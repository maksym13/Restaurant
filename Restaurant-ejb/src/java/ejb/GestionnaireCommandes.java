/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Commande;
import entities.Item;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author cdi409
 */
@Stateless
public class GestionnaireCommandes implements GestionnaireCommandesLocal
{

    private HashMap<String, Commande> commandes;
    @PersistenceContext(unitName = "Restaurant-ejbPU")
    private EntityManager em;

    public GestionnaireCommandes()
    {
        commandes = new HashMap<>();
    }

    @Override
    public Commande getCommande(String refCommande)
    {
        if (refCommande == null || refCommande.trim().isEmpty())
        {
            return null;
        }
        return commandes.get(refCommande);
    }

    /*
     Commande de la table en cours comme on ne garde d'historisation sur le serveur
     il n'y a pas de date a mettre ( faire une mettre surcharge avec la date )
     */
    @Override
    public Commande getCommande(Integer numTable)
    {
        return null;
    }

    @Override
    public void ajouterItem(String refCommande, Item item)
    {
        if (refCommande == null || refCommande.trim().isEmpty())
        {
            return;
        }
        if (item == null)
        {
            return;
        }
        commandes.get(refCommande).getItems().add(item);
    }

    @Override
    public void retirerItem(String refCommande, Item item)
    {
        if (refCommande == null || refCommande.trim().isEmpty())
        {
            return;
        }
        if (item == null)
        {
            return;
        }
        if (commandes.get(refCommande).getItems().contains(item))
        {
            commandes.get(refCommande).getItems().remove(item);
        }
        else
        {
            return;
        }
    }

    @Override
    public void viderCommande(String refCommande)
    {
        if (refCommande == null || refCommande.trim().isEmpty())
        {
            return;
        }
        commandes.get(refCommande).getItems().clear();

    }

    /*
     Cette methode est appelée après le paiement de la commande
     */
    @Override
    public void validerCommande(String refCommande)
    {
        if (refCommande == null || refCommande.trim().isEmpty())
        {
            return;
        }
        if (commandes.containsKey(refCommande))
        {
            em.persist(commandes.get(refCommande));
            commandes.remove(refCommande);
        }

    }

    @Override
    public Collection<Commande> getListCommande()
    {
        return commandes.values();
    }

    public void persist(Object object)
    {
        em.persist(object);
    }

}
