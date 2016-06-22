package bookskop.CRUD;

import bookskop.DBConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sun Diego
 */
public class CRUD_User {
    private Connection koneksi;
    private PreparedStatement ps;
    private DBConection kdb = new DBConection();
    private String id_staff, username, password, nama, nama_bioskop, role;

    public CRUD_User() {
    }

    public CRUD_User(String username, String password, String nama, String nama_bioskop, String role) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.nama_bioskop = nama_bioskop;
        this.role = role;
    }
    
    public void lihatNData() throws SQLException {
        try {
            kdb.bukaKoneksi();
            koneksi = kdb.getConn();
            String kueri = "SELECT * FROM staff";
            ps = koneksi.prepareStatement(kueri);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("staff");
                System.out.println("id: " + rs.getString(1));
                System.out.println("username: " + rs.getString(2));
                System.out.println("password: " + rs.getString(3));
                System.out.println("nama: " + rs.getString(4));
                System.out.println("nama_bioskop: " + rs.getString(5));
                System.out.println("role: " + rs.getString(6));
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
        String insertTableSQL = "INSERT INTO staff"
                + "(username, password, nama, nama_bioskop, role) VALUES"
                + "(?,?,?,?,?)";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(insertTableSQL);
            ps.setString(1, this.username);
            ps.setString(2, this.password);
            ps.setString(3, this.nama);
            ps.setString(4, this.nama_bioskop);
            ps.setString(5, this.role);
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
    
    public boolean hapusData(String id_film) throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        this.id_staff = id_film;
        String deleteTableSQL = "DELETE from staff WHERE id = ? ";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(deleteTableSQL);
            ps.setString(1, this.id_staff);
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
    
    public boolean ubahData(String id_staff, String username_baru, String password_baru, String nama_baru, String nama_bioskop_baru, String role_baru)
            throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        String updateTableSQL = "UPDATE staff SET username = ?, password = ?, nama = ?,"
                + " nama_bioskop = ?, role = ?"
                + " WHERE id = ?";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(updateTableSQL);
            ps.setString(6, id_staff);
            ps.setString(1, username_baru);
            ps.setString(2, password_baru);
            ps.setString(3, nama_baru);
            ps.setString(4, nama_bioskop_baru);
            ps.setString(5, role_baru);
            
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
