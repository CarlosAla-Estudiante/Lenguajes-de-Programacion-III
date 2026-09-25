package Laboratorio05;

public class PruebaPar {

    public static void main(String[] args) {

        Par<String, Integer> par1 = new Par<>("Juan", 20);
        Par<String, Integer> par2 = new Par<>("Juan", 20);
        Par<String, Integer> par3 = new Par<>("Pedro", 25);

        System.out.println("Par 1: " + par1);
        System.out.println("Par 2: " + par2);
        System.out.println("Par 3: " + par3);

        System.out.println("¿Par 1 es igual a Par 2? " + par1.esIgual(par2));

        System.out.println("¿Par 1 es igual a Par 3? " + par1.esIgual(par3));
    }
}
