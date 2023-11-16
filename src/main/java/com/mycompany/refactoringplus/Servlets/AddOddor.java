/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.refactoringplus.Servlets;

import com.mycompany.refactoringplus.Classes.DataManager;
import com.mycompany.refactoringplus.Classes.Odor;
import com.mycompany.refactoringplus.Classes.RefactoringMethod;
import com.mycompany.refactoringplus.Classes.ReportAction;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dom4j.DocumentException;

/**
 *
 * @author Oscar
 */
public class AddOddor extends HttpServlet {



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
        
        
        // Report action
        String ipAddress = request.getHeader("X-Forwarded-For");
        if(ipAddress == null){
            ipAddress = request.getRemoteAddr();
        }
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        String formattedDate = dateFormat.format(new Date());
        
        
        
        ReportAction.addtobitlist(0, "Añadir olor", ipAddress, formattedDate);
        try {
            ReportAction.reportAction(0,System.getProperty("user.dir")+"/db/reporting.xml");
        } catch (DocumentException ex) {
            Logger.getLogger(AddIncharge.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ReportAction.reportAction(1,System.getProperty("user.dir")+"/db/reporting.csv");
        } catch (DocumentException ex) {
            Logger.getLogger(AddIncharge.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            ReportAction.reportAction(2,System.getProperty("user.dir")+"/db/reporting.json");
        } catch (DocumentException ex) {
            Logger.getLogger(AddIncharge.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setCharacterEncoding("UTF-8");
        
        String odorName = request.getParameter("odorName_entry_form5");
        String description = request.getParameter("description_entry_form5");
        String[] relatedRefactoring = request.getParameterValues("refactor_entry_form5");
        
        ArrayList<RefactoringMethod> relatedRefactoringArray;
        relatedRefactoringArray= new ArrayList();
        if(relatedRefactoring!=null){
            for (String relatedref : relatedRefactoring) {
                RefactoringMethod ref = DataManager.findRefactoringbyName(relatedref);
                relatedRefactoringArray.add(ref);
            }
        }
        
        Odor od = new Odor(odorName, relatedRefactoringArray);
        od.getDescriptionFromChatGPT();
        if(od.getDescription().equals("No description from Chat GPT")){
            od.setDescription(description);
        }
        DataManager.oddors.add(od);
        DataManager.saveOdor();
        
        System.out.println(description);
        System.out.println(od.getDescription());
        
        Login.redirect(request, response, "refactoringPlus.jsp");
        
    }



}
