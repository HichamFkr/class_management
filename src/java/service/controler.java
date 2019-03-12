/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import Beans.etudiant;
import Beans.groupe;
import dao.etudiant_dao;
import dao.etudiant_dao_impl;
import dao.groupe_dao_impl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hicham
 */
public class controler extends HttpServlet {
private groupe_dao_impl grp_metier = new groupe_dao_impl();
private etudiant_dao_impl etud_metier = new etudiant_dao_impl();

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet controler</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet controler at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
        
         String path = request.getServletPath();
        
        if(path.equalsIgnoreCase("/login.et")){
            String mat = request.getParameter("matricule");
            String pw = request.getParameter("pw");
            int exist = etud_metier.auth(mat, pw);
            //System.out.println("---------"+exist);
            
            
            
            if(exist == 1){
                
                    ArrayList<groupe> listGrp = new ArrayList<groupe>();
                    
                    listGrp = grp_metier.lister();
                    etudiant e = etud_metier.getByMat(mat);
                    String nomEtudiant = e.getNom()+" "+e.getPrenom();
                    //System.out.println("Taille "+listGrp.size());
                    
                    HttpSession s = request.getSession();
                    s.setAttribute("listGrp",listGrp);
                    s.setAttribute("nom", nomEtudiant);
                    
                    request.getRequestDispatcher("home.jsp").forward(request, response);
            }
                    
            
            else 
                    response.sendRedirect("login.jsp");
            
        }
        else if(path.equalsIgnoreCase("/save.et")){
            
                      
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String matricule = request.getParameter("matricule");
            int code = Integer.parseInt(request.getParameter("selectGroupe"));
            Date dateNais = Date.valueOf(request.getParameter("dateNais"));
            String lieuNais = request.getParameter("lieuNais");
            String pw = request.getParameter("pw");
            
            etudiant etud = new etudiant(matricule, nom, prenom, dateNais, lieuNais, pw, code);
            etud = etud_metier.ajouter(etud);
            
            response.sendRedirect("students.et");
            //System.out.println(nom+" "+prenom+" "+matricule+" "+code);
            
            
        }
        else if(path.equalsIgnoreCase("/students.et")){
            
            ArrayList<etudiant> listEtudiant = new ArrayList<>();
            listEtudiant = etud_metier.lister();
            HttpSession se = request.getSession();
            se.setAttribute("listEtudiant", listEtudiant);
            
            ArrayList<groupe> listGrp = new ArrayList<groupe>();       
            listGrp = grp_metier.lister();
            HttpSession sg = request.getSession();
            sg.setAttribute("listGrp", listGrp);
            
            request.getRequestDispatcher("students.jsp").forward(request, response);
        }
        
        else if(path.equalsIgnoreCase("/listStudents.et")){
            String filtre = request.getParameter("selectGroupe");
            ArrayList<etudiant> listEtudiant = new ArrayList<>();
            HttpSession se = request.getSession();
            if(!filtre.equals("tout")){
                listEtudiant = etud_metier.getByGrp(Integer.parseInt(filtre));
                se.setAttribute("listEtudiant", listEtudiant);
                request.getRequestDispatcher("students.jsp").forward(request, response);
            }
            else
                request.getRequestDispatcher("students.et").forward(request, response);       
        }
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
        
        doGet(request, response);
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
