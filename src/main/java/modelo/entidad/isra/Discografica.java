package modelo.entidad.isra;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "discograficas")
public class Discografica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;

	@OneToMany(mappedBy = "discografica", cascade = CascadeType.ALL)
	private List<Disco> discosDiscografica;

	public Discografica() {
		super();
	}

	public Discografica(Integer id, String nombre, List<Disco> discosDiscografica) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.discosDiscografica = discosDiscografica;
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

	public List<Disco> getDiscosDiscografica() {
		return discosDiscografica;
	}

	public void setDiscosDiscografica(List<Disco> discosDiscografica) {
		this.discosDiscografica = discosDiscografica;
	}

	@Override
	public String toString() {
		return "Discografica [id=" + id + ", nombre=" + nombre + ", discosDiscografica=" + discosDiscografica + "]";
	}

}
