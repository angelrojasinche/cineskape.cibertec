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

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String host = System.getenv("MYSQL_HOST");
            String port = System.getenv("MYSQL_PORT");
            String database = System.getenv("MYSQL_DATABASE");
            String user = System.getenv("MYSQL_USER");
            String password = System.getenv("MYSQL_PASSWORD");

            System.out.println("HOST=" + host);
            System.out.println("PORT=" + port);
            System.out.println("DB=" + database);
            System.out.println("USER=" + user);

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database
                    + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado a MySQL en Railway");

            return con;

        } catch (Exception e) {
            System.out.println("Error de conexión:");
            e.printStackTrace();
            return null;
        }
    }
}


   

    

