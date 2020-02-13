/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mininotepad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author tangminhtin
 */
public class frmNodepad extends javax.swing.JFrame {

    private final JFileChooser fileChooser = new JFileChooser();
    boolean isChanged = false;


    
    /**
     * Creates new form frmNodepad
     */
    public frmNodepad() {
        initComponents();
        // Center window
        this.setLocationRelativeTo(null);
        // Set icon for window
        this.setIconImage(getToolkit().getDefaultToolkit().getImage(getClass().getResource("/img/icon.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        spMainNote = new javax.swing.JScrollPane();
        txtAreaMainNote = new javax.swing.JTextArea();
        mnuBar = new javax.swing.JMenuBar();
        mnuFile = new javax.swing.JMenu();
        mniNew = new javax.swing.JMenuItem();
        mniOpen = new javax.swing.JMenuItem();
        mniSave = new javax.swing.JMenuItem();
        mniSaveAs = new javax.swing.JMenuItem();
        mniExit = new javax.swing.JMenuItem();
        mnuEdit = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mini Notepad");

        txtAreaMainNote.setColumns(20);
        txtAreaMainNote.setRows(5);
        spMainNote.setViewportView(txtAreaMainNote);

        mnuFile.setMnemonic('F');
        mnuFile.setText("File");

        mniNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mniNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/new.png"))); // NOI18N
        mniNew.setMnemonic('n');
        mniNew.setText("New");
        mniNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniNewActionPerformed(evt);
            }
        });
        mnuFile.add(mniNew);

        mniOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mniOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/open.png"))); // NOI18N
        mniOpen.setMnemonic('o');
        mniOpen.setText("Open");
        mniOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniOpenActionPerformed(evt);
            }
        });
        mnuFile.add(mniOpen);

        mniSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mniSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/save.png"))); // NOI18N
        mniSave.setMnemonic('s');
        mniSave.setText("Save");
        mniSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSaveActionPerformed(evt);
            }
        });
        mnuFile.add(mniSave);

        mniSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mniSaveAs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/saveAs.png"))); // NOI18N
        mniSaveAs.setMnemonic('a');
        mniSaveAs.setText("Save As");
        mniSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniSaveAsActionPerformed(evt);
            }
        });
        mnuFile.add(mniSaveAs);

        mniExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mniExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/exit.png"))); // NOI18N
        mniExit.setText("Exit");
        mniExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniExitActionPerformed(evt);
            }
        });
        mnuFile.add(mniExit);

        mnuBar.add(mnuFile);

        mnuEdit.setMnemonic('E');
        mnuEdit.setText("Edit");
        mnuBar.add(mnuEdit);

        setJMenuBar(mnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spMainNote, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spMainNote, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniNewActionPerformed
        // TODO add your handling code here:
       
        // Add listener for text area
        DocumentListener listener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                isChanged = true;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                isChanged = true;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                isChanged = true;
            }
        };
        this.txtAreaMainNote.getDocument().addDocumentListener(listener);

        if(isChanged) {

            int option = JOptionPane.showConfirmDialog(this, "Do you want to save", "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);

            if(option == 0) {
                this.mniSaveActionPerformed(evt);
            } else if(option == 1) {
                this.txtAreaMainNote.setText("");
            }
        }

            
            
        
    }//GEN-LAST:event_mniNewActionPerformed

    private void mniOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniOpenActionPerformed
        // TODO add your handling code here:
        int returnVal = fileChooser.showOpenDialog(this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            if(file.getName().toLowerCase().endsWith(".txt")) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String content = "", tmp;
                    while((tmp = br.readLine()) != null) {
                        content += tmp + "\n";
                    }
                    this.txtAreaMainNote.setText(content);
                    br.close();
                } catch (IOException ex) {
                    Logger.getLogger(frmNodepad.class.getName()).log(Level.SEVERE, null, ex);
                } 
            } 
        }
        
    }//GEN-LAST:event_mniOpenActionPerformed

    private void mniSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSaveActionPerformed
        // TODO add your handling code here:
        int returnVal = fileChooser.showSaveDialog(this);
        
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                bw.write(this.txtAreaMainNote.getText());
                bw.close();
            } catch (IOException ex) {
                Logger.getLogger(frmNodepad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_mniSaveActionPerformed

    private void mniSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniSaveAsActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mniSaveAsActionPerformed

    private void mniExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mniExitActionPerformed

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
            java.util.logging.Logger.getLogger(frmNodepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNodepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNodepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNodepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmNodepad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem mniExit;
    private javax.swing.JMenuItem mniNew;
    private javax.swing.JMenuItem mniOpen;
    private javax.swing.JMenuItem mniSave;
    private javax.swing.JMenuItem mniSaveAs;
    private javax.swing.JMenuBar mnuBar;
    private javax.swing.JMenu mnuEdit;
    private javax.swing.JMenu mnuFile;
    private javax.swing.JScrollPane spMainNote;
    private javax.swing.JTextArea txtAreaMainNote;
    // End of variables declaration//GEN-END:variables
}
