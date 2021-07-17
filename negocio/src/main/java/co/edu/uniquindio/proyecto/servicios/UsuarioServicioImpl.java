package co.edu.uniquindio.proyecto.servicios;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import co.edu.uniquindio.proyecto.entidades.Usuario;
import co.edu.uniquindio.proyecto.repositorios.LugarRepo;
import co.edu.uniquindio.proyecto.repositorios.UsuarioRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UsuarioServicioImpl implements  UsuarioServicio{


    private final UsuarioRepo usuarioRepo;


    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;

    }


    @Override
    public Usuario registrarUsuario(Usuario u) {
        System.out.println("holaHD");
        Usuario buscado = usuarioRepo.findByEmail(u.getEmail());
        Usuario UsuarioNick = usuarioRepo.findByNickname(u.getNickname());
        if(buscado!=null){
          //  throw new Exception("El correo electronico ya se encuentra en uso");
        }
        if (UsuarioNick!=null){
            //throw new Exception("El NickName del usuario ya se encuentra registrado");
        }
        else{
            System.out.println(u.getEmail()+""+u.getEmail());
        }

        return usuarioRepo.save(u);
    }






}
