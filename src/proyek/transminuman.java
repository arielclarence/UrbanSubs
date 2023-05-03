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
public class transminuman {
    private int idMinuman;
    protected int jumlah;
    protected int subtotal;
    protected int harga;
    private String minuman;

    public transminuman(int idMinuman, int jumlah, int subtotal, int harga, String minuman) {
        this.idMinuman = idMinuman;
        this.jumlah = jumlah;
        this.subtotal = subtotal;
        this.harga = harga;
        this.minuman = minuman;
    }

    

    public int getIdMinuman() {
        return idMinuman;
    }

    public void setIdMinuman(int idMinuman) {
        this.idMinuman = idMinuman;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    

    public String getMinuman() {
        return minuman;
    }

    public void setMinuman(String minuman) {
        this.minuman = minuman;
    }
    
    
    
    
    
    
    
    
}
