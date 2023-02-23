package modelo.entidad.pablo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "equipos")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String Nombre;

	@OneToOne(mappedBy = "equipo")
	private Estadio estadio;

	@OneToMany(mappedBy = "equipo")
	private List<Jugador> listaJugadores;

	@ManyToMany(mappedBy = "listaEquipos", cascade = CascadeType.PERSIST)
	private List<Patrocinador> listaPatrocinadores;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public List<Patrocinador> getListaPatrocinadores() {
		return listaPatrocinadores;
	}

	public void setListaPatrocinadores(List<Patrocinador> listaPatrocinadores) {
		this.listaPatrocinadores = listaPatrocinadores;
	}

}
