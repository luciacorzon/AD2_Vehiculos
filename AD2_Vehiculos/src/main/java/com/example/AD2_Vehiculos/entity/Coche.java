package com.example.AD2_Vehiculos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.data.annotation.AccessType;

@Entity
@PrimaryKeyJoinColumn(name = "id_vehiculo")
@AccessType(AccessType.Type.FIELD)
public class Coche {
    private int puertas;
    private int plazas;

    public Coche(int puertas, int plazas) {
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
