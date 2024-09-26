package com.example;
import javax.swing.JButton;
import javax.swing.JFrame;
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
        setSize(800,600);
        setLocationRelativeTo(null);
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
        add(btnRecuperar);
        add(btnLimpiar);
        add(btnGuardar);
        add(btnActualizar);
        add(btnBorrar);
        add(btnConsultarTodas);
        add(txtComunidad);
        add(txtID);
        setVisible(true);
    }
    public void limpiar() {
        
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
