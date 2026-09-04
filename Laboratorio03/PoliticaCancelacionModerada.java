package gestionreservas;

import java.time.LocalDateTime;
import java.time.Duration;

public class PoliticaCancelacionModerada
        implements PoliticaCancelacion {

    @Override
    public boolean puedeCancelar(Reserva reserva) {

        LocalDateTime ahora = LocalDateTime.now();

        long horas = Duration.between(
                ahora,
                reserva.getFechaCheckIn()
        ).toHours();

        return horas >= 72;
    }

    @Override
    public double calcularPenalizacion(Reserva reserva) {

        return reserva.getPrecioTotal() * 0.50;
    }
}