
public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Av. Principal #123");
        //biblioteca.setEmpleado("José Iturbide", "EMP001", 1000.00, "Bibliotecario",Empleado.MATUTINO);
        
        // Crear algunos libros
        Libro libro1 = new Libro("El Principito", "Antoine de Saint-Exupéry", "978-0156012195", 96);
        Libro libro2 = new Libro("Don Quijote", "Miguel de Cervantes", "978-8424922498", 863);
        
        // Crear usuarios
        Usuario usuario1 = new Usuario("María López", "U001");
        Usuario usuario2 = new Usuario("Carlos Ruiz", "U002");
        
        // Demostrar el proceso de préstamo
        System.out.println("=== Iniciando proceso de préstamo ===");
        biblioteca.setLibro(libro1);
        biblioteca.setUsuario(usuario1);
        
        if (biblioteca.prestarLibro()) {
            System.out.println("Préstamo realizado con éxito:");
            System.out.println("Libro: " + libro1.getTitulo());
            System.out.println("Usuario: " + usuario1.getNombre());
        } else {
            System.out.println("No se pudo realizar el préstamo");
        }
        
        // Intentar prestar un libro ya prestado
        System.out.println("\n=== Intentando prestar libro no disponible ===");
        biblioteca.setLibro(libro1);
        biblioteca.setUsuario(usuario2);
        if (!biblioteca.prestarLibro()) {
            System.out.println("Préstamo denegado: Libro no disponible");
        }
        
        // Proceso de devolución
        System.out.println("\n=== Proceso de devolución ===");
        if (biblioteca.devolverLibro()) {
            System.out.println("Libro devuelto con éxito:");
            System.out.println("Libro: " + libro1.getTitulo());
            System.out.println("Estado: Disponible");
        }
        
        // Mostrar estado final de la biblioteca
        System.out.println("\n=== Estado de la Biblioteca ===");
        System.out.println(biblioteca.toString());
    }
}

