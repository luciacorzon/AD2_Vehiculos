package com.example.AD2_Vehiculos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.data.annotation.AccessType;

@Entity
@PrimaryKeyJoinColumn(name = "id_vehiculo")
@AccessType(AccessType.Type.FIELD)
public class Coche extends Vehiculo{
    private int puertas;
    private int plazas;

    public Coche() {
        super();
    }

    public Coche(String marca, String modelo, short anio, int precio, int puertas, int plazas) {
        super(marca, modelo, anio, precio);
        this.puertas = puertas;
        this.plazas = plazas;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "puertas=" + puertas +
                ", plazas=" + plazas +
                '}';
    }
}
