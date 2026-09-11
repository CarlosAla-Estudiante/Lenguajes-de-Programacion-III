package numeros;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GestorNumeros gestor =
                new GestorNumeros(10);

        System.out.println(
            "=== GESTION DE NUMEROS ===");

        while (true) {

            System.out.print(
                "\nIngrese un numero "
                + "(q para salir): ");

            String entrada = scanner.nextLine();

            if (entrada.equalsIgnoreCase("q")) {

                gestor.mostrarArreglo();

                System.out.println(
                    "Programa finalizado.");

                break;
            }

            try {

                double valor =
                        Double.parseDouble(entrada);

                gestor.registrarNumero(valor);

                gestor.mostrarNumero();

            } catch (NumberFormatException e) {

                System.out.println(
                    "Error: debe ingresar un numero valido.");

            } catch (IllegalArgumentException e) {

                System.out.println(
                    "Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}