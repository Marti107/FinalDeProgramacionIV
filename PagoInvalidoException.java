package model.exceptions;

public class PagoInvalidoException extends CentroMedicoException {
    public PagoInvalidoException(String mensaje) {
        super(mensaje);
    }
}