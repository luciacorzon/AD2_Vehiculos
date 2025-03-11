package com.example.AD2_Vehiculos.dto;

import com.example.AD2_Vehiculos.entity.Vehiculo;

public class VehiculoDTO {
    private Long idVehiculo;
    private String marca;
    private String modelo;
    private Short ano;
    private Double precio;
    private String propietario;

    public VehiculoDTO() {
    }

    public VehiculoDTO(Long idVehiculo, String marca, String modelo, Short ano, Double precio, String propietario) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
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

    public Short getAno() {
        return ano;
    }

    public void setAno(Short ano) {
        this.ano = ano;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public static VehiculoDTO of(Vehiculo vehiculo) {
        return new VehiculoDTO(vehiculo.getIdVehiculo(), vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getAnio(), (vehiculo.getPrecio() * 1.00),
                (vehiculo.getPropietario().getNombre() + " " + vehiculo.getPropietario().getApellidos()));
    }

    @Override
    public String toString() {
        return "VehiculoDTO{" +
                "idVehiculo=" + idVehiculo +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", precio=" + precio +
                ", propietario='" + propietario + '\'' +
                '}';
    }
}
