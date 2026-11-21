package model.estados.profesional;

import model.exceptions.ProfesionalNoHabilitadoException;

public class Moroso extends SituacionAdministrativa {
    public static final Moroso INSTANCIA = new Moroso();

    private Moroso() {}

    @Override
    public void validarReserva() throws ProfesionalNoHabilitadoException {
        throw new ProfesionalNoHabilitadoException("El profesional se encuentra en situacion de mora.");
    }

    @Override
    public boolean puedeReservar() {
        return false;
    }
}