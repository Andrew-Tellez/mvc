package com.example;

import static org.junit.jupiter.api.Assertions.*;

import com.example.db.BaseDeDatos;
import com.example.entities.Hectarea;
import org.junit.jupiter.api.*;

/**
 * BaseDeDatosTest
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseDeDatosTest {

    private BaseDeDatos BD;

    @BeforeAll
    public void setUp() {
        BD = new BaseDeDatos();
    }

    @Test
    public void testInsertarHectarea() {
        int idHectarea = 1;
        int renta = 100;
        String comunidad = "comunidad";
        String ubicacion = "ubicacion";
        BD.insertarHectarea(
            new Hectarea(idHectarea, renta, comunidad, ubicacion)
        );
        Hectarea hectarea = BD.recuperarHectarea(idHectarea);
        assertEquals(idHectarea, hectarea.getIdHectarea());
        assertEquals(renta, hectarea.getRenta());
        assertEquals(comunidad, hectarea.getComunidad());
        assertEquals(ubicacion, hectarea.getUbicacion());
    }

    @Test
    public void testActualizarHectarea() {
        int idHectarea = 2;
        int renta = 100;
        String comunidad = "comunidad";
        String ubicacion = "ubicacion";
        BD.insertarHectarea(
            new Hectarea(idHectarea, renta, comunidad, ubicacion)
        );
        renta = 200;
        comunidad = "comunidad2";
        ubicacion = "ubicacion2";
        BD.actualizarHectarea(
            new Hectarea(idHectarea, renta, comunidad, ubicacion)
        );
        Hectarea hectarea = BD.recuperarHectarea(idHectarea);
        assertEquals(idHectarea, hectarea.getIdHectarea());
        assertEquals(renta, hectarea.getRenta());
        assertEquals(comunidad, hectarea.getComunidad());
        assertEquals(ubicacion, hectarea.getUbicacion());
    }

    @Test
    public void testBorrarHectarea() {
        int idHectarea = 3;
        int renta = 100;
        String comunidad = "comunidad";
        String ubicacion = "ubicacion";
        BD.insertarHectarea(
            new Hectarea(idHectarea, renta, comunidad, ubicacion)
        );
        BD.borrarHectarea(idHectarea);
        Hectarea hectarea = BD.recuperarHectarea(idHectarea);
        assertNull(hectarea);
    }

    @Test
    public void testRecuperarHectarea() {
        int idHectarea = 4;
        int renta = 100;
        String comunidad = "comunidad";
        String ubicacion = "ubicacion";
        BD.insertarHectarea(
            new Hectarea(idHectarea, renta, comunidad, ubicacion)
        );
        Hectarea hectarea = BD.recuperarHectarea(idHectarea);
        assertEquals(idHectarea, hectarea.getIdHectarea());
        assertEquals(renta, hectarea.getRenta());
        assertEquals(comunidad, hectarea.getComunidad());
        assertEquals(ubicacion, hectarea.getUbicacion());
    }

    @Test
    public void testRecuperarHectareaNoExiste() {
        int idHectarea = 5;
        Hectarea hectarea = BD.recuperarHectarea(idHectarea);
        assertNull(hectarea);
    }

    @Test
    void tetsRegistrosAfectados() {
        int idHectarea = 6;
        int renta = 100;
        String comunidad = "comunidad";
        String ubicacion = "ubicacion";
        int registrosAfectados = BD.insertarHectarea(
            new Hectarea(idHectarea, renta, comunidad, ubicacion)
        );
        assertEquals(1, registrosAfectados);

        renta = 200;
        comunidad = "comunidad2";
        ubicacion = "ubicacion2";
        registrosAfectados = BD.actualizarHectarea(
            new Hectarea(idHectarea, renta, comunidad, ubicacion)
        );
        assertEquals(1, registrosAfectados);

        registrosAfectados = BD.borrarHectarea(idHectarea);
        assertEquals(1, registrosAfectados);
    }
}
