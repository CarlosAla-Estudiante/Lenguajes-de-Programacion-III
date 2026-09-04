package gestionreservas;

public class Cliente {

    private int id;
    private String nombre;
    private String documento;

    public Cliente(int id, String nombre, String documento) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void mostrarInformacion() {

        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Documento: " + documento);
    }
}