package com.example;
import java.awt.event.*;
import java.util.ArrayList;

import com.example.entities.Hectarea;
public class Controlador implements ActionListener {
    private Vista vista;
    private Modelo modelo;
    public Controlador(Vista vista, Modelo modelo) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.getBtnActualizar()){
            modelo.actualizarHectarea(vista.getHectarea());
            return;
        }
        if(e.getSource()==vista.getBtnBorrar()){
            modelo.borrarHectarea(vista.getHectarea().getIdHectarea());
            return;
        }
        if(e.getSource()==vista.getBtnConsultarTodas()){
            ArrayList<Hectarea> hectareasRecuperadas = modelo.recuperarHectareas(1);
            vista.mostrarRecuperadas(hectareasRecuperadas);
            return;
        }
        if(e.getSource()==vista.getBtnGuardar()){
            modelo.guardarHectarea(vista.getHectarea());
            return;
        }
        if(e.getSource()==vista.getBtnLimpiar()){
            vista.limpiar();
            return;
        }
        if(e.getSource()==vista.getBtnRecuperar()){
            Hectarea hectareaRecuperada = modelo.recuperarHectarea(vista.getHectarea().getIdHectarea());
            vista.mostrarRecuperada(hectareaRecuperada);
            return;
        }
    }
}
