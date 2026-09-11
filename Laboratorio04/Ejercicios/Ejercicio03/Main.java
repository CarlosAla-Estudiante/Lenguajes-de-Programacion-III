package biblioteca;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca =
                new Biblioteca(5);

        BuscadorLibros buscador =
                new BuscadorLibros();

        System.out.println("=== BIBLIOTECA ===");

        for (int i = 0; i < 3; i++) {

            System.out.print(
                "Ingrese el titulo del libro "
                + (i + 1) + ": ");

            String titulo = scanner.nextLine();

            try {

                biblioteca.agregarLibro(
                    new Libro(titulo));

                System.out.println(
                    "Libro agregado correctamente.");

            } catch (IllegalArgumentException e) {

                System.out.println(
                    "Error: " + e.getMessage());
            }
        }

        System.out.println(
            "\n=== BUSCAR LIBRO ===");

        System.out.print(
            "Ingrese el titulo que desea buscar: ");

        String tituloBusqueda =
                scanner.nextLine();

        try {

            Libro libro =
                    buscador.buscarLibro(
                        biblioteca,
                        tituloBusqueda);

            System.out.println(
                "Libro encontrado:");

            libro.mostrarInformacion();

        } catch (NoSuchElementException e) {

            System.out.println(
                "Error: " + e.getMessage());
        }

        scanner.close();
    }
}