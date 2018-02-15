/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Pegawai;

/**
 *
 * @author Hendro Steven
 */
public class PegawaiDao {
    private Connection conn;
    
    public PegawaiDao(Connection conn){
        this.conn = conn;
    }
    
    public void insert(Pegawai pegawai) throws Exception{
        String sql = "INSERT INTO tpegawai(no_induk,nama,alamat) values(?,?,?)";
        PreparedStatement pst = null;
        try{
            pst = this.conn.prepareStatement(sql);
            pst.setString(1, pegawai.getNoInduk());
            pst.setString(2, pegawai.getNama());
            pst.setString(3, pegawai.getAlamat());
            pst.executeUpdate();
            pst.close();
        }catch(Exception ex){
            throw new Exception("Data gagal disimpan");
        }
    }
    
    public List<Pegawai> getAll() throws Exception{
        List<Pegawai> dataPegawai = new ArrayList<Pegawai>();
        String sql = "SELECT no_induk,nama,alamat FROM tpegawai";
        PreparedStatement pst = null;
        try{
            pst = this.conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Pegawai peg = new Pegawai();
                peg.setNoInduk(rs.getString(1));
                peg.setNama(rs.getString(2));
                peg.setAlamat(rs.getString(3));
                dataPegawai.add(peg);
            }
        }catch(Exception ex){
            throw new Exception("Gagal membaca data");
        }
        return dataPegawai;
    }
    
    public void remove(String noInduk) throws Exception{
        String sql = "DELETE FROM tpegawai WHERE no_induk=?";
        PreparedStatement pst = null;
        try{
            pst = this.conn.prepareStatement(sql);
            pst.setString(1, noInduk);
            pst.executeUpdate();
            pst.close();
        }catch(Exception ex){
            throw new Exception("Hapus data gagal");
        }
    }
    
    public void update(Pegawai pegawai) throws Exception{
        String sql = "UPDATE tpegawai SET nama=?, alamat=? WHERE no_induk=?";
        PreparedStatement pst = null;
        try{
            pst = this.conn.prepareStatement(sql);
            pst.setString(1,pegawai.getNama());
            pst.setString(2, pegawai.getAlamat());
            pst.setString(3, pegawai.getNoInduk());
            pst.executeUpdate();
            pst.close();
        }catch(Exception ex){
            throw new Exception("Data gagal diupdate");
        }
    }
}
