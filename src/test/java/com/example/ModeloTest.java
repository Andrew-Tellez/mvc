package com.example;

import static org.junit.jupiter.api.Assertions.*;

import com.example.db.BaseDeDatos;
import org.junit.jupiter.api.*;

/**
 * ModeloTest
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ModeloTest {

    private Modelo modelo;

    @BeforeAll
    public void setUp() {
        modelo = new Modelo(new BaseDeDatos());
    }

    @Test
    public void borrarHectarea() {
        int idHectarea = 99999;
        assertEquals(false, modelo.borrarHectarea(idHectarea));
    }
}
