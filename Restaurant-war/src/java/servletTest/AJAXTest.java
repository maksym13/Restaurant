package servletTest;

import ejb.Cuisine;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cdi407
 */
@WebServlet(name = "AJAXTest", urlPatterns = {"/AJAXTest"})
public class AJAXTest extends HttpServlet {
@EJB
    private Cuisine cuisine;
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
                response.setContentType("text/html;charset=UTF-8");

        String url = "/WEB-INF/AJAX-Chef.jsp";
        HttpSession session = request.getSession();
        


        if ("produit".equals(request.getParameter("section"))) {
            
            url = "/WEB-INF/ajaxProduit.jsp";
            System.out.println(cuisine.getListe());
            request.setAttribute("produit", cuisine.getListe());
            
        }

        if ("item".equals(request.getParameter("section"))) {
            url = "/WEB-INF/ajaxItem.jsp";
            System.out.println(cuisine.getListei());
            request.setAttribute("item", cuisine.getListei());
               
        }
        
        if ("statutProduit".equals(request.getParameter("section"))){
            
                cuisine.ChangerEtat(request.getParameter("produit"));                 
            url = "/WEB-INF/ajaxProduit.jsp";
            request.setAttribute("produit", cuisine.getListe());
        }
        
        if ("razProduit".equals(request.getParameter("section"))){
            System.out.println("passage1 vers " +url+ "-----------------------------");
                cuisine.RemiseZero(request.getParameter("produit"));
            url = "/WEB-INF/ajaxProduit.jsp";
            request.setAttribute("produit", cuisine.getListe());
        }
        
        if ("statutItem".equals(request.getParameter("section"))){
           
                 cuisine.ChangerDispo(request.getParameter("item"));
            url= "/WEB-INF/ajaxItem.jsp";
            request.setAttribute("item", cuisine.getListei());
        }
        System.out.println("passage vers " +url+ "-----------------------------");
        
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
