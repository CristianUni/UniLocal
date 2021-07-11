package co.edu.uniquindio.proyecto.servicios;


import co.edu.uniquindio.proyecto.entidades.Usuario;
import org.springframework.stereotype.Service;


public interface UsuarioServicio {

    Usuario registrarUsuario(Usuario u) throws Exception;


}
