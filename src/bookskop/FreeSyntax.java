/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookskop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
