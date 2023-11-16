package com.mycompany.refactoringplus.Classes;

import java.util.ArrayList;

/**
 *
 * @author Oscar
 */
public class ClassMethod {
    
    private String methodName;
    private String accessType;
    private String returnType;
    private String code;
    private ArrayList<String> params;
    private AppClass appclass;
    private int complexity;
    private int maintainability;
    private ArrayList<Odor> oddors;
    
    public ClassMethod(){
        
        this.methodName = "New methodname";
        this.accessType = "New accessType";
        this.returnType = "New returnType";
        this.code = "New code";
        this.params = new ArrayList();
        this.appclass = null;
        this.complexity = 0;
        this.maintainability = 0;
        this.oddors = new ArrayList();
        
    }

    public ClassMethod(String methodName, String accessType, String returnType, 
            String code, ArrayList<String> params, AppClass appclass, 
            int complexity, int maintainability, ArrayList<Odor> oddors) {
        
        this.methodName = methodName;
        this.accessType = accessType;
        this.returnType = returnType;
        this.code = code;
        this.params = params;
        this.appclass = appclass;
        this.complexity = complexity;
        this.maintainability = maintainability;
        this.oddors = oddors;
        
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<String> getParams() {
        return params;
    }

    public void setParams(ArrayList<String> params) {
        this.params = params;
    }

    public AppClass getAppclass() {
        return appclass;
    }

    public void setAppclass(AppClass appclass) {
        this.appclass = appclass;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public int getMaintainability() {
        return maintainability;
    }

    public void setMaintainability(int maintainability) {
        this.maintainability = maintainability;
    }

    public ArrayList<Odor> getOddors() {
        return oddors;
    }

    public void setOddors(ArrayList<Odor> oddors) {
        this.oddors = oddors;
    }

    @Override
    public String toString() {
        return "ClassMethod{" +
               "\nmethodName=" + methodName +
               "\naccessType=" + accessType +
               "\nreturnType=" + returnType +
               "\ncode=" + code +
               "\nparams=" + params +
               "\nappclass=" + appclass +
               "\ncomplexity=" + complexity +
               "\nmaintainability=" + maintainability +
               "\noddors=" + oddors +
               '}';
    }
    
    
    
    
}
