package tienda.control;

import java.util.ArrayList;
import java.util.List;
import producto.control.ControladorProducto;
import producto.dao.ProductoDAOImp;
import producto.dominio.Producto;
import java.util.Scanner;

public class HacerPedido {

    List<Producto> cesta = new ArrayList<>();

    public static void AñadirProducto() {

        Scanner entradaDatos = new Scanner(System.in);

        System.out.println("");
        System.out.println("Lista de productos:");

        for (Producto producto : ControladorProducto.leerProductos()) {
            System.out.print(producto);
        }
        System.out.println("------------------------------------");

        System.out.print("Introduce el codigo del producto: ");
        entradaDatos.next();

    }
    
    private void AñadirProductos(Producto Producto) {
        cesta.add(Producto);
    }

    public double VisualizarPrecio() {
        System.out.println("");

        double PrecioTotal = 0;
        for (Producto p : this.cesta) {
            PrecioTotal += p.getPrecio();
        }
        return PrecioTotal;

    }

    public void ImprimirFactura() {
        System.out.println("Factura simplificada:");
        System.out.println("--------------------------------------------------------------");

        for (Producto p : cesta) {
            System.out.println("Código: " + p.getCodigo());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Descripción: " + p.getDescripcion());
            System.out.println("Precio: " + p.getPrecio());
            System.out.println("--------------------------------------------------------------");
        }
        
        System.out.println("--------------------------------------------------------------");
        System.out.println("El precio total es: " + VisualizarPrecio() + "€");
        System.out.println("Atendido por: " + getClass().getName());

    }
}
