/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.refactoringplus.Classes;

import java.util.Comparator;

/**
 *
 * @author Oscar
 */
public class ClassMethodComplexityComparator implements Comparator<ClassMethod> {
    @Override
    public int compare(ClassMethod method1, ClassMethod method2) {
        // Compara los métodos por su atributo complexity en orden ascendente
        return Integer.compare(method1.getComplexity(), method2.getComplexity());
    }
}

