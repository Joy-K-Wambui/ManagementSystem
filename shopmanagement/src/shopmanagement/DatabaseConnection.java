/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopmanagement;

/**
 *
 * @author Adimn
 */

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
 
public class DatabaseConnection { 
    private static final String URL = "jdbc:mysql://localhost:3306/shop_management"; 
    private static final String USER = "root"; // Change if necessary     private static final String PASSWORD = ""; // Change if necessary 
    private static final String PASSWORD = "password"; // Replace with your database password

    public static Connection getConnection() { 
        Connection conn = null;         try { 
            conn = DriverManager.getConnection(URL, USER, PASSWORD); 
            System.out.println("Connected to the database successfully!"); 
        } catch (SQLException e) { 
            System.out.println("Database connection failed: " + e.getMessage()); 
        } 
        return conn; 
    } 
    public static void main(String[] args) {         
        getConnection(); // Test connection 
    } 
} 

