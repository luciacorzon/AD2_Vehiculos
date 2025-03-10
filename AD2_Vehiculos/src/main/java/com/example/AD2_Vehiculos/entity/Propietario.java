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
    @OneToMany(mappedBy = "propietario")
    private List<Vehiculo> vehiculos;

    public Propietario(String nombre, String apellidos, List<Vehiculo> vehiculo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.vehiculos = vehiculos;
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

    public List<Vehiculo> getVehiculo() {
        return vehiculos;
    }

    public void setVehiculo(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
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
