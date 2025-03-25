import java.util.*;

public class Main {

    /* HOLA PROFE BUENAS NOCHES, REALIZE LAS PRUEBAS AQUI, SON LAS CLASES: LIBRO, USUARIO, BIBLIOTECA Y PRESTAMO */
    /* LO QUIERO PROFE, SOY ISREL */
    /* Yo tambein lo quiero profesor... soy Axel */
    public static void main(String[] args) {
        // Crear una biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Centro Ciudad");

        // Crear libros usando el constructor adecuado
        Libro libro1 = new Libro("Java para Todos", "Juan Pérez", "1234567890123", 250);
        Libro libro2 = new Libro("Programación Avanzada en Java", "Carlos López", "9876543210987", 300);

        // Crear un usuario
        Usuario usuario1 = new Usuario("Juan Pérez", "U001");

        // Asignar libro y usuario a la biblioteca
        biblioteca.setLibro(libro1);
        biblioteca.setUsuario(usuario1);

        // Crear empleados y agregarlos a la biblioteca
        biblioteca.agregarEmpleado("Carlos García", "E001", 3000.0, "Bibliotecario", 1);
        biblioteca.agregarEmpleado("Ana López", "E002", 2800.0, "Bibliotecario", 2);

        // Mostrar la información inicial de la biblioteca
        System.out.println(biblioteca);
        System.out.println();

        // Intentar prestar el libro
        System.out.println("Intentando prestar el libro...");
        if (biblioteca.prestarLibro("E001")) {
            System.out.println("¡Préstamo exitoso!");
        } else {
            System.out.println("No se pudo realizar el préstamo.");
        }
        System.out.println();

        // Mostrar el estado después del préstamo
        System.out.println(biblioteca);
        System.out.println();

        // Intentar devolver el libro
        System.out.println("Intentando devolver el libro...");
        if (biblioteca.devolverLibro("E001")) {
            System.out.println("¡Devolución exitosa!");
        } else {
            System.out.println("No se pudo realizar la devolución.");
        }
        System.out.println();

        // Mostrar el estado después de la devolución
        System.out.println(biblioteca);
    }
}
