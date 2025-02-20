
public class Usuario extends Persona {
    private Libro libroPrestado;
    

    
    public Usuario(String nombre, String id) {
        super(nombre, id);
        this.libroPrestado = null;
    }
    
    public Usuario(Usuario usuario) {
        super(usuario.getNombre(), usuario.getId());
        this.libroPrestado = usuario.getLibrosPrestados();
    }
    
    public boolean solicitarPrestamo(Libro libro) {
        if (!libro.isPrestado()) {
            if (libro.prestarLibro()) {
                libroPrestado = libro;
                return true;
            }
        }
        return false;
    }
    
    public boolean devolverLibro() {    
        if (libroPrestado != null) {
            libroPrestado.devolverLibro();
            libroPrestado = null;
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

}