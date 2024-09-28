package com.example.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    private static Connection connection;

    private Conexion() {
      try {
        String url = "jdbc:postgresql://localhost:5433/mvc";
        connection = DriverManager.getConnection(url, "admin_user", "123456");
        System.out.println("Base de datos conectada exitosamente");
      } catch (Exception e) {
        System.out.println("La conexion a la base de datos falló");
      }
    }

    public static Connection getConnection() {
      if (connection == null) {
        new Conexion();
      }
      return connection;
    }

}
