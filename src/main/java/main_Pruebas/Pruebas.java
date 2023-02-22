package main_Pruebas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;



import modelo.entidad.Autor;
import modelo.entidad.Direccion;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class Pruebas {

	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PruebaJPA");

		EntityManager em = null;
		Autor a1 = new Autor(null, "H.P.", "Lovecraft");
		a1.setFechaNacimiento(new Date(-10, 7, 20));
		Autor a2 = new Autor(null, "Stephen", "King");
		a2.setFechaNacimiento(new Date(47, 8, 21));
		Autor a3 = new Autor(null, "Anne", "Rice");
		a3.setFechaNacimiento(new Date(41, 19, 4));
		Autor a4 = new Autor(null, "Richard", "Matheson");
		a4.setFechaNacimiento(new Date(26, 1, 20));
		Autor a5 = new Autor(null, "Bram", "Stoker");
		a5.setFechaNacimiento(new Date(-53, 10, 8));
		Autor a6 = new Autor(null, "Adam", "L.G.N");
		a6.setFechaNacimiento(new Date(69, 3, 19));
		Autor a7 = new Autor(null, "Jack", "Ketchum");
		a7.setFechaNacimiento(new Date(46, 10, 10));

		Editorial e1 = new Editorial(null, "Planeta", null);
		Editorial e2 = new Editorial(null, "Anaya", null);
		List<Libro> librosEditorial1 = new ArrayList<Libro>();
		List<Libro> librosEditorial2 = new ArrayList<Libro>();

		List<Libro> listaAutor1 = new ArrayList<>();
		List<Libro> listaAutor2 = new ArrayList<>();
		List<Libro> listaAutor3 = new ArrayList<>();
		List<Libro> listaAutor4 = new ArrayList<>();
		List<Libro> listaAutor5 = new ArrayList<>();
		List<Libro> listaAutor6 = new ArrayList<>();
		List<Libro> listaAutor7 = new ArrayList<>();

		// Creamos todos los libros para las pruebas específicas
		Libro lib1 = new Libro(null, "It", 5.6, e1, a2);
		Libro lib2 = new Libro(null, "Drácula", 9, e1, a5);
		Libro lib3 = new Libro(null, "El resplandor", 11.2, e1, a2);
		Libro lib4 = new Libro(null, "Apartamento 16", 14.6, e1, a6);
		Libro lib5 = new Libro(null, "La casa infernal", 8.3, e2, a4);
		Libro lib6 = new Libro(null, "Entrevista con el Vampiro", 12.6, e2, a3);
		Libro lib7 = new Libro(null, "La chica de al lado", 11.6, e2, a7);
		Libro lib8 = new Libro(null, "Misery", 10.4, e2, a2);
		Libro lib9 = new Libro(null, "La llamada de Cthulhu", 19.99, e2, a1);
		librosEditorial1.add(lib1);
		librosEditorial1.add(lib2);
		librosEditorial1.add(lib3);
		librosEditorial1.add(lib4);
		librosEditorial2.add(lib5);
		librosEditorial2.add(lib6);
		librosEditorial2.add(lib7);
		librosEditorial2.add(lib8);
		librosEditorial2.add(lib9);

		listaAutor1.add(lib9);
		listaAutor2.add(lib1);
		listaAutor2.add(lib3);
		listaAutor2.add(lib8);
		listaAutor3.add(lib6);
		listaAutor4.add(lib5);
		listaAutor5.add(lib2);
		listaAutor6.add(lib4);
		listaAutor7.add(lib8);

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

		System.out.println("==============================================");
		em = emf.createEntityManager();

		Query query = em.createQuery(
				"SELECT lib.titulo, lib.editorial.nombre, lib.autor.nombre, lib.autor.apellidos " + "FROM Libro lib");
		List<Object[]> resultados = query.getResultList();
		System.out.println("==== listado de libros dados de alta, con su editorial y su autor====");
		for (Object[] p : resultados) {
			System.out.println(p[0] + " - " + p[1] + " - " + p[2] + " " + p[3]);// la posicion 0 tiene el titulo y la 1
																				// la editorial y la 2 el autor
		}
		System.out.println("==============================================");

		query = em.createQuery("SELECT lib.autor.nombre, lib.autor.apellidos, lib.titulo " + "FROM Libro lib");
		resultados = query.getResultList();
		System.out.println("==== listado de todos los autores dados de alta con sus libros asociados====");
		for (Object[] p : resultados) {
			System.out.println(p[0] + "  " + p[1] + " - " + p[2]);
		}

		System.out.println("==============================================");

		TypedQuery<Object[]> query1 = em.createQuery("SELECT lb.nombre, l.titulo " + "FROM Libro l "
				+ " JOIN l.librerias lb " + "ORDER BY lb.nombre, l.titulo", Object[].class);

		List<Object[]> resultados3 = query1.getResultList();

		System.out.println("==== listado de librerias con sus libros asociados====");
		for (Object[] p : resultados3) {
			System.out.println("Libreria: " + p[0] + " - Libro: " + p[1]);
		}

		System.out.println("==============================================");

		TypedQuery<Object[]> query4 = em.createQuery("SELECT l.titulo, lb.nombre FROM Libro l "
				+ "LEFT JOIN l.librerias lb " + "ORDER BY l.titulo, lb.nombre", Object[].class);
		List<Object[]> resultados4 = query4.getResultList();
		System.out.println(
				"================ Listado de todos los libros dados de alta y sus correspondientes librerias ================");
		for (Object[] p : resultados4) {
			System.out.println(p[0] + " - " + (p[1] != null ? p[1] : "No se ha encontrado libreria asociada"));
		}
		em.close();
		emf.close();
	}

}