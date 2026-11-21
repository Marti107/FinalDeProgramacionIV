package model;

public class CategoriaProfesional {
    private String nombre;
    private double porcentajeDescuento;

    public CategoriaProfesional(String nombre, double porcentajeDescuento) {
        this.nombre = nombre;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double calcularImporte(double importeBase) {
        return importeBase - (importeBase * porcentajeDescuento / 100);
    }

    public void modificarDescuento(double nuevoPorcentaje) {
        if (nuevoPorcentaje >= 0 && nuevoPorcentaje <= 100) {
            this.porcentajeDescuento = nuevoPorcentaje;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

}