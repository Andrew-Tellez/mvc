package com.example;

import com.example.entities.Hectarea;
import java.awt.event.*;
import java.util.ArrayList;

public class Controlador implements ActionListener {

    private Vista vista;
    private Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.modelo = modelo;
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnActualizar()) {
            modelo.actualizarHectarea(vista.getHectarea());
            return;
        }
        if (e.getSource() == vista.getBtnBorrar()) {
            modelo.borrarHectarea(vista.getHectarea().getIdHectarea());
            return;
        }
        if (e.getSource() == vista.getBtnConsultarTodas()) {
            int paginaActual = vista.getPagina();
            ArrayList<Hectarea> hectareas = modelo.recuperarHectareas(
                paginaActual
            );
            int totalHectareas = modelo.obtenerTotalHectareas();
            vista.setTotalPaginas(totalHectareas);
            vista.actualizarTabla(hectareas);
            vista.abrirModalConsultarTodas();
            return;
        }
        if (e.getSource() == vista.getBtnGuardar()) {
            modelo.guardarHectarea(vista.getHectarea());
            vista.limpiar();
            return;
        }
        if (e.getSource() == vista.getBtnLimpiar()) {
            vista.limpiar();
            return;
        }
        if (e.getSource() == vista.getBtnRecuperar()) {
            Hectarea hectareaRecuperada = modelo.recuperarHectarea(
                Integer.parseInt(vista.getTxtID().getText())
            );
            vista.mostrarRecuperada(hectareaRecuperada);
            return;
        }
        if (e.getSource() == vista.getBtnSiguiente()) {
            vista.setPagina(vista.getPagina() + 1);
            int paginaActual = vista.getPagina();
            ArrayList<Hectarea> hectareas = modelo.recuperarHectareas(
                paginaActual
            );
            vista.actualizarTabla(hectareas);
        }
        if (e.getSource() == vista.getBtnAnterior()) {
            vista.setPagina(vista.getPagina() - 1);
            int paginaActual = vista.getPagina();
            ArrayList<Hectarea> hectareas = modelo.recuperarHectareas(
                paginaActual
            );
            vista.actualizarTabla(hectareas);
        }
    }
}
