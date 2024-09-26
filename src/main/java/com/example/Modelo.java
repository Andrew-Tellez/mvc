package com.example;
import com.example.entities.Hectarea;
public class Modelo {

  // TODO: La parte de manejar la base de datos tiene que ser pasada en el constructor;
  // private BaseDeDatos bd;

  // public Modelo(BaseDeDatos bd) {
  //   this.bd = bd;
  // }
  
  public boolean guardarHectarea(Hectarea nuevaHectarea) {
    return true;
  }

  public Hectarea recuperarHectarea(int idHectarea) {
    return new Hectarea(idHectarea, idHectarea, null, null);
  }

  public boolean borrarHectarea(int idHectarea) {
    return true;
  }

  public Hectarea[] recuperarHectareas(int pagina) {
    return new Hectarea[]{new Hectarea(pagina, pagina, null, null)};
  }
  
  public boolean actualizarHectarea(Hectarea hectareaAModificar) {
    return true;
  }
}
