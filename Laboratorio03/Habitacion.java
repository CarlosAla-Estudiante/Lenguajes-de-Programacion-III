package gestionreservas;

import java.time.LocalDateTime;

public class Habitacion {

    private int numero;
    private String tipo;
    private double precio;
    private String estado;

    private Gestor gestorDisponibilidad;

    public Habitacion(
            int numero,
            String tipo,
            double precio) {

        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = "Disponible";
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setGestorDisponibilidad(
            Gestor gestorDisponibilidad) {

        this.gestorDisponibilidad =
                gestorDisponibilidad;
    }

    public boolean estaDisponible(
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin) {

        return gestorDisponibilidad.verificarDisponibilidad(
                this,
                fechaInicio,
                fechaFin
        );
    }
}