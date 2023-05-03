/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyek;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
/**
 *
 * @author ASUS
 */
public class FormCheckOut extends javax.swing.JFrame {

    DefaultTableModel model1 ;
    Object[] rows1 ;
    DefaultTableModel model2 ;
    Object[] rows2 ;
    
    Statement stmt;
    Statement stmt2;
    Connection conn;
    PreparedStatement pr;
    PreparedStatement pr2;
    ResultSet rs;
    ResultSet rs2;
    
    //long millis=System.currentTimeMillis();  
    //java.sql.Date date=new java.sql.Date(millis); //yyyy-mm-dd
    
    public FormCheckOut() {
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
        rows1 = new Object[] {"Roti", "Daging", "Topping", "QTY", "Subtotal", "Total"};
        model1 = new DefaultTableModel(rows1, 0);
        jTableMakanan.setDefaultEditor(Object.class, null);
        rows2 = new Object[] {"Minuman",  "QTY", "Harga", "Total"};
        model2 = new DefaultTableModel(rows2, 0);
        jTableMinuman.setDefaultEditor(Object.class, null);
        isiMakanan();
        isiMinuman();
        total();
        
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
        
        btnback.setOpaque(false);
        btnback.setContentAreaFilled(false);
        btnback.setBorderPainted(false);
        btnback.setFocusPainted(false);
        btnback.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButtonremove.setOpaque(false);
        jButtonremove.setContentAreaFilled(false);
        jButtonremove.setBorderPainted(false);
        jButtonremove.setFocusPainted(false);
        jButtonremove.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     
        jButtonclear.setOpaque(false);
        jButtonclear.setContentAreaFilled(false);
        jButtonclear.setBorderPainted(false);
        jButtonclear.setFocusPainted(false);
        jButtonclear.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jButtonbayar.setOpaque(false);
        jButtonbayar.setContentAreaFilled(false);
        jButtonbayar.setBorderPainted(false);
        jButtonbayar.setFocusPainted(false);
        jButtonbayar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        jTableMakanan.getTableHeader().setOpaque(false);
        jTableMakanan.getTableHeader().setBackground(new Color(28,29,31));
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
        
        jTableMakanan.getTableHeader().setForeground(Color.white);
        jTableMakanan.setForeground(Color.white);
        
        Font headerFont = new Font("Arial", Font.BOLD, 19);
        jTableMakanan.getTableHeader().setFont(headerFont);
        
        Font contentFont = new Font("Helvetica", Font.PLAIN, 17);
        jTableMakanan.setFont(contentFont);
        
        jTableMakanan.setRowHeight(38);
        
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        jTableMinuman.getTableHeader().setOpaque(false);
        jTableMinuman.getTableHeader().setBackground(new Color(28,29,31));
        jScrollPane2.setBorder(BorderFactory.createEmptyBorder());
        
        jTableMinuman.getTableHeader().setForeground(Color.white);
        jTableMinuman.setForeground(Color.white);
        
        Font headerFont1 = new Font("Arial", Font.BOLD, 19);
        jTableMinuman.getTableHeader().setFont(headerFont1);
        
        Font contentFont1 = new Font("Helvetica", Font.PLAIN, 17);
        jTableMinuman.setFont(contentFont1);
        
        jTableMinuman.setRowHeight(38);
        
        jScrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        jLabel2.setForeground(Color.white);
        jLabel4.setForeground(Color.white);
        jLabelTotal1.setForeground(Color.white);
        

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMakanan = new javax.swing.JTable();
        jButtonbayar = new javax.swing.JButton();
        jButtonclear = new javax.swing.JButton();
        jButtonremove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMinuman = new javax.swing.JTable();
        jLabelTotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelTotal1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnback.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });
        getContentPane().add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 690, 190, 40));

        jTableMakanan.setBackground(new java.awt.Color(28, 29, 31));
        jTableMakanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Roti", "Daging", "Topping", "QTY", "Subtotal", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMakanan.setGridColor(new java.awt.Color(28, 29, 31));
        jTableMakanan.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTableMakanan);
        if (jTableMakanan.getColumnModel().getColumnCount() > 0) {
            jTableMakanan.getColumnModel().getColumn(0).setResizable(false);
            jTableMakanan.getColumnModel().getColumn(1).setResizable(false);
            jTableMakanan.getColumnModel().getColumn(2).setResizable(false);
            jTableMakanan.getColumnModel().getColumn(3).setResizable(false);
            jTableMakanan.getColumnModel().getColumn(4).setResizable(false);
            jTableMakanan.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 820, 180));

        jButtonbayar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonbayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonbayarMouseClicked(evt);
            }
        });
        jButtonbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonbayarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 690, 150, 40));

        jButtonclear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonclearActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonclear, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 690, 150, 40));

        jButtonremove.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButtonremove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonremoveActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 690, 160, 40));

        jTableMinuman.setBackground(new java.awt.Color(28, 29, 31));
        jTableMinuman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Minuman", "QTY", "Subtotal", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMinuman.setGridColor(new java.awt.Color(28, 29, 31));
        jScrollPane2.setViewportView(jTableMinuman);
        if (jTableMinuman.getColumnModel().getColumnCount() > 0) {
            jTableMinuman.getColumnModel().getColumn(0).setResizable(false);
            jTableMinuman.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 820, 180));

        jLabelTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelTotal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotal.setText("0");
        getContentPane().add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 620, -1, -1));

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 50, 20, 20));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TOTAL :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 620, -1, -1));

        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 50, 20, 20));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Cart Minuman");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setText("Cart Makanan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jLabelTotal1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelTotal1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotal1.setText("Rp.");
        getContentPane().add(jLabelTotal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 620, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyek/Checkout.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1070, 790));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        FormMakanan fmin = new FormMakanan();
        fmin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnbackActionPerformed

    private void jButtonbayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonbayarMouseClicked
        if (FormMakanan.arrtransmakanan.size()==0&&FormMakanan.arrtransminuman.size()==0) {
            JOptionPane.showMessageDialog(this, "Cart kosong");
        }
        else{
            masuk();
            FormMakanan.arrtransmakanan.clear();
            FormMakanan.arrtransminuman.clear();
    //        JOptionPane.showMessageDialog(this,"Berhasil melakukan pembayaran","Success",JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(this, "Pembelian berhasil");
                FormLogin fm = new FormLogin();
                fm.setVisible(true);
                this.dispose();
        }
    }//GEN-LAST:event_jButtonbayarMouseClicked

    private void jButtonbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonbayarActionPerformed
        
    }//GEN-LAST:event_jButtonbayarActionPerformed

    private void jButtonremoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonremoveActionPerformed
        int indexminuman=-1;
        int indexmakanan=-1;
        indexminuman = jTableMinuman.getSelectedRow();
        indexmakanan = jTableMakanan.getSelectedRow();
        
        if (indexminuman<0&&indexmakanan<0) {
             JOptionPane.showMessageDialog(this, "Belum ada item yang dipilih");
        }
        else if (indexminuman<0) {
            model1.removeRow(indexmakanan);
            FormMakanan.arrtransmakanan.remove(indexmakanan);
        }
        else if (indexmakanan<0) {
            model2.removeRow(indexminuman);
            FormMakanan.arrtransminuman.remove(indexminuman);
        }
        total();
        
    }//GEN-LAST:event_jButtonremoveActionPerformed

    private void jButtonclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonclearActionPerformed
       model1.setRowCount(0);
        FormMakanan.arrtransminuman.clear();
        model2.setRowCount(0);
        FormMakanan.arrtransmakanan.clear();
        total();
    }//GEN-LAST:event_jButtonclearActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setExtendedState (FormCheckOut.ICONIFIED);
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
            java.util.logging.Logger.getLogger(FormCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCheckOut().setVisible(true);
            }
        });
    }
    
    // ngisi tabel makanan
    public void isiMakanan(){
        int id = -1;
        for (int i = 0; i < FormMakanan.arrtransmakanan.size(); i++) {
            
                transmakanan makan = FormMakanan.arrtransmakanan.get(i);
                
                
                model1.addRow(new Object[]{makan.getRoti(), makan.getDaging(), makan.getTopping(), makan.getJumlah(), makan.getSubtotal(), makan.getTotal()});
                jTableMakanan.setModel(model1);
            
        }
    }
    //isi tabel minuman
    public void isiMinuman(){
        for (int i = 0; i < FormMakanan.arrtransminuman.size(); i++) {
            
                transminuman minuman = FormMakanan.arrtransminuman.get(i);
                
//                System.out.println(minuman.getIdMinuman());
                model2.addRow(new Object[]{minuman.getMinuman(), minuman.getJumlah(), minuman.getHarga(), minuman.getSubtotal()});
                jTableMinuman.setModel(model2);
            
        }
    }
    
    //isi Total
    public void total(){
        int totalMinuman = 0;
        for (int i = 0; i < FormMakanan.arrtransminuman.size(); i++) {
            
                transminuman minum = FormMakanan.arrtransminuman.get(i);
                
                totalMinuman += minum.getSubtotal();  
            
        }
        
        int totalMakanan = 0;
        for (int i = 0; i < FormMakanan.arrtransmakanan.size(); i++) {
            
                transmakanan makan = FormMakanan.arrtransmakanan.get(i);
                
                totalMakanan += makan.getTotal();
            
        }
        
        
        int hasil = totalMakanan + totalMinuman;
        
        jLabelTotal.setText(String.valueOf(hasil));
    }

    //insert database
    public void masuk(){
        try{
            conn.setAutoCommit(false);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
            Date date = new Date();  
            pr = conn.prepareStatement("insert into htrans(customer, tanggal, total) values(?,?,?)");
            pr.setString(1, FormLogin.nama);
            pr.setString(2,formatter.format(date));
            pr.setInt(3, Integer.parseInt(jLabelTotal.getText()));
            pr.executeUpdate(); 
            
            int maxid = 0;
            try {
                pr2 = conn.prepareStatement("select max(idtrans) from htrans");
                rs2 = pr2.executeQuery();
                while (rs2.next()) {                    
                    maxid = rs2.getInt("max(idtrans)");
                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
            if (FormMakanan.arrtransmakanan.size()==0) {
                
            }
            else{
            for (int i = 0; i < FormMakanan.arrtransmakanan.size(); i++) {
                transmakanan makan = FormMakanan.arrtransmakanan.get(i);
                if (makan.getIdTopping()==-1)
                    {
                        pr = conn.prepareStatement("insert into dtransmaincourse(idtrans, idroti, iddaging,topping, jumlahmaincourse,subtotal) values(?,?,?,?,?,?) ");
                        pr.setInt(1, maxid);
                        pr.setInt(2, makan.getIdMakanan());
                        pr.setInt(3, makan.getIdDaging());
                        pr.setInt(4, 0);
                        pr.setInt(5, makan.getJumlah());
                        pr.setInt(6, makan.getSubtotal());
                        pr.executeUpdate(); 
                    }else{
                        pr = conn.prepareStatement("insert into dtransmaincourse(idtrans, idroti, iddaging, topping,jumlahmaincourse,subtotal) values(?,?,?,?,?, ?)");
                        pr.setInt(1, maxid);
                    pr.setInt(2, makan.getIdMakanan());
                    pr.setInt(3, makan.getIdDaging());
                    pr.setInt(4, makan.getIdTopping());
                    pr.setInt(5, makan.getJumlah());
                    pr.setInt(6, makan.getSubtotal());
                    pr.executeUpdate(); 
                    }
                
            }
            }
            
            if (FormMakanan.arrtransminuman.size()==0) {
                
            }
            else{
                for (int i = 0; i < FormMakanan.arrtransminuman.size(); i++) {

                    transminuman minum = FormMakanan.arrtransminuman.get(i);

                    pr = conn.prepareStatement("insert into dtransiminuman(idtrans, idminuman, jumlahminuman,subtotal) values(?,?,?,?)");


                    System.out.println(minum.getIdMinuman());
                    pr.setInt(1, maxid);
                        pr.setInt(2, minum.getIdMinuman());
                        pr.setInt(3, minum.getJumlah());
                        pr.setInt(4, minum.getSubtotal());
                        pr.executeUpdate();
                }
            }
            conn.commit();
            
//            for (int i = 0; i < FormMakanan.transaksi.size(); i++) {
//                if (FormMakanan.transaksi.get(i) instanceof Cmakanan) {
//                    Cmakanan makan = (Cmakanan)FormMakanan.transaksi.get(i);
//                    if (makan.getIdTopping()==-1)
//                    {
//                        pr = conn.prepareStatement("insert into dtransmaincourse(idtrans, idroti, iddaging,topping, jumlahmaincourse,subtotal) values(?,?,?,?,?,?) ");
//                        pr.setInt(1, maxid);
//                        pr.setInt(2, makan.getIdMakanan());
//                        pr.setInt(3, makan.getIdDaging());
//                        pr.setInt(4, 0);
//                        pr.setInt(5, makan.getJumlah());
//                        pr.setInt(6, makan.getSubtotal());
//                        pr.executeUpdate(); 
//                    }else{
//                        pr = conn.prepareStatement("insert into dtransmaincourse(idtrans, idroti, iddaging, topping,jumlahmaincourse,subtotal) values(?,?,?,?,?, ?)");
//                        pr.setInt(1, maxid);
//                    pr.setInt(2, makan.getIdMakanan());
//                    pr.setInt(3, makan.getIdDaging());
//                    pr.setInt(4, makan.getIdTopping());
//                    pr.setInt(5, makan.getJumlah());
//                    pr.setInt(6, makan.getSubtotal());
//                    pr.executeUpdate(); 
//                    }
//                    
//                }
//                if (FormMakanan.transaksi.get(i) instanceof Cminuman) {
//                    Cminuman minum = (Cminuman)FormMakanan.transaksi.get(i);
//                    
//                    pr = conn.prepareStatement("insert into dtransiminuman(idtrans, idminuman, jumlahminuman,subtotal) values(?,?,?,?)");
//                    pr.setInt(1, maxid);
//                    pr.setInt(2, minum.getIdMinuman());
//                    pr.setInt(3, minum.getJumlah());
//                    pr.setInt(4, minum.getSubtotal());
//                    pr.executeUpdate(); 
//                }
//            }
        }   
        catch (SQLException ex){
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(FormCheckOut.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(FormCheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnback;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonbayar;
    private javax.swing.JButton jButtonclear;
    private javax.swing.JButton jButtonremove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JLabel jLabelTotal1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableMakanan;
    private javax.swing.JTable jTableMinuman;
    // End of variables declaration//GEN-END:variables
}
