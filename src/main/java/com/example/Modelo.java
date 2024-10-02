package com.example;
import java.util.ArrayList;
import com.example.db.BaseDeDatos;
import com.example.entities.Hectarea;

public class Modelo {
    private BaseDeDatos bd;
    public Modelo(BaseDeDatos bd) {
        this.bd = bd;
    }

    public boolean guardarHectarea(Hectarea nuevaHectarea) {
        return bd.insertarHectarea(nuevaHectarea) == 1;
    }

    public Hectarea recuperarHectarea(int idHectarea) {
        return bd.recuperarHectarea(idHectarea);
    }

    public boolean borrarHectarea(int idHectarea) {
        return bd.borrarHectarea(idHectarea) == 1;
    }

    public ArrayList<Hectarea> recuperarHectareas(int pagina) {
        return bd.recuperarHectareas(pagina);
    }

    public boolean actualizarHectarea(Hectarea hectareaAModificar) {
        return bd.actualizarHectarea(hectareaAModificar) == 1;
    }

    public int obtenerTotalHectareas() {
        return bd.obtenerTotalRegistros();
    }
}
