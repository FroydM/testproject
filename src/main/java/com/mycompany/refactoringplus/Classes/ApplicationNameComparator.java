/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.refactoringplus.Classes;

/**
 *
 * @author Oscar
 */
import java.util.Comparator;

public class ApplicationNameComparator implements Comparator<Application> {
    @Override
    public int compare(Application app1, Application app2) {
        // Compara las Applications por el atributo name en orden ascendente
        return app1.getName().compareTo(app2.getName());
    }
}

