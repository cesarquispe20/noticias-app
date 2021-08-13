/**
 * 
 */
package ms.com.quispe.app.noticias.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import ms.com.quispe.app.noticias.entity.Noticia;
import ms.com.quispe.app.noticias.repository.NoticiaRepository;
import ms.com.quispe.app.noticias.service.INoticiaService;

/**
 * @author Pedro Quispe
 *
 */
@Log4j2
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

		Noticia noticia = noticiaRepository.findByCodigo(obj.getCodigo());
		
		if(noticia != null) return noticia;
		
		obj.setFechaCreacion(new Date());
		obj.setEstado('1');
		
		return noticiaRepository.save(obj);
	}

	@Override
	public Noticia buscarPorId(Long id) {

		return noticiaRepository.findById(id).orElse(null);
	}

	@Override
	public Noticia eliminar(Noticia obj) {
		Noticia noticia = buscarPorId(obj.getId());
		if(noticia == null) return null;
		
		obj.setEstado('0');
		
		return noticiaRepository.save(obj);
	}

	@Override
	public Noticia actualizar(Noticia obj) {
		log.info("Objeto recibido ->> {}", obj.toString() );		
		Noticia noticia = buscarPorId(obj.getId());
		log.info("Objeto encontrado ->> {}", obj.toString() );
		
		if(noticia == null) return null;
		
		Date fechaCreacion = noticia.getFechaCreacion();		
		noticia = obj;
		noticia.setFechaCreacion(fechaCreacion);
		noticia.setFechaModificacion(new Date());
		
		return noticiaRepository.save(obj);
	}

}
