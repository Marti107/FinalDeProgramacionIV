package model;

import model.estados.profesional.SituacionAdministrativa;

import java.util.ArrayList;

public class Profesional {
    private int matricula;
    private String nombre;
    private String apellido;
    private String documento;
    private String telefono;
    private String correoElectronico;
    private Fecha fechaAdhesion;

    private SituacionAdministrativa situacionAdministrativa;
    private CategoriaProfesional categoriaProfesional;

    private ArrayList<Reserva> reservas;

    public Profesional(int matricula, String nombre, String apellido, String documento, String telefono, String correoElectronico, Fecha fechaAdhesion, SituacionAdministrativa situacionAdministrativa, CategoriaProfesional categoriaProfesional) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.fechaAdhesion = fechaAdhesion;
        this.situacionAdministrativa = situacionAdministrativa;
        this.categoriaProfesional = categoriaProfesional;
        this.reservas = new ArrayList<>();
    }

    public boolean validarReserva() {
        return situacionAdministrativa.puedeReservar();

    }

    public double calcularDescuento(double importeBase) {
        return categoriaProfesional.calcularImporte(importeBase);
    }

    public void agregarReserva(Reserva reserva) {

        if (reserva != null) {
            reservas.add(reserva);
        }
    }

    public void cambiarSituacion(SituacionAdministrativa nuevaSituacion) {

        if (nuevaSituacion != null) {
            this.situacionAdministrativa = nuevaSituacion;
        }
    }

    public int getMatricula() {
        return matricula;
    }
}