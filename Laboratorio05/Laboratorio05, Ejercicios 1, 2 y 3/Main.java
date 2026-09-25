package Laboratorio05;

public class Main {

    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {

        Par<String, Integer> par1 = new Par<>("Edad", 20);

        Par<Double, Boolean> par2 = new Par<>(15.5, true);

        Persona persona = new Persona("Ana", 25);
        Par<Persona, Integer> par3 = new Par<>(persona, 100);

        imprimirPar(par1);
        imprimirPar(par2);
        imprimirPar(par3);
    }
}
