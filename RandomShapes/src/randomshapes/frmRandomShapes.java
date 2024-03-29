/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomshapes;

import java.awt.BorderLayout;

/**
 *
 * @author tangminhtin CE130438
 */
public class frmRandomShapes extends javax.swing.JFrame {

    private final Paper paper;  // Declare paper

    /**
     * Creates new form frmRandomShapes
     */
    public frmRandomShapes() {
        initComponents();
        paper = new Paper();    // Create new object paper
        pnlPaper.setLayout(new BorderLayout());   // Set layout for panel paper
        pnlPaper.add(paper, BorderLayout.CENTER);  // Add paper into panel paper
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDrawingTools = new javax.swing.JPanel();
        btnRect = new javax.swing.JButton();
        btnOval = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        pnlPaper = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Random Shapes");

        pnlDrawingTools.setBorder(javax.swing.BorderFactory.createTitledBorder("Drawing tools"));

        btnRect.setMnemonic('e');
        btnRect.setText("Draw rectangle");
        btnRect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRectActionPerformed(evt);
            }
        });

        btnOval.setMnemonic('o');
        btnOval.setText("Draw oval");
        btnOval.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOvalActionPerformed(evt);
            }
        });

        btnClear.setMnemonic('c');
        btnClear.setText("Clear paper");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDrawingToolsLayout = new javax.swing.GroupLayout(pnlDrawingTools);
        pnlDrawingTools.setLayout(pnlDrawingToolsLayout);
        pnlDrawingToolsLayout.setHorizontalGroup(
            pnlDrawingToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDrawingToolsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnRect)
                .addGap(20, 20, 20)
                .addComponent(btnOval)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 481, Short.MAX_VALUE)
                .addComponent(btnClear)
                .addGap(20, 20, 20))
        );
        pnlDrawingToolsLayout.setVerticalGroup(
            pnlDrawingToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDrawingToolsLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlDrawingToolsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRect)
                    .addComponent(btnOval)
                    .addComponent(btnClear))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pnlPaper.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout pnlPaperLayout = new javax.swing.GroupLayout(pnlPaper);
        pnlPaper.setLayout(pnlPaperLayout);
        pnlPaperLayout.setHorizontalGroup(
            pnlPaperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlPaperLayout.setVerticalGroup(
            pnlPaperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPaper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDrawingTools, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(pnlDrawingTools, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pnlPaper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Add new rectangle shape
     *
     * @param evt
     */
    private void btnRectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRectActionPerformed
        paper.addShape("rect", pnlPaper.getWidth(), pnlPaper.getHeight());
    }//GEN-LAST:event_btnRectActionPerformed

    /**
     * Add new oval shape
     *
     * @param evt
     */
    private void btnOvalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOvalActionPerformed
        paper.addShape("oval", pnlPaper.getWidth(), pnlPaper.getHeight());
    }//GEN-LAST:event_btnOvalActionPerformed

    /**
     * Delete all shape
     *
     * @param evt
     */
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        paper.clear();
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * Main program
     *
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
            java.util.logging.Logger.getLogger(frmRandomShapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRandomShapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRandomShapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRandomShapes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRandomShapes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnOval;
    private javax.swing.JButton btnRect;
    private javax.swing.JPanel pnlDrawingTools;
    private javax.swing.JPanel pnlPaper;
    // End of variables declaration//GEN-END:variables
}
