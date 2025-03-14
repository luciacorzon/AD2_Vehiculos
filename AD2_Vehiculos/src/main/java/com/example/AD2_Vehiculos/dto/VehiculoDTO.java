package com.example.AD2_Vehiculos.dto;

import com.example.AD2_Vehiculos.entity.Propietario;
import com.example.AD2_Vehiculos.entity.Vehiculo;

public class VehiculoDTO {
    private Long idVehiculo;
    private String marca;
    private String modelo;
    private Short anio;
    private Double precio;
    private Propietario propietario;

    public VehiculoDTO() {
    }

    public VehiculoDTO(Long idVehiculo, String marca, String modelo, Short anio, Double precio, Propietario propietario) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.precio = precio;
        this.propietario = propietario;
    }

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short ano) {
        this.anio = ano;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public static VehiculoDTO of(Vehiculo vehiculo) {
        return new VehiculoDTO(vehiculo.getIdVehiculo(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getAnio(), (vehiculo.getPrecio() * 1.00),
                //(vehiculo.getPropietario().getNombre() + " " + vehiculo.getPropietario().getApellidos()));
                vehiculo.getPropietario());
    }

    @Override
    public String toString() {
        return "VehiculoDTO{" +
                "idVehiculo=" + idVehiculo +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año=" + anio +
                ", precio=" + precio +
                ", propietario='" + propietario + '\'' +
                '}';
    }
}
