package modelo.entidad.jorge;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private Integer id;
		private String marca, modelo, matricula;
		@ManyToMany (cascade=CascadeType.PERSIST)
		@JoinTable(name = "mecanicos_vehiculos",
					joinColumns= { @JoinColumn(name="fk_id_mecanico", referencedColumnName="id") },
					inverseJoinColumns= { @JoinColumn(name="fk_id_vehiculo", referencedColumnName="id")})
		private List<Mecanico> mecanicos;
		
		public Vehiculo() {
			super();
		}

		public Vehiculo(Integer id, String marca, String modelo, String matricula, List<Mecanico> mecanicos) {
			super();
			this.id = id;
			this.marca = marca;
			this.modelo = modelo;
			this.matricula = matricula;
			this.mecanicos = mecanicos;
		}

		public String getMarca() {
			return marca;
		}

		public void setMarca(String marca) {
			this.marca = marca;
		}

		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		public String getMatricula() {
			return matricula;
		}

		public void setMatricula(String matricula) {
			this.matricula = matricula;
		}

		public List<Mecanico> getMecanicos() {
			return mecanicos;
		}

		public void setMecanicos(List<Mecanico> mecanicos) {
			this.mecanicos = mecanicos;
		}

		@Override
		public String toString() {
			return "Vehiculo [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula
					+ ", mecanicos=" + mecanicos + "]";
		}
				
}
