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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class CRUD_Bioskop {
    private Connection koneksi;
    private PreparedStatement ps;
    private DBConection kdb = new DBConection();
    private String id_bioskop, nama_bioskop, alamat, daerah, nomor_studio;
    
     public CRUD_Bioskop() {

    }

    public CRUD_Bioskop(String nama_bioskop, String alamat, String daerah, String nomor_studio) {
        this.nama_bioskop = nama_bioskop;
        this.alamat = alamat;
        this.daerah = daerah;
        this.nomor_studio = nomor_studio;
    }
        
    public void lihatNData() throws SQLException {
        try {
            kdb.bukaKoneksi();
            koneksi = kdb.getConn();
            String kueri = "SELECT * FROM bioskop";
            ps = koneksi.prepareStatement(kueri);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("bioskop");
                System.out.println("id: " + rs.getString(1));
                System.out.println("nama bioskop: " + rs.getString(2));
                System.out.println("alamat: " + rs.getString(3));
                System.out.println("daerah: " + rs.getString(4));
                System.out.println("nomor studio: " + rs.getString(5));
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
        String insertTableSQL = "INSERT INTO bioskop"
                + "(nama_bioskop, alamat, daerah, nomor_studio) VALUES"
                + "(?,?,?,?)";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(insertTableSQL);
            ps.setString(1, this.nama_bioskop);
            ps.setString(2, this.alamat);
            ps.setString(3, this.daerah);
            ps.setString(4, this.nomor_studio);
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

    public boolean hapusData(String id_bioskop) throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        this.id_bioskop = id_bioskop;
        String deleteTableSQL = "DELETE from bioskop WHERE id = ? ";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(deleteTableSQL);
            ps.setString(1, this.id_bioskop);
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

    public boolean ubahData(String id_bioskop, String nama_bioskop_baru, String alamat_baru, String daerah_baru, String nomor_studio_baru)
            throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        String updateTableSQL = "UPDATE bioskop SET nama_bioskop = ?, alamat = ?, daerah = ?, nomor_studio = ?"
                + " WHERE id = ?";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(updateTableSQL);
            ps.setString(5, id_bioskop);
            ps.setString(1, nama_bioskop_baru);
            ps.setString(2, alamat_baru);
            ps.setString(3, daerah_baru);
            ps.setString(4, nomor_studio_baru);
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
    
    public void comboSupplier(DefaultComboBoxModel model){
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String strSql="SELECT * FROM studio";
       
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

    boolean ubahData(String text, String nomor_studio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
