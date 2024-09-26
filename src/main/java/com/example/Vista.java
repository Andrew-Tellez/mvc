package com.example;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class Vista extends JFrame{
    private JTextField txtID, txtComunidad, txtRenta, txtUbicacion;
    private JButton btnRecuperar, btnLimpiar, btnGuardar, btnActualizar, btnBorrar, btnConsultarTodas;
    public Vista(){
        super("Catalogo hectareas");
        hazInterfaz();
    }
    private void hazInterfaz() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,350);
        setResizable(false);
        setLocationRelativeTo(null);
        JLabel titulobl = new JLabel("Catalogo de Hectareas MangoDB");
        JLabel IDlbl = new JLabel("Ingresa ID:");
        JLabel Comunidadlbl = new JLabel("Ingresa la comunidad:");
        JLabel Rentalbl = new JLabel("Ingresa la renta:");
        JLabel Ubibl = new JLabel("Ingresa la ubicacion:");
        txtID = new JTextField(20);
        txtComunidad = new JTextField(20);
        txtRenta = new JTextField(20);
        txtUbicacion = new JTextField(20);
        btnRecuperar = new JButton("Recuperar");
        btnLimpiar = new JButton("Limpiar");
        btnGuardar = new JButton("Guardar");
        btnActualizar = new JButton("Actualizar");
        btnBorrar = new JButton("Borrar");
        btnConsultarTodas = new JButton("Consultar Todas");
        {
            titulobl.setBounds((getWidth()/2)-150, 10, 300, 30);
            IDlbl.setBounds(30, 50, 200, 25);
            txtID.setBounds(230, 50, 300, 25);
    
            Comunidadlbl.setBounds(30, 90, 200, 25);
            txtComunidad.setBounds(230, 90, 300, 25);
    
            Rentalbl.setBounds(30, 130, 200, 25);
            txtRenta.setBounds(230, 130, 300, 25);
    
            Ubibl.setBounds(30, 170, 200, 25);
            txtUbicacion.setBounds(230, 170, 300, 25);
    
            btnRecuperar.setBounds(30, 210, 150, 30);
            btnLimpiar.setBounds(210, 210, 150, 30);
            btnGuardar.setBounds(390, 210, 150, 30);
    
            btnActualizar.setBounds(30, 250, 150, 30);
            btnBorrar.setBounds(210, 250, 150, 30);
            btnConsultarTodas.setBounds(390, 250, 150, 30);
        }
        Font fuente1 = new Font("Arial", 1,18); 
        Font fuente2 = new Font("Arial", 1,15);
        titulobl.setFont(fuente1);
        IDlbl.setFont(fuente2);
        Comunidadlbl.setFont(fuente2);
        Rentalbl.setFont(fuente2);
        Ubibl.setFont(fuente2);
        add(titulobl);
        add(IDlbl);
        add(txtID);
        add(Comunidadlbl);
        add(txtComunidad);
        add(Rentalbl);
        add(txtRenta);
        add(Ubibl);
        add(txtUbicacion);
        add(btnRecuperar);
        add(btnLimpiar);
        add(btnGuardar);
        add(btnActualizar);
        add(btnBorrar);
        add(btnConsultarTodas);
        setVisible(true);
    }
    public void limpiar() {
        txtID.setText("");
        txtComunidad.setText("");
        txtRenta.setText("");
        txtUbicacion.setText("");
        txtID.requestFocus();
    }
    public void setControlador(Controlador controlador) {
        btnRecuperar.addActionListener(controlador);
        btnLimpiar.addActionListener(controlador);
        btnGuardar.addActionListener(controlador);
        btnActualizar.addActionListener(controlador);
        btnBorrar.addActionListener(controlador);
        btnConsultarTodas.addActionListener(controlador);
    }
    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }
    public JTextField getTxtComunidad() {
        return txtComunidad;
    }
    public void setTxtComunidad(JTextField txtComunidad) {
        this.txtComunidad = txtComunidad;
    }
    public JTextField getTxtRenta() {
        return txtRenta;
    }
    public void setTxtRenta(JTextField txtRenta) {
        this.txtRenta = txtRenta;
    }
    public JTextField getTxtUbicacion() {
        return txtUbicacion;
    }
    public void setTxtUbicacion(JTextField txtUbicacion) {
        this.txtUbicacion = txtUbicacion;
    }
    public JButton getBtnRecuperar() {
        return btnRecuperar;
    }
    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }
    public JButton getBtnGuardar() {
        return btnGuardar;
    }
    public JButton getBtnActualizar() {
        return btnActualizar;
    }
    public JButton getBtnBorrar() {
        return btnBorrar;
    }
    public JButton getBtnConsultarTodas() {
        return btnConsultarTodas;
    }
    public JTextField getTxtID() {
        return txtID;
    }
}
