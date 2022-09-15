/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JFrame;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Asus
 */
public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    Color mouseEnterColor = new Color(204,0,0);
    Color mouseExitColor = new Color(102,102,255);
    String studentName, course, branch;
    int studentId;
    DefaultTableModel model;
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }
    
    // To set the book details into the table
    
    public void setStudentDetailsToTable() {
        
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");
            
            while(rs.next()) {
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("name");
                String course = rs.getString("course");
                String branch = rs.getString("branch");
                
                Object[] obj = {studentId, studentName, course, branch};
                model = (DefaultTableModel)tbl_studentsDetails.getModel();
                model.addRow(obj);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // to add book to student_details table;
    
    public boolean addStudent() {
        
        boolean isAdded = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into student_details value(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isAdded = true;
            }else {
                isAdded = false;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    // methode to update student Details
    
    public boolean updateStudent() {
        boolean isUpdated = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = combo_CourseName.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update student_details set name = ?, course = ?, branch = ? where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentName);
            pst.setString(2, course);
            pst.setString(3, branch);
            pst.setInt(4, studentId);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0) {
                isUpdated = true;
            }else {
                isUpdated = false;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return isUpdated;
    }
    
    // method to delete student details
    
    public boolean deleteStudent() {
        boolean isDeleted = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from student_details where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            
            int rowCount = pst.executeUpdate();
            if(rowCount > 0) {
                isDeleted = true;
            }else {
                isDeleted = false;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
    
    // method to clear the table data
    
    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) tbl_studentsDetails.getModel();
        model.setRowCount(0);
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
        backPanel = new javax.swing.JPanel();
        BackBtn = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        username1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        username2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        username3 = new javax.swing.JLabel();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_studentName = new app.bolivia.swing.JCTextField();
        DeleteBtn = new rojerusan.RSMaterialButtonCircle();
        AddBtn = new rojerusan.RSMaterialButtonCircle();
        UpdateBtn = new rojerusan.RSMaterialButtonCircle();
        combo_branch = new javax.swing.JComboBox<>();
        combo_CourseName = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        closePanel = new javax.swing.JPanel();
        closeBtn = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentsDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel24 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backPanel.setBackground(new java.awt.Color(255, 51, 51));
        backPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackBtn.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        BackBtn.setForeground(new java.awt.Color(255, 255, 255));
        BackBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        BackBtn.setText("Back");
        BackBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BackBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BackBtnMouseExited(evt);
            }
        });
        backPanel.add(BackBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 40));

        jPanel1.add(backPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));

        username.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Enter Student Id");
        jPanel1.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 130, 20));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 50, 60));

        username1.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        username1.setForeground(new java.awt.Color(255, 255, 255));
        username1.setText("Enter Student Name");
        jPanel1.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 160, 20));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 50, 60));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 50, 60));

        username2.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        username2.setForeground(new java.awt.Color(255, 255, 255));
        username2.setText("Select Course");
        jPanel1.add(username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 110, 20));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 50, 60));

        username3.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        username3.setForeground(new java.awt.Color(255, 255, 255));
        username3.setText("Branch");
        jPanel1.add(username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 60, 20));

        txt_studentId.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentId.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentId.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        txt_studentId.setPlaceholder("Enter Student Id...");
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 300, 30));

        txt_studentName.setBackground(new java.awt.Color(102, 102, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_studentName.setForeground(new java.awt.Color(255, 255, 255));
        txt_studentName.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        txt_studentName.setPlaceholder("Enter Student Name...");
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 300, 30));

        DeleteBtn.setBackground(new java.awt.Color(255, 51, 51));
        DeleteBtn.setText("DELETE");
        DeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteBtnActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 520, 120, 70));

        AddBtn.setBackground(new java.awt.Color(255, 51, 51));
        AddBtn.setText("ADD");
        AddBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBtnActionPerformed(evt);
            }
        });
        jPanel1.add(AddBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 120, 70));

        UpdateBtn.setBackground(new java.awt.Color(255, 51, 51));
        UpdateBtn.setText("Update");
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 520, 120, 70));

        combo_branch.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Civil", "Computer Science", "Electricals", "Electronics", "Economics(Hons.)", "History(Hons.)", "IT", "Law", "Mechanical" }));
        jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 300, 30));

        combo_CourseName.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        combo_CourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "B.A.", "B.Com", "B.Sc.", "B.Tech", "BCA", "M.A.", "MBA", "MCA", "M.Sc.", "M.Tech", " ", " " }));
        jPanel1.add(combo_CourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 300, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closePanel.setBackground(new java.awt.Color(102, 102, 255));
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

        jPanel3.add(closePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 40, 40));

        tbl_studentsDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Name", "Course", "Branch"
            }
        ));
        tbl_studentsDetails.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studentsDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studentsDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentsDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studentsDetails.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        tbl_studentsDetails.setFuenteFilas(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        tbl_studentsDetails.setFuenteFilasSelect(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        tbl_studentsDetails.setFuenteHead(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        tbl_studentsDetails.setRowHeight(30);
        tbl_studentsDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentsDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentsDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 710, 270));

        jLabel24.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 51, 51));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel24.setText("Manage Students");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 170, 340, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 960, 830));

        setSize(new java.awt.Dimension(1540, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackBtnMouseClicked

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeBtnMouseClicked

    private void tbl_studentsDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentsDetailsMouseClicked
        
        int rowNo = tbl_studentsDetails.getSelectedRow();
        TableModel model = tbl_studentsDetails.getModel();
        
        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo, 1).toString());
        combo_CourseName.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
        
    }//GEN-LAST:event_tbl_studentsDetailsMouseClicked

    private void AddBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBtnActionPerformed
        if(addStudent()) {
            JOptionPane.showMessageDialog(this, "Student Details Added Succesfully");
            clearTable();
            setStudentDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "Student Details addition Failed");
        }
    }//GEN-LAST:event_AddBtnActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed
        if(updateStudent()) {
            JOptionPane.showMessageDialog(this, "Student Details Updated Succesfully");
            clearTable();
            setStudentDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "Student Details Updation Failed");
        }
    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void DeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteBtnActionPerformed
        if(deleteStudent()) {
            JOptionPane.showMessageDialog(this, "Student Deleted Succesfully");
            clearTable();
            setStudentDetailsToTable();
        }else {
            JOptionPane.showMessageDialog(this, "Student Deletion Failed");
        }
    }//GEN-LAST:event_DeleteBtnActionPerformed

    private void closeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseEntered
        closePanel.setBackground(mouseEnterColor);
    }//GEN-LAST:event_closeBtnMouseEntered

    private void closeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseExited
        closePanel.setBackground(mouseExitColor);
    }//GEN-LAST:event_closeBtnMouseExited

    private void BackBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseEntered
        backPanel.setBackground(mouseEnterColor);
    }//GEN-LAST:event_BackBtnMouseEntered

    private void BackBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackBtnMouseExited
        backPanel.setBackground(mouseExitColor);
    }//GEN-LAST:event_BackBtnMouseExited

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle AddBtn;
    private javax.swing.JLabel BackBtn;
    private rojerusan.RSMaterialButtonCircle DeleteBtn;
    private rojerusan.RSMaterialButtonCircle UpdateBtn;
    private javax.swing.JPanel backPanel;
    private javax.swing.JLabel closeBtn;
    private javax.swing.JPanel closePanel;
    private javax.swing.JComboBox<String> combo_CourseName;
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojeru_san.complementos.RSTableMetro tbl_studentsDetails;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    private javax.swing.JLabel username;
    private javax.swing.JLabel username1;
    private javax.swing.JLabel username2;
    private javax.swing.JLabel username3;
    // End of variables declaration//GEN-END:variables
}
