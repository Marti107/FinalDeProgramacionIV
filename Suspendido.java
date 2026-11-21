package model.estados.profesional;

import model.exceptions.ProfesionalNoHabilitadoException;

public class Suspendido extends SituacionAdministrativa {
    public static final Suspendido INSTANCIA = new Suspendido();

    private Suspendido() {}

    @Override
    public void validarReserva() throws ProfesionalNoHabilitadoException {
        throw new ProfesionalNoHabilitadoException("El profesional se encuentra suspendido.");
    }

    @Override
    public boolean puedeReservar() {
        return false;
    }
}