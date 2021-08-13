/**
 * 
 */
package ms.com.quispe.app.noticias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@PostMapping
	public ResponseEntity<Noticia> guardarNoticia(@RequestBody Noticia obj) {
		
		Noticia response = noticiaService.guardar(obj);
		
		return new ResponseEntity<Noticia>(response, HttpStatus.CREATED);
	}
 
	@GetMapping("/{id}") 
	public ResponseEntity<Noticia> buscarPorId(@PathVariable(name = "id") Long id) {

		 Noticia response = noticiaService.buscarPorId(id);
		 if(response == null) return ResponseEntity.noContent().build();
		 
		 return new ResponseEntity<Noticia>(response, HttpStatus.OK);
	}

	@DeleteMapping
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void eliminarNoticia(@RequestBody Noticia obj) {		
		noticiaService.eliminar(obj);
	}

	@PutMapping
	public ResponseEntity<Noticia> actualizar(@RequestBody Noticia obj) {
		
		Noticia response = noticiaService.actualizar(obj);
		
		return new ResponseEntity<Noticia>(response, HttpStatus.ACCEPTED);
	}
	
	
}
