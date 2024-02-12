package com.unisabio.repository.models.models_extends;

public class Periodo {
    
    private String cod;
    private String anio;
    private int semestre;
    
    public String getAnio() {
        return this.anio;
    }
    
    public String getCod() {
        return this.cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    public int getSemestre() {
        return this.semestre;
    }
    
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Periodo(String anio, int semestre) {
        this.anio = anio;
        this.semestre = semestre;
    }

    public Periodo() {
    }

    public void imprimirPeriodo(){
        System.out.println("Código: " + this.getCod());
        System.out.println("Año: " + this.getAnio());
        System.out.println("Semestre: " + this.getSemestre());
    }
    
    
}
