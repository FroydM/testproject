/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.refactoringplus.Classes;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;






/**
 *
 * @author Oscar
 */
public class DataManager {
    
    public static ArrayList<Incharge> peopleIncharge;
    public static ArrayList<Application> applications;
    public static ArrayList<AppClass> classes;
    public static ArrayList<ClassMethod> methods;
    public static ArrayList<Odor> oddors;
    public static ArrayList<RefactoringMethod> refactoringMethods;
    
    private static String DBROOT = "";
    
    public DataManager(String dbroot) throws IOException{
        DBROOT = dbroot;
        init_db();
    }
    
    
    
    private static void init_db() throws IOException{
        //String folderroot = "C:/ApacheTomcat/apache-tomcat-9.0.73/bin/db";

        String folderroot = DBROOT;
        try {
            // Verifica si la carpeta existe
            if (!folderExists(folderroot)) {
                // Si no existe, crea la carpeta
                createFolder(folderroot);
                System.out.println("Folder created in: " + folderroot);
            } else {
                System.out.println("Folder already exists: " + folderroot);
            }
        } catch (IOException e) {
            System.err.println("Error verifiying or creating folder: " + e.getMessage());
        }
        
        peopleIncharge = JsonManager.readInchargeJson(DBROOT+"PeopleIncharge.txt");
        applications = JsonManager.readApplicationJson(DBROOT+"Applications.txt");
        classes = JsonManager.readAppClassJson(DBROOT+"AppClasses.txt");
        methods = JsonManager.readClassMethodJson(DBROOT+"Methods.txt");
        oddors = JsonManager.readOdorJson(DBROOT+"Oddors.txt");
        refactoringMethods = JsonManager.readRefactoringMethodJson(DBROOT+"RefactoringMethods.txt");
        
    }
    
    public static void saveIncharge() throws IOException{
        JsonManager.writeInchargeJson(peopleIncharge, DBROOT+"PeopleIncharge.txt");
    }
    
    public static void saveApplication() throws IOException{
        JsonManager.writeApplicationJson(applications, DBROOT+"Applications.txt");
    }
    
    public static void saveClass() throws IOException{
        JsonManager.writeAppClassJson(classes, DBROOT+"AppClasses.txt");
    }
    
    public static void saveMethods() throws IOException{
        JsonManager.writeClassMethodJson(methods, DBROOT+"Methods.txt");
    }
    
    public static void saveOdor() throws IOException{
        JsonManager.writeOdorJson(oddors, DBROOT+"Oddors.txt");
    }
    
    public static void saveRefactor() throws IOException{
        JsonManager.writeRefactoringMethodJson(refactoringMethods, DBROOT+"RefactoringMethods.txt");
    }
    
    public static Incharge findInchargebyName(String name){
        
        for(Incharge incharge: peopleIncharge){
            if(incharge.getName().equals(name)){
                return incharge;
            }
        }
        return null;
    }
    
    public static ClassMethod findMethodbyName(String name){
        
        for(ClassMethod classm: DataManager.methods){
            if(classm.getMethodName().equals(name)){
                return classm;
            }
        }
        return null;
    }
    
    public static Application findApplicationbyName(String name){
        
        for(Application app: applications){
            if(app.getName().equals(name)){
                return app;
            }
        }
        return null;
    }
    
    public static Odor findOddorbyName(String name){
        
        for(Odor o: oddors){
            if(o.getOdorName().equals(name)){
                return o;
            }
        }
        return null;
    }
    
    public static AppClass findAppClassbyName(String name){
        
        for(AppClass ap: classes){
            if(ap.getClassName().equals(name)){
                return ap;
            }
        }
        return null;
    }
    
    public static RefactoringMethod findRefactoringbyName(String name){
        
        for(RefactoringMethod ref: refactoringMethods){
            if(ref.getRefactorName().equals(name)){
                return ref;
            }
        }
        return null;
    }
    
    
    // Search Méthods
    
    
    public static String findMethodbyComplexity(String appname){

        ArrayList<ClassMethod> methods = new ArrayList();
        
        for(ClassMethod cm : DataManager.methods){
            if(cm.getAppclass().getClassName().equals(appname)){
                methods.add(cm);
            }
        }

        Collections.sort(methods, new ClassMethodComplexityComparator());
      
        StringBuilder namesBuilder = new StringBuilder();

        for (ClassMethod method : methods) {
            if (namesBuilder.length() > 0) {
              
                namesBuilder.append(",");
            }
         
            namesBuilder.append(method.getMethodName());
        }
        // System.out.println(namesBuilder.toString());
       
        return namesBuilder.toString();
    
    }
    
    public static String findMethodbyMaintainability(String appname){
        
        ArrayList<ClassMethod> methods = DataManager.methods;

        Collections.sort(methods, Collections.reverseOrder(new ClassMethodMaintainabilityComparator()));
        StringBuilder namesBuilder = new StringBuilder();

        for (ClassMethod method : methods) {
            if (namesBuilder.length() > 0) {
                
                namesBuilder.append(",");
            }
         
            namesBuilder.append(method.getMethodName());
        }
        //System.out.println(namesBuilder.toString());
        return namesBuilder.toString();
    }
    
    public static String findMethodbyOddor(String appname){
        ArrayList<ClassMethod> methods = DataManager.methods;

        Collections.sort(methods, new ClassMethodOdorCountComparator());
        
        StringBuilder namesBuilder = new StringBuilder();

        for (ClassMethod method : methods) {
            if (namesBuilder.length() > 0) {
                
                namesBuilder.append(",");
            }
         
            namesBuilder.append(method.getMethodName());
        }
        //System.out.println(namesBuilder.toString());
        return namesBuilder.toString();
    }
    
    public static String findOddorbyRefactor(String appname){
        
        ArrayList<Odor> odors = new ArrayList();
        
        
        for(AppClass appc: DataManager.classes){
         
            for(Application a : appc.getApp()){
                
                if(a.getName().equals(appname)){
                    for(ClassMethod cm : DataManager.methods){
                        if(cm.getAppclass().getClassName().equals(appc.getClassName())){
                            for(Odor o: cm.getOddors()){
                                odors.add(o);
                            }
                            
                        }
                    }
                }
            }
        }

        Collections.sort(odors, new OdorRefactoringMethodCountComparator());

        
        StringBuilder namesBuilder = new StringBuilder();

        for (Odor od : odors) {
            if (namesBuilder.length() > 0) {
                
                namesBuilder.append(",");
            }
         
            namesBuilder.append(od.getOdorName());
        }
        System.out.println(namesBuilder.toString().equals(""));
        // System.out.println(namesBuilder.toString());
        return namesBuilder.toString();
    
    }
    
    public static String findRefactorbyAlphaName(String appname){
        ArrayList<RefactoringMethod> refactors = new ArrayList();
        
       
        for(AppClass appc: DataManager.classes){
         
            for(Application a : appc.getApp()){
                
                if(a.getName().equals(appname)){
                    for(ClassMethod cm : DataManager.methods){
                        if(cm.getAppclass().getClassName().equals(appc.getClassName())){
                            for(Odor o: cm.getOddors()){
                                for(RefactoringMethod rf: o.getRefMethod()){
                                    refactors.add(rf);
                                }
                            }
                            
                        }
                    }
                }
            }
        }

        Collections.sort(refactors, new RefactoringMethodComparator());


        
        StringBuilder namesBuilder = new StringBuilder();

        for (RefactoringMethod ref : refactors) {
            if (namesBuilder.length() > 0) {
                
                namesBuilder.append(",");
            }
         
            namesBuilder.append(ref.getRefactorName());
        }
        // System.out.println(namesBuilder.toString());
        return namesBuilder.toString();
    }
    
    public static String findInchargebyAlphaName(String appname){
        
        ArrayList<Incharge> incs = new ArrayList();
        
        
        for(Application app: DataManager.applications){
         
            if(app.getName().equals(appname)){
                incs = app.getIncharge();
            }
        }

        Collections.sort(incs, new InchargeNameComparator());



        
        StringBuilder namesBuilder = new StringBuilder();

        for (Incharge inc : incs) {
            if (namesBuilder.length() > 0) {
                
                namesBuilder.append(",");
            }
         
            namesBuilder.append(inc.getName());
        }
        // System.out.println(namesBuilder.toString());
        return namesBuilder.toString();
    
    }
    
    public static ArrayList<Application> findApplicationbyAlphaName(){
        ArrayList<Application> apps = DataManager.applications;

        Collections.sort(apps, new ApplicationNameComparator());

        return apps;
    }
    
    
    
    public static boolean folderExists(String root) {
        Path folder = Paths.get(root);
        return Files.exists(folder) && Files.isDirectory(folder);
    }

    public static void createFolder(String root) throws IOException {
        Path folder = Paths.get(root);
        Files.createDirectories(folder);
    }
}
