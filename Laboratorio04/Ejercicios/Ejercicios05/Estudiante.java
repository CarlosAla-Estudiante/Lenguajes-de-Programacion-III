package Ejercicio05;

public class Estudiante {

    private String nombre;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarInformacion() {
        System.out.println(
                "Estudiante: " + nombre
        );
    }
}