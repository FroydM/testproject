package com.mycompany.refactoringplus.Classes;

import java.util.Date;

/**
 *
 * @author Oscar
 */
public class Incharge {
    
    private String name;
    private String email;
    private String phone;
    private Date birth;
   
    public Incharge(){
        this.name = "New Incharge name";
        this.email = "New email";
        this.phone = "New phone number";
        this.birth = new Date();
    }
    
    public Incharge(String name, String email, String phone, Date birth){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Incharge{" +
               "\nname=" + name +
               "\nemail=" + email +
               "\nphone=" + phone +
               "\nbirth=" + birth +
               "\n}";
    }

    
    
       
}
