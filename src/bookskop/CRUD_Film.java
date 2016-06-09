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

/**
 *
 * @author Sun Diego
 */
public class CRUD_Film {
    private Connection koneksi;
    private PreparedStatement ps;
    private DBConection kdb = new DBConection();
    private String id_film, judul, sutradara, kategori, durasi,tanggal,jam_mulai,jam_selesai,harga;

    public CRUD_Film() {
    }

    public CRUD_Film(String judul, String sutradara, String kategori, String durasi, String tanggal, String jam_mulai, String jam_selesai, String harga) {
        this.judul = judul;
        this.sutradara = sutradara;
        this.kategori = kategori;
        this.durasi = durasi;
        this.tanggal = tanggal;
        this.jam_mulai = jam_mulai;
        this.jam_selesai = jam_selesai;
        this.harga = harga;
    }
    
    public void lihatNData() throws SQLException {
        try {
            kdb.bukaKoneksi();
            koneksi = kdb.getConn();
            String kueri = "SELECT * FROM film";
            ps = koneksi.prepareStatement(kueri);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("bioskop");
                System.out.println("id: " + rs.getString(1));
                System.out.println("judul: " + rs.getString(2));
                System.out.println("sutradara: " + rs.getString(3));
                System.out.println("kategori: " + rs.getString(4));
                System.out.println("durasi: " + rs.getString(5));
                System.out.println("tanggal: " + rs.getString(6));
                System.out.println("jam mulai: " + rs.getString(7));
                System.out.println("jam selesai: " + rs.getString(8));
                System.out.println("harga: " + rs.getString(9));
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
        String insertTableSQL = "INSERT INTO film"
                + "(judul, sutradara, kategori, durasi, tanggal, jam_mulai, jam_selesai, harga) VALUES"
                + "(?,?,?,?,?,?,?,?)";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(insertTableSQL);
            ps.setString(1, this.judul);
            ps.setString(2, this.sutradara);
            ps.setString(3, this.kategori);
            ps.setString(4, this.durasi);
            ps.setString(5, this.tanggal);
            ps.setString(6, this.jam_mulai);
            ps.setString(7, this.jam_selesai);
            ps.setString(8, this.harga);
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
        this.id_film = id_film;
        String deleteTableSQL = "DELETE from film WHERE id = ? ";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(deleteTableSQL);
            ps.setString(1, this.id_film);
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
    
    public boolean ubahData(String id_film, String judul_baru, String sutradara_baru, String kategori_baru, String durasi_baru, String tanggal_baru, String jam_mulai_baru, String jam_selesai_baru, String harga_baru)
            throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        String updateTableSQL = "UPDATE film SET judul = ?, sutradara = ?, kategori = ?,"
                + " durasi = ?, tanggal = ?, jam_mulai = ?, jam_selesai = ?, harga = ? "
                + " WHERE id = ?";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(updateTableSQL);
            ps.setString(9, id_film);
            ps.setString(1, judul_baru);
            ps.setString(2, sutradara_baru);
            ps.setString(3, kategori_baru);
            ps.setString(4, durasi_baru);
            ps.setString(5, tanggal_baru);
            ps.setString(6, jam_mulai_baru);
            ps.setString(7, jam_selesai_baru);
            ps.setString(8, harga_baru);
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
