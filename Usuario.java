/**
 * Clase Usuario - Representa un usuario del sistema de biblioteca
 * 
 * Esta clase maneja las operaciones relacionadas con los usuarios de la biblioteca,
 * incluyendo el préstamo y devolución de libros.
 * 
 * @author Roberto SALAZAR MARQUEZ
 * @version 1.0
 */

public class Usuario extends Persona {
    private Libro libroPrestado;
    
    /**
     * Constructor para objetos de la clase Usuario
     * 
     * @param id El identificador único del usuario
     * @param nombre El nombre completo del usuario
     */
    public Usuario(String nombre, String id) {
        super(nombre, id);
        this.libroPrestado = null;
    }
    
    /**
     * Constructor para objetos de la clase Usuario
     * 
     * @param otro Manejador al objeto  usuario
     */
    public Usuario(Usuario usuario) {
        super(usuario.getNombre(), usuario.getId());
        this.libroPrestado = usuario.getLibrosPrestados();
    }
    
    
    /**
     * Solicita el préstamo de un libro
     * 
     * @param libro El libro que se desea pedir prestado
     * @return true si el préstamo fue exitoso, false en caso contrario
     */
    public boolean solicitarPrestamo(Libro libro) {
        if (!libro.isPrestado()) {
            if (libro.prestarLibro()) {
                libroPrestado = libro;
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * Devuelve el libro actualmente prestado
     * 
     * @return true si la devolución fue exitosa, false si no hay libro prestado
     */
    public boolean devolverLibro() {    
        if (libroPrestado != null) {
            libroPrestado.devolverLibro();
            libroPrestado = null;
            return true;
        }
        return false;
    }
    
    /**
     * Obtiene una copia del libro prestado actualmente
     * 
     * @return Una copia del libro prestado o null si no hay préstamos activos
     */
    public Libro getLibrosPrestados() {
        if(libroPrestado != null)
            return new Libro(libroPrestado); // Retorna una copia de la lista
        else
            return null;
    }
    
    /**
     * Retorna el tipo específico de esta clase.
     * Este método sobreescribe el método obtenerTipo() de la clase padre Persona
     * para proporcionar una identificación específica para los objetos Usuario.
     * 
     * @return "Usuario" - Una cadena que identifica esta clase como tipo Usuario
     */
    public String obtenerTipo() {
        return "Usuario";
    }
    
    /**
     * Genera una representación en texto del usuario
     * 
     * @return String con la información del usuario y su préstamo actual
     */
    public String toString() {
        String cad = "ID: " + getId() + ", " + "Nombre: " + getNombre() + ". ";
        if (this.libroPrestado != null)
            cad += "Tiene en préstamo" + libroPrestado.toString() +  ".";
        else
            cad += "No tiene en préstamo un libro.";
        return cad;
    }
}