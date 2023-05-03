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
public class Cminuman extends DataTransaksi {

    public Cminuman(String minuman, int jumlah, int subtotal, int total, int idMinuman) {
        
        super(jumlah,subtotal,total);
        this.minuman = minuman;
        this.idMinuman = idMinuman;
    }
    private int idMinuman;

    public int getIdMinuman() {
        return idMinuman;
    }

    public void setIdMinuman(int idMinuman) {
        this.idMinuman = idMinuman;
    }
    private String minuman;

    public String getMinuman() {
        return minuman;
    }

    public void setMinuman(String minuman) {
        this.minuman = minuman;
    }
}
