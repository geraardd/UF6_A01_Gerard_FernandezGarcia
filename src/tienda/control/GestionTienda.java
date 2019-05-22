package tienda.control;

import empleado.control.GestionaEmpleados;
import empleado.dominio.Empleado;
import java.util.ArrayList;
import java.util.List;
import producto.dominio.Producto;
import static tienda.control.CambiarContraseña.CambiarContraseña;
import static tienda.control.ModificarProducto.ModificarCodigoProducto;
import static tienda.control.ModificarProducto.ModificarNombreProducto;
import static tienda.control.ModificarProducto.ModificarPrecioProducto;
import tienda.vista.VistaTienda;

public class GestionTienda {

    private Empleado empleadoAutenticado;
    private List<Producto> cesta;
    GestionaEmpleados gestionaEmpleados;

    public GestionTienda() {
        empleadoAutenticado = null;
        cesta = new ArrayList<>();
        gestionaEmpleados = new GestionaEmpleados();
    }


    public void iniciar() {
        boolean esLoginCorrecto = false;
        while (!esLoginCorrecto) {
            try {
                gestionaEmpleados.login();
                esLoginCorrecto = true;
            } catch (Exception e) {
            }
        }

        empleadoAutenticado = gestionaEmpleados.getEmpleadoAutenticado();
        VistaTienda.mensajeBienvenida(empleadoAutenticado);

        switch (VistaTienda.opcionDesdeMenuPrincipal()) {
            case HACER_PEDIDO:
                HACER_PEDIDO();
                break;
            case MODIFICAR_PRODUCTO:
                MODIFICAR_PRODUCTO();
                break;
            case CAMBIAR_PASSWORD:
                CAMBIAR_CONTRASEÑA();
                break;
            case CERRAR_SESION:
                System.out.println("");
                iniciar();
                break;
        }

    }
    
    public void HACER_PEDIDO() {
        switch (VistaTienda.opcionDesdePrimerMenu()) {
            case AÑADIR_PRODUCTO:
                HacerPedido.AñadirProducto();
                
                break;
            case VISUALIZAR_PRECIO:
                
                break;
            case IMPRIMIR_FACTURA:
                
                break;
            case TERMINAR_PEDIDO:
                System.out.println("");
                VistaTienda.opcionDesdeMenuPrincipal();
                System.out.println("");
                iniciar();
                break;
        }
    }
    
    public void MODIFICAR_PRODUCTO() {
        switch (VistaTienda.opcionDesdeSegundoMenu()) {
            case MODIFICAR_NOMBRE_PRODUCTO:
                ModificarNombreProducto();
                
                break;
            case MODIFICAR_PRECIO_PRODUCTO:
                ModificarPrecioProducto();
                
                break;
            case MODIFICAR_CODIGO_PRODUCTO:
                ModificarCodigoProducto();
                
                break;
        }
    }
    
    public void CAMBIAR_CONTRASEÑA() {
        switch (VistaTienda.opcionDesdeTercerMenu()) {
            case CAMBIAR_CONTRASEÑA:
                CambiarContraseña();
                
                break;
            
        }
    }

}
