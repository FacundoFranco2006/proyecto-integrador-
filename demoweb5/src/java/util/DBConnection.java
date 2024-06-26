/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/tienda?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USER = "root"; // Ajusta según tu configuración
    private static final String PASSWORD = ""; // Ajusta según tu configuración
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection connection = null;

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER); // Cargar el driver JDBC
            connection = DriverManager.getConnection(URL, USER, PASSWORD); // Establecer la conexión
            System.out.println("Conectado a la base de datos");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Imprimir errores de conexión
        }
        return connection;
    }
}
