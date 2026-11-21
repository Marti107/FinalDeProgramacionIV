package model.estados.reserva;

public class PagoParcial extends EstadoReserva {
    public static final PagoParcial INSTANCIA = new PagoParcial();

    private PagoParcial() {}

    @Override
    public boolean ocupaHorario() {
        return true;
    }
}