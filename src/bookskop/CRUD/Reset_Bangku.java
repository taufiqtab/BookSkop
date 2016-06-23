/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookskop.CRUD;

import bookskop.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Sun Diego
 */
public class Reset_Bangku {
    
    private Connection koneksi;
    private PreparedStatement ps;
    private DBConection kdb = new DBConection();
    
    public void comboDataStudio(DefaultComboBoxModel model){
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String strSql="SELECT * FROM studio";
       
        try {
            kdb.bukaKoneksi();
            koneksi = kdb.getConn();
            ps = koneksi.prepareStatement(strSql);
            rs = ps.executeQuery();
           
            while (rs.next()){
                //model.addElement(rs.getString(2));
                if(model.getIndexOf(rs.getString(2)) == -1 ) {
                    model.addElement(rs.getString(2));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan : " +e);
        }
    }
    
    public void comboDataBioskop(DefaultComboBoxModel model){
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String strSql="SELECT * FROM bioskop";
       
        try {
            kdb.bukaKoneksi();
            koneksi = kdb.getConn();
            ps = koneksi.prepareStatement(strSql);
            rs = ps.executeQuery();
           
            while (rs.next()){
                //model.addElement(rs.getString(2));
                if(model.getIndexOf(rs.getString(2)) == -1 ) {
                    model.addElement(rs.getString(2));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan : " +e);
        }
    }
    
    public boolean ubahData(String nama_bioskop, String nomor_studio)
            throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        String updateTableSQL = "UPDATE bangku SET a1 = 0, a2 = 0, a3 = 0, a4 = 0,"
                + " b1 = 0, b2 = 0, b3 = 0, b4 = 0,"
                + " c1 = 0, c2 = 0, c3 = 0, c4 = 0"
                + " WHERE bioskop = ? AND nomor_studio = ?";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(updateTableSQL);
            ps.setString(1, nama_bioskop);
            ps.setString(2, nomor_studio);
            
    //langkah 4: eksekusi query
            rowAffect = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
    //langkah ke 6
            ps.close();
        }
    //langkah ke 5
        if (rowAffect > 0) {
            return true;
        } else {
            return false;
        }
    }
    
}
