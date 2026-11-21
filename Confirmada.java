package model.estados.reserva;

public class Confirmada extends EstadoReserva {
    public static final Confirmada INSTANCIA = new Confirmada();

    private Confirmada() {}

    @Override
    public boolean ocupaHorario() {
        return true;
    }
}