package app;

public class Main {
    public static void main(String[] args) {
        // Punto de entrada del sistema
    	CentroMedicoView vista = new CentroMedicoView();

        vista.mostrarMensaje("Configuración Inicial de los Consultorios");
        CentroMedico modelo = new CentroMedico();
        CentroMedicoController controlador = new CentroMedicoController(modelo, vista);

        controlador.iniciar();
    }
}
