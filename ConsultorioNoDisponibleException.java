package model.exceptions;

public class ConsultorioNoDisponibleException extends CentroMedicoException {
    public ConsultorioNoDisponibleException(String mensaje) {
        super(mensaje);
    }
}