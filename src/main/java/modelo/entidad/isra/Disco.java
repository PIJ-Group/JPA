package modelo.entidad.isra;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "discos")
public class Disco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private double precio;

	@Temporal(TemporalType.DATE)
	private Date fechaLanzamiento;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_artista", referencedColumnName = "id")
	private Artista artista;

	@ManyToOne
	@JoinColumn(name = "fk_discografia", referencedColumnName = "id")
	private Discografica discografica;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "discos_tiendas", joinColumns = {
			@JoinColumn(name = "fk_id_disco", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "fk_id_tienda", referencedColumnName = "id") })
	private List<TiendaDeMusica> tiendasDeMusica;

	public Disco() {
		super();
	}

	public Disco(Integer id, String nombre, double precio, Date fechaLanzamiento, Artista artista,
			Discografica discografica, List<TiendaDeMusica> tiendasDeMusica) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fechaLanzamiento = fechaLanzamiento;
		this.artista = artista;
		this.discografica = discografica;
		this.tiendasDeMusica = tiendasDeMusica;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	public Discografica getDiscografica() {
		return discografica;
	}

	public void setDiscografica(Discografica discografica) {
		this.discografica = discografica;
	}

	public List<TiendaDeMusica> getTiendasDeMusica() {
		return tiendasDeMusica;
	}

	public void setTiendasDeMusica(List<TiendaDeMusica> tiendasDeMusica) {
		this.tiendasDeMusica = tiendasDeMusica;
	}

	@Override
	public String toString() {
		return "Disco [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fechaLanzamiento="
				+ fechaLanzamiento + ", artista=" + artista + ", discografica=" + discografica + ", tiendasDeMusica="
				+ tiendasDeMusica + "]";
	}

}
