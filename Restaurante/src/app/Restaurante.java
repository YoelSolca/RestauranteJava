package app;

import persistence.Conexion;
import view.Tests.PrimeraVista;

import java.sql.SQLException;

public class Restaurante {

    public static void main(String[] args) {

        /*
        Sistema iniciar = new Sistema();
        iniciar.setVisible(true);
         */

        PrimeraVista sistema = new PrimeraVista();
        sistema.setVisible(true);

        // Conexion a db
        try {
            Conexion conexion = Conexion.getInstance();

            System.out.println("Conexión establecida correctamente.");

            conexion.printDatabaseName();

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }

        // Cierre de la conexion a la db
        /*
        try {
            // Obtiene la instancia única y cierra la conexión cuando termines
            Conexion conexion = Conexion.getInstance();
            conexion.closeConnection();
            System.out.println("Conexión cerrada.");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
        */

    }
}
