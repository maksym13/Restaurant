
package controller;


import ejb.GestionnaireUsersLocal;
import entities.Users;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    
    @EJB
    private GestionnaireUsersLocal cUser;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");

     //String url = "/WEB-INF/jspPinConnexion.jsp";
     String url = "/WEB-INF/jspPinConnexion.jsp";
        
//<editor-fold defaultstate="collapsed" desc="Test">
//System.out.println("avant addUser");
//      cUser.addUser("1234", "Jean Peuplu", true, true, true, true);
//      cUser.addUser("4321", "Ohmar Matuer", false, false, true, true);
//      cUser.addUser("9876", "Fred Tequib", false, true, false, true);
//System.out.println("après addUser");
//
//
//System.out.println("avant removeUser");
//       cUser.removeUser(cUser.findUser("Pin"));
//System.out.println("après removeUser");
//
//System.out.println("avant alterUser");
//        cUser.AlterUser("9876", "Sylvain", false, false, false, true);
//        cUser.AlterUser("4321", "Ohmar Matuer", false, false, true, true);    
//System.out.println("après alterUser");
//
//
//        HttpSession session = request.getSession();
//        session.setAttribute("listeUser", cm.loadUsers(true)); // fonctionne
//
//
//System.out.println("tout est OK !!! ");
//
//</editor-fold>
        String msg = "";
        String pin = request.getParameter("pin");
        String welcome;
        
        HttpSession session = request.getSession();
        
        // IDENTIFICATION
        if  (request.getParameter("doIt") != null)
            {
                Users u = cUser.findUser(pin);

                if (u != null && u.getActive()) 
                    {
                        session.setAttribute("user",u);
                        url = "/WEB-INF/main.jsp";
                    }
                else if (u == null)
                    {
                        msg = "Erreur de code Pin !!!";
                    }
                else
                    {                         
                        msg = "Cet utilsateur n'existe pas ! ";
                    }   
            }
       
    //System.out.println("avant addUser");
    //      cUser.addUser("1234", "Jean Peuplu", true, true, true, true);
    //      cUser.addUser("4321", "Ohmar Matuer", false, false, true, true);
    //      cUser.addUser("9876", "Fred Tequib", false, true, false, true);
    //System.out.println("après addUser");
        
        if (request.getParameter("doIt2")!=null)
        {
            System.out.println(request.getParameter("Pin"));
            System.out.println(request.getParameter("Nom"));
            System.out.println(Boolean.valueOf(request.getParameter("RH")));
            System.out.println(Boolean.valueOf(request.getParameter("Caissier")));
            System.out.println(Boolean.valueOf(request.getParameter("Chef")));
            System.out.println(Boolean.valueOf(request.getParameter("Serveur")));
        //    System.out.println(request.getParameter("Serveur"));
            
            cUser.addUser(request.getParameter("Pin"), 
                          request.getParameter("Nom"), 
                          Boolean.valueOf(request.getParameter("RH")),
                          Boolean.valueOf(request.getParameter("Caissier")),
                          Boolean.valueOf(request.getParameter("Chef")),
                          Boolean.valueOf(request.getParameter("Serveur"))
                          );
        }
        
        if (request.getParameter("remove")!=null)
        {    
 System.out.println("avant désactivation");
            cUser.removeUser((cUser.findUser(request.getParameter("Pin"))));
// System.out.println(request.getParameter(cUser.findUser(request.getParameter("Nom")) + " est bien désactivé"));
      
        }
        
        
        request.setAttribute("msg", msg);
        session.setAttribute("listeUser", cUser.loadUsers(true));
        request.getRequestDispatcher(url).include(request, response);
        

    }
            

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
