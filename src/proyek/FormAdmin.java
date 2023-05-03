/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyek;


import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class FormAdmin extends javax.swing.JFrame {
Object[] rows ;
    DefaultTableModel model;
    Statement stmt;
    Connection con;
    PreparedStatement pr;
    ResultSet rs;
    /**
     * Creates new form FormAdmin
     */
    public FormAdmin() {
        try {
            setUndecorated(true);
        setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }  
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    
        initComponents();
        
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton2.setFocusPainted(false);
        jButton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButton1.setOpaque(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setBorderPainted(false);
        jButton1.setFocusPainted(false);
        jButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButtontampilkan.setOpaque(false);
        jButtontampilkan.setContentAreaFilled(false);
        jButtontampilkan.setBorderPainted(false);
        jButtontampilkan.setFocusPainted(false);
        jButtontampilkan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButtonsearch.setOpaque(false);
        jButtonsearch.setContentAreaFilled(false);
        jButtonsearch.setBorderPainted(false);
        jButtonsearch.setFocusPainted(false);
        jButtonsearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButtonlaporan.setOpaque(false);
        jButtonlaporan.setContentAreaFilled(false);
        jButtonlaporan.setBorderPainted(false);
        jButtonlaporan.setFocusPainted(false);
        jButtonlaporan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnback.setOpaque(false);
        btnback.setContentAreaFilled(false);
        btnback.setBorderPainted(false);
        btnback.setFocusPainted(false);
        btnback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButtoninsert.setOpaque(false);
        jButtoninsert.setContentAreaFilled(false);
        jButtoninsert.setBorderPainted(false);
        jButtoninsert.setFocusPainted(false);
        jButtoninsert.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButtonupdate.setOpaque(false);
        jButtonupdate.setContentAreaFilled(false);
        jButtonupdate.setBorderPainted(false);
        jButtonupdate.setFocusPainted(false);
        jButtonupdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButtondelete.setOpaque(false);
        jButtondelete.setContentAreaFilled(false);
        jButtondelete.setBorderPainted(false);
        jButtondelete.setFocusPainted(false);
        jButtondelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jTextFieldnamaiud.setOpaque(false);
        jTextFieldnamaiud.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jTextFieldnamaiud.setBorder(BorderFactory.createEmptyBorder( 4 /*top*/, 0, 0, 0 ));
        
        jTextFieldhargauid.setOpaque(false);
        jTextFieldhargauid.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jTextFieldhargauid.setBorder(BorderFactory.createEmptyBorder( 8 /*top*/, 0, 0, 0 ));
          
        
        jTextFieldstokuid.setOpaque(false);
        jTextFieldstokuid.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jTextFieldstokuid.setBorder(BorderFactory.createEmptyBorder( 4 /*top*/, 0, 0, 0 ));
        
        jComboBoxkategoriuid.setOpaque(false);
        jComboBoxkategoriuid.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        jTextFieldnamasearch.setOpaque(false);
        jTextFieldnamasearch.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jTextFieldnamasearch.setBorder(BorderFactory.createEmptyBorder( 4 /*top*/, 0, 0, 0 ));
        
        jTextFieldhargasearch.setOpaque(false);
        jTextFieldhargasearch.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        jTextFieldhargasearch.setBorder(BorderFactory.createEmptyBorder( 8 /*top*/, 0, 0, 0 ));
        


        
        jScrollPane2.getViewport().setOpaque(false);
        jScrollPane2.getViewport().getView().setBackground(new Color(28,29,31));
        
        jTabledata.getTableHeader().setOpaque(false);
        jTabledata.getTableHeader().setBackground(new Color(28,29,31));
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        
        jTabledata.getTableHeader().setForeground(Color.white);
        jTabledata.setForeground(Color.white);
        
        Font headerFont = new Font("Arial", Font.BOLD, 19);
        jTabledata.getTableHeader().setFont(headerFont);
        
        Font contentFont = new Font("Helvetica", Font.PLAIN, 17);
        jTabledata.setFont(contentFont);
        
        
        jTabledata.setRowHeight(30);
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_proyek","root","");
        } catch (Exception ex) {
          
        }
        rows = new Object[]{"IDMENU","NAMA","HARGA","NAMA KATEGORI","STOK"};
        model = new DefaultTableModel(rows,0);
        jTabledata.setModel(model);
        jTabledata.setDefaultEditor(Object.class, null);
        jComboBoxtampilkan.setSelectedIndex(0);
        refreshTabelTampil();
        jButtoninsert.setEnabled(true);
        jButtonupdate.setEnabled(false);
        jButtondelete.setEnabled(false);

    }
    public void refreshTabel()
    {
         model = new DefaultTableModel(rows, 0);
         jTabledata.setModel(model);
    }

    public void refreshTabelTampil()
    {
        refreshTabel();
        
        try {
            if (jComboBoxtampilkan.getSelectedItem().toString().equalsIgnoreCase("all")) {
                stmt = con.createStatement();
                rs = stmt.executeQuery("select m.idmenu,m.nama,m.harga,k.nama,m.stok from menu as m,kategori as k where m.idkategori=k.idkategori order by m.idmenu");
            }
            else{
                 pr = con.prepareStatement("select m.idmenu,m.nama,m.harga,k.nama,m.stok from menu as m,kategori as k where m.idkategori=k.idkategori and m.idkategori=? order by  m.idmenu");
            pr.setInt(1,jComboBoxtampilkan.getSelectedIndex());
            rs = pr.executeQuery();
                
            }
            while(rs.next())
            {
                model.addRow(
                        new Object[]
                        {rs.getInt("idmenu"),rs.getString("nama"),rs.getInt("harga"),rs.getString("k.nama"),rs.getInt("stok")});
            }
            rs.close();
        } catch (Exception ex) {
            System.out.print(ex);
        }
    }
    public void viewdata()
    {
        int i = jTabledata.getSelectedRow();

        String paramId = model.getValueAt(i,0).toString();
        String paramNama = model.getValueAt(i,1).toString();
        String paramHarga = model.getValueAt(i,2).toString();
        
        String namakat = model.getValueAt(i,3).toString();
        int idkat=-1;
        if (namakat.equalsIgnoreCase("roti")) {
            idkat=0;
        }
        else if (namakat.equalsIgnoreCase("daging")) {
            idkat=1;
        }
        else if (namakat.equalsIgnoreCase("topping")) {
            idkat=2;
        }
        else if (namakat.equalsIgnoreCase("minuman")) {
            idkat=3;
        }
        String paramStok = model.getValueAt(i,4).toString();
        jTextFieldnamaiud.setText(paramNama);
        jTextFieldhargauid.setText(paramHarga);
        jTextFieldstokuid.setText(paramStok);
        jComboBoxkategoriuid.setSelectedIndex(idkat);
                
       
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil2 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil3 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil4 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil5 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil6 = new org.jdatepicker.util.JDatePickerUtil();
        jDatePickerUtil7 = new org.jdatepicker.util.JDatePickerUtil();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTabledata = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButtonsearch = new javax.swing.JButton();
        jTextFieldnamasearch = new javax.swing.JTextField();
        jTextFieldhargasearch = new javax.swing.JTextField();
        jTextFieldnamaiud = new javax.swing.JTextField();
        jTextFieldstokuid = new javax.swing.JTextField();
        jTextFieldhargauid = new javax.swing.JTextField();
        jButtonupdate = new javax.swing.JButton();
        jButtondelete = new javax.swing.JButton();
        jButtoninsert = new javax.swing.JButton();
        btnback = new javax.swing.JButton();
        jComboBoxtampilkan = new javax.swing.JComboBox<>();
        jComboBoxkategorisearch = new javax.swing.JComboBox<>();
        jButtontampilkan = new javax.swing.JButton();
        jComboBoxkategoriuid = new javax.swing.JComboBox<>();
        jButtonlaporan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabledata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTabledata.setGridColor(new java.awt.Color(59, 59, 61));
        jTabledata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabledataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTabledata);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 820, 280));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 30, 20, 20));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 30, 20, 20));

        jButtonsearch.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonsearchActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 770, 150, 40));

        jTextFieldnamasearch.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(jTextFieldnamasearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 550, 240, -1));

        jTextFieldhargasearch.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(jTextFieldhargasearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 600, 240, -1));

        jTextFieldnamaiud.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jTextFieldnamaiud.setAlignmentY(55.0F);
        getContentPane().add(jTextFieldnamaiud, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, 240, -1));

        jTextFieldstokuid.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(jTextFieldstokuid, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 660, 240, -1));

        jTextFieldhargauid.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        getContentPane().add(jTextFieldhargauid, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 600, 240, -1));

        jButtonupdate.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtonupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonupdateActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 770, 100, 30));

        jButtondelete.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtondelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtondeleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButtondelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 770, 110, 30));

        jButtoninsert.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButtoninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoninsertActionPerformed(evt);
            }
        });
        getContentPane().add(jButtoninsert, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 770, 110, 30));

        btnback.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        getContentPane().add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 850, 190, 40));

        jComboBoxtampilkan.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBoxtampilkan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Roti", "Daging", "Topping", "Minuman" }));
        getContentPane().add(jComboBoxtampilkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 404, 630, 30));

        jComboBoxkategorisearch.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBoxkategorisearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Roti", "Daging", "Topping", "Minuman" }));
        jComboBoxkategorisearch.setFocusable(false);
        getContentPane().add(jComboBoxkategorisearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 661, 240, 30));

        jButtontampilkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtontampilkanActionPerformed(evt);
            }
        });
        getContentPane().add(jButtontampilkan, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 400, 160, 40));

        jComboBoxkategoriuid.setBackground(new java.awt.Color(153, 153, 153));
        jComboBoxkategoriuid.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jComboBoxkategoriuid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Roti", "Daging", "Topping", "Minuman" }));
        jComboBoxkategoriuid.setAlignmentY(10.0F);
        jComboBoxkategoriuid.setFocusable(false);
        getContentPane().add(jComboBoxkategoriuid, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 720, 240, 20));

        jButtonlaporan.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonlaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonlaporanActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonlaporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 850, 190, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek/Admin.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, -20, 1140, 1020));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        FormLogin login = new FormLogin();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void jButtonsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonsearchActionPerformed
   try {
            // TODO add your handling code here:
            
            refreshTabel();
          
        String nama;
        String harga;
        String kategori;
        if (jTextFieldnamasearch.getText().equals("")) {
            nama="%";
        }
        else{ 
            nama="%"+jTextFieldnamasearch.getText()+"%";
        }
        if (jTextFieldhargasearch.getText().equals("")) {
            harga="harga=harga";
        }
        else{
             harga=harga="harga="+jTextFieldhargasearch.getText();
        }
        if (jComboBoxkategorisearch.getSelectedIndex()==0) {
           kategori="m.idkategori=m.idkategori";
        }
        else{
             kategori="m.idkategori="+String.valueOf(jComboBoxkategorisearch.getSelectedIndex());
        }
//        pr = con.prepareStatement("select * from menu where nama like ? and harga=? and idkategori=? ");

            pr = con.prepareStatement("select m.idmenu,m.nama,m.harga,k.nama,m.stok from menu as m,kategori as k where m.idkategori=k.idkategori and m.nama like ? and "+harga+" and "+kategori+" order by  m.idmenu ");
            pr.setString(1,nama);

            rs = pr.executeQuery();
            while(rs.next())
            {    model.addRow(
                        new Object[]
                        {rs.getInt("idmenu"),rs.getString("nama"),rs.getInt("harga"),rs.getString("k.nama"),rs.getInt("stok")});
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(FormAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonsearchActionPerformed

    private void jButtontampilkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtontampilkanActionPerformed
        refreshTabelTampil();
    }//GEN-LAST:event_jButtontampilkanActionPerformed

    private void jTabledataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabledataMouseClicked
        viewdata();
        jButtoninsert.setEnabled(false);
        jButtonupdate.setEnabled(true);
        jButtondelete.setEnabled(true);
        
    }//GEN-LAST:event_jTabledataMouseClicked

    private void jButtoninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoninsertActionPerformed
        
            
            // TODO add your handling code here:
        if(!jTextFieldnamaiud.getText().equals("")&&!jTextFieldhargauid.getText().equals("")&&!jTextFieldstokuid.equals("")){
            try {     
            pr = con.prepareStatement("insert into menu (nama,harga,idkategori,stok) values (?,?,?,?) ");
            pr.setString(1,jTextFieldnamaiud.getText());
            pr.setInt(2,Integer.parseInt(jTextFieldhargauid.getText()));
            pr.setInt(3,jComboBoxkategoriuid.getSelectedIndex()+1);
            pr.setString(4,jTextFieldstokuid.getText());

            pr.executeUpdate(); 
            refreshTabelTampil();
            JOptionPane.showMessageDialog(null, "Berhasil Insert menu baru"); 
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(rootPane, "errorr boss");
        }
        }else{
            //untuk show dialog kita menggunakan JOptionPane, dimana harus -> import javax.swing.JOptionPane;
            JOptionPane.showMessageDialog(this,"Field tidak boleh Kosong!","Warning",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_jButtoninsertActionPerformed

    private void jButtonupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonupdateActionPerformed
         int i = jTabledata.getSelectedRow();
              String paramId = model.getValueAt(i,0).toString(); 
             
        if(!jTextFieldnamaiud.getText().equals("")&&!jTextFieldhargauid.getText().equals("")&&!jTextFieldstokuid.equals("")){
            try {
            // TODO add your handling code here:
            
            pr = con.prepareStatement("update menu set nama=?, harga=?, idkategori=?, stok=?   where idmenu=? ");
            pr.setString(1,jTextFieldnamaiud.getText());
             pr.setInt(2,Integer.parseInt(jTextFieldhargauid.getText()));
             pr.setInt(3,jComboBoxkategoriuid.getSelectedIndex()+1);
             pr.setString(4,jTextFieldstokuid.getText());
             pr.setInt(5,Integer.parseInt(paramId));
             pr.executeUpdate(); 
             
             refreshTabelTampil();
             jButtoninsert.setEnabled(true);
        jButtonupdate.setEnabled(false);
        jButtondelete.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Berhasil update menu"); 
             
        } catch (SQLException ex) {
            Logger.getLogger(FormAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            //untuk show dialog kita menggunakan JOptionPane, dimana harus -> import javax.swing.JOptionPane;
            JOptionPane.showMessageDialog(this,"Field tidak boleh Kosong!","Warning",JOptionPane.ERROR_MESSAGE);
            
        }
        
    }//GEN-LAST:event_jButtonupdateActionPerformed

    private void jButtondeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtondeleteActionPerformed
       int i = jTabledata.getSelectedRow();
              String paramId = model.getValueAt(i,0).toString(); 
        try {
            // TODO add your handling code here:
            
             pr = con.prepareStatement("delete from menu where idmenu=? ");
             pr.setInt(1,Integer.parseInt(paramId));
             pr.executeUpdate(); 
             refreshTabelTampil();
             jButtoninsert.setEnabled(true);
        jButtonupdate.setEnabled(false);
        jButtondelete.setEnabled(false);
        JOptionPane.showMessageDialog(null, "Berhasil delete menu"); 
             
        } catch (SQLException ex) {
            Logger.getLogger(FormAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtondeleteActionPerformed

    private void jButtonlaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonlaporanActionPerformed
        Formlaporan laporan = new Formlaporan();
        laporan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonlaporanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setExtendedState (FormLogin.ICONIFIED);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtondelete;
    private javax.swing.JButton jButtoninsert;
    private javax.swing.JButton jButtonlaporan;
    private javax.swing.JButton jButtonsearch;
    private javax.swing.JButton jButtontampilkan;
    private javax.swing.JButton jButtonupdate;
    private javax.swing.JComboBox<String> jComboBoxkategorisearch;
    private javax.swing.JComboBox<String> jComboBoxkategoriuid;
    private javax.swing.JComboBox<String> jComboBoxtampilkan;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil2;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil3;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil4;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil5;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil6;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTabledata;
    private javax.swing.JTextField jTextFieldhargasearch;
    private javax.swing.JTextField jTextFieldhargauid;
    private javax.swing.JTextField jTextFieldnamaiud;
    private javax.swing.JTextField jTextFieldnamasearch;
    private javax.swing.JTextField jTextFieldstokuid;
    // End of variables declaration//GEN-END:variables
}
