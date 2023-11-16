/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.refactoringplus.Servlets;

import com.mycompany.refactoringplus.Classes.AppClass;
import com.mycompany.refactoringplus.Classes.ClassMethod;
import com.mycompany.refactoringplus.Classes.DataManager;
import com.mycompany.refactoringplus.Classes.Odor;
import com.mycompany.refactoringplus.Classes.ReportAction;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
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

public class AddMethod extends HttpServlet {



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
        
        
        
        ReportAction.addtobitlist(0, "Añadir Metodo", ipAddress, formattedDate);
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
        
        
        String methodName = get_verify_parameter(request, "methodName_entry_form4");
        String accessType = get_verify_parameter(request, "accessType_entry_form4");
        String returnType = get_verify_parameter(request, "returnType_entry_form4");
        String code = get_verify_parameter(request, "code_entry_form4");
        String params = get_verify_parameter(request, "params_entry_form4");
        
        String methodclass = get_verify_parameter(request, "method_class_select");
        
        
        String complexity = get_verify_parameter(request, "complexity_entry_form4");
        String maintainability = get_verify_parameter(request, "maintainability_entry_form4");
        String[] relatedOddors = request.getParameterValues("oddors_entry_form4");
        
        
        AppClass apclass = DataManager.findAppClassbyName(methodclass);
        
        ArrayList<String> paramsArray = stringToArrayList(params);
        
        ArrayList<Odor> relatedOddorsArray;
        relatedOddorsArray= new ArrayList();
        if(relatedOddors!=null){
            for (String relatedOddor : relatedOddors) {
                Odor o = DataManager.findOddorbyName(relatedOddor);
                relatedOddorsArray.add(o);
            }
        }
        
        ClassMethod classm;
        classm = new ClassMethod(methodName,
                accessType,returnType,
                code,paramsArray,apclass,
                Integer.parseInt(complexity),
                Integer.parseInt(maintainability)
                ,relatedOddorsArray);
        DataManager.methods.add(classm);
        DataManager.saveMethods();
        
        
        Login.redirect(request, response, "refactoringPlus.jsp");


    }
    
    
        public static String get_verify_parameter(HttpServletRequest request, String parameter){
        if((request.getParameter(parameter) != null ) && !(request.getParameter(parameter).isEmpty())){
            return request.getParameter(parameter);
        }else{
            return "empty parameter";
        }
    }
        
        
        public static ArrayList<String> stringToArrayList(String input) {
     
        String[] elements = input.split("[,\\s]+");
        
      
        List<String> elementList = Arrays.asList(elements);
        
      
        ArrayList<String> arrayList = new ArrayList<>(elementList);
        
        return arrayList;
    }



}
