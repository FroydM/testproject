/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.refactoringplus.Servlets;

import com.mycompany.refactoringplus.Classes.AppClass;
import com.mycompany.refactoringplus.Classes.Application;
import com.mycompany.refactoringplus.Classes.DataManager;
import com.mycompany.refactoringplus.Classes.ReportAction;
import java.io.IOException;
import java.text.ParseException;
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
public class AddAppClass extends HttpServlet {



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
        
        
        
        ReportAction.addtobitlist(0, "Añadir App Class", ipAddress, formattedDate);
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
        
        String fileName = get_verify_parameter(request, "fileName_entry_form3");
        String className = get_verify_parameter(request, "className_entry_form3");
        String packageName = get_verify_parameter(request, "packageName_entry_form3");
        String lastMaintainDate = get_verify_parameter(request, "lastMaintain_entry_form3");
        String[] relatedApplications = request.getParameterValues("app_entry_form3");
        
        Date pdate = new Date();
        //Pattern mm/dd/yyyy
        String pattern = "MM/dd/yyyy";

        // format the entry
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            
            pdate = sdf.parse(lastMaintainDate);
           
        } catch (ParseException e) {
            System.out.println("Parse error");
        }
        
        ArrayList<Application> relatedAppsArray;
        relatedAppsArray= new ArrayList();
        if(relatedApplications!=null){
            for (String relatedApplication : relatedApplications) {
                Application a = DataManager.findApplicationbyName(relatedApplication);
                relatedAppsArray.add(a);
            }
        }
        
        AppClass apclass = new AppClass(fileName, className, pdate, packageName, relatedAppsArray);
        DataManager.classes.add(apclass);
        DataManager.saveClass();
        
        
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
