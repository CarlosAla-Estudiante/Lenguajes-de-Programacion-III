package numeros;

public class GestorNumeros {

    private Numero[] numeros;
    private int cantidad;

    public GestorNumeros(int capacidad) {
        numeros = new Numero[capacidad];
        cantidad = 0;
    }

    public void registrarNumero(double valor) {

        if (cantidad >= numeros.length) {
            System.out.println(
                "El arreglo esta lleno.");
            return;
        }

        numeros[cantidad] = new Numero(valor);
        cantidad++;

        System.out.println(
            "Numero registrado correctamente.");
    }

    public void mostrarNumero() {

        if (cantidad > 0) {
            System.out.println(
                "Valor almacenado: "
                + numeros[cantidad - 1].getValor());
        }
    }

    public void mostrarArreglo() {

        System.out.println(
            "\n=== ARREGLO FINAL ===");

        System.out.print("[ ");

        for (int i = 0; i < cantidad; i++) {

            System.out.print(
                numeros[i].getValor());

            if (i < cantidad - 1) {
                System.out.print(", ");
            }
        }

        System.out.println(" ]");
    }
}