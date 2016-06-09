/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookskop;

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
public class CRUD_Studio {
    private Connection koneksi;
    private PreparedStatement ps;
    private DBConection kdb = new DBConection();
    private String id_studio, nomor_studio, judul_film;
    
    public CRUD_Studio(){
    
    }

    public CRUD_Studio(String nomor_studio) {
        this.nomor_studio = nomor_studio;
    }

    public CRUD_Studio(String nomor_studio, String judul_film) {
        this.nomor_studio = nomor_studio;
        this.judul_film = judul_film;
    }
    
    public void lihatNData() throws SQLException {
        try {
            kdb.bukaKoneksi();
            koneksi = kdb.getConn();
            String kueri = "SELECT * FROM studio";
            ps = koneksi.prepareStatement(kueri);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("studio");
                System.out.println("id: " + rs.getString(1));
                System.out.println("nomor studio: " + rs.getString(2));
                System.out.println("Judul Film: " + rs.getString(3));
                System.out.println("");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            ps.close();
        }
    }
    
    public boolean masukkanData() throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        String insertTableSQL = "INSERT INTO studio"
                + "(nomor_studio, judul) VALUES"
                + "(?,?)";
        try {
        //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
        //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
        //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(insertTableSQL);
            ps.setString(1, this.nomor_studio);
            ps.setString(2, this.judul_film);
        //langkah 4: eksekusi query
            rowAffect = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
        //langkah ke 6
            ps.close();
        }
        //langkah ke-5: menterjemahkan hasil yang dikembalikan
        //dari bentuk integer ke dalam bentuk boolean sebagai representasi keberhasilan eksekusi
        if (rowAffect > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hapusData(String id_studio) throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        this.id_studio = id_studio;
        String deleteTableSQL = "DELETE from studio WHERE id = ? ";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(deleteTableSQL);
            ps.setString(1, this.id_studio);
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

    public boolean ubahData(String idStudio, String nomor_studio_baru, String judul_film_baru)
            throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        String updateTableSQL = "UPDATE studio SET nomor_studio = ?, judul = ?"
                + " WHERE id = ?";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(updateTableSQL);
            ps.setString(3, idStudio);
            ps.setString(1, nomor_studio_baru);
            ps.setString(2, judul_film_baru);
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
    
    public void comboData(DefaultComboBoxModel model){
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String strSql="SELECT * FROM film";
       
        try {
            kdb.bukaKoneksi();
            koneksi = kdb.getConn();
            ps = koneksi.prepareStatement(strSql);
            rs = ps.executeQuery();
           
            while (rs.next()){
                model.addElement(rs.getString(2));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan : " +e);
        }
    }
    /*
    boolean ubahData(String text, String id_studio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */
}
