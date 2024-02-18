package com.svalero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://postgresdb.cg6vma2ag6q6.us-east-1.rds.amazonaws.com/CareConnect";

        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "12344321");
        props.setProperty("ssl", "false");

        try (Connection conn = DriverManager.getConnection(url, props)) {
            if (conn != null) {
                System.out.println("Conectado a la base de datos!");
            } else {
                System.out.println("Fallo al conectar con la base de datos.");
            }
            // Obtiene los metadatos de la base de datos
            /*
             * ResultSet rs = conn.getMetaData().getTables(null, null, "%", new String[] {
             * "TABLE" });
             * 
             * System.out.println("Listado de tablas:");
             * while (rs.next()) {
             * // Muestra el nombre de cada tabla
             * System.out.println(rs.getString("TABLE_NAME"));
             * }
             */

            // Crear un objeto Statement
            try (Statement stmt = conn.createStatement()) {
                // Ejecutar una consulta SELECT
                String query = "SELECT id, nombre FROM user";
                ResultSet rs = stmt.executeQuery(query);

                // Iterar sobre el conjunto de resultados
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    System.out.println("ID: " + id + ", Nombre: " + nombre);
                }
            } catch (SQLException e) {
                System.out.println("Error al ejecutar la consulta.");
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
