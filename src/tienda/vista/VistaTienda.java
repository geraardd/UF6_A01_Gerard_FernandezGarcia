package tienda.vista;

import empleado.dominio.Empleado;
import java.util.Scanner;
import tienda.control.MenuPrincipal;
import tienda.control.MenuPrincipal;
import tienda.control.PrimerMenu;
import tienda.control.PrimerMenu;
import tienda.control.SegundoMenu;
import tienda.control.TercerMenu;
import util.Color;

public class VistaTienda {

    public static MenuPrincipal opcionDesdeMenuPrincipal() {
        borrarPantalla();
        System.out.println("--Menú principal -------------------");
        System.out.println("   1. Hacer pedido");
        System.out.println("   2. Modificar producto");
        System.out.println("   3. Cambiar contraseña de empleado");
        System.out.println("   4. Cerrar sesión");
        System.out.println("------------------------------------");

        int opcion = pedirOpcionEnRango(1, 4);

        MenuPrincipal menu = null;

        switch (opcion) {
            case 1:
                menu = MenuPrincipal.HACER_PEDIDO;
                break;
            case 2:
                menu = MenuPrincipal.MODIFICAR_PRODUCTO;
                break;
            case 3:
                menu = MenuPrincipal.CAMBIAR_PASSWORD;
                break;
            case 4:
                menu = MenuPrincipal.CERRAR_SESION;
                break;
        }

        return menu;

    }

    public static PrimerMenu opcionDesdePrimerMenu() {
        System.out.println("");
        System.out.println("--Hacer pedido -------------------");
        System.out.println("   1. Añadir producto a la cesta");
        System.out.println("   2. Visualizar precio total de la cesta");
        System.out.println("   3. Imprimir factura");
        System.out.println("   4. Terminar pedido");
        System.out.println("------------------------------------");

        int opcion = pedirOpcionEnRango(1, 4);

        PrimerMenu menu = null;

        switch (opcion) {
            case 1:
                menu = PrimerMenu.AÑADIR_PRODUCTO;
                break;
            case 2:
                menu = PrimerMenu.VISUALIZAR_PRECIO;
                break;
            case 3:
                menu = PrimerMenu.IMPRIMIR_FACTURA;
                break;
            case 4:
                menu = PrimerMenu.TERMINAR_PEDIDO;
                break;
        }

        return menu;

    }

    public static SegundoMenu opcionDesdeSegundoMenu() {
        System.out.println("");
        System.out.println("--Modificar un prodcuto -------------------");
        System.out.println("   1. Modificar nombre de producto");
        System.out.println("   2. Modificar precio de producto");
        System.out.println("   3. Modificar código de producto");
        System.out.println("------------------------------------");

        int opcion = pedirOpcionEnRango(1, 3);

        SegundoMenu menu = null;

        switch (opcion) {
            case 1:
                menu = SegundoMenu.MODIFICAR_NOMBRE_PRODUCTO;
                break;
            case 2:
                menu = SegundoMenu.MODIFICAR_PRECIO_PRODUCTO;
                break;
            case 3:
                menu = SegundoMenu.MODIFICAR_CODIGO_PRODUCTO;
                break;
        }

        return menu;

    }

    public static TercerMenu opcionDesdeTercerMenu() {
        System.out.println("");
        System.out.println("--Cambiar contraseña empleado -------------------");

        TercerMenu menu = null;

        menu = TercerMenu.CAMBIAR_CONTRASEÑA;

        return menu;

    }

    private static int pedirOpcionEnRango(int min, int max) {

        Scanner leerTeclado = new Scanner(System.in);
        int opcion = 0;
        boolean hayError = true;

        while (hayError) {
            System.out.print("Seleccione una opción: ");
            if (leerTeclado.hasNextInt()) {
                opcion = leerTeclado.nextInt();
                hayError = opcion < min || opcion > max;
                if (hayError) {
                    muestraMensaje("Error, opción no válida. Debe ser entre [" + min + "," + max + "]", Color.ERROR);
                }
            } else {
                muestraMensaje("Error, opción no válida. Debe ser entre [" + min + "," + max + "]", Color.ERROR);
                leerTeclado.next();
            }
        }

        return opcion;
    }

    public static void mensajeBienvenida(Empleado empleado) {
        muestraMensaje("Bienvenido " + empleado.getNombre());
        System.out.println();
    }

    public static void muestraMensaje(String mensaje, Color color) {
        System.out.println(color + mensaje + Color.DEFAULT);
    }

    public static void muestraMensaje(String mensaje) {
        muestraMensaje(mensaje, Color.DEFAULT);
    }

    private static void borrarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
