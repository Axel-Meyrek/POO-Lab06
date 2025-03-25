import java.time.*;
import java.util.*;

public class Prestamo {
    private String id;
    private Usuario usuario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucionEsperada;
    private LocalDate fechaDevolucionReal;
    private int estado;

    private static Queue <Prestamo> prestamosPendientes = new LinkedList<>();
    private static final int MULTA = 50;

    public static final int ACTIVO = 0;
    public static final int DEVUELTO = 1;
    public static final int VENCIDO = 2;

    public Prestamo(String id, Usuario usuario, Libro libro) {
        this.id = id;
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = LocalDate.now();
        this.fechaDevolucionEsperada = fechaPrestamo.plusDays(14);
        this.fechaDevolucionReal = null;
        this.estado = ACTIVO;
        prestamosPendientes.add(this);
    }

    public static Queue<Prestamo> getPrestamosPendientes() {
        return prestamosPendientes;
    }

    public static Prestamo procesarSiguientePrestamo() {
        return prestamosPendientes.poll();
    }

    public String getId() {
        return id;
    }

    public Usuario getUsuario() {
        return new Usuario(usuario);
    }

    public Libro getLibro() {
        return new Libro(libro);
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public LocalDate getFechaDevolucionEsperada() {
        return fechaDevolucionEsperada;
    }

    public LocalDate getFechaDevolucionReal() {
        return fechaDevolucionReal;
    }

    public int getEstado() {
        return estado;
    }

    public boolean registrarPrestamo() {
        if (libro.isPrestado() || usuario.getHistorialPrestamos().contains(this)) return false;

        if (usuario.solicitarPrestamo(libro)) {
            usuario.agregarPrestamo(this);
            estado = ACTIVO;
            return true;
        }
        return false;
    }

    public boolean procesarDevolucion() {
        if (estado == ACTIVO) {
            fechaDevolucionReal = LocalDate.now();
            if (usuario.devolverLibro()) {
                estado = DEVUELTO;
                return true;
            }
        }
        return false;
    }

    public void verificarEstado() {
        if (estado == ACTIVO && LocalDate.now().isAfter(fechaDevolucionEsperada)) {
            estado = VENCIDO;
        }
    }

    public boolean extenderPrestamo(int dias) {
        if (estado == ACTIVO && !LocalDate.now().isAfter(fechaDevolucionEsperada)) {
            fechaDevolucionEsperada = fechaDevolucionEsperada.plusDays(dias);
            return true;
        }
        return false;
    }

    public int calcularMulta() {
        int diasRetrasados = -diasRestantesParaDevolucion();
        return (diasRetrasados > 0) ? diasRetrasados * MULTA : 0;
    }

    public String generarReciboMulta() {
        int diasRetrasados = -diasRestantesParaDevolucion();
        if (diasRetrasados <= 0) {
            return "No hay multa, el libro fue devuelto a tiempo.";
        }
        int totalPagar = calcularMulta();
        return "---- RECIBO DE MULTA ----\n" +
                "Libro: " + libro.getTitulo() + "\n" +
                "Bibliotecario: " + usuario.getNombre() + "\n" +
                "Fecha esperada de devolución: " + fechaDevolucionEsperada + "\n" +
                "Días de retraso: " + diasRetrasados + "\n" +
                "Total a pagar: $" + totalPagar + "\n" +
                "-------------------------";
    }

    public int diasRestantesParaDevolucion() {
        return Period.between(LocalDate.now(), fechaDevolucionEsperada).getDays();
    }

    public String alertNuevoLibro() {
        if (estado == DEVUELTO && fechaDevolucionReal != null) {
            return "ALERTA: Devolución registrada \n" +
                    "Libro: " + libro.getTitulo() + "\n" +
                    "Usuario: " + usuario.getNombre() + "\n" +
                    "Fecha de devolución: " + fechaDevolucionReal + "\n" +
                    "-------------------------";
        }
        return "El libro aún no ha sido devuelto.";
    }

    @Override
    public String toString() {
        String estadoStr;
        switch (estado) {
            case ACTIVO:
                estadoStr = "ACTIVO";
                break;
            case DEVUELTO:
                estadoStr = "DEVUELTO";
                break;
            case VENCIDO:
                estadoStr = "VENCIDO";
                break;
            default:
                estadoStr = "DESCONOCIDO";
        }

        return "Prestamo [ID=" + id +
                ", Usuario=" + usuario.getNombre() +
                ", Libro=" + libro.getTitulo() +
                ", Fecha Prestamo=" + fechaPrestamo +
                ", Fecha Devolución Esperada=" + fechaDevolucionEsperada +
                ", Fecha Devolución Real=" + (fechaDevolucionReal != null ? fechaDevolucionReal : "No devuelto") +
                ", Estado=" + estadoStr + "]";
    }
}
