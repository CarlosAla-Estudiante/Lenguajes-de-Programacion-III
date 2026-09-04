package gestionreservas;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Gestor {

    private List<Reserva> reservas;

    public Gestor() {
        reservas = new ArrayList<>();
    }

    public boolean verificarDisponibilidad(
            Habitacion habitacion,
            LocalDateTime fechaInicio,
            LocalDateTime fechaFin) {

        for (Reserva reserva : reservas) {

            if (reserva.getHabitacion() == habitacion
                    && !reserva.isCancelada()) {

                if (fechaInicio.isBefore(reserva.getFechaCheckOut())
                        && fechaFin.isAfter(reserva.getFechaCheckIn())) {

                    return false;
                }
            }
        }

        return true;
    }

    public void agregarReserva(Reserva reserva) {

        reservas.add(reserva);
    }

    public void marcarReservada(Habitacion habitacion) {

        habitacion.setEstado("Reservada");
    }

    public void marcarDisponible(Habitacion habitacion) {

        habitacion.setEstado("Disponible");
    }

    public void mostrarReservas() {

        for (Reserva reserva : reservas) {

            System.out.println("Cliente: "
                    + reserva.getCliente().getNombre());

            System.out.println("Habitación: "
                    + reserva.getHabitacion().getNumero());

            System.out.println("Check-in: "
                    + reserva.getFechaCheckIn());

            System.out.println("Check-out: "
                    + reserva.getFechaCheckOut());

            System.out.println("Cancelada: "
                    + reserva.isCancelada());

            System.out.println("----------------------");
        }
    }
}