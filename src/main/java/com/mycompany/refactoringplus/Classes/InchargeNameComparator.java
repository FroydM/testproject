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

public class InchargeNameComparator implements Comparator<Incharge> {
    @Override
    public int compare(Incharge incharge1, Incharge incharge2) {
        // Compara los Incharge por el atributo name en orden ascendente
        return incharge1.getName().compareTo(incharge2.getName());
    }
}
    
