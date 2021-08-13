/**
 * 
 */
package ms.com.quispe.app.noticias.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms.com.quispe.app.noticias.entity.Noticia;
import ms.com.quispe.app.noticias.repository.NoticiaRepository;
import ms.com.quispe.app.noticias.service.INoticiaService;

/**
 * @author Pedro Quispe
 *
 */
@Service("NoticiaService")
public class NoticiaServiceImpl implements INoticiaService {
	
	@Autowired
	private NoticiaRepository noticiaRepository;
	

	@Override
	public List<Noticia> listarNoticiasActivas() {
		return (List<Noticia>) noticiaRepository.findByNoticiaActiva();
	}

	@Override
	public Noticia guardar(Noticia obj) {

		return noticiaRepository.save(obj);
	}

	@Override
	public Noticia buscarPorId(Long id) {

		return noticiaRepository.findById(id).orElse(null);
	}

	@Override
	public void eliminar(Noticia obj) {
		noticiaRepository.delete(obj);
	}

	@Override
	public Noticia actualizar(Noticia obj) {
		
		return noticiaRepository.save(obj);
	}

}
