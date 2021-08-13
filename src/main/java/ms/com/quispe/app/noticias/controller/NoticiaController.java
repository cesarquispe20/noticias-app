/**
 * 
 */
package ms.com.quispe.app.noticias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ms.com.quispe.app.noticias.entity.Noticia;
import ms.com.quispe.app.noticias.service.INoticiaService;

/**
 * @author Pedro Quispe
 *
 */

@RestController
@RequestMapping("/noticias")
public class NoticiaController {

	@Autowired
	private INoticiaService noticiaService;
	
	@GetMapping
	public ResponseEntity<List<Noticia>> listarNoticias(){
		
		List<Noticia> response = noticiaService.listarNoticiasActivas();
				
		return new ResponseEntity<List<Noticia>>(response, HttpStatus.OK);
		
	}
	
	
}
