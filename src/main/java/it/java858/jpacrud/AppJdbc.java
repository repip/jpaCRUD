/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.java858.jpacrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tss
 */
public class AppJdbc {

    public static void main(String[] args) {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/feedback",
                    "root",
                    "mysql");

            Statement cmd = connection.createStatement();

            ResultSet result = cmd.executeQuery("select * from customer order by last_name;");



            while (result.next()) {
                System.out.println(result.getString("last_name"));
            }



            result.close();
            connection.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppJdbc.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AppJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
