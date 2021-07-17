package co.edu.uniquindio.proyecto.repositorios;

import co.edu.uniquindio.proyecto.entidades.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//repositorio de lugar con llave integer
@Repository
public interface LugarRepo extends JpaRepository<Lugar,Integer> {

    Lugar findByNombre(String nombre);

    @Query("select l from Lugar l where l.nombre like %:nombre%")
    List<Lugar> buscarPorCampo( @Param("nombre") String nombre);

    @Query("select l from Lugar l where l.categoria.codigo=:nombre ")
    List<Lugar> buscarPorCateoria(@Param("nombre")int nombre);


    @Query("select l from Lugar l where l.categoria.codigo=:categoriaId and l.nombre like %:nombre% ")
    List<Lugar> buscarPorCateoriaYNombre(@Param("nombre")String nombre,@Param("categoriaId")int categoriaId);




}
