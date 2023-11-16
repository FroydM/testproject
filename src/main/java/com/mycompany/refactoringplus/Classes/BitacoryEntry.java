package com.mycompany.refactoringplus.Classes;

public class BitacoryEntry {

    private String format;
    private String action;
    private String ip;
    private String date;
    private String country;

    // Constructores
    
    public BitacoryEntry(){
        this.format = "None";
        this.action = "None";
        this.ip = "None";
        this.date = "None";
        this.country = "none";
    }
    public BitacoryEntry(String format, String action, String ip, String date, String country) {
        this.format = format;
        this.action = action;
        this.ip = ip;
        this.date = date;
        this.country = country;
    }

    // Getters y setters (puedes generarlos automáticamente en tu IDE)

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Puedes agregar más atributos y métodos según sea necesario

    @Override
    public String toString() {
        return "BitacoraEntry{" +
                "format='" + format + '\'' +
                ", action='" + action + '\'' +
                ", ip='" + ip + '\'' +
                ", date='" + date + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
