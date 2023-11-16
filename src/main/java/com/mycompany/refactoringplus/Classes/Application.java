package com.mycompany.refactoringplus.Classes;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Oscar
 */
public class Application {
    
    private String name;
    private String version;
    private String codeLanguage;
    private Date production;
    private boolean isMultiplattform;
    private boolean onPremises;
    private boolean onCloud;
    private ArrayList<Incharge> incharge;
    
   
    
    public Application(){
        this.name = "New application";
        this.version = "New version";
        this.codeLanguage = "New codelanguage";
        this.production = new Date();
        this.isMultiplattform = false;
        this.onPremises = false;
        this.onCloud = false;
        this.incharge = null;
    }

    public Application(String name, String version, String codeLanguage, 
            Date production, boolean isMultiplattform, boolean onPremises, 
            boolean onCloud, ArrayList<Incharge> incharge) {
        this.name = name;
        this.version = version;
        this.codeLanguage = codeLanguage;
        this.production = production;
        this.isMultiplattform = isMultiplattform;
        this.onPremises = onPremises;
        this.onCloud = onCloud;
        this.incharge = incharge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCodeLanguage() {
        return codeLanguage;
    }

    public void setCodeLanguage(String codeLanguage) {
        this.codeLanguage = codeLanguage;
    }

    public Date getProduction() {
        return production;
    }

    public void setProduction(Date production) {
        this.production = production;
    }

    public boolean isIsMultiplattform() {
        return isMultiplattform;
    }

    public void setIsMultiplattform(boolean isMultiplattform) {
        this.isMultiplattform = isMultiplattform;
    }

    public boolean isOnPremises() {
        return onPremises;
    }

    public void setOnPremises(boolean onPremises) {
        this.onPremises = onPremises;
    }

    public boolean isOnCloud() {
        return onCloud;
    }

    public void setOnCloud(boolean onCloud) {
        this.onCloud = onCloud;
    }

    public ArrayList<Incharge> getIncharge() {
        return incharge;
    }

    public void setIncharge(ArrayList<Incharge> incharge) {
        this.incharge = incharge;
    }

    @Override
    public String toString() {
        return "Application{" +
               "\nname=" + name +
               "\nversion=" + version +
               "\ncodeLanguage=" + codeLanguage +
               "\nproduction=" + production +
               "\nisMultiplattform=" + isMultiplattform +
               "\nonPremises=" + onPremises +
               "\nonCloud=" + onCloud +
               "\nincharge=" + incharge +
               "\n}";
    }

    
    
    
}
