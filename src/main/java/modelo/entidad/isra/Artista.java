package modelo.entidad.isra;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "artistas")
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre, apellidos;

	@Temporal(TemporalType.DATE)
	private Date fNacimiento;

	@OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
	private List<Disco> discosArtista;

	public Artista() {
		super();
	}

	public Artista(Integer id, String nombre, String apellidos, Date fNacimiento, List<Disco> discosArtista) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fNacimiento = fNacimiento;
		this.discosArtista = discosArtista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(Date fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public List<Disco> getDiscosArtista() {
		return discosArtista;
	}

	public void setDiscosArtista(List<Disco> discosArtista) {
		this.discosArtista = discosArtista;
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fNacimiento=" + fNacimiento
				+ ", discosArtista=" + discosArtista + "]";
	}

}
