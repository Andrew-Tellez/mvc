package com.example.db;

import com.example.entities.Hectarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * BaseDeDatos
 */
public class BaseDeDatos {

    private Connection conexion;

    public BaseDeDatos() {
        conexion = Conexion.getConnection();
    }

    public int insertarHectarea(Hectarea hectarea) {
        int resultado = 0;
        String sql =
            "INSERT INTO hectareas (idHectarea, comunidad, renta, ubicacion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, hectarea.getIdHectarea());
            ps.setString(2, hectarea.getComunidad());
            ps.setInt(3, hectarea.getRenta());
            ps.setString(4, hectarea.getUbicacion());
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int actualizarHectarea(Hectarea hectarea) {
        int resultado = 0;
        String sql =
            "UPDATE hectareas SET comunidad = ?, renta = ?, ubicacion = ? WHERE idHectarea = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, hectarea.getComunidad());
            ps.setInt(2, hectarea.getRenta());
            ps.setString(3, hectarea.getUbicacion());
            ps.setInt(4, hectarea.getIdHectarea());
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public int borrarHectarea(int idHectarea) {
        int resultado = 0;
        String sql = "DELETE FROM hectareas WHERE idHectarea = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idHectarea);
            resultado = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    public Hectarea recuperarHectarea(int idHectarea) {
        Hectarea hectarea = null;
        String sql = "SELECT * FROM hectareas WHERE idHectarea = ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idHectarea);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                hectarea = new Hectarea(
                    rs.getInt("idHectarea"),
                    rs.getInt("renta"),
                    rs.getString("comunidad"),
                    rs.getString("ubicacion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hectarea;
    }

    public ArrayList<Hectarea> recuperarHectareas(int numPagina) {
        ArrayList<Hectarea> hectareas = new ArrayList<>();
        String sql =
            "SELECT * FROM hectareas ORDER BY idHectarea LIMIT 5 OFFSET ?";
        int desplazamiento = (numPagina - 1) * 5;
        try (PreparedStatement ps = conexion.prepareStatement(sql);) {
            ps.setInt(1, desplazamiento);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                hectareas.add(
                    new Hectarea(
                        rs.getInt("idHectarea"),
                        rs.getInt("renta"),
                        rs.getString("comunidad"),
                        rs.getString("ubicacion")
                    )
                );
                // for (Hectarea hectarea : hectareas) {
                //     System.out.println(hectarea.getIdHectarea());
                // }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hectareas;
    }
}
