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
 * @author Fakhri
 */
public class CRUD_Pelanggan {
    private Connection koneksi;
    private PreparedStatement ps;
    private DBConection kdb = new DBConection();
    private String id_pelanggan, nama, nama_bioskop, nomor_studio, judul, waktu_pemesanan, tanggal, waktu_mulai, waktu_selesai, baris, nomor_bangku, harga;

    public CRUD_Pelanggan() {
    }

    public CRUD_Pelanggan(String nama, String nama_bioskop, String nomor_studio, String judul, String waktu_pemesanan, String tanggal, String waktu_mulai, String waktu_selesai, String baris, String nomor_bangku, String harga) {
        this.nama = nama;
        this.nama_bioskop = nama_bioskop;
        this.nomor_studio = nomor_studio;
        this.judul = judul;
        this.waktu_pemesanan = waktu_pemesanan;
        this.tanggal = tanggal;
        this.waktu_mulai = waktu_mulai;
        this.waktu_selesai = waktu_selesai;
        this.baris = baris;
        this.nomor_bangku = nomor_bangku;
        this.harga = harga;
    }
    
    public void lihatNData() throws SQLException {
        try {
            kdb.bukaKoneksi();
            koneksi = kdb.getConn();
            String kueri = "SELECT * FROM pelanggan";
            ps = koneksi.prepareStatement(kueri);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("pelanggan");
                System.out.println("id: " + rs.getString(1));
                System.out.println("nama: " + rs.getString(2));
                System.out.println("nama_bioskop: " + rs.getString(3));
                System.out.println("nomor_studio: " + rs.getString(4));
                System.out.println("judul: " + rs.getString(5));
                System.out.println("waktu_pemesanan: " + rs.getString(6));
                System.out.println("tanggal: " + rs.getString(7));
                System.out.println("waktu_mulai: " + rs.getString(8));
                System.out.println("waktu_selesai: " + rs.getString(9));
                System.out.println("baris: " + rs.getString(10));
                System.out.println("nomor_bangku: " + rs.getString(11));
                System.out.println("harga: " + rs.getString(12));
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
        String insertTableSQL = "INSERT INTO pelanggan"
                + "(nama, nama_bioskop, nomor_studio, judul, tanggal, waktu_mulai, waktu_selesai, baris, nomor_bangku, harga) VALUES"
                + "(?,?,?,?,?,?,?,?,?,?)";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(insertTableSQL);
            ps.setString(1, this.judul);
            ps.setString(2, this.nama_bioskop);
            ps.setString(3, this.nomor_studio);
            ps.setString(4, this.judul);
            ps.setString(5, this.tanggal);
            ps.setString(6, this.waktu_mulai);
            ps.setString(7, this.waktu_selesai);
            ps.setString(8, this.baris);
            ps.setString(9, this.nomor_bangku);
            ps.setString(10, this.harga);
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
    
    public boolean hapusData(String id_pelanggan) throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        this.id_pelanggan = id_pelanggan;
        String deleteTableSQL = "DELETE from pelanggan WHERE id = ? ";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(deleteTableSQL);
            ps.setString(1, this.id_pelanggan);
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
    
    public boolean ubahData(String id_pelanggan, String nama_baru, String nama_bioskop_baru, String nomor_studio_baru, String judul_baru, String waktu_pemesanan_baru, String tanggal_baru, String waktu_mulai_baru, String waktu_selesai_baru, String baris_baru, String nomor_bangku_baru, String harga_baru)
            throws SQLException {
    //deklarasi connection dan preparedStatement
        Connection dbConnection = null;
        PreparedStatement ps = null;
        int rowAffect = 0;
        String updateTableSQL = "UPDATE pelanggan SET nama = ?, nama_bioskop = ?, nomor_studio = ?,"
                + " judul = ?, waktu_pemesanan = ?, tanggal = ?, waktu_mulai = ?, waktu_selesai = ? "
                + " baris = ?, nomor_bangku = ?, harga = ?, WHERE id = ?";
        try {
    //buka koneksi saat objek dari desa ninja dibentuk
            kdb.bukaKoneksi();
    //inisialisasi dbConnection dari objek Connection
            dbConnection = kdb.getConn();
    //Langkah ke 4 bagian 1
            ps = dbConnection.prepareStatement(updateTableSQL);
            ps.setString(12, id_pelanggan);
            ps.setString(1, nama_baru);
            ps.setString(2, nama_bioskop_baru);
            ps.setString(3, nomor_studio_baru);
            ps.setString(4, judul_baru);
            ps.setString(5, waktu_pemesanan_baru);
            ps.setString(6, tanggal_baru);
            ps.setString(7, waktu_mulai_baru);
            ps.setString(8, waktu_selesai_baru);
            ps.setString(9, baris_baru);
            ps.setString(10, nomor_bangku_baru);
            ps.setString(11, harga_baru);
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
