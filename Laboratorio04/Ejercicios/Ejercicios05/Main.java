package Ejercicio05;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        RegistroEstudiantes registro =
                new RegistroEstudiantes(10);

        boolean salir = false;

        System.out.println(
                "===== REGISTRO DE ESTUDIANTES ====="
        );

        System.out.println(
                "Ingrese los nombres de los estudiantes."
        );

        System.out.println(
                "Ingrese q para terminar el registro."
        );

        while (!salir) {

            System.out.print(
                    "\nNombre: "
            );

            String nombre =
                    teclado.nextLine();

            if (nombre.equalsIgnoreCase("q")) {

                salir = true;

                continue;
            }

            try {

                Estudiante estudiante =
                        new Estudiante(nombre);

                registro.agregarEstudiante(
                        estudiante
                );

            } catch (IllegalArgumentException e) {

                System.out.println(
                        "Error: "
                        + e.getMessage()
                );
            }
        }

        registro.mostrarEstudiantes();

        System.out.println(
                "\n===== BUSCAR ESTUDIANTE ====="
        );

        System.out.print(
                "Ingrese el nombre que desea buscar: "
        );

        String nombreBusqueda =
                teclado.nextLine();

        try {

            Estudiante estudiante =
                    registro.buscarEstudiante(
                            nombreBusqueda
                    );

            System.out.println(
                    "\nEstudiante encontrado:"
            );

            estudiante.mostrarInformacion();

        } catch (NoSuchElementException e) {

            System.out.println(
                    "Error: "
                    + e.getMessage()
            );
        }

        teclado.close();
    }
}