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

public class ClassMethodMaintainabilityComparator implements Comparator<ClassMethod> {
    @Override
    public int compare(ClassMethod method1, ClassMethod method2) {
        // Compara los métodos por su atributo maintainability en orden descendente
        return Integer.compare(method1.getMaintainability(), method2.getMaintainability());
    }
}

