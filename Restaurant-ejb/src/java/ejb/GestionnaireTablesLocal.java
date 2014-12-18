/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.TableRestaurant;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author cdi406
 */
@Local
public interface GestionnaireTablesLocal
{

    public void appelerServer(TableRestaurant table);

    public void chargerListeTable();

    public Collection<TableRestaurant> getListeTable();

    public void persistTable(TableRestaurant table);

    public void persistEnsembleTables();

    public void ajouterTable(Integer numeroTable, Integer nombreCouvert);

    public void retirerTable(TableRestaurant table);

    public void reserverTable(TableRestaurant table);

    public void occuperTable(TableRestaurant table);

    public void libererTable(TableRestaurant table);

    public void viderListeTable();

    public void definirNombreCouvertsTable(TableRestaurant table, Integer nombreCouvert);

    public TableRestaurant getTable(Integer numeroTable);
    
}
