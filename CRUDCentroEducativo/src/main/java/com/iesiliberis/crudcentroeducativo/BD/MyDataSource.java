/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iesiliberis.crudcentroeducativo.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sergio
 */
public class MyDataSource {    
    
    private static final String url = "jdbc:mysql://127.0.0.1:3306/centroeducativo";
    private static final String user = "root";
    private static final String pass = "calcetin20";
    private static Connection cn;

    public static Connection getConnection() {
        try {
            if (cn==null || cn.isClosed()){
                cn=DriverManager.getConnection(url,user,pass);
            }
        } catch (SQLException e) {
            System.out.println("Error.."+e.getMessage());
        }
        return cn;
    }
    
}
