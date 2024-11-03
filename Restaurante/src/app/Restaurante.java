package app;

import Modelo.Cliente;
import View.Sistema;
import persistencia.ClienteDao;
import persistencia.Conexion;

import java.sql.Connection;
import java.sql.SQLException;

public class Restaurante {

    public static void main(String[] args) {
        /*
        Sistema iniciar = new Sistema();
        iniciar.setVisible(true);
        */

        // Pruebas
        // Conexion a db
        try {
            Conexion conexion = Conexion.getInstance();

            System.out.println("Conexión establecida correctamente.");

            conexion.printDatabaseName();

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }

        // Crear y mostrar cliente
        ClienteDao clienteDao = new ClienteDao();
        Cliente clientePrueba = new Cliente(2, "Jose","tomas");

        clienteDao.agregarCliente(clientePrueba);

        Cliente ObtenerCliente = clienteDao.obtenerCliente(1);
        if (ObtenerCliente != null) {
            System.out.println("Id: " + ObtenerCliente.getId());
            System.out.println("Nombre: " + ObtenerCliente.getNombre());
            System.out.println("Apellido: " + ObtenerCliente.getApellido());
        } else {
            System.out.println("No se encontró el Cliente con el Id: 2");
        }

        // Modificar cliente
        ObtenerCliente.setNombre("Carlos");
        ObtenerCliente.setApellido("Gabriel");

        if (ObtenerCliente != null) {
            System.out.println("Id cliente modificado: " + ObtenerCliente.getId());
            System.out.println("Nombre: " + ObtenerCliente.getNombre());
            System.out.println("Apellido: " + ObtenerCliente.getApellido());
        } else {
            System.out.println("No se encontró el Cliente con el Id: 2");
        }


        // Eliminar cliente
        clienteDao.eliminarCliente(2);

        Cliente clienteEliminado = clienteDao.obtenerCliente(1);
        if (clienteEliminado == null) {
            System.out.println("El cliente con ID 1 fue eliminado correctamente.");
        } else {
            System.out.println("Error: El cliente con ID 1 aún existe.");
        }


        // Cierre de la conexion a la db
        try {
            // Obtiene la instancia única y cierra la conexión cuando termines
            Conexion conexion = Conexion.getInstance();
            conexion.closeConnection();
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
