package Ejercicio02;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Calculadora calculadora = new Calculadora();
        Historial historial = new Historial();

        double resultado = 0;
        boolean tieneResultado = false;
        boolean salir = false;

        System.out.println("===== CALCULADORA =====");
        System.out.println("Ingrese un número para comenzar");
        System.out.println("Operadores: +  -  *  /");
        System.out.println("c = limpiar");
        System.out.println("h = historial");
        System.out.println("q = salir");
        System.out.println();

        while (!salir) {

            if (tieneResultado) {
                System.out.print("> " + resultado);
            } else {
                System.out.print("> ");
            }

            String entrada =
                    teclado.nextLine().trim();

            try {

                if (entrada.equalsIgnoreCase("q")) {

                    salir = true;

                    System.out.println();
                    System.out.println(
                            "Programa finalizado");

                    continue;
                }

                if (entrada.equalsIgnoreCase("c")) {

                    resultado = 0;
                    tieneResultado = false;

                    historial.limpiar();

                    System.out.println();
                    System.out.println(
                            "Calculadora limpiada");

                    continue;
                }

                if (entrada.equalsIgnoreCase("h")) {

                    historial.mostrar();

                    continue;
                }

                if (entrada.isEmpty()) {

                    throw new IllegalArgumentException(
                            "No se ha introducido ninguna operación");
                }

                if (!tieneResultado) {

                    try {

                        resultado =
                                Double.parseDouble(entrada);

                    } catch (NumberFormatException e) {

                        throw new IllegalArgumentException(
                                "Debe introducir un número válido");
                    }

                    tieneResultado = true;

                    historial.agregar(
                            String.valueOf(resultado));

                    continue;
                }

                char operador =
                        entrada.charAt(0);

                if (operador != '+' &&
                    operador != '-' &&
                    operador != '*' &&
                    operador != '/') {

                    throw new IllegalArgumentException(
                            "Operador no válido.");
                }

                if (entrada.length() == 1) {

                    throw new IllegalArgumentException(
                            "Falta número después del operador");
                }

                String numeroTexto =
                        entrada.substring(1);

                double numero;

                try {

                    numero =
                            Double.parseDouble(numeroTexto);

                } catch (NumberFormatException e) {

                    throw new IllegalArgumentException(
                            "Número no válido.");
                }

                double resultadoAnterior =
                        resultado;

                switch (operador) {

                    case '+':

                        resultado =
                                calculadora.sumar(
                                        resultado,
                                        numero);

                        break;

                    case '-':

                        resultado =
                                calculadora.restar(
                                        resultado,
                                        numero);

                        break;

                    case '*':

                        resultado =
                                calculadora.multiplicar(
                                        resultado,
                                        numero);

                        break;

                    case '/':

                        resultado =
                                calculadora.dividir(
                                        resultado,
                                        numero);

                        break;
                }

                historial.agregar(
                        resultadoAnterior
                        + String.valueOf(operador)
                        + numero
                        + "="
                        + resultado);

            } catch (IllegalArgumentException e) {

                System.out.println();
                System.out.println(
                        "Error: "
                        + e.getMessage());

            } catch (ArithmeticException e) {

                System.out.println();
                System.out.println(
                        "Error aritmético: "
                        + e.getMessage());
            }
        }

        teclado.close();
    }
}