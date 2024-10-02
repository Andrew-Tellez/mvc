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
            if (vista.getTxtRenta().getText().isEmpty()) {
                vista.MostarMensaje("El campo Renta no puede estar vacío");
                return;
            }
            if (!vista.getTxtRenta().getText().matches("[0-9]+")) {
                vista.MostarMensaje("El campo Renta debe ser un número entero");
                return;
            }
            if (vista.getTxtComunidad().getText().isEmpty()) {
                vista.MostarMensaje("El campo Comunidad no puede estar vacío");
                return;
            }
            if (vista.getTxtComunidad().getText().matches("[0-9]+")) {
                vista.MostarMensaje(
                    "El campo comunidad no debe ser un número entero"
                );
                return;
            }
            if (vista.getTxtUbicacion().getText().isEmpty()) {
                vista.MostarMensaje("El campo Ubicacion no puede estar vacío");
                return;
            }
            if (vista.getTxtUbicacion().getText().matches("[0-9]+")) {
                vista.MostarMensaje(
                    "El campo Ubicacion no debe ser un número entero"
                );
                return;
            }

            if (
                vista.confirmar(
                    "¿Está seguro de que desea actualizar la hectárea?"
                ) !=
                0
            ) {
                return;
            }

            modelo.actualizarHectarea(vista.getHectarea());
            return;
        }
        if (e.getSource() == vista.getBtnBorrar()) {
            if (vista.getTxtID().getText().isEmpty()) {
                vista.MostarMensaje("El campo ID no puede estar vacío");
                return;
            }
            if (!vista.getTxtID().getText().matches("[0-9]+")) {
                vista.MostarMensaje("El campo ID debe ser un número entero");
                return;
            }

            if (
                modelo.recuperarHectarea(
                    Integer.parseInt(vista.getTxtID().getText())
                ) ==
                null
            ) {
                vista.MostarMensaje(
                    "no existe una hectárea con el ID " +
                    vista.getTxtID().getText()
                );
                return;
            }
            if (
                vista.confirmar(
                    "¿Está seguro de que desea borrar la hectárea?"
                ) !=
                0
            ) {
                return;
            }
            modelo.borrarHectarea(Integer.parseInt(vista.getTxtID().getText()));
            vista.limpiar();
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
            if (vista.getTxtID().getText().isEmpty()) {
                vista.MostarMensaje("El campo ID no puede estar vacío");
                return;
            }
            if (!vista.getTxtID().getText().matches("[0-9]+")) {
                vista.MostarMensaje("El campo ID debe ser un número entero");
                return;
            }
            if (vista.getTxtRenta().getText().isEmpty()) {
                vista.MostarMensaje("El campo Renta no puede estar vacío");
                return;
            }
            if (!vista.getTxtRenta().getText().matches("[0-9]+")) {
                vista.MostarMensaje("El campo Renta debe ser un número entero");
                return;
            }
            if (vista.getTxtComunidad().getText().isEmpty()) {
                vista.MostarMensaje("El campo Comunidad no puede estar vacío");
                return;
            }
            if (vista.getTxtComunidad().getText().matches("[0-9]+")) {
                vista.MostarMensaje(
                    "El campo comunidad no debe ser un número entero"
                );
                return;
            }
            if (vista.getTxtUbicacion().getText().isEmpty()) {
                vista.MostarMensaje("El campo Ubicacion no puede estar vacío");
                return;
            }
            if (vista.getTxtUbicacion().getText().matches("[0-9]+")) {
                vista.MostarMensaje(
                    "El campo Ubicacion no debe ser un número entero"
                );
                return;
            }
            if (
                modelo.recuperarHectarea(
                    Integer.parseInt(vista.getTxtID().getText())
                ) !=
                null
            ) {
                vista.MostarMensaje(
                    "existe una hectárea con el ID " +
                    vista.getTxtID().getText()
                );
                return;
            }
            if (
                vista.confirmar(
                    "¿Está seguro de que desea guardar la hectárea?"
                ) !=
                0
            ) {
                return;
            }
            modelo.guardarHectarea(vista.getHectarea());
            vista.limpiar();
            return;
        }
        if (e.getSource() == vista.getBtnLimpiar()) {
            vista.limpiar();
            return;
        }
        if (e.getSource() == vista.getBtnRecuperar()) {
            if (vista.getTxtID().getText().isEmpty()) {
                vista.MostarMensaje("El campo ID no puede estar vacío");
                vista.limpiar();
                return;
            }

            if (!vista.getTxtID().getText().matches("[0-9]+")) {
                vista.MostarMensaje("El campo ID debe ser un número entero");
                return;
            }

            Hectarea hectareaRecuperada = modelo.recuperarHectarea(
                Integer.parseInt(vista.getTxtID().getText())
            );

            if (hectareaRecuperada == null) {
                vista.MostarMensaje(
                    "No se encontró la hectárea con el ID proporcionado"
                );
                vista.limpiar();
                return;
            }

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
        if (e.getSource() == vista.getChkHabilitar()) {
            if (vista.getChkHabilitar().isSelected()) {
                if (vista.getTxtID().getText().isEmpty()) {
                    vista.MostarMensaje("El campo ID no puede estar vacío");
                    vista.getChkHabilitar().setSelected(false);
                    return;
                }
                if (!vista.getTxtID().getText().matches("[0-9]+")) {
                    vista.MostarMensaje(
                        "El campo ID debe ser un número entero"
                    );
                    vista.getChkHabilitar().setSelected(false);
                    vista.limpiar();
                    return;
                }
                if (
                    modelo.recuperarHectarea(
                        Integer.parseInt(vista.getTxtID().getText())
                    ) ==
                    null
                ) {
                    vista.MostarMensaje(
                        "no existe una hectárea con el ID " +
                        vista.getTxtID().getText()
                    );
                    vista.getChkHabilitar().setSelected(false);
                    vista.limpiar();
                    return;
                }
                vista.getBtnBorrar().setEnabled(false);
                vista.getBtnActualizar().setEnabled(true);
                vista.getBtnGuardar().setEnabled(false);
                vista.getBtnLimpiar().setEnabled(false);
                vista.getBtnRecuperar().setEnabled(false);
                vista.getTxtID().setEnabled(false);
                return;
            }
            vista.getBtnBorrar().setEnabled(true);
            vista.getBtnActualizar().setEnabled(false);
            vista.getBtnGuardar().setEnabled(true);
            vista.getBtnLimpiar().setEnabled(true);
            vista.getBtnRecuperar().setEnabled(true);
            vista.getTxtID().setEnabled(true);
            return;
        }
    }
}
