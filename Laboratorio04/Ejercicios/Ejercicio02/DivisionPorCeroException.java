package Ejercicio02;

public class DivisionPorCeroException
        extends ArithmeticException {

    public DivisionPorCeroException() {
        super("No se puede dividir por cero.");
    }

}