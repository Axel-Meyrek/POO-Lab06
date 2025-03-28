import java.util.ArrayList;

public class Libro {
   private String titulo;
   private String autor;
   private String isbn;
   private int numPaginas;
   private boolean prestado;
   private String estadoFisico;
   private ArrayList <String> mantenimientos;
   private ArrayList <String> registroDeDaños;
   private int contadorPrestamos = 0;
   
    public Libro() {
        this.titulo = "Sin título";
        this.autor = "Desconocido";
        this.isbn = "0000000000000";
        this.numPaginas = 0;
        this.prestado = false;
        this.mantenimientos = new ArrayList<>();
        this.registroDeDaños = new ArrayList<>();
    }   
    
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = "0000000000000";
        this.numPaginas = 0;
        this.prestado = false;
        this.mantenimientos = new ArrayList<>();
        this.registroDeDaños = new ArrayList<>();
    }

    public Libro(String titulo, String autor, String isbn, int numPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.numPaginas = numPaginas;
        this.prestado = false;
        this.mantenimientos = new ArrayList<>();
        this.registroDeDaños = new ArrayList<>();
    }

    public Libro(Libro otroLibro) {
        this.titulo = otroLibro.titulo;
        this.autor = otroLibro.autor;
        this.isbn = otroLibro.isbn;
        this.numPaginas = otroLibro.numPaginas;
        this.prestado = false;
        this.mantenimientos = new ArrayList<>(otroLibro.mantenimientos);
        this.registroDeDaños = new ArrayList<>(otroLibro.registroDeDaños);
    }

    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.trim().isEmpty()) {
            this.titulo = titulo;
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor != null && !autor.trim().isEmpty()) {
            this.autor = autor;
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn != null && isbn.matches("\\d{13}")) {
            this.isbn = isbn;
        }
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        if (numPaginas > 0) {
            this.numPaginas = numPaginas;
        }
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public boolean prestarLibro() {
        if (!prestado) {
            prestado = true;
            return true;
        }
        return false;
    }

    public void devolverLibro() {
        prestado = false;
    }

    public String toString() {
        return "Libro: " + titulo + " por " + autor + 
               "\nISBN: " + isbn + 
               "\nPáginas: " + numPaginas +
               "\nEstado: " + (prestado ? "Prestado" : "Disponible");
    }

    /* MY CHANGES */
    public boolean verificarDisponibilidad() {
        return !prestado;
    }

    public String getEstadoFisico() {
        return estadoFisico;
    }

    public void changeEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
    }

    public ArrayList <String> getMantenimiento() {
        return mantenimientos;
    }

    public ArrayList <String> getRegistroDeDaños() {
        return registroDeDaños;
    }

    public void setNewDano(String daño) {
        registroDeDaños.add(daño);
    }

    public void setNewMantenimiento(String mantenimiento) {
        mantenimientos.add(mantenimiento);
    }

    public void incrementarPrestamos() {
        contadorPrestamos++;
    }
    
    public int getContadorPrestamos() {
        return contadorPrestamos;
    }
}