import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Usuario extends Persona {
    private Libro libroPrestado;
    private ArrayList <String> generosFavoritos;
    private String preferenciaDeLectura;
    private int librosPrestados;
    private int maxLibrosPrestados;
    private Set <Prestamo> historialPrestamos;
    
    public Usuario(String nombre, String id) {
        super(nombre, id);
        this.libroPrestado = null;
        this.generosFavoritos = new ArrayList<>();
        this.historialPrestamos = new HashSet<>();
        librosPrestados = 0;
        this.maxLibrosPrestados = 5;
    }
    
    public Usuario(Usuario usuario) {
        super(usuario.getNombre(), usuario.getId());
        this.libroPrestado = usuario.getLibrosPrestados();
        this.librosPrestados = usuario.getNumLibrosPrestados();
        this.historialPrestamos = usuario.getHistorialPrestamos();
        this.generosFavoritos = new ArrayList<>(usuario.getGenerosFavoritos());
    }
    
    public boolean solicitarPrestamo(Libro libro) {
        if (!libro.isPrestado() && maxLibrosPrestados <= 5 ) {
            if (libro.prestarLibro()) {
                libroPrestado = libro;
                librosPrestados++;
                return true;
            }
        }
        return false;
    }
    
    public boolean devolverLibro() {    
        if (libroPrestado != null) {
            libroPrestado.devolverLibro();
            libroPrestado = null;
            librosPrestados--;
            return true;
        }
        return false;
    }
    
    public Libro getLibrosPrestados() {
        if (libroPrestado != null)
            return new Libro(libroPrestado);
        else
            return null;
    }
    
    public String obtenerTipo() {
        return "Usuario";
    }
    
    public String toString() {
        String cad = "ID: " + getId() + ", " + "Nombre: " + getNombre() + ". ";
        if (this.libroPrestado != null)
            cad += "Tiene en préstamo" + libroPrestado.toString() +  ".";
        else
            cad += "No tiene en préstamo un libro.";
        return cad;
    }

    /* MY CHANGES */
    public ArrayList<String> getGenerosFavoritos() {
        return generosFavoritos;
    }

    public void setNewGeneroFavorito(String genero) {
        generosFavoritos.add(genero);
    }

    public String getPreferenciaDeLectura() {
        return preferenciaDeLectura;
    }

    public void setPreferenciaDeLectura(String preferenciaDeLectura) {
        this.preferenciaDeLectura = preferenciaDeLectura;
    }

    public int getNumLibrosPrestados() {
        return librosPrestados;
    }

    public int getMaxLibrosPrestados() {
        return maxLibrosPrestados;
    }

    public Set<Prestamo> getHistorialPrestamos() {
        return Set.copyOf(historialPrestamos);
    }

    public boolean agregarPrestamo(Prestamo prestamo) {
        return historialPrestamos.add(prestamo);
    }
}