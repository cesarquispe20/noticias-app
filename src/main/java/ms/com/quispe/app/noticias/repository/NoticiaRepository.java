/**
 * 
 */
package ms.com.quispe.app.noticias.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import ms.com.quispe.app.noticias.entity.Noticia;

/**
 * @author Pedro Quispe
 *
 */
@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long>{
	
	
	@Query(value = "SELECT * FROM NOTICIAS n WHERE n.estado = '1'", nativeQuery = true)
	public List<Noticia> findByNoticiaActiva();
	
	public Noticia findByCodigo(String codigo);
	

}
