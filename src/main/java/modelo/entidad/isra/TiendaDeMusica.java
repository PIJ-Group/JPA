package modelo.entidad.isra;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@Table(name = "tiendas")
public class TiendaDeMusica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;

	@OneToOne(mappedBy = "tienda", cascade = CascadeType.ALL)
	private Direccion direccion;

	@ManyToMany(mappedBy = "tiendasDeMusica", cascade = CascadeType.PERSIST)
	private List<Disco> discos;

	public TiendaDeMusica() {
		super();
	}

	public TiendaDeMusica(Integer id, String nombre, Direccion direccion, List<Disco> discos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.discos = discos;
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public List<Disco> getDiscos() {
		return discos;
	}

	public void setDiscos(List<Disco> discos) {
		this.discos = discos;
	}

	@Override
	public String toString() {
		return "TiendaDeMusica [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", discos=" + discos
				+ "]";
	}

}
