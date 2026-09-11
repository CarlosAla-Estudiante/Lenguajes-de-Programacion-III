package Ejercicio01;

public class ExcepcionBlanco extends Exception {

    public ExcepcionBlanco() {
        super("Se ha introducido un espacio en blanco");
    }
}