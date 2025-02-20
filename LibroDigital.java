
public class LibroDigital extends Libro {
    private String formato;  
    private double tamanoMB;
    private String urlDescarga;
    private int descargasPermitidas;
    private int descargasActuales;

    public LibroDigital(String titulo, String autor, String isbn, int numPaginas, 
                       String formato, double tamanoMB, String urlDescarga) {
        super(titulo, autor, isbn, numPaginas);
        this.formato = formato;
        this.tamanoMB = tamanoMB;
        this.urlDescarga = urlDescarga;
        this.descargasPermitidas = 3;
        this.descargasActuales = 0;
    }
    
    public LibroDigital(Libro libro, String formato, double tamanoMB, String urlDescarga) {
        super(libro);
        this.formato = formato;
        this.tamanoMB = tamanoMB;
        this.urlDescarga = urlDescarga;
        this.descargasPermitidas = 3;
        this.descargasActuales = 0;
    }
    
    public String getFormato() { 
        return formato; 
    }

    public double getTamanoMB() { 
        return tamanoMB; 
    
    }

    public String getUrlDescarga() {
        return urlDescarga; 
    }

    public int getDescargasPermitidas() { 
        return descargasPermitidas; 
    }

    public int getDescargasActuales() { 
        return descargasActuales; 
    }

    public boolean descargar() {
        if (descargasActuales < descargasPermitidas) {
            descargasActuales++;
            return true;
        }
        return false;
    }

    public void reiniciarDescargas() {
        descargasActuales = 0;
    }

    public boolean prestarLibro() {
        if (descargasActuales < descargasPermitidas) {
            return super.prestarLibro();
        }
        return false;
    }

    public String toString() {
        return super.toString() + 
               "\nFormato: " + formato +
               "\nTamaño: " + tamanoMB + " MB" +
               "\nURL de descarga: " + urlDescarga +
               "\nDescargas realizadas: " + descargasActuales + "/" + descargasPermitidas;
    }

}