package modelo.entidad.jorge;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mecanicos")
public class Mecanico {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		private String nombre;
		private Integer telefono;
		private String puesto;
		@ManyToOne
		@JoinColumn(name="fk_id_taller", referencedColumnName="id")
		private Taller taller;
		@ManyToMany(mappedBy="mecanicos", cascade=CascadeType.PERSIST)
		private List<Vehiculo> vehiculos;
		
		public Mecanico() {
			super();
		}

		public Mecanico(Integer id, String nombre, Integer telefono, String puesto, Taller taller,
				List<Vehiculo> vehiculos) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.telefono = telefono;
			this.puesto = puesto;
			this.taller = taller;
			this.vehiculos = vehiculos;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Integer getTelefono() {
			return telefono;
		}

		public void setTelefono(Integer telefono) {
			this.telefono = telefono;
		}

		public String getPuesto() {
			return puesto;
		}

		public void setPuesto(String puesto) {
			this.puesto = puesto;
		}

		public Taller getTaller() {
			return taller;
		}

		public void setTaller(Taller taller) {
			this.taller = taller;
		}

		public List<Vehiculo> getVehiculos() {
			return vehiculos;
		}

		public void setVehiculos(List<Vehiculo> vehiculos) {
			this.vehiculos = vehiculos;
		}

		@Override
		public String toString() {
			return "Mecanico [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", puesto=" + puesto
					+ ", taller=" + taller + ", vehiculos=" + vehiculos + "]";
		}
			
}
