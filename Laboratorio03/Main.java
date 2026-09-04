package gestionreservas;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // ==========================================
        // 1. CREAR GESTOR
        // ==========================================

        Gestor gestor = new Gestor();


        // ==========================================
        // 2. CREAR CONTROL
        // ==========================================

        Control control = new Control(gestor);


        // ==========================================
        // 3. CREAR HABITACIÓN
        // ==========================================

        Habitacion habitacion =
                new Habitacion(
                        101,
                        "Matrimonial",
                        200.00
                );


        // Asociar gestor a la habitación
        habitacion.setGestorDisponibilidad(gestor);


        // ==========================================
        // 4. CREAR CLIENTE
        // ==========================================

        Cliente cliente =
                new Cliente(
                        1,
                        "Carlos",
                        "12345678"
                );


        // ==========================================
        // 5. CREAR FECHAS
        // ==========================================

        LocalDateTime checkIn =
                LocalDateTime.now().plusDays(5);

        LocalDateTime checkOut =
                LocalDateTime.now().plusDays(7);


        // ==========================================
        // 6. SELECCIONAR POLÍTICA
        // ==========================================

        PoliticaCancelacion politica =
                new PoliticaCancelacionFlexible();


        // ==========================================
        // 7. CREAR RESERVA
        // ==========================================

        Reserva reserva =
                control.crearReserva(
                        habitacion,
                        cliente,
                        checkIn,
                        checkOut,
                        400.00,
                        politica
                );


        // ==========================================
        // 8. MOSTRAR INFORMACIÓN
        // ==========================================

        if (reserva != null) {

            System.out.println();
            System.out.println(
                    "===== INFORMACIÓN DE LA RESERVA ====="
            );

            System.out.println(
                    "Cliente: "
                    + reserva.getCliente().getNombre()
            );

            System.out.println(
                    "Habitación: "
                    + reserva.getHabitacion().getNumero()
            );

            System.out.println(
                    "Check-in: "
                    + reserva.getFechaCheckIn()
            );

            System.out.println(
                    "Check-out: "
                    + reserva.getFechaCheckOut()
            );

            System.out.println(
                    "Precio: S/ "
                    + reserva.getPrecioTotal()
            );

            System.out.println(
                    "Política: "
                    + reserva.getPoliticaCancelacion()
                            .getClass()
                            .getSimpleName()
            );


            // ==========================================
            // 9. CANCELAR
            // ==========================================

            System.out.println();
            System.out.println(
                    "===== CANCELACIÓN ====="
            );

            control.cancelarReserva(reserva);


            // ==========================================
            // 10. ESTADO HABITACIÓN
            // ==========================================

            System.out.println();

            System.out.println(
                    "Estado de la habitación "
            		+ reserva.getHabitacion().getNumero()
            		+ ": "
                    + habitacion.getEstado()
            );
        }
    }
}