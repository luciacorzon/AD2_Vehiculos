package com.example.AD2_Vehiculos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import org.springframework.data.annotation.AccessType;

@Entity
// Para que herede da outra tabla
@PrimaryKeyJoinColumn(name = "id_vehiculo")
@AccessType(AccessType.Type.FIELD)
public class Moto {
    private int cilindrada;
    private String tipo;

    public Moto(int cilindrada, String tipo) {
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
