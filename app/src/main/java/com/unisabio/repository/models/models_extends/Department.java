package com.unisabio.repository.models.models_extends;

public class Department {
    
    private String nombre;

    public Department() {}

    public Department(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
