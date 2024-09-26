package com.example;

import java.awt.event.*;

public class Controlador implements ActionListener {

  private Modelo modelo;
  private Vista vista;

  public Controlador(Vista vista, Modelo modelo) {
    this.modelo = modelo;
    this.vista = vista;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
  }
  
}
