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
public class transmakanan {
    
    private int idMakanan;
    private int idDaging;
    private int idTopping;
    protected int jumlah;
    protected int subtotal;
    protected int total;
    private String roti;
    private String daging;
    private String topping;

    public transmakanan(int idMakanan, int idDaging, int idTopping, int jumlah, int subtotal, int total, String roti, String daging, String topping) {
        this.idMakanan = idMakanan;
        this.idDaging = idDaging;
        this.idTopping = idTopping;
        this.jumlah = jumlah;
        this.subtotal = subtotal;
        this.total = total;
        this.roti = roti;
        this.daging = daging;
        this.topping = topping;
    }
    
    

    

    public int getIdMakanan() {
        return idMakanan;
    }

    public void setIdMakanan(int idMakanan) {
        this.idMakanan = idMakanan;
    }

    public int getIdDaging() {
        return idDaging;
    }

    public void setIdDaging(int idDaging) {
        this.idDaging = idDaging;
    }

    public int getIdTopping() {
        return idTopping;
    }

    public void setIdTopping(int idTopping) {
        this.idTopping = idTopping;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getRoti() {
        return roti;
    }

    public void setRoti(String roti) {
        this.roti = roti;
    }

    public String getDaging() {
        return daging;
    }

    public void setDaging(String daging) {
        this.daging = daging;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }
    
    
    
    
    

    
    
    
    
}
