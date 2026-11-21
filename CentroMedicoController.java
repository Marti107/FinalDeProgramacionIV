package controller;
import java.util.ArrayList;

public class CentroMedicoController {
	private CentroMedico modelo;
	private CentroMedicoView vista;

    public CentroMedicoController(CentroMedico modelo, CentroMedicoView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        int opc = 0;
        do {
            this.vista.mostrarMenu();
            opc = this.vista.pedirEntero("Ingrese opcion: ");
            this.ejecutarOpcion(opc);
        } while (opc != 0);
    }

    private void ejecutarOpcion(int opc) {
        switch (opc) {
            case 1:
                
            case 0:
                this.vista.mostrarMensaje("Programa finalizado.");
                break;
            default:
                this.vista.mostrarMensaje("Opción no válida.");
                break;
        }
    }
    
    
}
