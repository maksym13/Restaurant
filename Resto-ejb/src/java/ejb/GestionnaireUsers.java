package ejb;

import entities.Users;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class GestionnaireUsers implements GestionnaireUsersLocal {

    @PersistenceContext(unitName = "Resto-PU")
    private EntityManager em;
    
   private HashMap<String, Users> listUser;
   private List<String>pinListe;

    public GestionnaireUsers() {
//        this.listUser = new HashMap();
//        this.pinListe = new ArrayList();
    }  
   
   
    
//    @Override
//   public List loadUsers ()
//   {
//       this.listUser = new HashMap();
//       String tableUser = "SELECT u FROM Users u";
//       Query allUser = em.createQuery(tableUser);
//       
//       return allUser.getResultList();
////       for (Users user : liste) {
////           
////         listUser.put(user.getPin(), user); 
//         
//         /*
//            liste.stream().forEach((user) -> {
//            listUser.put(user.getPin(), user); (la meme chose) 
//         */
//         
////       }
//      
//   }
   
    
    /**
     * Methode retournant une liste des utilisateurs
     * 
     * @param argActif if true =  Users Actifs, if False = All Users
     * @return Liste contenant des Users
     */
    @Override
   public List loadUsers (Boolean argActif)
   {
            this.listUser = new HashMap();
            String tableUser="SELECT u FROM Users u";
            
       // if true = Users actifs sinon Tous les Users
       if (argActif) 
       {
            tableUser = "SELECT u FROM Users u WHERE u.active='1'";
       }
       
        Query allUser = em.createQuery(tableUser);
        
       return allUser.getResultList();
       
   }
   
       
   
   
   
   
    @Override
   public void addUser (String pin, String nom, Boolean HR, Boolean caissier , Boolean chef, Boolean serveur)
        {
             Users ajouterUser = new Users(pin, nom, HR, caissier, chef, serveur, true);
             em.persist(ajouterUser);

     //      listUser.put(pin, ajouterUser);
System.out.println("User ajouter");
         }
   
  
    @Override
   public Boolean verifPinValide (String argPin){
     
       if (argPin.isEmpty()) return false;
        
       if (argPin.trim().equals("")) return false;
       
       if (!argPin.matches("[0-9]{4}")) return false;
       
       return true;
   }
   
    @Override
  public Users findUser (String argPin)
  {      
      Users u = null;
        if (verifPinValide(argPin)) 
            {
                u = em.find(Users.class, argPin);
            }
      
      return u;
  }
  
    
    @Override
  public void AlterUser (String pin, String nom, Boolean HR, Boolean caissier , Boolean chef, Boolean serveur)
  {
      Users u = this.findUser(pin);
      u.setPin(pin);
      u.setNom(nom);
      u.setRh(HR);
      u.setCaissier(caissier);
      u.setChef(chef);
      u.setServeur(serveur);
        
  }
  
   
    @Override
  public Boolean removeUser (Users argUsers){
       
       if(!argUsers.getActive())
            {
                return false;
            }
       else
            {
                 argUsers.setActive(false);
                 em.merge(argUsers); //
                 return true;
            }
       
   } 
  

  //<editor-fold defaultstate="collapsed" desc="Getter/Setter">
  
  
    @Override
  public HashMap<String, Users> getListUser() {
      return listUser;
  }
    @Override
  public void setListUser(HashMap<String, Users> listUser) {
      this.listUser = listUser;
  }
    @Override
  public List<String> getPinListe() {
      return pinListe;
  }
    @Override
  public void setPinListe(List<String> pinListe) {
      this.pinListe = pinListe;
  }
  
//</editor-fold>

  
  
  
}