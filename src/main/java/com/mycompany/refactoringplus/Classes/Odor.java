package com.mycompany.refactoringplus.Classes;

import java.util.ArrayList;


/**
 *
 * @author Oscar
 */
public class Odor {
    
    private String odorName;
    private String description;
    private ArrayList<RefactoringMethod> refMethods;
    private static String prompt = "Define en menos de 100 palabras el olor de software que se llama: ";
    
    
    public Odor(){
        
        this.odorName = "Opacidad";
        this.refMethods = new ArrayList();
        
        
    }

    public Odor(String odorName, ArrayList<RefactoringMethod> refMethods) {
        
        this.odorName = odorName;
        this.refMethods = refMethods;
        
    }

    public String getOdorName() {
        return odorName;
    }

    public void setOdorName(String odorName) {
        this.odorName = odorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<RefactoringMethod> getRefMethod() {
        return refMethods;
    }

    public void setRefMethod(ArrayList<RefactoringMethod> refMethods) {
        this.refMethods = refMethods;
    }

    public static String getPrompt() {
        return prompt;
    }

    public static void setPrompt(String prompt) {
        Odor.prompt = prompt;
    }
    
    public void getDescriptionFromChatGPT(){
        // Call api function to initializate the description
        this.description = ChatGPTClient.consultChatGPT(Odor.prompt + this.odorName);
    }

    @Override
    public String toString() {
        return "Odor{" +
               "\nodorName=" + odorName +
               "\ndescription=" + description +
               "\nrefMethods=" + refMethods +
               "\n}";
    }
    
    

}
