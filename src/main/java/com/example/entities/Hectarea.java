package com.example.entities;
public class Hectarea {

    private int idHectarea, renta;
    private String comunidad, ubicacion;

    public Hectarea(
        int idHectarea,
        int renta,
        String comunidad,
        String ubicacion) 
    {
        this.idHectarea = idHectarea;
        this.renta = renta;
        this.comunidad = comunidad;
        this.ubicacion = ubicacion;
    }

    public int getIdHectarea() {
        return idHectarea;
    }

    public void setIdHectarea(int idHectarea) {
        this.idHectarea = idHectarea;
    }

    public int getRenta() {
        return renta;
    }

    public void setRenta(int renta) {
        this.renta = renta;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
