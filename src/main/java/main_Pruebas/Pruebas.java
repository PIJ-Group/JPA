package main_Pruebas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.entidad.Autor;
import modelo.entidad.Direccion;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class Pruebas {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaJPA");

		EntityManager em = null;
		Autor a1 = new Autor(null, "H.P.", "Lovecraft");
		a1.setFechaNacimiento(new Date(1890-8-20));
		Autor a2 = new Autor(null, "Stephen", "King");
		a2.setFechaNacimiento(new Date(1947-9-21));
		Autor a3 = new Autor(null, "Anne", "Rice");
		a3.setFechaNacimiento(new Date(1941-10-4));
		Autor a4 = new Autor(null, "Richard", "Matheson");
		a4.setFechaNacimiento(new Date(1926-2-20));
		Autor a5 = new Autor(null, "Bram", "Stoker");
		a5.setFechaNacimiento(new Date(1847-11-8));
		Autor a6 = new Autor(null, "Adam", "L.G.N");
		a6.setFechaNacimiento(new Date(1969-4-19));
		Autor a7 = new Autor(null, "Jack", "Ketchum");
		a7.setFechaNacimiento(new Date(1946-11-10));

		Editorial e1 = new Editorial(null, "Planeta", null);
		Editorial e2 = new Editorial(null, "Anaya", null);
		List<Libro> librosEditorial1 = new ArrayList<Libro>();
		List<Libro> librosEditorial2 = new ArrayList<Libro>();

		// Creamos todos los libros para las pruebas específicas
		Libro lib1 = new Libro(null, "It", 5.6, e1, a2);
		Libro lib2 = new Libro(null, "Drácula", 9, e1, a5);
		Libro lib3 = new Libro(null, "El resplandor", 11.2, e1, a2);
		Libro lib4 = new Libro(null, "Apartamento 16", 14.6, e1, a6);
		Libro lib5 = new Libro(null, "La casa infernal", 8.3, e2, a4);
		Libro lib6 = new Libro(null, "Entrevista con el Vampiro", 12.6, e2, a3);
		Libro lib7 = new Libro(null, "La chica de al lado", 11.6, e2, a7);
		Libro lib8 = new Libro(null, "Misery", 10.4, e2, a2);
		librosEditorial1.add(lib1);
		librosEditorial1.add(lib2);
		librosEditorial1.add(lib3);
		librosEditorial1.add(lib4);
		librosEditorial2.add(lib5);
		librosEditorial2.add(lib6);
		librosEditorial2.add(lib7);
		librosEditorial2.add(lib8);

		e1.setLibrosEditorial(librosEditorial1);
		e2.setLibrosEditorial(librosEditorial2);

		// Creamos las Librerias
		Libreria libreria1 = new Libreria(null, "Libreria Madrid", "Pancracio", null);
		Libreria libreria2 = new Libreria(null, "Libreria Móstoles", "Maximiliano", null);

		// Asignamos las bibliotecas a una Lista de librerias
		List<Libreria> tiendasLibros = new ArrayList<Libreria>();
		tiendasLibros.add(libreria1);
		tiendasLibros.add(libreria2);

		// Asignamos una lista independiente a la libreria 1
		List<Libreria> biblioteca1 = new ArrayList<Libreria>();
		biblioteca1.add(libreria1);

		// Asignamos una lista independiente a la libreria 2
		List<Libreria> biblioteca2 = new ArrayList<Libreria>();
		biblioteca2.add(libreria2);

		// Asignamos los libros a ambas librerias, libreria 1 o libreria 2
		lib1.setLibrerias(tiendasLibros);
		lib7.setLibrerias(tiendasLibros);

		lib3.setLibrerias(biblioteca1);
		lib8.setLibrerias(biblioteca1);
		lib5.setLibrerias(biblioteca2);
		lib6.setLibrerias(biblioteca2);

		// Asignar los libros a cada libreria
		List<Libro> libros1 = new ArrayList<Libro>();
		libros1.add(lib1);
		libros1.add(lib7);
		libros1.add(lib3);
		libros1.add(lib8);

		libreria1.setLibros(libros1);

		List<Libro> libros2 = new ArrayList<Libro>();
		libros2.add(lib1);
		libros2.add(lib7);
		libros2.add(lib5);
		libros2.add(lib6);

		libreria2.setLibros(libros2);

		Direccion d = new Direccion();
		d.setTipoVia("Calle");
		d.setNombreVia("Asamblea 18");
		d.setCiudad("Madrid");

		// Dirección Autores
		a1.setDireccion(d);
		a2.setDireccion(d);
		a3.setDireccion(d);
		a4.setDireccion(d);
		a5.setDireccion(d);
		a6.setDireccion(d);
		a7.setDireccion(d);
		e1.setDireccion(d);
		e2.setDireccion(d);

		// Dirección Editoriales
		libreria1.setDireccion(d);
		libreria2.setDireccion(d);

		System.out.println("==============================================");
		em = emf.createEntityManager();
		em.getTransaction().begin();

		em.persist(e1);
		em.persist(e2);
		em.persist(libreria1);

		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
