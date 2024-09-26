package com.example;
import java.awt.event.*;
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
            modelo.Actualizar();
            return;
        }
        if(e.getSource()==vista.getBtnBorrar()){
            modelo.Borrar();
            return;
        }
        if(e.getSource()==vista.getBtnConsultarTodas()){
            modelo.CosultarTodas();
            return;
        }
        if(e.getSource()==vista.getBtnGuardar()){
            modelo.Guardar();
            return;
        }
        if(e.getSource()==vista.getBtnLimpiar()){
            vista.limpiar();
            return;
        }
        if(e.getSource()==vista.getBtnRecuperar()){
            modelo.Actualizar();
            return;
        }
    }
}
