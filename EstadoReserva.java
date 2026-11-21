package model.estados.reserva;

import model.Reserva;
import model.exceptions.EstadoReservaInvalidoException;
import model.exceptions.PagoInvalidoException;
import model.pagos.MedioPago;

public abstract class EstadoReserva {
    public void registrarPago(Reserva r, double monto, MedioPago medio)
            throws EstadoReservaInvalidoException, PagoInvalidoException {
        throw new EstadoReservaInvalidoException("No se puede registrar un pago en el estado actual.");
    }

    public void cancelar(Reserva r, String origen) throws EstadoReservaInvalidoException {
        throw new EstadoReservaInvalidoException("No se puede cancelar la reserva en el estado actual.");
    }

    public void marcarUtilizada(Reserva r) throws EstadoReservaInvalidoException {
        throw new EstadoReservaInvalidoException("No se puede marcar como utilizada en el estado actual.");
    }

    public abstract boolean ocupaHorario();
}