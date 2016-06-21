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
 * @author TaufiqTab
 */
public class FreeSyntax {
    private Connection koneksi;
    private PreparedStatement ps;
    private DBConection kdb = new DBConection();
    
    public FreeSyntax(){
    
    }
    
    public boolean getLogin(String user, String pass){
        PreparedStatement ps = null;
        ResultSet rs = null;
        String theUser = "";
        String thePass = "";
        String strSql="SELECT * FROM staff where username ='"+user+"' ";
       
        try {
            kdb.bukaKoneksi();
            koneksi = kdb.getConn();
            ps = koneksi.prepareStatement(strSql);
            rs = ps.executeQuery();
           
            while (rs.next()){
                theUser = rs.getString(2);
                thePass = rs.getString(3);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan : " +e);
        }
        
        if(user.equals(theUser) && pass.equals(thePass)){
            return true;
        }else{
            return false;
        }
    }
    
    public void getDataBangku(String NoStudio, String NamaBioskop, int[] bangku){
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String strSql="SELECT * FROM bangku WHERE bioskop = '"+NamaBioskop+"' AND nomor_studio = '"+NoStudio+"' ";
        
        try {
            kdb.bukaKoneksi();
            koneksi = kdb.getConn();
            ps = koneksi.prepareStatement(strSql);
            rs = ps.executeQuery();
           
            while (rs.next()){
                //label.setText(rs.getString(11));
                
                bangku[0] = Integer.parseInt(rs.getString(4));
                bangku[1] = Integer.parseInt(rs.getString(5));
                bangku[2] = Integer.parseInt(rs.getString(6));
                bangku[3] = Integer.parseInt(rs.getString(7));
                bangku[4] = Integer.parseInt(rs.getString(8));
                bangku[5] = Integer.parseInt(rs.getString(9));
                bangku[6] = Integer.parseInt(rs.getString(10));
                bangku[7] = Integer.parseInt(rs.getString(11));
                bangku[8] = Integer.parseInt(rs.getString(12));
                bangku[9] = Integer.parseInt(rs.getString(13));
                bangku[10] = Integer.parseInt(rs.getString(14));
                bangku[11] = Integer.parseInt(rs.getString(15));
                
                System.out.println("list Bangku");
                System.out.println("Bangku A1: " + rs.getString(4));
                System.out.println("Bangku A2: " + rs.getString(5));
                System.out.println("Bangku A3: " + rs.getString(6));
                System.out.println("Bangku A4: " + rs.getString(7));
                
                System.out.println("Bangku B1: " + rs.getString(8));
                System.out.println("Bangku B2: " + rs.getString(9));
                System.out.println("Bangku B3: " + rs.getString(10));
                System.out.println("Bangku B4: " + rs.getString(11));
                
                System.out.println("Bangku C1: " + rs.getString(12));
                System.out.println("Bangku C2: " + rs.getString(13));
                System.out.println("Bangku C3: " + rs.getString(14));
                System.out.println("Bangku C4: " + rs.getString(15));
                System.out.println("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan : " +e);
        }
    }
    
    public boolean setBangku(String noStudio, String namaBioskop, String bangkuNya)
            throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        String updateTableSQL = "UPDATE bangku SET "+bangkuNya+" = 1 WHERE nomor_studio = ? AND bioskop = ?";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(updateTableSQL);
            ps.setString(1, noStudio);
            ps.setString(2, namaBioskop);
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
    
    public void comboDataFilmSpesifik(DefaultComboBoxModel model, String index){
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String strSql="SELECT * FROM film WHERE nama_bioskop = '"+index+"' ";
       
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
}
