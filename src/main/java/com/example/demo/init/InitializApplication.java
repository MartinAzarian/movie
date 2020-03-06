package com.example.demo.init;

import com.example.demo.persistence.MariadbConstants;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class InitializApplication {

    public static void initializApplication() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(MariadbConstants.DB_URL, MariadbConstants.USER, MariadbConstants.PASS);

            if (conn != null) {
                String query = "CREATE DATABASE IF NOT EXISTS  movie;";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.execute();
            }

        } catch (SQLException ex) {
            System.err.println("Conection error");
            ex.printStackTrace();
        } finally {

            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // Connection conn = null;
        try {

            conn = DriverManager.getConnection(MariadbConstants.DB_URL, MariadbConstants.USER, MariadbConstants.PASS);

            if (conn != null) {

                String query = "CREATE TABLE IF NOT EXISTS  movies(\n" +
                        "    id INT NOT NULL AUTO_INCREMENT,\n" +
                        "    name VARCHAR(255) NOT NULL ,\n" +
                        "    ganre VARCHAR(255) NOT NULL ,\n" +
                        "    PRIMARY KEY (id)\n" +
                        ");";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.execute();


                preparedStatement.execute();
            }

        } catch (SQLException ex) {
            System.err.println("Conection error");
            ex.printStackTrace();
        } finally {

            if (conn != null) {

                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}




