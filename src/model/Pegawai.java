/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hendro Steven
 */
public class Pegawai {
    private String noInduk;
    private String nama;
    private String alamat;
    
    public Pegawai(){}
    
    /**
     * @return the noInduk
     */
    public String getNoInduk() {
        return noInduk;
    }

    /**
     * @param noInduk the noInduk to set
     */
    public void setNoInduk(String noInduk) {
        this.noInduk = noInduk;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    
}
