package model.estados.profesional;

public class Activo extends SituacionAdministrativa {
    public static final Activo INSTANCIA = new Activo();

    private Activo() {}

    @Override
    public void validarReserva() {
        // Profesional habilitado para reservar
    }

    @Override
    public boolean puedeReservar() {
        return true;
    }
}