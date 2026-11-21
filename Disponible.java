package model.estados.consultorio;

public class Disponible extends EstadoConsultorio {
    public static final Disponible INSTANCIA = new Disponible();

    private Disponible() {}

    @Override
    public void validarDisponibilidad() {
        // Disponible para reservar
    }
}