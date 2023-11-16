/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.refactoringplus.Servlets;

import com.mycompany.refactoringplus.Classes.BitacoryEntry;
import com.mycompany.refactoringplus.Classes.DataManager;
import com.mycompany.refactoringplus.Classes.Incharge;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.refactoringplus.Classes.ReportAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.dom4j.DocumentException;

/**
 *
 * @author Oscar
 */
public class AddIncharge extends HttpServlet {


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
        
        
        
        ReportAction.addtobitlist(0, "Añadir encargado", ipAddress, formattedDate);
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
     
  
        
        String name = get_verify_parameter(request,"name_entry_form1");
        String email = get_verify_parameter(request,"email_entry_form1");
        String phone = get_verify_parameter(request,"phone_entry_form1");
        String date = get_verify_parameter(request,"birth_entry_form1");
        Date birth = new Date();
        // Pattern mm/dd/yyyy
        String pattern = "MM/dd/yyyy";

        // format the entry
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            
            birth = sdf.parse(date);
           
        } catch (ParseException e) {
            System.out.println("Parse error");
        }
        
        // Create incharge object
        Incharge incharge = new Incharge(name, email, phone, birth);
        DataManager.peopleIncharge.add(incharge);
        DataManager.saveIncharge();
        Login.redirect(request, response, "refactoringPlus.jsp");
 
    }
    
    public static String get_verify_parameter(HttpServletRequest request, String parameter){
        if((request.getParameter(parameter) != null ) && !(request.getParameter(parameter).isEmpty())){
            return request.getParameter(parameter);
        }else{
            return "empty parameter";
        }
    }


}
