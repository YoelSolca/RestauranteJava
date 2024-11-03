package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static Conexion instance;
    private Connection connection;

    // Evitar instanciación directa
    private Conexion() throws SQLException {
        try {
            // Configuración para la base de datos en freesqldatabase.com
            String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10742365";
            String user = "sql10742365";
            String password = "HYwrLvPTtG";

            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida con éxito a la base de datos");
        } catch (SQLException e) {
            throw new SQLException("Error al conectarse a la BD: " + e.getMessage());
        }
    }

    // Retorna la única instancia de la clase (patrón Singleton)
    public static Conexion getInstance() throws SQLException {
        if (instance == null) {
            instance = new Conexion();
        } else if (instance.getConnection().isClosed()) {
            instance = new Conexion();
        }
        return instance;
    }

    // Obtener la conexión
    public Connection getConnection() {
        return connection;
    }

    // Cerrar la conexión
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Conexión cerrada con éxito");
            }
        } catch (SQLException e) {
            System.err.println("Hubo un error al cerrar la conexión: " + e.getMessage());
        }
    }

    public void printDatabaseName() {
        try {
            String dbName = connection.getCatalog();  // obtiene el nombre de la base de datos
            System.out.println("Base de datos actual: " + dbName);
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre de la base de datos: " + e.getMessage());
        }
    }

    public void connect() throws SQLException {
        String url = "jdbc:mysql://sql10.freesqldatabase.com:3306/sql10742365";
        String user = "sql10742365";
        String password = "HYwrLvPTtG";

        this.connection = DriverManager.getConnection(url, user, password);
        System.out.println("Conectado a la base de datos: " + url);
    }

}