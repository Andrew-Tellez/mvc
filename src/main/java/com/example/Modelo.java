package com.example;

import com.example.db.BaseDeDatos;
import com.example.entities.Hectarea;

public class Modelo {

    private BaseDeDatos bd;

    public Modelo(BaseDeDatos bd) {
        this.bd = bd;
    }

    public boolean guardarHectarea(Hectarea nuevaHectarea) {
        return true;
    }

    public Hectarea recuperarHectarea(int idHectarea) {
        return new Hectarea(idHectarea, idHectarea, null, null);
    }

    public boolean borrarHectarea(int idHectarea) {
        return bd.borrarHectarea(idHectarea) == 1;
    }

    public Hectarea[] recuperarHectareas(int pagina) {
        return new Hectarea[] { new Hectarea(pagina, pagina, null, null) };
    }

    public boolean actualizarHectarea(Hectarea hectareaAModificar) {
        return true;
    }
}
