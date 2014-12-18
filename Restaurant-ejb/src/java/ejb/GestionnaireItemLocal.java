/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Item;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi406
 */
@Local
public interface GestionnaireItemLocal
{

    public List getListe();

    public List getListeEntrees();

    public List getListePlats();

    public List getListeDesserts();

    public List getListeFromages();

    public List getListeVins();

    public List getListeActive();
            
    public void changerEtat(String nomItem);

    public void createItem(String nomItem, String description, String imagePath, BigDecimal TVA, BigDecimal prixHT, Boolean argCuisine, String categorie);

    public void save(Item argItem);
    
}
