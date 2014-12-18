/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sousControlers.iControleur;

/**
 *
 * @author cdi406
 */
public class Controler extends HttpServlet
{

    HashMap<String, iControleur> SousControleurs ;

    @Override
    public void init(ServletConfig config) throws ServletException
    {
        super.init(config);
        SousControleurs = new HashMap();
        for(Enumeration e = this.getServletConfig().getInitParameterNames();e.hasMoreElements();)
            {
                String name = e.nextElement().toString();
                //if(name.endsWith(".cmd"))
                //{
                    String value = this.getServletConfig().getInitParameter(name);
                    try
                    {
                        SousControleurs.put(name, (iControleur)Class.forName(value).newInstance());
                    }
                    catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex)
                    {
                        Logger.getLogger(Controler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                //}
            }
    }
    
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
        
        HttpSession session = request.getSession();
        
        //A modifier
        String url = "/WEB-INF/jspPageMVC2.jsp";
        
        //a dedoubler selon les sections (gestion) et les pages (affichages)
        String section = request.getParameter("section");
        if(SousControleurs.containsKey(section))
        {
            iControleur c = SousControleurs.get(section);
            url = c.execute(request, response);
        }
        
        String page = request.getParameter("page");
        if(SousControleurs.containsKey(page))
        {
            iControleur c = SousControleurs.get(page);
            url = c.execute(request, response);
        }
        
        System.out.println(url);
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
