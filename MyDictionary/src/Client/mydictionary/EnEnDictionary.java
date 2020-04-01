/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client.mydictionary;

import Server.Exceptions.*;
import Server.MyServer.*;
import Server.ObjectInfos.Word;
import java.awt.Component;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author tangminhtin
 */
public class EnEnDictionary extends javax.swing.JFrame {

    I_TypeModel tm;         // Declare db
    I_MeaningModel mm;  // Declare tm
    I_WordModel wm; // Declare wm

    NewWord frmNewWord = null; // Create frame NewWord
    UpdateWord frmUpdateWord = null; // Create frame UpdateWord
    int selectedWordID = -1;    // Store selected id of word

    ArrayList<Word> theTest = null;     // Declare the Test
    ArrayList<String> userInput = null; // Declare userInput
    TestCreator frmTestCreator = null; // Declare frmTestCreator

    /**
     * Creates new form EnEnDictionary
     *
     * @throws Server.Exceptions.TypeException
     * @throws Server.Exceptions.MeaningException
     * @throws Server.Exceptions.WordException
     * @throws java.rmi.RemoteException
     * @throws java.net.MalformedURLException
     * @throws java.rmi.NotBoundException
     */
    public EnEnDictionary() throws TypeException, MeaningException, WordException, RemoteException, NotBoundException, MalformedURLException {
        initComponents();
        this.setLocationRelativeTo(null);   // Set center frame
        // Set logo frame
        this.setIconImage(getToolkit().getDefaultToolkit().getImage(getClass().getResource("/Client/img/logo.png")));

        try {
            tm = (I_TypeModel) Naming.lookup("rmi://localhost:3223/typeServer"); // Get type server 
            mm = (I_MeaningModel) Naming.lookup("rmi://localhost:3223/meaningServer"); // Get meaning server
            wm = (I_WordModel) Naming.lookup("rmi://localhost:3223/wordServer"); // Get word server

            theTest = new ArrayList<>(); // Initialize theTest
            userInput = new ArrayList<>();  // Initialize userInput

            // Load data from database
            tm.load();  // Load type
            mm.load();  // Load meaning
            wm.load();  // Load word

            loadDictionary();   // Load dictionary
        } catch (SQLException ex) {
            System.out.println(ex); // Show error
        }
    }

    /**
     * Load all word in database to list
     *
     * @throws java.rmi.RemoteException
     */
    public void loadDictionary() throws RemoteException {

        lblWordList.setText("WORD LIST (" + wm.getSize() + " words)"); // Set number of word
        ArrayList<String> listOfWords = wm.showDictionary();    // Get list of word

        DefaultListModel listModel = new DefaultListModel();   // Create list model
        for (String word : listOfWords) {
            listModel.addElement(word); // Add each word to each element of list model
        }

        lstDictionary.setModel(listModel);  // Set model to list
        lstDictionary.setCellRenderer(new DefaultListCellRenderer() { // Set cell render
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                String v = (String) value; // Get value of item
                if (v.startsWith("--------------- ")) {
                    return super.getListCellRendererComponent(list, value, index, false, false); //To change body of generated methods, choose Tools | Templates. 
                }
                return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    /**
     * Show meaning of word if user click on word
     *
     * @param wordSeleted word selected
     */
    public void showMeaning(String wordSeleted) throws RemoteException, WordException, MeaningException, SQLException, TypeException {
            wm.load();
            tm.load();
            mm.load();
            Word word = wm.searchByFullWord(wordSeleted);   // Search word
            if (word != null) {
                int wordID = word.getId();  // Get id of word
                String wordMeaning = wm.showWord(wordID); // Get meaning of word
                tpContent.setText(wordMeaning); // Set text of
                
                selectedWordID = wordID; // Update id of word
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

        lblWordList = new javax.swing.JLabel();
        spWordList = new javax.swing.JScrollPane();
        lstDictionary = new javax.swing.JList<>();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnTest = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        spContent = new javax.swing.JScrollPane();
        tpContent = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("En-En Dictionary v1.0");
        setName("frmEnEnDictionary"); // NOI18N

        lblWordList.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        lblWordList.setForeground(new java.awt.Color(0, 255, 0));
        lblWordList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWordList.setText("WORD LIST (0 words)");

        lstDictionary.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        lstDictionary.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDictionaryValueChanged(evt);
            }
        });
        spWordList.setViewportView(lstDictionary);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/img/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setPreferredSize(new java.awt.Dimension(126, 65));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/img/update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setPreferredSize(new java.awt.Dimension(126, 65));
        btnUpdate.setSize(new java.awt.Dimension(126, 64));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnTest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/img/test.png"))); // NOI18N
        btnTest.setText("Test");
        btnTest.setPreferredSize(new java.awt.Dimension(126, 65));
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Client/img/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setPreferredSize(new java.awt.Dimension(126, 65));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tpContent.setEditable(false);
        tpContent.setContentType("text/html"); // NOI18N
        tpContent.setName("frmEnEnDictionary"); // NOI18N
        spContent.setViewportView(tpContent);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWordList, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(spWordList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(5, 5, 5)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spContent, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblWordList)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spWordList, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(spContent))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Add new word
     *
     * @param evt click
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            if (frmNewWord == null) { // If frame new word is null, then create new frame
                frmNewWord = new NewWord(this, tm, mm, wm);
            }

            frmNewWord.resetFrmNewWord(); // Reset frame new word
            frmNewWord.setVisible(true);    // Show frame
        } catch (RemoteException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TypeException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MeaningException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WordException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * Delete word
     *
     * @param evt click
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (selectedWordID == -1) {     // Check word is selected or not
                JOptionPane.showMessageDialog(this, "You must select a word");  // Show error
            } else {
                Word word = wm.searchById(selectedWordID);  // Get word by id
                String wordText = word.getText();
                int option = JOptionPane.showConfirmDialog(this, "Do you really want to delete word '" + wordText + "'?");
                if (option == 0) {  // Check on Yes button
                    wm.delete(selectedWordID);  // Delete word
                    mm.delete(selectedWordID);  // Delete Meaning
                    loadDictionary();           // Load dictionary
                    tpContent.setText("");      // Set tpContent is empty
                    JOptionPane.showMessageDialog(this, "The word '" + wordText + "' is deleted!");
                }
            }
        } catch (WordException | MeaningException ex) {
            System.out.println(ex); // Show error
        } catch (RemoteException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * Update word
     *
     * @param evt click
     */
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (selectedWordID == -1) {     // Check word is selected or not
            JOptionPane.showMessageDialog(this, "You must select a word");  // Show error
        } else {
            if (frmUpdateWord == null) {    // If frame update is null, then create new frame 
                frmUpdateWord = new UpdateWord(this, tm, mm, wm);   // Create new frame frmUpdateWord
            }

            frmUpdateWord.loadOldWord(selectedWordID);    // Load old word
            frmUpdateWord.setVisible(true); // Show frame update
        }

    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * Test word
     *
     * @param evt click
     */
    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        try {
            if (frmTestCreator == null) { // If frame new word is null, then create new frame
                frmTestCreator = new TestCreator(this, wm, theTest, userInput); // Create new frame frmTestCreator
            }

            frmTestCreator.refresh(); // Reset frame new word
            frmTestCreator.setVisible(true);    // Show frame
        } catch (RemoteException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTestActionPerformed

    /**
     * Gets event when user click item of list
     *
     * @param evt event click
     */
    private void lstDictionaryValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDictionaryValueChanged
        try {
            String wordSelected = lstDictionary.getSelectedValue(); // Get word Seleted
            showMeaning(wordSelected); // Show meaning
        } catch (RemoteException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (WordException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MeaningException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TypeException ex) {
            Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lstDictionaryValueChanged

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
            java.util.logging.Logger.getLogger(EnEnDictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnEnDictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnEnDictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnEnDictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EnEnDictionary().setVisible(true);
                } catch (TypeException | MeaningException | WordException | RemoteException | NotBoundException | MalformedURLException ex) { // Show error
                    Logger.getLogger(EnEnDictionary.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnTest;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblWordList;
    private javax.swing.JList<String> lstDictionary;
    private javax.swing.JScrollPane spContent;
    private javax.swing.JScrollPane spWordList;
    private javax.swing.JTextPane tpContent;
    // End of variables declaration//GEN-END:variables
}
