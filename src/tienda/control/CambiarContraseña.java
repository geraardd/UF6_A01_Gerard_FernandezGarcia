package tienda.control;

import empleado.control.ControladorEmpleado;
import empleado.dominio.Empleado;
import java.util.Scanner;

public class CambiarContraseña {
    
    public static void CambiarContraseña() {

        Scanner entradaDatos = new Scanner(System.in);

        System.out.print("Introduce el codigo del empleado a modificar la contraseña: ");
        entradaDatos.next();

        System.out.print("Introduce la nueva contraseña del empleado: ");
        entradaDatos.next();
        System.out.println("-------------------------------------------------");
        System.out.println("");
        
        
    }
    
}
