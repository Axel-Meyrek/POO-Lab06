/**
 * Clase que representa una biblioteca y gestiona sus operaciones principales.
 * Esta clase maneja la interacción entre libros, usuarios y empleados bibliotecarios,
 * permitiendo realizar operaciones como préstamos y devoluciones de libros.
 * 
 * @author Roberto SALAZAR MARQUEZ
 * @version 1.0
 */

public class Biblioteca {
    private String nombre;
    private String ubicacion;
    private Libro libro;
    private Usuario usuario;
    private Empleado empleadoBibliotecario;

    public Biblioteca(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.empleadoBibliotecario = null;
        this.libro = null;
        this.usuario = null;
    }

    public void setEmpleado(String nombre, String Id, double salario, String puesto, int turno) {
        this.empleadoBibliotecario = new Empleado(nombre, Id, salario, puesto);
        empleadoBibliotecario.setSalario(salario);
        empleadoBibliotecario.setTurno(turno);
    }

    public String getNombre() {
        return new String(nombre);
    }

    public String getUbicacion() {
        return new String (ubicacion);
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Libro getLibro() {
        return new Libro(libro);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario =usuario;
    }

    public Usuario getUsuario() {
        return new Usuario(usuario);
    }

    public Empleado getEmpleadoBibliotecario() {
        return empleadoBibliotecario;
    }

    public boolean prestarLibro() {
        if (libro != null && usuario != null && !libro.isPrestado() && empleadoBibliotecario != null) {
            return empleadoBibliotecario.procesarPrestamo(libro, usuario);
        }
        return false;
    }

    public boolean devolverLibro() {
        if (libro != null && usuario != null && libro.isPrestado() && 
            empleadoBibliotecario != null && empleadoBibliotecario.getPrestamoGestionado() != null) {
            libro.devolverLibro();
            empleadoBibliotecario.devolverPrestamo();
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("Biblioteca: %s\n" +
                           "Ubicación: %s\n" +
                           "Libro actual: %s\n" +
                           "Usuario actual: %s\n" +
                           "Bibliotecario: %s\n" +
                           "Estado préstamo: %s",
                           nombre, 
                           ubicacion,
                           (libro != null ? libro.getTitulo() : "Ninguno"),
                           (usuario != null ? usuario.getNombre() : "Ninguno"),
                           (empleadoBibliotecario != null ? empleadoBibliotecario.getNombre() : "Sin asignar"),
                           (empleadoBibliotecario != null && empleadoBibliotecario.getPrestamoGestionado() != null ? 
                            "Préstamo activo" : "Sin préstamos"));
    }
}