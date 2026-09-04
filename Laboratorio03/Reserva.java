package gestionreservas;

import java.time.LocalDateTime;

public class Reserva {

    private Habitacion habitacion;
    private Cliente cliente;

    private LocalDateTime fechaCheckIn;
    private LocalDateTime fechaCheckOut;

    private double precioTotal;

    private PoliticaCancelacion politicaCancelacion;

    private boolean cancelada;

    public Reserva(
            Habitacion habitacion,
            Cliente cliente,
            LocalDateTime fechaCheckIn,
            LocalDateTime fechaCheckOut,
            double precioTotal,
            PoliticaCancelacion politicaCancelacion) {

        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
        this.precioTotal = precioTotal;
        this.politicaCancelacion = politicaCancelacion;
        this.cancelada = false;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getFechaCheckIn() {
        return fechaCheckIn;
    }

    public LocalDateTime getFechaCheckOut() {
        return fechaCheckOut;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public PoliticaCancelacion getPoliticaCancelacion() {
        return politicaCancelacion;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public boolean cancelar() {

        if (politicaCancelacion.puedeCancelar(this)) {

            double penalizacion =
                    politicaCancelacion.calcularPenalizacion(this);

            cancelada = true;

            System.out.println(
                    "Reserva cancelada correctamente."
            );

            System.out.println(
                    "Penalización: S/ "
                    + penalizacion
            );

            return true;

        } else {

            System.out.println(
                    "La reserva no puede ser cancelada."
            );

            return false;
        }
    }
}