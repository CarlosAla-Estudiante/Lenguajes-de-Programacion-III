package Ejercicio02;

public class Calculadora {

    public double sumar(double a, double b) {

        Operacion operacion = new Suma();

        return operacion.calcular(a, b);
    }

    public double restar(double a, double b) {

        Operacion operacion = new Resta();

        return operacion.calcular(a, b);
    }

    public double multiplicar(double a, double b) {

        Operacion operacion = new Multiplicacion();

        return operacion.calcular(a, b);
    }

    public double dividir(double a, double b) {

        Operacion operacion = new Division();

        return operacion.calcular(a, b);
    }

}