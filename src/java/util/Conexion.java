/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author RS
 */


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String databaseUrl = System.getenv("DATABASE_URL");

            if (databaseUrl == null) {
                throw new RuntimeException("DATABASE_URL no está definida");
            }

            String jdbcUrl = databaseUrl.replace(
                    "mysql://",
                    "jdbc:mysql://"
            ) + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            Connection con = DriverManager.getConnection(jdbcUrl);

            System.out.println("✅ Conectado correctamente a MySQL (Railway)");
            return con;

        } catch (Exception e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}




   

    

