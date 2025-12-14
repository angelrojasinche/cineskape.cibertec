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


public class Conexion {

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String host = System.getenv("MYSQLHOST");
            String port = System.getenv("MYSQLPORT");
            String database = System.getenv("MYSQLDATABASE");
            String user = System.getenv("MYSQLUSER");
            String password = System.getenv("MYSQLPASSWORD");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database
                       + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            con = DriverManager.getConnection(url, user, password);
            System.out.println(" Conectado a MySQL en Railway");

        } catch (Exception e) {
            System.out.println(" Error de conexión: " + e.getMessage());
        }

        return con;
    }
}

   

    

