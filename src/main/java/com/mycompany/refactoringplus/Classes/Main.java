package com.mycompany.refactoringplus.Classes;

import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class Main {
    
    public static void main(String[] args) throws Exception {
        
        // Tests
        //ChatGPTClient cc = new ChatGPTClient();
        //System.out.println(cc.consultarGPT("qué es un número primo? "));
        //Odor o = new Odor();
        
        // testing json manager for write/read objects
        
        ArrayList<Application> l1 = new ArrayList();
        System.out.println("Json tests");
        Application a = new Application();
        Application c = new Application();
        l1.add(a);
        l1.add(c);
        JsonManager.writeApplicationJson(l1, "db/Applications.txt");

        ArrayList<Application> l2 = JsonManager.readApplicationJson("db/Applications.txt");
        System.out.println(l2.get(0).getProduction());
        
        ArrayList<AppClass> appclasses = new ArrayList();
        AppClass apc1 = new AppClass();
        apc1.getApp().add(l2.get(0));
        appclasses.add(apc1);
        JsonManager.writeAppClassJson(appclasses, "db/AppClasses.txt");
        
        ArrayList<AppClass> appclasses2 = JsonManager.readAppClassJson("db/Appclasses.txt");
        System.out.println(appclasses2.get(0).getApp().get(0).getProduction());

        DataManager dm = new DataManager("db/");
        
        
   }
    
}
