package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//repositorio de lugar con llave integer
@Repository
public interface LugarRepo extends JpaRepository<Lugar,Integer> {
}
