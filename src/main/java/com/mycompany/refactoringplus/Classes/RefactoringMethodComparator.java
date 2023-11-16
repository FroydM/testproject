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

public class RefactoringMethodComparator implements Comparator<RefactoringMethod> {
    @Override
    public int compare(RefactoringMethod method1, RefactoringMethod method2) {
        // Compara los RefactoringMethod por el atributo refactorName en orden ascendente
        return method1.getRefactorName().compareTo(method2.getRefactorName());
    }
}

