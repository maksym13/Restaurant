/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Commande;
import entities.Item;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author cdi406
 */
@Local
public interface GestionnaireCommandesLocal
{

    public Commande getCommande(String refCommande);

    public Commande getCommande(Integer numTable);

    public void ajouterItem(String refCommande, Item item);

    public void retirerItem(String refCommande, Item item);

    public void viderCommande(String refCommande);

    public void validerCommande(String refCommande);

    public Collection<Commande> getListCommande();
    
}
