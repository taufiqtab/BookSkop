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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author TaufiqTab
 */
public class CRUD_Pesan {
    private Connection koneksi;
    private PreparedStatement ps;
    private DBConection kdb = new DBConection();
    //private String id_studio, nomor_studio, judul_film;
    
    public CRUD_Pesan(){
    
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
    
    public void labelDataIdStudio(JLabel label, String nama_bioskop, String judul){
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String strSql="SELECT * FROM film WHERE nama_bioskop = '"+nama_bioskop+"' AND judul = '"+judul+"' ";
        
        try {
            kdb.bukaKoneksi();
            koneksi = kdb.getConn();
            ps = koneksi.prepareStatement(strSql);
            rs = ps.executeQuery();
           
            while (rs.next()){
                label.setText(rs.getString(11));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan : " +e);
        }
    }
    
    public void comboDataFilm(DefaultComboBoxModel model){
        PreparedStatement ps = null;
        ResultSet rs = null;
       
        String strSql="SELECT * FROM film";
       
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
}
