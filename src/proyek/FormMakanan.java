/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyek;

import com.sun.javafx.event.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;



/**
 *
 * @author ASUS
 */
public class FormMakanan extends javax.swing.JFrame {


        
    public static ArrayList<DataTransaksi> transaksi = new ArrayList<DataTransaksi>();
    public static ArrayList<transmakanan> arrtransmakanan = new ArrayList<transmakanan>();
    public static ArrayList<transminuman> arrtransminuman = new ArrayList<transminuman>();
    
    Object[] rows ;
    DefaultTableModel model ;
    
    Statement stmt;
    Connection conn;
    PreparedStatement pr;
    ResultSet rs;
    
    
    public static ArrayList<menu> arrmenu = new ArrayList();
    
    int total = 0;
    int subtotal = 0;
    
    
    
    
    public FormMakanan() {
        

        
        setUndecorated(true);
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        initComponents();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_proyek","root","");
        } catch (Exception ex) {
          
        }
        
        loaddbmenu();
        
        for (int i = 0; i <arrmenu.size() ; i++) {
            menu m = arrmenu.get(i);
            System.out.println(m.toString());
        }
        loadroti();
        loaddaging();
        loadtoping();
       
        
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.getViewport().getView().setBackground(new Color(28,29,31));
        
        jTablecart.getTableHeader().setOpaque(false);
        jTablecart.getTableHeader().setBackground(new Color(28,29,31));
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        
        jTablecart.getTableHeader().setForeground(Color.white);
        jTablecart.setForeground(Color.white);
        
        Font headerFont = new Font("Arial", Font.BOLD, 19);
        jTablecart.getTableHeader().setFont(headerFont);
        
        Font contentFont = new Font("Helvetica", Font.PLAIN, 17);
        jTablecart.setFont(contentFont);
        
        
        
        jTablecart.setRowHeight(34);
        
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButton3.setOpaque(false);
        jButton3.setContentAreaFilled(false);
        jButton3.setBorderPainted(false);
        jButton3.setFocusPainted(false);
        jButton3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnAdd.setOpaque(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.setBorderPainted(false);
        btnAdd.setFocusPainted(false);
        btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnback.setOpaque(false);
        btnback.setContentAreaFilled(false);
        btnback.setBorderPainted(false);
        btnback.setFocusPainted(false);
        btnback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnNext.setOpaque(false);
        btnNext.setContentAreaFilled(false);
        btnNext.setBorderPainted(false);
        btnNext.setFocusPainted(false);
        btnNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnClear.setOpaque(false);
        btnClear.setContentAreaFilled(false);
        btnClear.setBorderPainted(false);
        btnClear.setFocusPainted(false);
        btnClear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnRemove.setOpaque(false);
        btnRemove.setContentAreaFilled(false);
        btnRemove.setBorderPainted(false);
        btnRemove.setFocusPainted(false);
        btnRemove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
        
        
         model = new DefaultTableModel(rows, 0);
        rows = new Object[]{"Roti", "Daging", "Toping" , "Harga", "Qty","Subtotal" };
        
        jTablecart.setModel(model);
        jTablecart.setDefaultEditor(Object.class, null);
        SpinnerQty.setValue(1);
        isiMakanan();
        
        
        
        jLabel3.setBorder(BorderFactory.createEmptyBorder( 0 /*top*/, 0, 10, 0 ));
        jLabel4.setBorder(BorderFactory.createEmptyBorder( 0 /*top*/, 0, 10, 0 ));
      
        
        txtHarga.setBorder(BorderFactory.createEmptyBorder( 0 /*top*/, 0, 15, 0 ));
        txtSubTotal.setBorder(BorderFactory.createEmptyBorder( 0 /*top*/, 0, 10, 0 ));
        
        txtSubTotal.setForeground(Color.white);
        txtHarga.setForeground(Color.white);
        jLabel3.setForeground(Color.white);
        jLabel4.setForeground(Color.white);
        jLabel5.setForeground(Color.white);
        jLabel6.setForeground(Color.white);
        jLabel7.setForeground(Color.white);
        jLabel8.setForeground(Color.white);
        
        txthargaroti.setForeground(Color.white);
        txthargadaging.setForeground(Color.white);
        txthargatoping.setForeground(Color.white);
        String tempnama="none";
        ImageIcon imageroti = new ImageIcon(System.getProperty("user.dir") + "\\GAMBARPROYEKPBO\\"+tempnama+".jpg");
                       jLabeltoping.setIcon(imageroti);
    }
  

    
        
    public void isiMakanan(){
        
        model = new DefaultTableModel(rows, 0);
        rows = new Object[]{"Roti", "Daging", "Toping" , "Harga", "Qty","Subtotal" };
        
        jTablecart.setModel(model);
        jTablecart.setDefaultEditor(Object.class, null);
        for (int i = 0; i < arrtransmakanan.size(); i++) {
            
                transmakanan makan = arrtransmakanan.get(i);
                
                
                model.addRow(new Object[]{makan.getRoti(), makan.getDaging(), makan.getTopping(), makan.getSubtotal(), makan.getJumlah(),makan.getTotal()});
                jTablecart.setModel(model);
            
        }
    }
     
    
    
    // UNTUK MENDAPATKAN SEMUA MENU YANG ADA PADA DATABASE
    public void loaddbmenu()
    {
        arrmenu.clear();
        try {
            pr = conn.prepareStatement("Select * from menu ");
            rs = pr.executeQuery();
            
            while (rs.next()) {                
                menu m = new menu(rs.getInt("idmenu"), rs.getString("nama"), rs.getInt("harga"), rs.getInt("idkategori"), rs.getInt("stok"));
                arrmenu.add(m);
            }
        } catch (Exception e) {
        }
    }
    
    // UNTUK MENGISI COMBOBOX ROTI
    public void loadroti()
    {
        try {
            pr = conn.prepareStatement("Select * from menu where idkategori = 1");
            rs = pr.executeQuery();
            
            while (rs.next()) {                
                String nama = rs.getString("nama");
                jComboBoxroti.addItem(nama);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        jComboBoxroti.setSelectedIndex(0);
//        menu m = arrmenu.get(0);
//        txthargaroti.setText(String.valueOf(m.getHarga()));
    }
    
    // untuk mengisi Combobox daging
    public void loaddaging()
    {
        try {
            pr = conn.prepareStatement("Select * from menu where idkategori = 2");
            rs = pr.executeQuery();
            
            while (rs.next()) {                
                String nama = rs.getString("nama");
                jComboBoxdaging.addItem(nama);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        jComboBoxdaging.setSelectedIndex(0);
        
        
    }
    
    // untuk mengisi Combobox topping
    public void loadtoping()
    {
        try {
            pr = conn.prepareStatement("Select * from menu where idkategori = 3");
            rs = pr.executeQuery();
            
            while (rs.next()) {                
                String nama = rs.getString("nama");
                jComboBoxtoping.addItem(nama);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        jComboBoxtoping.setSelectedIndex(0);
    }
    
    // UNTUK MERUBAH VALUE TEXTBOX HARGA
    private void berubahharga()
    {
        total = Integer.valueOf(txthargaroti.getText()) + Integer.valueOf(txthargadaging.getText()) + Integer.valueOf(txthargatoping.getText()) ;
        txtHarga.setText(String.valueOf(total));
    }
    //UNTUK MERUBAH VALUE TEXTBOX SUBTOTAL
    private void berubahsubtotal()
    {
        subtotal = 0;
        String temp1 = String.valueOf(SpinnerQty.getValue());
        subtotal = Integer.valueOf(temp1) * Integer.valueOf(txtHarga.getText());
        txtSubTotal.setText(String.valueOf(subtotal));
    }
    
    //untuk menambah ke cart
    public void tambah()
    {
        int idRoti = -1;
        int idDaging = -1;
        int idTopping = -1;
        String roti = jComboBoxroti.getSelectedItem().toString();
        String daging = jComboBoxdaging.getSelectedItem().toString();
        String topping = jComboBoxtoping.getSelectedItem().toString();
        
        int subtotal = Integer.parseInt(txtHarga.getText());
        int jumlah = Integer.parseInt(SpinnerQty.getValue().toString());
        int total = Integer.parseInt(txtSubTotal.getText());
        
//        jTablecart.setModel(model);
//        model.addRow(new Object[]{jComboBoxroti.getSelectedItem(), jComboBoxdaging.getSelectedItem(), jComboBoxtoping.getSelectedItem(), txtHarga.getText(), SpinnerQty.getValue(), txtSubTotal.getText()});
        for (int i = 0; i < arrmenu.size(); i++) {
            menu m = arrmenu.get(i);
            if (m.getNama().equals(roti)) {
                idRoti = m.getIdmenu();
                System.out.println(idRoti);
            }
            if (m.getNama().equals(daging)) {
                idDaging = m.getIdmenu();
                System.out.println(idDaging);
            }
            if (m.getNama().equals(topping)) {
                idTopping = m.getIdmenu();
            }
        }
        boolean cektambah=false;
        for (transmakanan t:arrtransmakanan) {
            if (t.getRoti().equals(roti)&&t.getDaging().equals(daging)&&t.getTopping().equals(topping)&&t.getSubtotal()==subtotal ) {
                t.setJumlah(t.getJumlah()+jumlah);
                t.setTotal(t.getTotal()+total);
                cektambah=true;
            }
        }
        if (cektambah==false) {
            transmakanan baru = new transmakanan(idRoti, idDaging, idTopping, jumlah, subtotal, total, roti , daging, topping);
        arrtransmakanan.add(baru);
        }
        isiMakanan();
        
//        System.out.println("TEST");
    }
    
    public void clearfield()
    {
//        jComboBoxroti.setSelectedIndex(-1);
//        txthargaroti.setText("0");
//        jComboBoxdaging.setSelectedIndex(-1);
//        txthargadaging.setText("0");
//        jComboBoxtoping.setSelectedIndex(0);
//        txthargatoping.setText("0");
//        txtHarga.setText("0");
//        SpinnerQty.setValue(0);
//        txtSubTotal.setText("0");
        jComboBoxroti.setSelectedIndex(0);
        
        jComboBoxdaging.setSelectedIndex(0);
        
        jComboBoxtoping.setSelectedIndex(0);
        
        SpinnerQty.setValue(1);
        
    }
    
   
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnback = new javax.swing.JButton();
        jComboBoxroti = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxdaging = new javax.swing.JComboBox<>();
        jComboBoxtoping = new javax.swing.JComboBox<>();
        SpinnerQty = new javax.swing.JSpinner();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablecart = new javax.swing.JTable();
        btnNext = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        txthargadaging = new javax.swing.JTextField();
        txthargaroti = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txthargatoping = new javax.swing.JTextField();
        txtHarga = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        jLabelroti = new javax.swing.JLabel();
        jLabeltoping = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabeldaging = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1379, 905));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnback.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        getContentPane().add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 770, 180, 42));

        jComboBoxroti.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxrotiItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBoxroti, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 110, -1));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 371, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(862, 371, -1, -1));

        jComboBoxdaging.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxdagingItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBoxdaging, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 310, 110, -1));

        jComboBoxtoping.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "none" }));
        jComboBoxtoping.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxtopingItemStateChanged(evt);
            }
        });
        getContentPane().add(jComboBoxtoping, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 110, -1));

        SpinnerQty.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        SpinnerQty.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                SpinnerQtyStateChanged(evt);
            }
        });
        getContentPane().add(SpinnerQty, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 60, 30));

        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 420, 240, 44));

        jTablecart.setBackground(new java.awt.Color(28, 29, 31));
        jTablecart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Roti", "Daging", "Toping", "TOTAL", "Qty", "Subtotal"
            }
        ));
        jTablecart.setFocusTraversalPolicyProvider(true);
        jTablecart.setGridColor(new java.awt.Color(28, 29, 31));
        jTablecart.setOpaque(false);
        jScrollPane1.setViewportView(jTablecart);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 560, 840, 170));

        btnNext.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 770, 190, 50));

        btnClear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        getContentPane().add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 770, 140, 50));

        btnRemove.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        getContentPane().add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 770, 150, 50));

        txthargadaging.setBackground(new java.awt.Color(28, 29, 31));
        txthargadaging.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txthargadaging.setText("0");
        txthargadaging.setBorder(null);
        getContentPane().add(txthargadaging, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 70, -1));

        txthargaroti.setBackground(new java.awt.Color(28, 29, 31));
        txthargaroti.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txthargaroti.setText("0");
        txthargaroti.setBorder(null);
        getContentPane().add(txthargaroti, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 70, 20));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Rp.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 310, -1, 30));

        txthargatoping.setBackground(new java.awt.Color(28, 29, 31));
        txthargatoping.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txthargatoping.setText("0");
        txthargatoping.setBorder(null);
        getContentPane().add(txthargatoping, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 310, 70, 20));

        txtHarga.setBackground(new java.awt.Color(28, 29, 31));
        txtHarga.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtHarga.setText("0");
        txtHarga.setBorder(null);
        getContentPane().add(txtHarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 362, 90, 40));

        txtSubTotal.setBackground(new java.awt.Color(28, 29, 31));
        txtSubTotal.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        txtSubTotal.setText("0");
        txtSubTotal.setBorder(null);
        txtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubTotalActionPerformed(evt);
            }
        });
        getContentPane().add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 360, 90, 40));

        jLabelroti.setBackground(new java.awt.Color(0, 255, 204));
        getContentPane().add(jLabelroti, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 150, 150));

        jLabeltoping.setBackground(new java.awt.Color(0, 255, 204));
        getContentPane().add(jLabeltoping, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 150, 150));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 50, 20, 20));

        jLabeldaging.setBackground(new java.awt.Color(0, 255, 204));
        getContentPane().add(jLabeldaging, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 150, 150));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setText("Rp.");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, -1, 40));

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 410, 50));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 50, 20, 20));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("Rp.");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, -1, 50));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Rp.");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, 40));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Rp.");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, -1, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek/MenuMakanan.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 1110, 890));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        FormCheckOut fck = new FormCheckOut();
        fck.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed

        
        
        
        int m = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin keluar? Item yang ada di dalam cart akan terhapus","Select an Option...",JOptionPane.YES_NO_OPTION);
        // 0=yes, 1=no, 2=cancel
            if (m==0) {
                arrtransmakanan.clear();
                arrtransminuman.clear();
                FormLogin login = new FormLogin();
                login.setVisible(true);
                this.dispose();
            }
           
                
        
    }//GEN-LAST:event_btnbackActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        
        int i = jTablecart.getSelectedRow();
        if (i<0) {
             JOptionPane.showMessageDialog(this, "Belum ada item yang dipilih");
        }
        else{
        model.removeRow(i);
        arrtransmakanan.remove(i);
        }
        
        
        
    }//GEN-LAST:event_btnRemoveActionPerformed
    // BUTTON TAMBAH PESANAN KE CART
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        
        if (jComboBoxroti.getSelectedIndex() == -1 || jComboBoxdaging.getSelectedIndex() == -1) {
            System.out.println("titap bisa add kocak");
            JOptionPane.showMessageDialog(this,"MAU NAMBAH APA BRO ?","EROR",JOptionPane.INFORMATION_MESSAGE);
        }
        else if(Integer.valueOf(String.valueOf(SpinnerQty.getValue())) < 1)
        {
//            System.out.println("kuantiti tidak boleh 0");
            JOptionPane.showMessageDialog(this,"Kuantiti tidak boleh 0","EROR",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            tambah();
            clearfield();
        }
        
    }//GEN-LAST:event_btnAddActionPerformed
    // UNTUK MERUBAH HARGA SETIAP VALUE COMBOBOX BERUBAH
    private void jComboBoxrotiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxrotiItemStateChanged
        // TODO add your handling code here:
        
        for (int i = 0; i < arrmenu.size(); i++) {
                menu m = arrmenu.get(i);
                String tempnama ;
    
                if (m.getNama().equals(String.valueOf(jComboBoxroti.getSelectedItem()))) {
                       System.out.println(m.getNama());
                    txthargaroti.setText(String.valueOf(m.getHarga()));

                    tempnama = m.getNama();

                }  

                }
         boolean cekgambar=false;
       
        String[] roti = {"roti gandum", "roti tawar", "roti keju", "roti honey oat", "roti wijen"};
         for (int j = 0; j < roti.length; j++) {
            
            if (String.valueOf(jComboBoxroti.getSelectedItem()).equals(roti[j])) {
                cekgambar=true;
                
                
                
            }

        }
         if (cekgambar) {
           for (int i = 0; i < arrmenu.size(); i++) {
            menu m = arrmenu.get(i);
             String tempnama ;
            
   
                
            if (m.getNama().equals(String.valueOf(jComboBoxroti.getSelectedItem()))) {
    //                System.out.println("sama");
                txthargaroti.setText(String.valueOf(m.getHarga()));

                tempnama = m.getNama();

                ImageIcon imageroti = new ImageIcon(System.getProperty("user.dir") + "\\GAMBARPROYEKPBO\\"+tempnama+".jpg");
                jLabelroti.setIcon(imageroti);
            }  

            }
           

        }
        else{
            String tempnama ;
                      tempnama="tandatanya1";
                ImageIcon imageroti = new ImageIcon(System.getProperty("user.dir") + "\\GAMBARPROYEKPBO\\"+tempnama+".jpg");
                jLabelroti.setIcon(imageroti);
                   
                   
        }
        
        berubahharga();
        berubahsubtotal();
        
    }//GEN-LAST:event_jComboBoxrotiItemStateChanged
    // UNTUK MERUBAH HARGA SETIAP VALUE COMBOBOX BERUBAH
    private void jComboBoxdagingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxdagingItemStateChanged

        for (int i = 0; i < arrmenu.size(); i++) {
                menu m = arrmenu.get(i);
                String tempnama ;
    
                if (m.getNama().equals(String.valueOf(jComboBoxdaging.getSelectedItem()))) {
                        
                    txthargadaging.setText(String.valueOf(m.getHarga()));

                    tempnama = m.getNama();

                }  

                }
        boolean cekgambar=false;
       
        String[] daging = {"Ayam BBQ", "Sapi Black Pepper", "Ayam Teriyaki", "Tuna Melt", "Sapi Panggang"};
        
        for (int j = 0; j < daging.length; j++) {
            
            if (String.valueOf(jComboBoxdaging.getSelectedItem()).equals(daging[j])) {
                cekgambar=true;
                
            }

        }
        
            
        if (cekgambar) {
           for (int i = 0; i < arrmenu.size(); i++) {
            menu m = arrmenu.get(i);
             String tempnama ;
            
   
                
            if (m.getNama().equals(String.valueOf(jComboBoxdaging.getSelectedItem()))) {
    //                System.out.println("sama");
                txthargadaging.setText(String.valueOf(m.getHarga()));

                tempnama = m.getNama();

                ImageIcon imageroti = new ImageIcon(System.getProperty("user.dir") + "\\GAMBARPROYEKPBO\\"+tempnama+".jpg");
                jLabeldaging.setIcon(imageroti);
            }  

            }
           

        }
        else{
            String tempnama ;
                      tempnama="tandatanya1";
                ImageIcon imageroti = new ImageIcon(System.getProperty("user.dir") + "\\GAMBARPROYEKPBO\\"+tempnama+".jpg");
                jLabeldaging.setIcon(imageroti);
                   
                   
        }

        berubahharga();
        berubahsubtotal();
    }//GEN-LAST:event_jComboBoxdagingItemStateChanged
    
    // UNTUK MERUBAH HARGA SETIAP VALUE COMBOBOX BERUBAH
    private void jComboBoxtopingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxtopingItemStateChanged
        // TODO add your handling code here:
                            for (int i = 0; i < arrmenu.size(); i++) {
                    menu m = arrmenu.get(i);
                    String tempnama;

                    if (m.getNama().equals(String.valueOf(jComboBoxtoping.getSelectedItem()))) {
                           System.out.println(m.getNama());
                        txthargatoping.setText(String.valueOf(m.getHarga()));

                        tempnama = m.getNama();

                    }  

                }
        boolean cekgambar=false;
         if (String.valueOf(jComboBoxtoping.getSelectedItem()).equals("none")){
                      String tempnama="none";
                   ImageIcon imageroti = new ImageIcon(System.getProperty("user.dir") + "\\GAMBARPROYEKPBO\\"+tempnama+".jpg");
                       jLabeltoping.setIcon(imageroti);
                       txthargatoping.setText("0");
                   
                   
                   
        } 
        String[] topping = {"none","Keju", "Jamur", "Acar", "Bawang Bombay", "Bacon"};
            for (int j = 0; j < topping.length; j++) {

               if (String.valueOf(jComboBoxtoping.getSelectedItem()).equals(topping[j])) {
                   cekgambar=true;
                   

                   
               }

           }
           if (cekgambar) {
           for (int i = 0; i < arrmenu.size(); i++) {
               menu m = arrmenu.get(i);
               String tempnama ;
                    
                    
                   if (m.getNama().equals(String.valueOf(jComboBoxtoping.getSelectedItem()))) {
       //                System.out.println("sama");
                         
                       txthargatoping.setText(String.valueOf(m.getHarga()));

                       tempnama = m.getNama();
                        
                       ImageIcon imageroti = new ImageIcon(System.getProperty("user.dir") + "\\GAMBARPROYEKPBO\\"+tempnama+".jpg");
                       jLabeltoping.setIcon(imageroti);

                   }
                   
           }
        }
        else{
            String tempnama ;
                      tempnama="tandatanya";
                ImageIcon imageroti = new ImageIcon(System.getProperty("user.dir") + "\\GAMBARPROYEKPBO\\"+tempnama+".jpg");
                jLabeltoping.setIcon(imageroti);
                   
                   
        }
       
       berubahharga();
       berubahsubtotal();

       
    }//GEN-LAST:event_jComboBoxtopingItemStateChanged
    // UNTUK MENGUBAH SUBTOTAL SETIAP SPINNER VALUE BERUBAH
    private void SpinnerQtyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_SpinnerQtyStateChanged
        // TODO add your handling code here:
        berubahsubtotal();
    }//GEN-LAST:event_SpinnerQtyStateChanged

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        
//        for (int i = 0; i < model.getRowCount(); i++) {
//            
//            model.removeRow(i);
//            
//        }
        model.setRowCount(0);
        
        arrtransmakanan.clear();
        
        
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubTotalActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setExtendedState (FormMakanan.ICONIFIED);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        FormMinuman fminuman = new FormMinuman();
        fminuman.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMakanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinnerQty;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnback;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxdaging;
    private javax.swing.JComboBox<String> jComboBoxroti;
    private javax.swing.JComboBox<String> jComboBoxtoping;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabeldaging;
    private javax.swing.JLabel jLabelroti;
    private javax.swing.JLabel jLabeltoping;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablecart;
    private javax.swing.JTextField txtHarga;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txthargadaging;
    private javax.swing.JTextField txthargaroti;
    private javax.swing.JTextField txthargatoping;
    // End of variables declaration//GEN-END:variables
}
