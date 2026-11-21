package model.estados.consultorio;

import model.exceptions.ConsultorioNoDisponibleException;

public class Inhabilitado extends EstadoConsultorio {
    public static final Inhabilitado INSTANCIA = new Inhabilitado();

    private Inhabilitado() {}

    @Override
    public void validarDisponibilidad() throws ConsultorioNoDisponibleException {
        throw new ConsultorioNoDisponibleException("El consultorio se encuentra inhabilitado.");
    }
}