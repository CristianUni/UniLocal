package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Usuario;

import java.util.List;

public interface LugarServicio {

List<Lugar> buscarPorNombre(String nombre ) throws Exception;
List<Lugar> buscarPorCategoria(int categoria) throws Exception;
List<Lugar>  buscarPorCategoriaYNombre(String nombre, int categoria) throws Exception;
Lugar buscarPorNombreExacto (String nombre) throws Exception;

}
