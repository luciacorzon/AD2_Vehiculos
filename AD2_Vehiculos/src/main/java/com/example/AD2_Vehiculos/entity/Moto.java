package com.example.AD2_Vehiculos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.data.annotation.AccessType;

@Entity
// Para que herede da outra tabla
// Non hai que poñerlle ID porque xa se declara en Vehiculo
@PrimaryKeyJoinColumn(name = "id_vehiculo")
@AccessType(AccessType.Type.FIELD)
// Hai que poñerlle tamém a herdanza normal
public class Moto extends Vehiculo{
    private int cilindrada;
    private String tipo;

    // Sempre fai falta o constructor vacio para JPA
    public Moto() {
        super();
    }

    // Meter o super para que chame ao constructor de Vehiculo
    public Moto(String marca, String modelo, short anio, int precio, int cilindrada, String tipo) {
        super(marca, modelo, anio, precio); // Usa el constructor de Vehiculo
        this.cilindrada = cilindrada;
        this.tipo = tipo;
    }


    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindrada=" + cilindrada +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
