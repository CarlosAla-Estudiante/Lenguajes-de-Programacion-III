package biblioteca;

public class Biblioteca {

    private Libro[] libros;
    private int cantidad;

    public Biblioteca(int capacidad) {
        libros = new Libro[capacidad];
        cantidad = 0;
    }

    public void agregarLibro(Libro libro) {

        if (libro == null ||
            libro.getTitulo() == null ||
            libro.getTitulo().trim().isEmpty()) {

            throw new IllegalArgumentException(
                "El titulo no puede ser nulo o vacio.");
        }

        if (cantidad >= libros.length) {
            throw new IllegalArgumentException(
                "La biblioteca esta llena.");
        }

        libros[cantidad] = libro;
        cantidad++;
    }

    public Libro[] getLibros() {
        return libros;
    }

    public int getCantidad() {
        return cantidad;
    }
}