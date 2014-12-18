/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import ejb.GestionnaireItemLocal;
import ejb.GestionnaireTablesLocal;
import ejb.GestionnaireUsersLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cdi406
 */
@WebServlet(name = "AjoutDonnees", urlPatterns =
    {
        "/AjoutDonnees"
})
public class AjoutDonnees extends HttpServlet
{
    @EJB
    private GestionnaireItemLocal gestionnaireItem;
    @EJB
    private GestionnaireUsersLocal gestionnaireUsers;
    @EJB
    private GestionnaireTablesLocal gestionnaireTables;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AjoutDonnees</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjoutDonnees at " + request.getContextPath() + "</h1>");
            
            gestionnaireTables.ajouterTable(1, 2);
            gestionnaireTables.ajouterTable(2, 2);
            gestionnaireTables.ajouterTable(3, 4);
            gestionnaireTables.ajouterTable(4, 4);
            gestionnaireTables.ajouterTable(5, 6);

            gestionnaireUsers.addUser("1234", "Jean Peuplu", true, true, true, true);
            gestionnaireUsers.addUser("4321", "Ohmar Matuer", false, false, true, true);
            gestionnaireUsers.addUser("9876", "Fred Tequib", false, true, false, true);

            gestionnaireItem.createItem("salade composée", " laitue avec croutons et tomates", "/image/photosEntrees01.gif", new BigDecimal("10"), new BigDecimal("24.80"), true, "entree");
            gestionnaireItem.createItem("oeufs mayonnaise", " des oeufs et de la mayonnaise", "/image/photosEntrees02.gif", new BigDecimal("11"), new BigDecimal("21.70"), true, "entree");
            gestionnaireItem.createItem("salsifis a la vinaigrette", " des salsifis avec de la vinaigrette ", "/image/photosEntrees03.gif", new BigDecimal("12"), new BigDecimal("19.60"), true, "entree");
            gestionnaireItem.createItem("croustades", " tranches de pomme de terre frites", "/image/photosEntrees04.gif", new BigDecimal("09"), new BigDecimal("11.73"), true, "entree");
            gestionnaireItem.createItem("steak frittes", " un steak avec des frittes", "/image/photosEntrees05.gif", new BigDecimal("13"), new BigDecimal("07.80"), true, "plat");
            gestionnaireItem.createItem("poulet basquaise", " du poulet avec de la basquaise", "/image/photosEntrees06.gif", new BigDecimal("14"), new BigDecimal("17.76"), true, "plat");
            gestionnaireItem.createItem("hachi parmentier", " du hachi avec du parmentier", "/image/photosEntrees07.gif", new BigDecimal("11"), new BigDecimal("18.40"), true, "plat");
            gestionnaireItem.createItem("boeuf en daube", " du boeuf avec de la daube", "/image/photosEntrees08.gif", new BigDecimal("14"), new BigDecimal("25.70"), true, "plat");
            gestionnaireItem.createItem("choucroute", " du choux et de la croute", "/image/photosEntrees09.gif", new BigDecimal("09"), new BigDecimal("16.70"), true, "plat");
            gestionnaireItem.createItem(" poires au sirop", " des poires avec les six rots", "/image/photosEntrees10.gif", new BigDecimal("14"), new BigDecimal("14.70"), true, "dessert");
            gestionnaireItem.createItem(" tarte aux pommes ", " une tarte avec des pommes", "/image/photosEntrees11.gif", new BigDecimal("12"), new BigDecimal("13.70"), true, "dessert");
            gestionnaireItem.createItem(" banana split ", " une banane avec de la glace vanille", "/image/photosEntrees12.gif", new BigDecimal("13"), new BigDecimal("7.80"), true, "dessert");         
            gestionnaireItem.createItem(" evian ", " eau payante ", "/image/photosEntrees13.gif", new BigDecimal("12"), new BigDecimal("09.70"), true, "boisson");
            gestionnaireItem.createItem(" coca-cola ", " abrasif reglementé pour la cuisine", "/image/photosEntrees14.gif", new BigDecimal("08"), new BigDecimal("4.70"), true, "boisson");
            gestionnaireItem.createItem(" grenadine ", " sirop ", "/image/photosEntrees15.gif", new BigDecimal("11"), new BigDecimal("3.76"), true, "boisson");         
            gestionnaireItem.createItem(" chateau margot 1965 ", " vin qu'on peu pas acheter", "/image/photosEntrees16.gif", new BigDecimal("20"), new BigDecimal("1363.70"), true, "vin");
            gestionnaireItem.createItem(" vin rouge ", " grenadine du chef", "/image/photosEntrees17.gif", new BigDecimal("07"), new BigDecimal("10.70"), true, "vin");
            gestionnaireItem.createItem(" vin blanc de montrouge ", " restes agricoles masserés dans des restes plus vieux", "/image/photosEntrees18.gif", new BigDecimal("08"), new BigDecimal("15.70"), true, "vin");        
            gestionnaireItem.createItem(" camembert ", " lait mou ", "/image/photosEntrees18.gif", new BigDecimal("08"), new BigDecimal("07.70"), true, "fromage");
            gestionnaireItem.createItem(" bleu de bresse ", " fromage de provenance inconnue", "/image/photosEntrees19.gif", new BigDecimal("07"), new BigDecimal("06.70"), true, "fromage");
            gestionnaireItem.createItem(" gorgonzolla ", " pour les pattes (a mettre avant et apres)", "/image/photosEntrees20.gif", new BigDecimal("11"), new BigDecimal("03.70"), true, "fromage");
            
            out.println("</body>");
            out.println("</html>");
        }
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
            throws ServletException, IOException
    {
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
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
