package biblioteca;

import java.util.NoSuchElementException;

public class BuscadorLibros {

    public Libro buscarLibro(Biblioteca biblioteca,
                             String titulo) {

        for (int i = 0;
             i < biblioteca.getCantidad();
             i++) {

            Libro libro =
                    biblioteca.getLibros()[i];

            if (libro.getTitulo()
                    .equalsIgnoreCase(titulo)) {

                return libro;
            }
        }

        throw new NoSuchElementException(
            "El libro no se encuentra en la biblioteca.");
    }
}