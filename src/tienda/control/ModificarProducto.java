package tienda.control;

import java.util.Scanner;
import producto.control.ControladorProducto;
import producto.dominio.Producto;

public class ModificarProducto {
    
    public static void ModificarNombreProducto() {

        Scanner entradaDatos = new Scanner(System.in);

        System.out.println("");
        System.out.println("Lista de productos:");

        for (Producto producto : ControladorProducto.leerProductos()) {
            System.out.print(producto);
        }
        System.out.println("------------------------------------");

        System.out.print("Introduce el codigo del producto a modificar: ");
        entradaDatos.next();

        System.out.print("Introduce el nuevo nombre del producto: ");
        entradaDatos.next();
        System.out.println("");
        
    }
    
    public static void ModificarPrecioProducto() {

        Scanner entradaDatos = new Scanner(System.in);

        System.out.println("");
        System.out.println("Lista de productos:");

        for (Producto producto : ControladorProducto.leerProductos()) {
            System.out.print(producto);
        }
        System.out.println("------------------------------------");

        System.out.print("Introduce el codigo del producto a modificar: ");
        entradaDatos.next();  
        
        System.out.print("Introduce el nuevo precio del producto: ");
        entradaDatos.next();
        System.out.println("");
        

    }
    
    public static void ModificarCodigoProducto() {

        Scanner entradaDatos = new Scanner(System.in);

        System.out.println("");
        System.out.println("Lista de productos:");

        for (Producto producto : ControladorProducto.leerProductos()) {
            System.out.print(producto);
        }
        System.out.println("------------------------------------");

        System.out.print("Introduce el codigo del producto a modificar: ");
        entradaDatos.next();     
        
        System.out.print("Introduce el nuevo codigo del producto: ");
        entradaDatos.next();
        System.out.println("");
        

    }
    
}
