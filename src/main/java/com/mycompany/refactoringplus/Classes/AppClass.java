package com.mycompany.refactoringplus.Classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Oscar
 */
public class AppClass {
    
    private String fileName;
    private String className;
    private String packageName;
    private Date lastMantain;
    private ArrayList<Application> app;
    public AppClass(){
        
        this.fileName = "New filename";
        this.className = "New classname";
        this.packageName = "New packagename";
        this.lastMantain = new Date();
        this.app = new ArrayList();
        
        
    }

    public AppClass(String fileName, String className, Date lastMantain, 
            String packageName, ArrayList app) {
        this.fileName = fileName;
        this.className = className;
        this.lastMantain = lastMantain;
        this.packageName = packageName;
        this.app = app;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Date getLastMantain() {
        return lastMantain;
    }

    public void setLastMantain(Date lastMantain) {
        this.lastMantain = lastMantain;
    }

    public ArrayList<Application> getApp() {
        return app;
    }

    public void setApp(ArrayList<Application> app) {
        this.app = app;
    }

    @Override
    public String toString() {
        return "AppClass{" +
               "\nfileName=" + fileName +
               "\nclassName=" + className +
               "\npackageName=" + packageName +
               "\nlastMantain=" + lastMantain +
               "\napp=" + app +
               "\n}";
    }

    
    
    
}
