/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class ViewAllRecord extends javax.swing.JFrame {

    /**
     * Creates new form ViewAllRecord
     */
    Color mouseEnterColor = new Color(204,0,0);
    Color mouseExitColor = new Color(255,51,51);
    DefaultTableModel model;
    public ViewAllRecord() {
        initComponents();
        setIssueBookDetailsToTable();
    }
    
    // To set the book details into the table
    public void setIssueBookDetailsToTable() {
        
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_book_details");
            
            while(rs.next()) {
                String id = rs.getString("id");
                String bookName = rs.getString("book_name");
                String studentName = rs.getString("student_name");
                String issueDate = rs.getString("issue_date");
                String dueDate = rs.getString("due_date");
                String status = rs.getString("status");
                
                Object[] obj = {id,bookName,studentName,issueDate,dueDate,status};
                model = (DefaultTableModel)tbl_issueBookDetails.getModel();
                model.addRow(obj);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // method to clear the table data
    
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_issueBookDetails.getModel();
        model.setRowCount(0);
    }
    
    //to fetch the record using date fields
    public void search() {
        
        Date ufromDate = date_fromDate.getDatoFecha();
        Date utoDate = date_toDate.getDatoFecha();
        
        long l1 = ufromDate.getTime();
        long l2 = utoDate.getTime();
        
        java.sql.Date fromDate = new java.sql.Date(l1);
        java.sql.Date toDate = new java.sql.Date(l2);
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where issue_date BETWEEN ? and ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setDate(1, fromDate);
            pst.setDate(2, toDate);
            
            ResultSet rs = pst.executeQuery();
            
            if(!rs.next()) {
                JOptionPane.showMessageDialog(this, "No Record Found");
            }else {
                while (rs.next()) {
                    String id = rs.getString("id");
                    String bookName = rs.getString("book_name");
                    String studentName = rs.getString("student_name");
                    String issueDate = rs.getString("issue_date");
                    String dueDate = rs.getString("due_date");
                    String status = rs.getString("status");

                    Object[] obj = {id, bookName, studentName, issueDate, dueDate, status};
                    model = (DefaultTableModel) tbl_issueBookDetails.getModel();
                    model.addRow(obj);
                }
            } 
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        date_fromDate = new rojeru_san.componentes.RSDateChooser();
        jLabel8 = new javax.swing.JLabel();
        date_toDate = new rojeru_san.componentes.RSDateChooser();
        AllBtn = new rojerusan.RSMaterialButtonCircle();
        jLabel10 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        backPanel = new javax.swing.JPanel();
        backBtn = new javax.swing.JLabel();
        closePanel = new javax.swing.JPanel();
        closeBtn = new javax.swing.JLabel();
        searchBtn = new rojerusan.RSMaterialButtonCircle();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_issueBookDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("From :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

        date_fromDate.setAlignmentX(0.0F);
        date_fromDate.setAlignmentY(0.0F);
        date_fromDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_fromDate.setColorButtonHover(new java.awt.Color(204, 0, 0));
        date_fromDate.setColorDiaActual(new java.awt.Color(255, 51, 51));
        date_fromDate.setColorForeground(new java.awt.Color(140, 140, 140));
        date_fromDate.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        date_fromDate.setFormatoFecha("dd/MM/yyyy");
        date_fromDate.setFuente(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        date_fromDate.setPlaceholder("Start Date");
        jPanel1.add(date_fromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 290, -1));

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("To :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 150, -1, -1));

        date_toDate.setAlignmentX(0.0F);
        date_toDate.setAlignmentY(0.0F);
        date_toDate.setColorBackground(new java.awt.Color(255, 51, 51));
        date_toDate.setColorButtonHover(new java.awt.Color(204, 0, 0));
        date_toDate.setColorDiaActual(new java.awt.Color(255, 51, 51));
        date_toDate.setColorForeground(new java.awt.Color(140, 140, 140));
        date_toDate.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        date_toDate.setFormatoFecha("dd/MM/yyyy");
        date_toDate.setFuente(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        date_toDate.setPlaceholder("End Date");
        jPanel1.add(date_toDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 140, 290, -1));

        AllBtn.setBackground(new java.awt.Color(255, 51, 51));
        AllBtn.setText("All");
        AllBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllBtnActionPerformed(evt);
            }
        });
        jPanel1.add(AllBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 130, 140, 50));

        jLabel10.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel10.setText("Issue Book Details");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 340, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 110, 340, -1));

        backPanel.setBackground(new java.awt.Color(255, 51, 51));
        backPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backBtn.setFont(new java.awt.Font("Century Schoolbook", 1, 16)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        backBtn.setText(" Back");
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtnMouseExited(evt);
            }
        });
        backPanel.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        jPanel1.add(backPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 40));

        closePanel.setBackground(new java.awt.Color(255, 51, 51));
        closePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeBtn.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 25)); // NOI18N
        closeBtn.setForeground(new java.awt.Color(255, 255, 255));
        closeBtn.setText("X");
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                closeBtnMouseExited(evt);
            }
        });
        closePanel.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        jPanel1.add(closePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1410, 0, 40, 40));

        searchBtn.setBackground(new java.awt.Color(255, 51, 51));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        jPanel1.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 130, 140, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 200));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_issueBookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Book Name", "Student Name", "Issue Date", "Due Date", "Status"
            }
        ));
        tbl_issueBookDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_issueBookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_issueBookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_issueBookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_issueBookDetails.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        tbl_issueBookDetails.setFuenteFilas(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        tbl_issueBookDetails.setFuenteFilasSelect(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        tbl_issueBookDetails.setFuenteHead(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        tbl_issueBookDetails.setRowHeight(30);
        jScrollPane2.setViewportView(tbl_issueBookDetails);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 1030, 270));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1450, 400));

        setSize(new java.awt.Dimension(1450, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_backBtnMouseClicked

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        backPanel.setBackground(mouseEnterColor);
    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        backPanel.setBackground(new Color(102,102,255));
    }//GEN-LAST:event_backBtnMouseExited

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeBtnMouseClicked

    private void closeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseEntered
        closePanel.setBackground(mouseEnterColor);
    }//GEN-LAST:event_closeBtnMouseEntered

    private void closeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseExited
        closePanel.setBackground(mouseExitColor);
    }//GEN-LAST:event_closeBtnMouseExited

    private void AllBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllBtnActionPerformed
        clearTable();
        setIssueBookDetailsToTable();
    }//GEN-LAST:event_AllBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        if(date_fromDate.getDatoFecha() != null && date_toDate.getDatoFecha() != null) {
            clearTable();
            search();
        }else {
            JOptionPane.showMessageDialog(this, "Please Select A Date");
        }
        
    }//GEN-LAST:event_searchBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAllRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAllRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle AllBtn;
    private javax.swing.JLabel backBtn;
    private javax.swing.JPanel backPanel;
    private javax.swing.JLabel closeBtn;
    private javax.swing.JPanel closePanel;
    private rojeru_san.componentes.RSDateChooser date_fromDate;
    private rojeru_san.componentes.RSDateChooser date_toDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle searchBtn;
    private rojeru_san.complementos.RSTableMetro tbl_issueBookDetails;
    // End of variables declaration//GEN-END:variables
}