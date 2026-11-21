package model.exceptions;

public abstract class CentroMedicoException extends Exception {
    public CentroMedicoException(String mensaje) {
        super(mensaje);
    }
}