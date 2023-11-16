/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.refactoringplus.Classes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author Oscar
 */
public class JsonManager {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    
    public JsonManager(){
        
    }

    public static void writeAppClassJson(ArrayList<AppClass> objeto, String fileRoot) throws IOException {
        objectMapper.writeValue(new File(fileRoot), objeto);
    }

    public static ArrayList<AppClass>  readAppClassJson(String fileRoot) throws IOException {
        
        verify_file(fileRoot);
        ArrayList<AppClass> obj = new ArrayList();
        File f = new File(fileRoot);
        if(f.length() != 0){
            obj = objectMapper.readValue(new File(fileRoot), new TypeReference<ArrayList<AppClass>>() {});
        }
        return obj;
    }
    
    public static void writeApplicationJson(ArrayList<Application> objeto, String fileRoot) throws IOException {
        objectMapper.writeValue(new File(fileRoot), objeto);
    }

    public static ArrayList<Application>  readApplicationJson(String fileRoot) throws IOException {

        verify_file(fileRoot);
        ArrayList<Application> obj = new ArrayList();
        File f = new File(fileRoot);
        if(f.length() != 0){
            obj = objectMapper.readValue(new File(fileRoot), new TypeReference<ArrayList<Application>>() {});
        }
        return obj;
        
    }
    
    public static void writeClassMethodJson(ArrayList<ClassMethod> objeto, String fileRoot) throws IOException {
        objectMapper.writeValue(new File(fileRoot), objeto);
    }

    public static ArrayList<ClassMethod>  readClassMethodJson(String fileRoot) throws IOException {
       
        verify_file(fileRoot);
        ArrayList<ClassMethod> obj = new ArrayList();
        File f = new File(fileRoot);
        if(f.length() != 0){
            obj = objectMapper.readValue(new File(fileRoot), new TypeReference<ArrayList<ClassMethod>>() {});
        }
        return obj;
        
    }
    
    public static void writeInchargeJson(ArrayList<Incharge> objeto, String fileRoot) throws IOException {
        objectMapper.writeValue(new File(fileRoot), objeto);
    }

    public static ArrayList<Incharge>  readInchargeJson(String fileRoot) throws IOException {

        verify_file(fileRoot);
        ArrayList<Incharge> obj = new ArrayList();
        File f = new File(fileRoot);
        if(f.length() != 0){
            obj = objectMapper.readValue(new File(fileRoot), new TypeReference<ArrayList<Incharge>>() {});
        }
        return obj;
    }
    
    public static void writeOdorJson(ArrayList<Odor> objeto, String fileRoot) throws IOException {
        objectMapper.writeValue(new File(fileRoot), objeto);
    }

    public static ArrayList<Odor>  readOdorJson(String fileRoot) throws IOException {
 
        verify_file(fileRoot);
        ArrayList<Odor> obj = new ArrayList();
        File f = new File(fileRoot);
        if(f.length() != 0){
            obj = objectMapper.readValue(new File( fileRoot), new TypeReference<ArrayList<Odor>>() {});
        }
        return obj;
    }
    
    public static void writeRefactoringMethodJson(ArrayList<RefactoringMethod> objeto, String fileRoot) throws IOException {
        objectMapper.writeValue(new File(fileRoot), objeto);
    }

    public static ArrayList<RefactoringMethod>  readRefactoringMethodJson(String fileRoot) throws IOException {

        verify_file(fileRoot);
        ArrayList<RefactoringMethod> obj = new ArrayList();
        File f = new File(fileRoot);
        if(f.length() != 0){
            obj = objectMapper.readValue(new File(fileRoot), new TypeReference<ArrayList<RefactoringMethod>>() {});
        }
        return obj;
    }
    
    public static void verify_file(String filename){
        
        // Crea un objeto File con la ruta y el nombre del archivo
        File file = new File(filename);

        // Verifica si el archivo existe
        if (file.exists()) {
            System.out.println("File: " + filename + " already exists");
        } else {
            try {
                // Si el archivo no existe, crea un nuevo archivo
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("Created: " + filename);
                } else {
                    System.out.println("Error creating: " + filename);
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }

        }
    }

}
