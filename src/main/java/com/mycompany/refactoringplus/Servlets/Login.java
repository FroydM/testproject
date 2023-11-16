/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.refactoringplus.Servlets;

import com.mycompany.refactoringplus.Classes.DataManager;
import com.mycompany.refactoringplus.Classes.ReportAction;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Oscar
 */
public class Login extends HttpServlet {

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
        
        String nombre = request.getParameter("entryname");
        String contraseña = request.getParameter("entrypassword");
        nombre = nombre.replace("Ã±", "ñ");
        contraseña = contraseña.replace("Ã±", "ñ");
        
        try{
            
            if(nombre.equals("admin") && contraseña.equals("admin")){
                
                // Init data manager for db files
                System.out.println("path:" + System.getProperty("user.dir"));
                String dbpath = System.getProperty("user.dir")+"/db/";
              
                System.out.println(dbpath);
                DataManager dm = new DataManager(dbpath);
                ReportAction ra = new ReportAction(dbpath);
                HttpSession mysession = request.getSession();
                mysession.setAttribute("datamanager", dm);
                mysession.setAttribute("reportaction", ra);
                
                redirect(request, response, "refactoringPlus.jsp");
            
        }else{
                
                redirect(request, response, "index.jsp");
            
        }
            
        }catch(IOException e){
            System.out.println(e);
        }
        
    
    }

    
    public static void redirect(HttpServletRequest request,HttpServletResponse response, String page) throws ServletException, IOException{

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}
