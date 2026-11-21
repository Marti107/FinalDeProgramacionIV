package model.estados.consultorio;

import model.exceptions.ConsultorioNoDisponibleException;

public class EnMantenimiento extends EstadoConsultorio {
    public static final EnMantenimiento INSTANCIA = new EnMantenimiento();

    private EnMantenimiento() {}

    @Override
    public void validarDisponibilidad() throws ConsultorioNoDisponibleException {
        throw new ConsultorioNoDisponibleException("El consultorio se encuentra en mantenimiento.");
    }
}