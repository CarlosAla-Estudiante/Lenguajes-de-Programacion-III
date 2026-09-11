package Ejercicio01;

import java.io.IOException;

public class Aplicacion {

    private LeerEntrada entrada;

    public Aplicacion() {
        entrada = new LeerEntrada(System.in);
    }

    public void procesar()
            throws ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida, IOException {

        char caracter = entrada.getChar();

        if (caracter == '\n' || caracter == '\r') {
            return;
        }

        if (caracter == 'q' || caracter == 'Q') {
            throw new ExcepcionSalida();
        }

        if ("aeiouAEIOUáéíóúÁÉÍÓÚ".indexOf(caracter) >= 0) {
            throw new ExcepcionVocal();
        }

        if (Character.isDigit(caracter)) {
            throw new ExcepcionNumero();
        }

        if (caracter == ' ') {
            throw new ExcepcionBlanco();
        }

        System.out.println("Caracter correcto: " + caracter);
    }

    
    public static void main(String[] args) {

        Aplicacion aplicacion = new Aplicacion();

        boolean continuar = true;

        while (continuar) {

            try {
                aplicacion.procesar();

            } catch (ExcepcionVocal e) {

                System.out.println(e.getMessage());

            } catch (ExcepcionNumero e) {

                System.out.println(e.getMessage());

            } catch (ExcepcionBlanco e) {

                System.out.println(e.getMessage());

            } catch (ExcepcionSalida e) {

                System.out.println(e.getMessage());
                continuar = false;

            } catch (IOException e) {

                System.out.println("Error al leer el caracter");
                continuar = false;
            }
        }
        System.out.println("Programa terminado");
    }
}