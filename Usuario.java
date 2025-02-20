import java.util.Vector;

public class Usuario extends Persona {
    private Libro libroPrestado;
    private Vector <String> generosFavoritos;
    private String preferenciaDeLectura;
    private int librosPrestados;
    private int maxLibrosPrestados;
    
    public Usuario(String nombre, String id) {
        super(nombre, id);
        this.libroPrestado = null;
        librosPrestados = 0;
    }
    
    public Usuario(Usuario usuario) {
        super(usuario.getNombre(), usuario.getId());
        this.libroPrestado = usuario.getLibrosPrestados();
        this.librosPrestados = usuario.getNumLibrosPrestados();
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
        if(libroPrestado != null)
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

    /* CHANGES */
    public Vector<String> getGenerosFavoritos() {
        return generosFavoritos;
    }

    public void setNewGeneroFavorito (String genero) {
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
}