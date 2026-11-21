package model.estados.reserva;

public class Cancelada extends EstadoReserva {
    private String canceladaPor;

    public Cancelada(String canceladaPor) {
        this.canceladaPor = canceladaPor;
    }

    public String getCanceladaPor() {
        return canceladaPor;
    }

    @Override
    public boolean ocupaHorario() {
        return false;
    }
}