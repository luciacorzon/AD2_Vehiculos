package com.example.AD2_Vehiculos.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.AccessType;

import java.util.List;

@Entity
@AccessType(AccessType.Type.FIELD)
public class Propietario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long idPropietario;
    private String nombre;
    private String apellidos;
    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL) // Cascade para entidade débiles (?)
    private List<Vehiculo> vehiculos;

    // Poñer SEMPRE o constructor vacio para JPA, senon dá fallo
    public Propietario() {
    }

    public Propietario(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void addVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
        // Hai que indicarlle o propietario
        vehiculo.setPropietario(this);
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "idPropietario=" + idPropietario +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", vehiculo=" + vehiculos +
                '}';
    }
}
