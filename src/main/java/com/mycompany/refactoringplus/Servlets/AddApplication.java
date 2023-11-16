/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.refactoringplus.Servlets;

import com.mycompany.refactoringplus.Classes.Application;
import com.mycompany.refactoringplus.Classes.DataManager;
import com.mycompany.refactoringplus.Classes.Incharge;
import com.mycompany.refactoringplus.Classes.RefactoringMethod;
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
public class AddApplication extends HttpServlet {



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
        Login.redirect(request, response, "index.jsp");
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
        
        
        
        ReportAction.addtobitlist(0, "Añadir Aplicacion", ipAddress, formattedDate);
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
        
        
        // Obtener los parámetros del formulario
        String name = get_verify_parameter(request, "name_entry_form2");
        String version = get_verify_parameter(request, "version_entry_form2");
        String codeLanguage = get_verify_parameter(request, "codeLanguage_entry_form2");
        String productionDate = get_verify_parameter(request, "production_entry_form2");
        String isMultiplattform = get_verify_parameter(request, "isMultiplattform_entry_form2");
        String onPremises = get_verify_parameter(request, "onPremises_entry_form2");
        String onCloud = get_verify_parameter(request, "onCloud_entry_form2");
        String[] selectedIncharge = request.getParameterValues("incharge_select");
        boolean ism = false;
        boolean onp = false;
        boolean onc = false;
// Puedes realizar la conversión o procesamiento necesario de los parámetros según su tipo

        Date pdate = new Date();
        //Pattern mm/dd/yyyy
        String pattern = "MM/dd/yyyy";

        // format the entry
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {
            
            pdate = sdf.parse(productionDate);
           
        } catch (ParseException e) {
            System.out.println("Parse error");
        }
        
        if (onPremises != null && onPremises.equals("true")) {
            onp = true;
        }

        if (onCloud != null && onCloud.equals("true")) {
            onc = true;
        } 
        
        if (isMultiplattform != null) {
            if (isMultiplattform.equals("true")) {
                ism = true;
            }
        }
        
        
        ArrayList<Incharge> inchargeArray;
        inchargeArray= new ArrayList();
        if(selectedIncharge!=null){
            for (String inc : selectedIncharge) {
                Incharge incharr = DataManager.findInchargebyName(inc);
                inchargeArray.add(incharr);
            }
        }

        // Create incharge object
        Application app = new Application(name,version,codeLanguage,pdate,ism,onp,onc,inchargeArray);
        DataManager.applications.add(app);
        DataManager.saveApplication();
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


