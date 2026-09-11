package Ejercicio02;

public class Division implements Operacion {

    @Override
    public double calcular(double a, double b) {

        if (b == 0) {
            throw new DivisionPorCeroException();
        }

        return a / b;
    }

}