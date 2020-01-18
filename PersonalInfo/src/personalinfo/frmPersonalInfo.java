package personalinfo;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tangminhtin
 */
public class frmPersonalInfo extends javax.swing.JFrame {
    
    /**
     * Sets birthday
     * @param text 
     */
    public void setBirthday(String text) {
        lblBirthday.setText(text);
    }

    /**
     * Creates new form frmPersonalInfo
     */
    public frmPersonalInfo() {
        initComponents();
        
        // Center window
        this.setLocationRelativeTo(null);
        
        // Set icon for window
        this.setIconImage(getToolkit().getDefaultToolkit().getImage(getClass().getResource("user.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        jDialog3 = new javax.swing.JDialog();
        pnlMyPersonalInfo = new javax.swing.JPanel();
        lblname = new javax.swing.JLabel();
        lblChangeName = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblbirthday = new javax.swing.JLabel();
        lblBirthday = new javax.swing.JLabel();
        lblChangeBirthday = new javax.swing.JLabel();
        lblsex = new javax.swing.JLabel();
        lblSex = new javax.swing.JLabel();
        lblChangeSex = new javax.swing.JLabel();
        lblmarried = new javax.swing.JLabel();
        lblMarried = new javax.swing.JLabel();
        lblChangeMarried = new javax.swing.JLabel();
        lblProfile = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personal Information Manager");

        pnlMyPersonalInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "My Personal Info", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 0, 24))); // NOI18N

        lblname.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblname.setText("Name:");

        lblChangeName.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblChangeName.setForeground(new java.awt.Color(0, 0, 255));
        lblChangeName.setText("Change");
        lblChangeName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChangeNameMouseClicked(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName.setText("Tăng Minh Tín");

        lblbirthday.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblbirthday.setText("Birthday:");

        lblBirthday.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblBirthday.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBirthday.setText("29/09/1999");

        lblChangeBirthday.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblChangeBirthday.setForeground(new java.awt.Color(0, 0, 255));
        lblChangeBirthday.setText("Change");
        lblChangeBirthday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChangeBirthdayMouseClicked(evt);
            }
        });

        lblsex.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblsex.setText("Sex:");

        lblSex.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblSex.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSex.setText("Male");

        lblChangeSex.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblChangeSex.setForeground(new java.awt.Color(0, 0, 255));
        lblChangeSex.setText("Change");
        lblChangeSex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChangeSexMouseClicked(evt);
            }
        });

        lblmarried.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblmarried.setText("Married:");

        lblMarried.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblMarried.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMarried.setText("No");

        lblChangeMarried.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblChangeMarried.setForeground(new java.awt.Color(0, 0, 255));
        lblChangeMarried.setText("Change");
        lblChangeMarried.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChangeMarriedMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlMyPersonalInfoLayout = new javax.swing.GroupLayout(pnlMyPersonalInfo);
        pnlMyPersonalInfo.setLayout(pnlMyPersonalInfoLayout);
        pnlMyPersonalInfoLayout.setHorizontalGroup(
            pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyPersonalInfoLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMyPersonalInfoLayout.createSequentialGroup()
                        .addGroup(pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblname)
                            .addComponent(lblbirthday))
                        .addGap(40, 40, 40)
                        .addGroup(pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblChangeName)
                            .addComponent(lblChangeBirthday)))
                    .addGroup(pnlMyPersonalInfoLayout.createSequentialGroup()
                        .addGroup(pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblsex)
                            .addComponent(lblmarried))
                        .addGap(47, 47, 47)
                        .addGroup(pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblMarried, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSex, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblChangeSex, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblChangeMarried, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(25, 25, 25))
        );
        pnlMyPersonalInfoLayout.setVerticalGroup(
            pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMyPersonalInfoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblname)
                    .addComponent(lblName)
                    .addComponent(lblChangeName))
                .addGap(40, 40, 40)
                .addGroup(pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblbirthday)
                    .addComponent(lblBirthday)
                    .addComponent(lblChangeBirthday))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblsex)
                    .addComponent(lblSex)
                    .addComponent(lblChangeSex))
                .addGap(37, 37, 37)
                .addGroup(pnlMyPersonalInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarried)
                    .addComponent(lblChangeMarried)
                    .addComponent(lblmarried))
                .addGap(27, 27, 27))
        );

        lblProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/personalinfo/profile.jpg"))); // NOI18N
        lblProfile.setAlignmentY(0.0F);
        lblProfile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblProfile.setMaximumSize(new java.awt.Dimension(200, 200));
        lblProfile.setMinimumSize(new java.awt.Dimension(200, 200));
        lblProfile.setPreferredSize(new java.awt.Dimension(200, 200));
        lblProfile.setSize(new java.awt.Dimension(5, 16));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lblProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMyPersonalInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlMyPersonalInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Change name
     * @param evt 
     */
    private void lblChangeNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangeNameMouseClicked
        
        // Show option pane for user to change name and sort name to variable name
        String name = JOptionPane.showInputDialog(this, 
                "Please enter your name: ", "Change name",
                JOptionPane.INFORMATION_MESSAGE, null, null,
                lblName.getText()).toString();
        
        // Set label name 
        lblName.setText(name);
    }//GEN-LAST:event_lblChangeNameMouseClicked
    
    /**
     * Change birthday
     * @param evt 
     */
    private void lblChangeBirthdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangeBirthdayMouseClicked
        // Create new changeBirthday
        frmChangeBirthday changeBirthday = new frmChangeBirthday();
       
        // Set text for ftfBirthday
        changeBirthday.setBirthday(lblBirthday.getText());
        changeBirthday.setLocationRelativeTo(null);
        
        // Hide current window and show window of changeBirthday.
        this.setVisible(false);
        changeBirthday.setVisible(true);
    }//GEN-LAST:event_lblChangeBirthdayMouseClicked

    /**
     * Change gender
     * @param evt 
     */
    private void lblChangeSexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangeSexMouseClicked
        // Array to sort list of gender
        String[] sexes = {"Male", "Female", "Other"};
        // Get index of array when user choose
        int choice = JOptionPane.showOptionDialog(this,
                "Please choose your sex", "Sex choose",
                JOptionPane.INFORMATION_MESSAGE,
                JOptionPane.OK_OPTION, null, sexes, lblSex.getText());
        
        // Set label gender
        lblSex.setText(sexes[choice]);
    }//GEN-LAST:event_lblChangeSexMouseClicked

    /**
     * Change married
     * @param evt 
     */
    private void lblChangeMarriedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChangeMarriedMouseClicked
        // Get index of button Yes/No
        int choice = JOptionPane.showConfirmDialog(this, 
                "Do you get married?", "Get married",
                JOptionPane.YES_NO_OPTION);
        
        // If choice is 0 set label married is Yes otherwise is No
        if (choice==0) {
            lblMarried.setText("Yes");
        } else {
            lblMarried.setText("No");
        }
    }//GEN-LAST:event_lblChangeMarriedMouseClicked

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
            java.util.logging.Logger.getLogger(frmPersonalInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPersonalInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPersonalInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPersonalInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPersonalInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel lblBirthday;
    private javax.swing.JLabel lblChangeBirthday;
    private javax.swing.JLabel lblChangeMarried;
    private javax.swing.JLabel lblChangeName;
    private javax.swing.JLabel lblChangeSex;
    private javax.swing.JLabel lblMarried;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblProfile;
    private javax.swing.JLabel lblSex;
    private javax.swing.JLabel lblbirthday;
    private javax.swing.JLabel lblmarried;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblsex;
    private javax.swing.JPanel pnlMyPersonalInfo;
    // End of variables declaration//GEN-END:variables
}
