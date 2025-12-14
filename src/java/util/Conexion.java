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

            String host = System.getenv("MYSQL_HOST");
            String port = System.getenv("MYSQL_PORT");
            String database = System.getenv("MYSQL_DATABASE");
            String user = System.getenv("MYSQL_USER");
            String password = System.getenv("MYSQL_PASSWORD");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database
                       + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            con = DriverManager.getConnection(url, user, password);

            System.out.println("✅ CONECTADO A MYSQL RAILWAY");

        } catch (Exception e) {
            e.printStackTrace(); // 👈 MUY IMPORTANTE
        }

        return con;
    }
}


   

    

