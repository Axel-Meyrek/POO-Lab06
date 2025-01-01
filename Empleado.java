
/**
 * Clase que representa a un empleado de la biblioteca.
 * Extiende de la clase Persona y añade funcionalidades específicas para la gestión de préstamos.
 * 
 * @author Roberto Salazar Márquez
 * @version 1.0
 */
public class Empleado extends Persona {
    /** Número identificador único del empleado */
    private String numeroEmpleado;
    /** Puesto que ocupa el empleado en la biblioteca */
    private String puesto;
    /** Salario del empleado */
    private double salario;
    /** Turno de trabajo del empleado (MATUTINO, VESPERTINO o MIXTO) */
    private int turno;
    /** Préstamo que está siendo gestionado actualmente por el empleado */
    private Prestamo prestamoGestionado;
    /** Contador para generar IDs únicos */
    private static int contadorId = 0;
    
    /** Constante que representa el turno matutino */
    public static final int MATUTINO = 0;
    /** Constante que representa el turno vespertino */
    public static final int VESPERTINO = 1;
    /** Constante que representa el turno mixto */
    public static final int MIXTO = 2;

    /**
     * Constructor de la clase Empleado.
     * @param nombre Nombre del empleado
     * @param id Identificador único del empleado
     * @param numeroEmpleado Número de empleado asignado
     * @param puesto Puesto que ocupará el empleado
     */
    public Empleado(String nombre, String id, double salario, String puesto) {
        super(nombre, id);
        this.salario = salario;
        this.puesto = puesto;
        this.prestamoGestionado = null;
    }

    /**
     * Obtiene el puesto del empleado.
     * @return String con el puesto actual
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto del empleado.
     * @param puesto Nuevo puesto a asignar
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    /**
     * Obtiene el salario del empleado.
     * @return double con el salario actual
     */
    public double getSalario() {
        return salario;
    }

    /**
     * Establece el salario del empleado.
     * @param salario Nuevo salario a asignar
     */
    public void setSalario(double salario) {
        this.salario = salario > 0 ? salario : 0;
    }

    /**
     * Obtiene el turno del empleado.
     * @return int que representa el turno (MATUTINO, VESPERTINO o MIXTO)
     */
    public int getTurno() {
        return turno;
    }

    /**
     * Establece el turno del empleado.
     * @param turno Nuevo turno a asignar
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    /**
     * Obtiene el préstamo que está siendo gestionado.
     * @return Prestamo actual o null si no hay préstamo en gestión
     */
    public Prestamo getPrestamoGestionado() {
        return prestamoGestionado;
    }

    /**
     * Obtiene el tipo de persona.
     * @return String "Empleado"
     */
    public String obtenerTipo() {
        return "Empleado";
    }

    /**
     * Genera un nuevo ID único para préstamos.
     * @return String con formato "P" seguido de 4 dígitos
     */
    public static String generarId() {
        contadorId++;
        return "P" + String.format("%04d", contadorId);
    }
    
    /**
     * Procesa una solicitud de préstamo de libro.
     * @param libro Libro que se desea prestar
     * @param usuario Usuario que solicita el préstamo
     * @return true si el préstamo se realizó exitosamente, false en caso contrario
     */
    public boolean procesarPrestamo(Libro libro, Usuario usuario) {
        if (libro != null && usuario != null && !libro.isPrestado()) {
            if (usuario.solicitarPrestamo(libro)) {
                prestamoGestionado = new Prestamo(generarId(), usuario, libro);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Procesa la devolución de un préstamo, liberando el préstamo gestionado
     * por el empleado.
     * 
     * @return true si se procesó la devolución exitosamente, false en caso contrario
     */
    public boolean devolverPrestamo() {
        if (prestamoGestionado != null) {
            prestamoGestionado = null;
            return true;
        }
        return false;
    }
    
    /**
     * Devuelve una representación en cadena del empleado.
     * @return String con los datos del empleado
     */
    public String toString() {
        return "Empleado [puesto=" + puesto + 
               ", salario=" + salario + 
               ", turno=" + turno + 
               ", prestamoGestionado=" + prestamoGestionado + 
               ", nombre=" + getNombre() + 
               ", id=" + getId() + "]";
    }
}