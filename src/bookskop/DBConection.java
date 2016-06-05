/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookskop;

/**
 *
 * @author TaufiqTab
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConection {
    private final String NAMA_DRIVER = "com.mysql.jdbc.Driver";
    private final String NAMA_DB = "jdbc:mysql://localhost/dbbookskop";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    private Connection conn;

    public void bukaKoneksi() {
        boolean flag = false;
        try {
        //langkah ke-2
            Class.forName(NAMA_DRIVER);
            flag = true;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        if (flag) {
            try {
        //langkah ke-3
                conn = DriverManager.getConnection(NAMA_DB, USERNAME, PASSWORD);
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Connection getConn() {
        return conn;
    }    
}
