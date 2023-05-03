/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyek;

/**
 *
 * @author ACER
 */
public class menu {
    private int idmenu;
    private String nama ;
    private int harga;
    private int idkategori;
    private int stok;

    public menu(int idmenu, String nama, int harga, int idkategori, int stok) {
        this.idmenu = idmenu;
        this.nama = nama;
        this.harga = harga;
        this.idkategori = idkategori;
        this.stok = stok;
    }

    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getIdkategori() {
        return idkategori;
    }

    public void setIdkategori(int idkategori) {
        this.idkategori = idkategori;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    @Override
    public String toString() {
        return "menu{" + "idmenu=" + idmenu + ", nama=" + nama + ", harga=" + harga + ", idkategori=" + idkategori + ", stok=" + stok + '}';
    }
    
    
    
    


    
    
    
}
