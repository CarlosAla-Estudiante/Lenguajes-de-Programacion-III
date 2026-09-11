package Ejercicio05;

public class ValidadorEstudiante {

    public void validarNombre(String nombre) {

        if (nombre == null ||
            nombre.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "El nombre no puede ser nulo o vacio."
            );
        }
    }
}