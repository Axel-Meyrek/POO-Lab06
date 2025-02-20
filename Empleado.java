
public class Empleado extends Persona {
    private String puesto;
    private double salario;
    private int turno;
    private Prestamo prestamoGestionado;
    private String especialidad;
    private String horario;


    private static int contadorId = 0;
    
    public static final int MATUTINO = 0;

    public static final int VESPERTINO = 1;
    
    public static final int MIXTO = 2;

    public Empleado(String nombre, String id, double salario, String puesto) {
        super(nombre, id);
        this.salario = salario;
        this.puesto = puesto;
        this.prestamoGestionado = null;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario > 0 ? salario : 0;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        if (turno < MATUTINO || turno > MIXTO) return;
        
        this.turno = turno;
    
        switch (turno) {
            case MATUTINO:
                this.horario = "08:00 - 14:00";
                break;
            case VESPERTINO:
                this.horario = "14:00 - 20:00";
                break;
            case MIXTO:
                this.horario = "08:00 - 12:00 y 16:00 - 20:00";
                break;
        }
    }
    

    public Prestamo getPrestamoGestionado() {
        return prestamoGestionado;
    }

    public String obtenerTipo() {
        return "Empleado";
    }

    public static String generarId() {
        contadorId++;
        return "P" + String.format("%04d", contadorId);
    }

    public boolean procesarPrestamo(Libro libro, Usuario usuario) {
        if (libro != null && usuario != null && !libro.isPrestado()) {
            if (usuario.solicitarPrestamo(libro)) {
                prestamoGestionado = new Prestamo(generarId(), usuario, libro);
                return true;
            }
        }
        return false;
    }

    public boolean devolverPrestamo() {
        if (prestamoGestionado != null) {
            prestamoGestionado = null;
            return true;
        }
        return false;
    }

    public String toString() {
        return "Empleado [puesto=" + puesto + 
               ", salario=" + salario + 
               ", turno=" + turno + 
               ", prestamoGestionado=" + prestamoGestionado + 
               ", nombre=" + getNombre() + 
               ", id=" + getId() + "]";
    }

    /* MY CHANGES */
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHorario() {
        return horario;
    }

}