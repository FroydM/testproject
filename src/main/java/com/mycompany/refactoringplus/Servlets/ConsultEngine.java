/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.refactoringplus.Servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.refactoringplus.Classes.DataManager;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Oscar
 */
public class ConsultEngine extends HttpServlet {



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
        
         String consultType = request.getParameter("consultType");
         String appname = request.getParameter("appname");
         String methodname = request.getParameter("methodname");
         
    
         
        if(!(consultType.equals("")) && !(appname.equals(""))){
            if(consultType.equals("getmethod1")){
                String appnameforsearch;
                appnameforsearch = DataManager.findAppClassbyName(appname).getClassName();
                String methods = DataManager.findMethodbyComplexity(appnameforsearch);

                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("methodlist", methods);
                jsonResponse.put("methodinfo", "Seleccionando Métodos");

                // Configurar la respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Serializar el mapa de respuesta JSON y escribirlo en el cuerpo de la respuesta
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(response.getWriter(), jsonResponse);
                
                
            }else if(consultType.equals("getmethod2")){
                String appnameforsearch;
                appnameforsearch = DataManager.findAppClassbyName(appname).getClassName();
                String methods = DataManager.findMethodbyMaintainability(appnameforsearch);
                
                

              
                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("methodlist", methods);
                jsonResponse.put("methodinfo", "Seleccionando Métodos");

                // Configurar la respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Serializar el mapa de respuesta JSON y escribirlo en el cuerpo de la respuesta
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(response.getWriter(), jsonResponse);
                
                
            }else if(consultType.equals("getmethod3")){
                String appnameforsearch;
                appnameforsearch = DataManager.findAppClassbyName(appname).getClassName();
                String methods = DataManager.findMethodbyOddor(appnameforsearch);
                
                

              
                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("methodlist", methods);
                jsonResponse.put("methodinfo", "Seleccionando Métodos");

                // Configurar la respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Serializar el mapa de respuesta JSON y escribirlo en el cuerpo de la respuesta
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(response.getWriter(), jsonResponse);
                
                
            }else if(consultType.equals("getmethod4")){
                
               
                String appnameforsearch;
                

                appnameforsearch = DataManager.findApplicationbyName(appname).getName();
                
                String methods = DataManager.findOddorbyRefactor(appnameforsearch);
                
                

              
                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("methodlist", methods);
                jsonResponse.put("methodinfo", "Seleccionando Métodos");

                // Configurar la respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Serializar el mapa de respuesta JSON y escribirlo en el cuerpo de la respuesta
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(response.getWriter(), jsonResponse);
                
                
            }else if(consultType.equals("getmethod5")){
                
               
                String appnameforsearch;
                
           
                appnameforsearch = DataManager.findApplicationbyName(appname).getName();
                
                String methods = DataManager.findRefactorbyAlphaName(appnameforsearch);
                
                

              
                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("methodlist", methods);
                jsonResponse.put("methodinfo", "Seleccionando Métodos");

                // Configurar la respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Serializar el mapa de respuesta JSON y escribirlo en el cuerpo de la respuesta
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(response.getWriter(), jsonResponse);
                
                
            }else if(consultType.equals("getmethod6")){
                
               
                String appnameforsearch;
                

                appnameforsearch = DataManager.findApplicationbyName(appname).getName();
                
                String methods = DataManager.findInchargebyAlphaName(appnameforsearch);
                
                

              
                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("methodlist", methods);
                jsonResponse.put("methodinfo", "Seleccionando Métodos");

                // Configurar la respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Serializar el mapa de respuesta JSON y escribirlo en el cuerpo de la respuesta
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(response.getWriter(), jsonResponse);
                
                
            }
            
            
        }else if(!(consultType.equals("")) && !(methodname.equals(""))){
            if(consultType.equals("getmethod1") || consultType.equals("getmethod2") || consultType.equals("getmethod3")){
                
                String methodinfoo;
                methodinfoo = DataManager.findMethodbyName(methodname).toString();
                

                
                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("methodlist", "");
                jsonResponse.put("methodinfo", methodinfoo);

                // Configurar la respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Serializar el mapa de respuesta JSON y escribirlo en el cuerpo de la respuesta
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(response.getWriter(), jsonResponse);
                
                
            }else if(consultType.equals("getmethod4")){
                String methodinfoo;
                methodinfoo = DataManager.findOddorbyName(methodname).toString();
                

               
                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("methodlist", "");
                jsonResponse.put("methodinfo", methodinfoo);

                // Configurar la respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Serializar el mapa de respuesta JSON y escribirlo en el cuerpo de la respuesta
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(response.getWriter(), jsonResponse);
            }else if(consultType.equals("getmethod5")){
                String methodinfoo;
                methodinfoo = DataManager.findRefactoringbyName(methodname).toString();
                

              
                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("methodlist", "");
                jsonResponse.put("methodinfo", methodinfoo);

                // Configurar la respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Serializar el mapa de respuesta JSON y escribirlo en el cuerpo de la respuesta
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(response.getWriter(), jsonResponse);
            }else if(consultType.equals("getmethod6")){
                String methodinfoo;
                methodinfoo = DataManager.findInchargebyName(methodname).toString();
                

            
                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("methodlist", "");
                jsonResponse.put("methodinfo", methodinfoo);

                // Configurar la respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Serializar el mapa de respuesta JSON y escribirlo en el cuerpo de la respuesta
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(response.getWriter(), jsonResponse);
            }else if(consultType.equals("getmethod7")){
                String methodinfoo;
                methodinfoo = DataManager.findApplicationbyName(methodname).toString();
                

               
                Map<String, Object> jsonResponse = new HashMap<>();
                jsonResponse.put("methodlist", "");
                jsonResponse.put("methodinfo", methodinfoo);

                // Configurar la respuesta HTTP
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                // Serializar el mapa de respuesta JSON y escribirlo en el cuerpo de la respuesta
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.writeValue(response.getWriter(), jsonResponse);
            }
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
     
    }

}

