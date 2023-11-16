<%-- 
    Document   : consult_report
    Created on : 6 oct. 2023, 08:53:13
    Author     : Oscar
--%>

<%@page import="com.mycompany.refactoringplus.Classes.ReportAction"%>
<%@page import="com.mycompany.refactoringplus.Classes.Application"%>
<%@page import="com.mycompany.refactoringplus.Classes.ClassMethod"%>
<%@page import="com.mycompany.refactoringplus.Classes.AppClass"%>
<%@page import="com.mycompany.refactoringplus.Classes.Incharge"%>
<%@page import="com.mycompany.refactoringplus.Classes.DataManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Refactoging Plus Consult Report Module</title>
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
        <!-- Agrega el enlace al archivo CSS -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        
        <link href="multiple/css/mobiscroll.javascript.min.css" rel="stylesheet" />
        <script src="multiple/js/mobiscroll.javascript.min.js"></script>

        <link rel="stylesheet" type="text/css" href="css/carrusel.css">

        
        <script src="js/functions.js"></script>

    </head>
    <body>
        
        <div class="centrado">
            
            <h1 class="marginleftright" style="font-family: Andale Mono, monospace">Que quieres analizar? </h1>
        
            <div class="example gradient">

                <!--buttons for modals-->

                <button type="button" class="btn btn-primary lessbutton gradient1" style="background-color: #331b60; font-family: Andale Mono, monospace" data-toggle="modal" data-target=".modal_methods1">Métodos: Complejidad Ascendente</button><br>
                <button type="button" class="btn btn-primary lessbutton gradient2" style="background-color: #8b1d71; font-family: Andale Mono, monospace" data-toggle="modal" data-target=".modal_methods2">Métodos: Mantenibilidad Descendente</button><br>
                <button type="button" class="btn btn-primary lessbutton gradient3" style="background-color: #2ba3c8; font-family: Andale Mono, monospace" data-toggle="modal" data-target=".modal_methods3">Métodos: Olores Ascendente</button><br>
                <button type="button" class="btn btn-primary lessbutton gradient4" style="background-color: #2bcac8; font-family: Andale Mono, monospace" data-toggle="modal" data-target=".modal_oddors">Olores: Cantidad de Refactorización</button><br>
                <button type="button" class="btn btn-primary lessbutton gradient5" style="background-color: #83d9d9; font-family: Andale Mono, monospace" data-toggle="modal" data-target=".modal_refactor">Listar Refactorización Alfabeticamente </button><br>
                <button type="button" class="btn btn-primary lessbutton gradient6" style="background-color: #78d8a3; font-family: Andale Mono, monospace" data-toggle="modal" data-target=".modal_incharge">Listar Encargados Alfabeticamente </button><br>
                <button type="button" class="btn btn-primary lessbutton gradient7" style="background-color: #e3e2a5; font-family: Andale Mono, monospace" data-toggle="modal" data-target=".modal_apps">Listar Aplicaciones Alfabeticamente </button><br>
                <button type="button" class="btn btn-primary lessbutton gradient1" style="background-color: #331b60; font-family: Andale Mono, monospace" data-toggle="modal" data-target=".modal_generatePDF">Generar PDF</button><br>
                <button type="button" class="btn btn-primary lessbutton gradient2" style="background-color: #331b60; font-family: Andale Mono, monospace" data-toggle="modal" data-target=".modal_showFormat">Reportes</button><br>
                <a href="RefactoringMenu"><button type="button" style="background-color: #8b1d71; font-family: Andale Mono, monospace" class="btn btn-primary lessbutton gradient2" >Menu Principal</button></a> <br>

                
                <!--Methods1-->
        
                               
                <div class="modal fade modal_methods1 gradient1"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            
       
                            
                            
                            <!--content-->
                            <div class="form-group margin_form_modal">
                                <h2 class="center_title">Listar Métodos [Complejidad]</h2>
                                <label for="app_selectmethod1">Selecciona una Clase</label>
                                <select class="form-control" id="app_selectmethod1" name="app_selectmethod1" onchange="findMethodByComplex()">
                                    <option value=""></option>
                                    <% 
                                        
                                        DataManager datamanager = (DataManager) request.getSession().getAttribute("datamanager");

                                        for (AppClass appclass : datamanager.classes) { 
                                    %>
                                        <option value="<%= appclass.getClassName()%>"><%= appclass.getClassName() %></option>

                                    <% } %>
                                </select>
                            </div>
                                
                            <div class="form-group margin_form_modal">
                            <label for="method_selectmethod1">Selecciona una Método</label>
                            <select class="form-control" id="method_selectmethod1" name="method_selectmethod1" onchange="findmethodinfo1()">
                                    <option value=""></option>
                                    <% 
                                        
                                        for (ClassMethod classm : datamanager.methods) { 
                                    %>
                                        <option value="<%= classm.getMethodName()%>"><%= classm.getMethodName() %></option>

                                    <% } %>
                                </select>
                            </div>
                                
                           <div class="form-group margin_form_modal">
                                <label for="textareamethod1">Información del método</label>
                                <textarea class="form-control" style="height: 400px" id="textareamethod1" name="textareamethod1" rows="4" placeholder="Información del método" readonly="true"></textarea>
                            </div>
                                
                                
                             <!--content-->
                            
                        </div>
                    </div>
                </div>
                                
                <!--Methods2-->
               
                <div class="modal fade modal_methods2 gradient2"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            
                       
                            
                            
                            <!--content-->
                            <div class="form-group margin_form_modal">
                                <h2 class="center_title">Listar Métodos [Mantenibilidad]</h2>
                                <label for="app_selectmethod2">Selecciona una Clase</label>
                                <select class="form-control" id="app_selectmethod2" name="app_selectmethod2" onchange="findMethodByComplex2()">
                                    <option value=""></option>
                                    
                                    <% 
                                        for (AppClass appclass : datamanager.classes) { 
                                    %>
                                        <option value="<%= appclass.getClassName()%>"><%= appclass.getClassName() %></option>

                                    <% } %>
                                </select>
                            </div>
                                
                            <div class="form-group margin_form_modal">
                            <label for="method_selectmethod2">Selecciona una Método</label>
                            <select class="form-control" id="method_selectmethod2" name="method_selectmethod2" onchange="findmethodinfo2()">
                                    <option value=""></option>
                                    <% 
                                        
                                        for (ClassMethod classm : datamanager.methods) { 
                                    %>
                                        <option value="<%= classm.getMethodName()%>"><%= classm.getMethodName() %></option>

                                    <% } %>
                                </select>
                            </div>
                                
                           <div class="form-group margin_form_modal">
                                <label for="textareamethod2">Información del método</label>
                                <textarea class="form-control" style="height: 400px" id="textareamethod2" name="textareamethod2" rows="4" placeholder="Información del método" readonly="true"></textarea>
                            </div>
                                
                                
                             <!--content-->
                            
                        </div>
                    </div>
                </div>

                <!--Methods3-->
                <div class="modal fade modal_methods3 gradient3"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            
                      
                            
                            <!--content-->
                            <div class="form-group margin_form_modal">
                                <h2 class="center_title">Listar Métodos [Olores]</h2>
                                <label for="app_selectmethod3">Selecciona una Clase</label>
                                <select class="form-control" id="app_selectmethod3" name="app_selectmethod3" onchange="findMethodByComplex3()">
                                    <option value=""></option>
                                    
                                    <% 
                                        for (AppClass appclass : datamanager.classes) { 
                                    %>
                                        <option value="<%= appclass.getClassName()%>"><%= appclass.getClassName() %></option>

                                    <% } %>
                                </select>
                            </div>
                                
                            <div class="form-group margin_form_modal">
                            <label for="method_selectmethod3">Selecciona una Método</label>
                            <select class="form-control" id="method_selectmethod3" name="method_selectmethod3" onchange="findmethodinfo3()">
                                    <option value=""></option>
                                    <% 
                                        
                                        for (ClassMethod classm : datamanager.methods) { 
                                    %>
                                        <option value="<%= classm.getMethodName()%>"><%= classm.getMethodName() %></option>

                                    <% } %>
                                </select>
                            </div>
                                
                           <div class="form-group margin_form_modal">
                                <label for="textareamethod3">Información del método</label>
                                <textarea class="form-control" style="height: 400px" id="textareamethod3" name="textareamethod3" rows="4" placeholder="Información del método" readonly="true"></textarea>
                            </div>
                                
                                
                             <!--content-->
                            
                          
                        </div>
                    </div>
                </div>
                                
                <!--Methods4-->
             
                <div class="modal fade modal_oddors gradient4"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            
             
                            
                            
                            <!--content-->
                            <div class="form-group margin_form_modal">
                                <h2 class="center_title">Listar Olores [Refactorización]</h2>
                                <label for="app_selectmethod4">Selecciona una Applicación</label>
                                <select class="form-control" id="app_selectmethod4" name="app_selectmethod4" onchange="findMethodByComplex4()">
                                    <option value=""></option>
                                    
                                    <% 
                                        for (Application app : datamanager.applications) { 
                                    %>
                                        <option value="<%= app.getName()%>"><%= app.getName() %></option>

                                    <% } %>
                                </select>
                            </div>
                                
                            <div class="form-group margin_form_modal">
                            <label for="method_selectmethod4">Selecciona una Olor</label>
                                <select class="form-control" id="method_selectmethod4" name="method_selectmethod4" onchange="findmethodinfo4()">
                                    <option value=""></option>
                                    
                                </select>
                            </div>
                                
                           <div class="form-group margin_form_modal">
                                <label for="textareamethod4">Información del método</label>
                                <textarea class="form-control" style="height: 400px" id="textareamethod4" name="textareamethod4" rows="4" placeholder="Información del olor" readonly="true"></textarea>
                            </div>
                                
                                
                             <!--content-->
                        
                        </div>
                    </div>
                </div>
                                
                <!--Methods5-->
                
                <div class="modal fade modal_refactor gradient5"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            
                               
                            
                            <!--content-->
                            <div class="form-group margin_form_modal">
                                <h2 class="center_title">Listar Refactorización [Alfabeticamente]</h2>
                                <label for="app_selectmethod5">Selecciona una Applicación</label>
                                <select class="form-control" id="app_selectmethod5" name="app_selectmethod5" onchange="findMethodByComplex5()">
                                    <option value=""></option>
                                    
                                    <% 
                                        for (Application app : datamanager.applications) { 
                                    %>
                                        <option value="<%= app.getName()%>"><%= app.getName() %></option>

                                    <% } %>
                                </select>
                            </div>
                                
                            <div class="form-group margin_form_modal">
                            <label for="method_selectmethod5">Selecciona una Método</label>
                                <select class="form-control" id="method_selectmethod5" name="method_selectmethod5" onchange="findmethodinfo5()">
                                    <option value=""></option>
                                    
                                </select>
                            </div>
                                
                           <div class="form-group margin_form_modal">
                                <label for="textareamethod5">Información del método</label>
                                <textarea class="form-control" style="height: 400px" id="textareamethod5" name="textareamethod5" rows="4" placeholder="Información del método" readonly="true"></textarea>
                            </div>
                                
                                
                             <!--content-->
                         
                        </div>
                    </div>
                </div>

                <!--Methods6-->
                <div class="modal fade modal_incharge gradient6"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            
   
                            
                            
                            <!--content-->
                            <div class="form-group margin_form_modal">
                                <h2 class="center_title">Listar Encargados [Alfabeticamente]</h2>
                                <label for="app_selectmethod6">Selecciona una Applicación</label>
                                <select class="form-control" id="app_selectmethod6" name="app_selectmethod6" onchange="findMethodByComplex6()">
                                    <option value=""></option>
                                    
                                    <% 
                                        for (Application app : datamanager.applications) { 
                                    %>
                                        <option value="<%= app.getName()%>"><%= app.getName() %></option>

                                    <% } %>
                                </select>
                            </div>
                                
                            <div class="form-group margin_form_modal">
                            <label for="method_selectmethod6">Selecciona una Encargado</label>
                                <select class="form-control" id="method_selectmethod6" name="method_selectmethod6" onchange="findmethodinfo6()">
                                    <option value=""></option>
                                    
                                </select>
                            </div>
                                
                           <div class="form-group margin_form_modal">
                                <label for="textareamethod6">Información del método</label>
                                <textarea class="form-control" style="height: 400px" id="textareamethod6" name="textareamethod6" rows="4" placeholder="Información del encargado" readonly="true"></textarea>
                            </div>
                                
                                
                             <!--content-->
                          
                        </div>
                    </div>
                </div>
                <!--Methods7-->
                
                <div class="modal fade modal_apps gradient7" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                           
                            <!--content-->
                            <div class="form-group margin_form_modal">
                                 <h2 class="center_title">Listar Aplicaciones [Alfabeticamente]</h2>
                                <label for="app_selectmethod7">Selecciona una Applicación</label>
                                <select class="form-control" id="app_selectmethod7" name="app_selectmethod7" onchange="findmethodinfo7()" >
                                    <option value=""></option>
                                        <% 
                                            for (Application app : datamanager.findApplicationbyAlphaName()) { 
                                        %>
                                            <option value="<%= app.getName()%>"><%= app.getName() %></option>

                                        <% } %>
                                </select>
                            </div>
                                

                                
                           <div class="form-group margin_form_modal">
                                <label for="textareamethod7">Información del Aplicación</label>
                                <textarea class="form-control" style="height: 400px" id="textareamethod7" name="textareamethod7" rows="4" placeholder="Información del Aplicación" readonly="true"></textarea>
                            </div>
                                
                                
                             <!--content-->
                        
                        </div>
                    </div>
                </div>

                <!--Methods8-->
                <div class="modal fade modal_generatePDF gradient1"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <h2 class="center_title">Generar PDF</h2>
                            <br>
                            
                           <div class="centerdiv" style="display: flex; justify-content: center; gap: 10px; margin-right: 200px">
                                <form action="CreatePDFes" method="post" target="_blank">
                                    <button type="button submit" class="btn btn-info">Generar en español</button>
                                </form>

                                <form action="CreatePDFen" method="post" target="_blank">
                                    <button type="button submit" class="btn btn-info">Generar en inglés</button>
                                </form>
                            </div>

                            
                            
                            
                            
                        </div>
                    </div>
                </div>
                
                
                <!--Methods9-->
                <div class="modal fade modal_showFormat" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <h2 class="center_title">Mostrar Reporte con Formato</h2>
                            <br>
                            

                            
                            <div class="centerdiv" style="display: flex; justify-content: center; gap: 10px; margin-right: 180px">
                                <button type="button" class="btn btn-info" onclick="showReportXML()">Generar Reporte XML</button>
                                <button type="button" class="btn btn-info" onclick="showReportCSV()">Generar Reporte CSV</button>
                                <button type="button" class="btn btn-info" onclick="showReportJSON()">Generar Reporte JSON</button>
                            </div>

                        

                            <%
                                ReportAction raction = (ReportAction) request.getSession().getAttribute("reportaction");
                                String xmlContent = raction.readXmlFile();
                                String csvContent = raction.readCsvFile();
                                String jsonContent = raction.readJsonFile();
                            %>

                            <label for="textareamethod91" class="report-container" id="labelXML">Reporte XML</label>
                            <textarea class="form-control report-container" style="height: 400px" id="textareamethod91" name="textareamethod91" rows="4" placeholder="Reporte XML" readonly="true">
                                <%= xmlContent %>
                            </textarea>

                            <label for="textareamethod92" class="report-container" id="labelCSV">Reporte CSV</label>
                            <textarea class="form-control report-container" style="height: 400px" id="textareamethod92" name="textareamethod92" rows="4" placeholder="Reporte CSV" readonly="true">
                                <%= csvContent %>
                            </textarea>

                            <label for="textareamethod93" class="report-container" id="labelJSON">Reporte JSON</label>
                            <textarea class="form-control report-container" style="height: 400px" id="textareamethod93" name="textareamethod93" rows="4" placeholder="Reporte JSON" readonly="true">
                                <%= jsonContent %>
                            </textarea>

                                        
                                        
                            
                            
                            
                            
                            
                        </div>
                    </div>
                </div>
                


            </div>
        </div>
        
        
        
        
    </body>
</html>
