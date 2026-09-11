package biblioteca;

public class Libro {

    private String titulo;

    public Libro(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void mostrarInformacion() {
        System.out.println("Libro: " + titulo);
    }
}