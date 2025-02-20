
public abstract class Persona {
    private String nombre;
    private String id;
    private String email;
    private String telefono;

    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.email = "usuario@servidor.com";
        this.telefono = "0000000000";
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return new String(this.email);
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return new String(this.telefono);
    }

    public String toString() {
        return "Nombre: " + nombre + " ID: " + id + "\nEmail: " + email + "\nTeléfono: " + telefono + "\nTipo: " + obtenerTipo();
    }

    public abstract String obtenerTipo();
    
}