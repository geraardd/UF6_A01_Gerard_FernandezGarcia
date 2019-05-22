package empleado.dao;

import conexion.ConexionBD;
import empleado.dominio.Empleado;
import java.sql.SQLException;
import java.util.List;
import empleado.dao.EmpleadoDAO;
import java.util.ArrayList;
import producto.dominio.Producto;

public class EmpleadoDAOImp implements EmpleadoDAO {

    @Override
    public List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();

        String query = "SELECT * FROM empleados";

        try (
                var conexion = ConexionBD.conectar();
                var sentencia = conexion.createStatement();
                var resultado = sentencia.executeQuery(query);) {

            // capturar los resultados
            while (resultado.next()) {
                var codigo = resultado.getInt("e_codigo");
                var nombre = resultado.getString("e_nombre");
                var apellido = resultado.getString("e_apellido");
                var contraseña = resultado.getString("e_contraseña");

                empleados.add(new Empleado(codigo, nombre, apellido, contraseña));
            }

        } catch (SQLException e) {
            System.out.println("Error al leer los empleados en la base de datos "
                    + this.getClass().getName());
        }

        return empleados;
    }

    @Override
    public Empleado getEmpleadoPorCodigo(int codigo) {
        Empleado empleado = null;
        String query = "SELECT * FROM empleados where e_codigo = " + codigo;

        try (
                var conexion = ConexionBD.conectar();
                var sentencia = conexion.createStatement();
                var resultado = sentencia.executeQuery(query)) {

            resultado.next();
            var code = resultado.getInt("e_codigo");
            var nombre = resultado.getString("e_nombre");
            var apellidos = resultado.getString("e_apellidos");
            var password = resultado.getString("e_password");
            empleado = new Empleado(codigo, nombre, apellidos, password);

        } catch (SQLException e) {
            System.out.println("Error al cargar empleado con el codigo " + codigo);
        }

        return empleado;
    }

    @Override
    public boolean actualizarEmpleado(Empleado empleado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
