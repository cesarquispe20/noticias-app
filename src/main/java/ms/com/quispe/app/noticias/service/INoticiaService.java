/**
 * 
 */
package ms.com.quispe.app.noticias.service;

import java.util.List;

import ms.com.quispe.app.noticias.entity.Noticia;

/**
 * @author Pedro Quispe
 *
 */
public interface INoticiaService {

	public List<Noticia> listar();
	public Noticia guardar(Noticia obj);
	public Noticia buscarPorId(Long id);
	public void eliminar(Noticia obj);
	public Noticia actualizar(Noticia obj);
	
}
