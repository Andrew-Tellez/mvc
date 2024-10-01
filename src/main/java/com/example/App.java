package com.example;
import java.sql.Connection;
import com.example.db.Conexion;
import com.example.db.BaseDeDatos;

public class App 
{
    public static void main( String[] args )
    {
        BaseDeDatos basedeDatos = new BaseDeDatos();
        Vista vista = new Vista();
        Modelo modelo = new Modelo(basedeDatos);
        Controlador controlador = new Controlador(vista,modelo);
        vista.setControlador(controlador);
    }
}
