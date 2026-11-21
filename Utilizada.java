package model.estados.reserva;

public class Utilizada extends EstadoReserva {
    public static final Utilizada INSTANCIA = new Utilizada();

    private Utilizada() {}

    @Override
    public boolean ocupaHorario() {
        return true;
    }
}