package model.estados.profesional;

import model.exceptions.ProfesionalNoHabilitadoException;

public abstract class SituacionAdministrativa {
    public abstract void validarReserva() throws ProfesionalNoHabilitadoException;

    public abstract boolean puedeReservar();
}