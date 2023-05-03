/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyek;

/**
 *
 * @author ASUS
 */
public class DataTransaksi {
    protected int jumlah;
    protected int subtotal;
    protected int total;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public DataTransaksi(int jumlah, int subtotal, int total){
        this.jumlah = jumlah;
        this.subtotal = subtotal;
        this.total = total;
    }
    
}
