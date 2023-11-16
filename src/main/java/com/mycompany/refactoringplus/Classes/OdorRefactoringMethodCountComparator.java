/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.refactoringplus.Classes;

/**
 *
 * @author Daniel Quesada
 */
import java.util.Comparator;

public class OdorRefactoringMethodCountComparator implements Comparator<Odor> {
    @Override
    public int compare(Odor odor1, Odor odor2) {
        // Compara los olores por la cantidad de RefactoringMethod en su atributo refMethods en orden descendente
        return Integer.compare(odor2.getRefMethod().size(), odor1.getRefMethod().size());
    }
}
