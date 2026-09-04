package gestionreservas;

import java.time.LocalDateTime;

public class Control {

    private Gestor gestor;

    public Control(Gestor gestor) {

        this.gestor = gestor;
    }

    public Reserva crearReserva(
            Habitacion habitacion,
            Cliente cliente,
            LocalDateTime fechaCheckIn,
            LocalDateTime fechaCheckOut,
            double precio,
            PoliticaCancelacion politica) {

        boolean disponible =
                gestor.verificarDisponibilidad(
                        habitacion,
                        fechaCheckIn,
                        fechaCheckOut
                );

        if (!disponible) {

            System.out.println(
                    "La habitación no está disponible."
            );

            return null;
        }

        Reserva reserva =
                new Reserva(
                        habitacion,
                        cliente,
                        fechaCheckIn,
                        fechaCheckOut,
                        precio,
                        politica
                );

        gestor.agregarReserva(reserva);

        gestor.marcarReservada(habitacion);

        System.out.println(
                "Reserva creada correctamente."
        );

        return reserva;
    }

    public void cancelarReserva(Reserva reserva) {

        if (reserva == null) {

            System.out.println(
                    "No existe una reserva para cancelar."
            );

            return;
        }

        System.out.println(
                "Intentando cancelar reserva..."
        );

        boolean cancelada =
                reserva.cancelar();

        if (cancelada) {

            gestor.marcarDisponible(
                    reserva.getHabitacion()
            );
        }
    }
}