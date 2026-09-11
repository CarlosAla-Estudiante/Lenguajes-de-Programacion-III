package Ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class Historial {

    private List<String> operaciones;

    public Historial() {
        operaciones = new ArrayList<>();
    }

    public void agregar(String operacion) {
        operaciones.add(operacion);
    }

    public void limpiar() {
        operaciones.clear();
    }

    public void mostrar() {

        System.out.println("\n===== HISTORIAL =====");

        if (operaciones.isEmpty()) {
            System.out.println("No hay operaciones.");
            return;
        }

        for (String operacion : operaciones) {
            System.out.println(operacion);
        }
    }
}