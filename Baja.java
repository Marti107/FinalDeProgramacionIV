package model.estados.profesional;

import model.exceptions.ProfesionalNoHabilitadoException;

public class Baja extends SituacionAdministrativa {
    public static final Baja INSTANCIA = new Baja();

    private Baja() {}

    @Override
    public void validarReserva() throws ProfesionalNoHabilitadoException {
        throw new ProfesionalNoHabilitadoException("El profesional se encuentra dado de baja.");
    }

    @Override
    public boolean puedeReservar() {
        return false;
    }
}