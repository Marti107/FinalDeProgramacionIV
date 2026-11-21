package model.estados.consultorio;

import model.exceptions.ConsultorioNoDisponibleException;

public abstract class EstadoConsultorio {
    public abstract void validarDisponibilidad() throws ConsultorioNoDisponibleException;
}