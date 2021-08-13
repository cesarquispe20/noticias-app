/**
 * 
 */
package ms.com.quispe.app.noticias.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Pedro Quispe
 *
 */
@Entity
@Data
@Table(name = "noticas")
public class Noticia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(length = 200, nullable = false)
	private String titulo;
	
	@Column(nullable = false)
	private String codigo;
	
	private String detalle;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;	
	
	private String estado;
}
