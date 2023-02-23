package modelo.entidad.pablo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patrocinadores") 
public class Patrocinador {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String pais;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "equipo_patrocinadores", joinColumns = {
			@JoinColumn(name = "FK_ID_PATROCINADOR", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "FK_ID_EQUIPO", referencedColumnName = "id") })
	private List<Equipo> listaEquipos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Equipo> getListaEquipos() {
		return listaEquipos;
	}

	public void setListaEquipos(List<Equipo> listaEquipos) {
		this.listaEquipos = listaEquipos;
	}

}
