package Ejercicio05;

import java.util.NoSuchElementException;

public class BuscadorEstudiantes {

    public Estudiante buscar(
            Estudiante[] estudiantes,
            int cantidad,
            String nombre) {

        for (int i = 0; i < cantidad; i++) {

            if (estudiantes[i]
                    .getNombre()
                    .equalsIgnoreCase(nombre)) {

                return estudiantes[i];
            }
        }

        throw new NoSuchElementException(
                "El estudiante no se encuentra en el registro."
        );
    }
}