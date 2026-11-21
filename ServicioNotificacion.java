package model.notificaciones;

import model.Reserva;

public interface ServicioNotificacion {
    void enviarDetalleReserva(Reserva reserva);
}