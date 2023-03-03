package modelo.entidad.isra;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "direcciones")
public class Domicilio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String calle;
	private Integer numero, codigoPostal;

	@OneToOne
	@JoinColumn(name = "fk_id_tienda", referencedColumnName = "id")
	private TiendaDeMusica tiendaDeMusica;

	public Domicilio() {
		super();
	}

	public Domicilio(Integer id, String calle, Integer numero, Integer codigoPostal, TiendaDeMusica tiendaDeMusica) {
		super();
		this.id = id;
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.tiendaDeMusica = tiendaDeMusica;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public TiendaDeMusica getTiendaDeMusica() {
		return tiendaDeMusica;
	}

	public void setTiendaDeMusica(TiendaDeMusica tiendaDeMusica) {
		this.tiendaDeMusica = tiendaDeMusica;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero=" + numero + ", codigoPostal=" + codigoPostal
				+ ", tiendaDeMusica=" + tiendaDeMusica + "]";
	}

}
