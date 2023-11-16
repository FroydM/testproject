package com.mycompany.refactoringplus.Classes;

/**
 *
 * @author Oscar
 */
public class RefactoringMethod {
    
    private String refactorName;
    private String description;
    private static String prompt = "Define en menos de 100 lineas, este tipo de refactorización de código: ";
    
    
  
    public RefactoringMethod(){
        
        this.refactorName = "Renombrar";
        
    }

    public RefactoringMethod(String refactorName) {
        
        this.refactorName = refactorName;
        
        
    }

    public String getRefactorName() {
        return refactorName;
    }

    public void setRefactorName(String refactorName) {
        this.refactorName = refactorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public static String getPrompt() {
        return prompt;
    }

    public static void setPrompt(String prompt) {
        RefactoringMethod.prompt = prompt;
    }
    
    public void getDescriptionFromChatGPT(){
        
        // Call api function to initializate the description
        this.description = ChatGPTClient.consultChatGPT(RefactoringMethod.prompt + this.refactorName);
    }

    @Override
    public String toString() {
        return "RefactoringMethod{" +
               "\nrefactorName=" + refactorName +
               "\ndescription=" + description +
               "\n}";
    }

    
    
    
}
