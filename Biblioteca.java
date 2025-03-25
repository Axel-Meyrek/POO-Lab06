import java.util.HashMap;

public class Biblioteca {
    private String nombre;
    private String ubicacion;
    private Libro libro;
    private Usuario usuario;
    private HashMap <String, Empleado> empleadosBibliotecarios;

    public Biblioteca(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.libro = null;
        this.usuario = null;
        this.empleadosBibliotecarios = new HashMap<>();
    }

    public void agregarEmpleado(String nombre, String id, double salario, String puesto, int turno) {
        Empleado nuevoEmpleado = new Empleado(nombre, id, salario, puesto);
        nuevoEmpleado.setSalario(salario);
        nuevoEmpleado.setTurno(turno);
        empleadosBibliotecarios.put(id, nuevoEmpleado);
    }

    public Empleado getEmpleado(String id) {
        return empleadosBibliotecarios.get(id);
    }

    public boolean eliminarEmpleado(String id) {
        return empleadosBibliotecarios.remove(id) != null;
    }

    public HashMap <String, Empleado> getTodosLosEmpleados() {
        return empleadosBibliotecarios;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Libro getLibro() {
        return new Libro(libro);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return new Usuario(usuario);
    }

    public boolean prestarLibro(String idEmpleado) {
        Empleado empleado = empleadosBibliotecarios.get(idEmpleado);
        if (libro != null && usuario != null && !libro.isPrestado() && empleado != null) {
            return empleado.procesarPrestamo(libro, usuario);
        }
        return false;
    }

    public boolean devolverLibro(String idEmpleado) {
        Empleado empleado = empleadosBibliotecarios.get(idEmpleado);
        if (libro != null && usuario != null && libro.isPrestado() && empleado != null && 
            empleado.getPrestamoGestionado() != null) {
            libro.devolverLibro();
            empleado.devolverPrestamo();
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder empleadosInfo = new StringBuilder();
        for (Empleado empleado : empleadosBibliotecarios.values()) {
            empleadosInfo.append(empleado.getNombre()).append(", ");
        }
        
        return String.format("Biblioteca: %s\n" +
                           "Ubicación: %s\n" +
                           "Libro actual: %s\n" +
                           "Usuario actual: %s\n" +
                           "Bibliotecarios: %s\n" +
                           "Estado préstamo: %s",
                           nombre, 
                           ubicacion,
                           (libro != null ? libro.getTitulo() : "Ninguno"),
                           (usuario != null ? usuario.getNombre() : "Ninguno"),
                           (!empleadosBibliotecarios.isEmpty() ? empleadosInfo.toString() : "Sin empleados"),
                           (libro != null && libro.isPrestado() ? "Préstamo activo" : "Sin préstamos"));
    }
}
