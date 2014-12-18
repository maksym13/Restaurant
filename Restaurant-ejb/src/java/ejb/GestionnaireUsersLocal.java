/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entities.Users;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author cdi406
 */
@Local
public interface GestionnaireUsersLocal
{

    public List loadUsers(Boolean argActif);

    public void addUser(String pin, String nom, Boolean HR, Boolean caissier, Boolean chef, Boolean serveur);

    public Boolean verifPinValide(String argPin);

    public Users findUser(String argPin);

    public void AlterUser(String pin, String nom, Boolean HR, Boolean caissier, Boolean chef, Boolean serveur);

    public Boolean removeUser(Users argUsers);

    public HashMap<String, Users> getListUser();

    public void setListUser(HashMap<String, Users> listUser);

    public List<String> getPinListe();

    public void setPinListe(List<String> pinListe);
    
}
