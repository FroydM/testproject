<%-- 
    Document   : refactoringPlus
    Created on : 29 sep. 2023, 11:10:51
    Author     : Oscar
--%>

<%@page import="com.mycompany.refactoringplus.Classes.RefactoringMethod"%>
<%@page import="com.mycompany.refactoringplus.Classes.AppClass"%>
<%@page import="com.mycompany.refactoringplus.Classes.Odor"%>
<%@page import="com.mycompany.refactoringplus.Classes.Application"%>
<%@page import="com.mycompany.refactoringplus.Classes.Incharge"%>
<%@page import="com.mycompany.refactoringplus.Classes.DataManager"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Refactoring Plus Menu</title>
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
        <!-- Agrega el enlace al archivo CSS -->
        <link rel="stylesheet" type="text/css" href="css/style.css">
        
        <link rel="stylesheet" type="text/css" href="css/carrusel.css">
        
        
        <link href="multiple/css/mobiscroll.javascript.min.css" rel="stylesheet" />
        <script src="multiple/js/mobiscroll.javascript.min.js"></script>
        
    </head>
    <body>
        
        <div class="centrado">
            
            <h1 class="marginleftright" style="font-family: Andale Mono, monospace">Selecciona algún registro : </h1>
        
            <div class="example gradient">


                <button type="button" style="background-color: #331b60; font-family: Andale Mono, monospace" class="btn btn-primary normalbutton gradient1" data-toggle="modal" data-target=".modal_add_incharge">Añadir persona a cargo</button><br>
                <button type="button" style="background-color: #8b1d71; font-family: Andale Mono, monospace"  class="btn btn-primary normalbutton gradient2" data-toggle="modal" data-target=".modal_add_application">Añadir Aplicación</button><br>
                <button type="button" style="background-color: #2ba3c8; font-family: Andale Mono, monospace"  class="btn btn-primary normalbutton gradient3" data-toggle="modal" data-target=".modal1_add_refactor">Añadir Método de refactorización</button><br>
                <button type="button" style="background-color: #2bcac8; font-family: Andale Mono, monospace"  class="btn btn-primary normalbutton gradient4" data-toggle="modal" data-target=".modal1_add_oddor">Añadir Olor</button><br>
                <button type="button" style="background-color: #83d9d9; font-family: Andale Mono, monospace"  class="btn btn-primary normalbutton gradient5" data-toggle="modal" data-target=".modal1_add_class">Añadir Clase </button><br>
                <button type="button" style="background-color: #78d8a3; font-family: Andale Mono, monospace"  class="btn btn-primary normalbutton gradient6" data-toggle="modal" data-target=".modal1_add_method">Añadir Método </button><br>
                <a href="ConsultReportModule"   style="background-color: #e3e2a5; font-family: Andale Mono, monospace"  ><button type="button" class="btn  normalbutton gradient7" > Módulo Consultas y reportes </button></a> <br>

            </div>
        </div>
        


        
        <!--INCHARGE-->
        
        <div class="modal fade modal_add_incharge gradient1"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
          <div class="modal-dialog modal-lg">
            <div class="modal-content">
                
               
                
                
                <form class="margin_form_modal" action="AddIncharge" method="post" accept-charset="UTF-8">
                    
                     <h2 class="center_title">Registrar encargado</h2>
                    
                    <div class="form-group">
                      <label for="name_entry_form1">Nombre</label>
                      <input type="text" class="form-control" id="name_entry_form1" name="name_entry_form1" aria-describedby="" placeholder="Nombre">
                      
                    </div>
                    
                    <div class="form-group">
                      <label for="email_entry_form1">Email</label>
                      <input type="text" class="form-control" id="email_entry_form1" name="email_entry_form1" aria-describedby="emailHelp" placeholder="Email">
                      <small id="emailHelp" class="form-text text-muted">Nunca compartiremos tu email con nadie.</small>
                    </div>
                    
                    <div class="form-group">
                      <label for="phone_entry_form1">Télefono</label>
                      <input type="text" class="form-control" id="phone_entry_form1" name="phone_entry_form1" aria-describedby="" placeholder="Télefono">
                    </div>
                    
                    
                    <div class="form-group"> <!-- Date input -->
                        <label class="control-label" for="birth_entry_form1">Fecha de nacimiento</label>
                        <input class="form-control" id="birth_entry_form1" name="birth_entry_form1" placeholder="MM/DD/YYYY" type="text"/>
                    </div>
                    

                    <button type="submit" class="btn btn-primary">Agregar</button>
                    
              </form>
              
            </div>
          </div>
        </div>
        
        <!--APPLICATION-->
        
        <div class="modal fade modal_add_application gradient2"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
            <div class="modal-content">

            
     
            
            <form class="margin_form_modal" action="AddApplication" method="post" accept-charset="UTF-8">
                <h2 class="center_title">Registrar Aplicación</h2>
                <div class="form-group">
                    <label for="name_entry_form1">Nombre</label>
                    <input type="text" class="form-control" id="name_entry_form1" name="name_entry_form2" aria-describedby="" placeholder="Nombre">
                </div>
                
                <div class="form-group">
                    <label for="version_entry_form1">Versión</label>
                    <input type="text" class="form-control" id="version_entry_form1" name="version_entry_form2" aria-describedby="" placeholder="Versión">
                </div>
                
                <div class="form-group">
                    <label for="codeLanguage_entry_form1">Lenguaje de Código</label>
                    <input type="text" class="form-control" id="codeLanguage_entry_form1" name="codeLanguage_entry_form2" aria-describedby="" placeholder="Lenguaje de Código">
                </div>
                
                <div class="form-group"> 
                    <label class="control-label" for="production_entry_form2">Fecha de Producción</label>
                    <input class="form-control" id="production_entry_form2" name="production_entry_form2" placeholder="MM/DD/YYYY" type="text"/>
                </div>
                
                
                <div class="form-group">
                    <label for="isMultiplattform_entry_form1">¿Es Multiplataforma?</label>
                    <select class="form-control" id="isMultiplattform_entry_form1" name="isMultiplattform_entry_form2">
                        <option value="true">Sí</option>
                        <option value="false">No</option>
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="onPremises_entry_form1">¿En Premisas?</label> <br>
                    <input style="margin-left: 40px" type="checkbox" class="form-check-input" id="onPremises_entry_form1" name="onPremises_entry_form2" value="true">
                    <label class="form-check-label" for="onPremises_entry_form1">Sí</label>
                </div>
                
                <div class="form-group">
                    <label for="onCloud_entry_form1">¿En la Nube?</label> <br>
                    <input style="margin-left: 40px" type="checkbox" class="form-check-input" id="onCloud_entry_form1" name="onCloud_entry_form2" value="true">
                    <label class="form-check-label" for="onCloud_entry_form1">Sí</label>
                </div>
                
  
                <label for="incharge_select">Selecciona una o varias personas</label>
                    <div mbsc-page class="demo-multiple-select">
                        <div style="height:100%">

                        <label>
                            Personas encargadas
                            <input mbsc-input id="multiselectinputformIncharge" placeholder="Please select..." data-dropdown="true" data-input-style="outline" data-label-style="stacked" data-tags="true" />
                        </label>

                        <select id="incharge_select" name="incharge_select" multiple>
                            <option value=""></option>
                            <% 
                                DataManager datamanager = (DataManager) request.getSession().getAttribute("datamanager");

                                for (Incharge incharge : datamanager.peopleIncharge) { 
                            %>
                            <option value="<%= incharge.getName() %>"><%= incharge.getName() %></option>
                            
                            <% } %>
                        </select>

                        </div>

                    </div>

                
                <button type="submit" class="btn btn-primary">Agregar</button>
                
            </form>

                </div>
                </div>
            </div>
                    
                    
           <!--APPCLASS-->
           
           
           
           <div class="modal fade modal1_add_class gradient3"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
            <div class="modal-content">


                <form class="margin_form_modal" action="AddAppClass" method="post" accept-charset="UTF-8">
                    <h2 class="center_title">Registrar Clase</h2>
                    <div class="form-group">
                        <label for="fileName_entry_form3">Nombre del archivo</label>
                        <input type="text" class="form-control" id="fileName_entry_form3" name="fileName_entry_form3" placeholder="Nombre del archivo">
                    </div>

                    <div class="form-group">
                        <label for="className_entry_form3">Nombre de la clase</label>
                        <input type="text" class="form-control" id="className_entry_form3" name="className_entry_form3" placeholder="Nombre de la clase">
                    </div>

                    <div class="form-group">
                        <label for="packageName_entry_form3">Paquete</label>
                        <input type="text" class="form-control" id="packageName_entry_form3" name="packageName_entry_form3" placeholder="Paquete">
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="lastMaintain_entry_form3">Último mantenimiento</label>
                        <input class="form-control" id="lastMaintain_entry_form3" name="lastMaintain_entry_form3" placeholder="MM/DD/YYYY" type="text"/>
                    </div>
                    

                        
                        <label for="app_entry_form3">Selecciona una o varias aplicaciones:</label>
                        <div mbsc-page class="demo-multiple-select">
                            <div style="height:100%">
                                
                            <label>
                                Aplicaciones relacionadas
                                <input mbsc-input id="multiselectinputform3" placeholder="Please select..." data-dropdown="true" data-input-style="outline" data-label-style="stacked" data-tags="true" />
                            </label>
                                
                            <select id="app_entry_form3" name="app_entry_form3" multiple>
                                <option value=""></option>
                                <% 
                                    for (Application app : datamanager.applications) { 
                                %>
                                    <option value="<%= app.getName() %>"><%= app.getName() %></option>
                                <% } %>
                            </select>
                            
                            </div>
                            
                        </div>
                        

                        


 
                    <button type="submit" class="btn btn-primary">Agregar</button>
                </form>

                </div>
                </div>
            </div>
                            
                            
            <!--CLASS METHOD-->
           
           
           
            <div class="modal fade modal1_add_method gradient4" style="background: #2bcac8" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
            <div class="modal-content">

            
            
                <form class="margin_form_modal" action="AddMethod" method="post" accept-charset="UTF-8">
                    <h2 class="center_title">Registrar Método</h2>
                    <div class="form-group">
                        <label for="methodName_entry_form4">Nombre del Método</label>
                        <input type="text" class="form-control" id="methodName_entry_form4" name="methodName_entry_form4" placeholder="Nombre del Método">
                    </div>

                    <div class="form-group">
                        <label for="accessType_entry_form4">Tipo de Acceso</label>
                        <input type="text" class="form-control" id="accessType_entry_form4" name="accessType_entry_form4" placeholder="Tipo de Acceso">
                    </div>

                    <div class="form-group">
                        <label for="returnType_entry_form4">Tipo de Retorno</label>
                        <input type="text" class="form-control" id="returnType_entry_form4" name="returnType_entry_form4" placeholder="Tipo de Retorno">
                    </div>

                    <div class="form-group">
                        <label for="code_entry_form4">Código</label>
                        <textarea class="form-control" id="code_entry_form3" name="code_entry_form4" rows="4" placeholder="Código"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="params_entry_form4">Parámetros (separados por comas)</label>
                        <input type="text" class="form-control" id="params_entry_form4" name="params_entry_form4" placeholder="Parámetros">
                    </div>
                    
                    <div class="form-group">
                        <label for="method_class_select">Selecciona la clase que pertenece:</label>
                        <select class="form-control" id="method_class_select" name="method_class_select">
                            <option value=""></option>
                            <% 
                                for (AppClass appc : datamanager.classes) { 
                            %>
                                <option value="<%= appc.getClassName()%>"><%= appc.getClassName()%></option>

                            <% } %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="complexity_entry_form4">Complejidad</label>
                        <input type="number" class="form-control" id="complexity_entry_form4" name="complexity_entry_form4" placeholder="Complejidad">
                    </div>

                    <div class="form-group">
                        <label for="maintainability_entry_form4">Mantenibilidad</label>
                        <input type="number" class="form-control" id="maintainability_entry_form4" name="maintainability_entry_form4" placeholder="Mantenibilidad">
                    </div>
                    
                    <label for="oddors_entry_form4">Selecciona una o varios olores</label>
                        <div mbsc-page class="demo-multiple-select">
                            <div style="height:100%">
                                
                            <label>
                                Olores del método
                                <input mbsc-input id="multiselectinputform4" placeholder="Please select..." data-dropdown="true" data-input-style="outline" data-label-style="stacked" data-tags="true" />
                            </label>
                                
                            <select id="oddor_entry_form4" name="oddors_entry_form4" multiple>
                                <option value=""></option>
                                <% 
                                    for (Odor odd : datamanager.oddors) { 
                                %>
                                    <option value="<%= odd.getOdorName()%>"><%= odd.getOdorName()%></option>
                                <% } %>
                            </select>
                            
                            </div>
                            
                        </div>

 
                    <button type="submit" class="btn btn-primary">Agregar</button>
                </form>


                </div>
                </div>
            </div>
                            
                            
                            
            <!--ODDOR-->
           
           
           
            <div class="modal fade modal1_add_oddor gradient5"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
            <div class="modal-content">


            
            <form class="margin_form_modal" action="AddOddor" method="post" accept-charset="UTF-8">
                <h2 class="center_title">Registrar Olor</h2>
                <div class="form-group">
                    <label for="odorName_entry_form5">Nombre del Olor</label>
                    <input type="text" class="form-control" id="odorName_entry_form5" name="odorName_entry_form5" placeholder="Nombre del Olor" onchange="consultOddorDescription()" >
                </div>
                
             
                
                <div class="form-group">
                    <label for="description_entry_form5">Descripción</label>
                    <textarea class="form-control" id="description_entry_form5" name="description_entry_form5" rows="4" placeholder="Descripción" readonly="true"></textarea>
                </div>
                
                
                
                <label for="refactor_entry_form5">Selecciona una o varios métodos de refactorización</label>
                        <div mbsc-page class="demo-multiple-select">
                            <div style="height:100%">
                                
                            <label>
                                Métodos de refactorización
                                <input mbsc-input id="multiselectinputform5" placeholder="Please select..." data-dropdown="true" data-input-style="outline" data-label-style="stacked" data-tags="true" />
                            </label>
                                
                            <select id="refactor_entry_form5" name="refactor_entry_form5" multiple>
                                <option value=""></option>
                                <% 
                                    for (RefactoringMethod method : datamanager.refactoringMethods) { 
                                %>
                                    <option value="<%= method.getRefactorName()%>"><%= method.getRefactorName()%></option>
                                <% } %>
                            </select>
                            
                            </div>
                            
                        </div>

                <button type="submit" class="btn btn-primary">Agregar</button>
                
            </form>

            

            </div>
            </div>
            </div>
                            
                            
            <!--REFACTOR-->
           

            <div class="modal fade modal1_add_refactor gradient6"  tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
            <div class="modal-content">

           
            
            
            <form class="margin_form_modal" action="AddRefactor" method="post" accept-charset="UTF-8">
                 <h2 class="center_title">Registrar Método de Refactorización</h2>
                <div class="form-group">
                    <label for="refacorName_entry_form6">Nombre del Método</label>
                    <input type="text" class="form-control" id="refacorName_entry_form6" name="refacorName_entry_form6" placeholder="Nombre del Método" onchange="consultRefactorDescription()" >
                </div>
                
             
                
                <div class="form-group">
                    <label for="description_entry_form6">Descripción</label>
                    <textarea class="form-control" id="description_entry_form6" name="description_entry_form6" rows="4" placeholder="Descripción" readonly="true"></textarea>
                </div>
                

                <button type="submit" class="btn btn-primary">Agregar</button>
                
            </form>

            

            </div>
            </div>
            </div>
            
          
        
    </body>
</html>

<script>

       mobiscroll.setOptions({
            locale: mobiscroll.localeEs,                              
            theme: 'ios',                                                        
            themeVariant: 'light'                                                
        });

        mobiscroll.select('#app_entry_form3', {
            inputElement: document.getElementById('multiselectinputform3')  
        });
</script>


<script>

       mobiscroll.setOptions({
            locale: mobiscroll.localeEs,                              
            theme: 'ios',                                                        
            themeVariant: 'light'                                                
        });

        mobiscroll.select('#oddor_entry_form4', {
            inputElement: document.getElementById('multiselectinputform4')  
        });
</script>


<script>

       mobiscroll.setOptions({
            locale: mobiscroll.localeEs,                              
            theme: 'ios',                                                        
            themeVariant: 'light'                                                
        });

        mobiscroll.select('#refactor_entry_form5', {
            inputElement: document.getElementById('multiselectinputform5')  
        });
</script>

<script>

       mobiscroll.setOptions({
            locale: mobiscroll.localeEs,                              
            theme: 'ios',                                                        
            themeVariant: 'light'                                                
        });

        mobiscroll.select('#incharge_select', {
            inputElement: document.getElementById('multiselectinputformIncharge')  
        });
</script>

<script src="js/functions.js"></script>

<script src="js/carrusel.js"></script>