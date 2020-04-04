/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMIClient;

import RMIServer.IModels.I_AccountModel;
import RMIServer.IModels.I_PocketModel;
import RMIServer.ObjectInfos.Account;
import RMIServer.ObjectInfos.Pocket;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author TangMinhTin - CE130438 - tintmce130438@fpt.edu.vn
 */
public class Financial extends javax.swing.JFrame {

    I_AccountModel am; // Store am
    I_PocketModel pm; // Store pm
    ArrayList<Pocket> pockets; // Store pockets
    ArrayList<Account> accounts; // Store accounts

    private String[] columnNames = {"No", "Income / outcome", "Description"}; // set column name
    private DefaultTableModel tableModel; // create table model

    private int aId = -1; // store id account
    private Date firstDate = new Date(2020 - 1900, 1, 1); // year + 1900 => nam that su = 2020 - 1900
    private Date currentDate; // store current date
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // format for date
    private int tableIndex = -1;    // store index of table

    /**
     * Creates new form Financial
     * @param aId
     */
    public Financial(int aId) {
        try {
            initComponents();
            this.setLocationRelativeTo(null); // set center frame

            am = (I_AccountModel) Naming.lookup("rmi://localhost:3223/accountServer"); // lookup account server
            pm = (I_PocketModel) Naming.lookup("rmi://localhost:3223/pocketServer"); // lookup pocket server
            initTable(); // initialize table
            currentDate = new Date(); // store current date
            this.aId = aId;  // Set id of account
            txtDate.setDate(currentDate);   // set date
            txtDate.setFormats(sdf);    // set format
            
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) { // show error
            Logger.getLogger(Financial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * set style of table
     *
     * @param columnIndex columnIndex
     * @param width width
     * @param alignment alignment
     */
    public void setStyleTable(int columnIndex, int width, int alignment) {
        TableColumn column = tblFinancial.getColumnModel().getColumn(columnIndex); // get column model
        column.setMaxWidth(width);  // set max width of column
        column.setMinWidth(width);  // set min width of column
        column.setPreferredWidth(width); // set size of width

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer(); // create table cell renderer
        renderer.setHorizontalAlignment(alignment); // set alignment
        column.setCellRenderer(renderer); // set cell renderer
    }

    /**
     * initialize table
     */
    public void initTable() {
        tableModel = new DefaultTableModel(columnNames, 0); // create new table model
        tblFinancial.setModel(tableModel); // set table model
        // set style row of table
        this.setStyleTable(0, 50, JLabel.CENTER);
        this.setStyleTable(1, 150, JLabel.RIGHT);
        this.setStyleTable(2, 300, JLabel.LEFT);
    }

    /**
     * clear table
     */
    public void clearTable() {
        int numOfRows = tableModel.getRowCount();
        for (int i = numOfRows - 1; i >= 0; i--) { // import
            tableModel.removeRow(i); // clear earch row of table
        }
    }

    /**
     * refresh table
     */
    public void refreshTable() {
        if (currentDate != null && aId > 0) { // check date, id account is invalid or not
            try {
                am.load(); // load account
                pm.load(); // load pocket

                accounts = am.getAll(); // get all account
                pockets = pm.search(aId, currentDate); // search pocket of account

                clearTable(); // clear table
                int i = -1;
                for (Pocket p : pockets) {
                    i++; // set data for earch row
                    tableModel.insertRow(i, new Object[]{i + 1, p.getMoney(), p.getDescription()});
                }

                long income = pm.income(aId, currentDate); // get income
                long outcome = pm.outcome(aId, currentDate); // get outcome
                long total = pm.total(aId, firstDate, currentDate); // get total

                lblIncome.setText(String.format("%,d", income)); // set income
                lblOutcome.setText(String.format("%,d", outcome)); // set outcome
                lblTotalMoney.setText(String.format("%,d", total)); // set total
                lblHeader.setText("Income / outcome of " + sdf.format(currentDate)); // set date
                clearInput(); // clear data
            } catch (RemoteException ex) { // show error
                Logger.getLogger(Financial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * clear input
     */
    public void clearInput() {
        txtMoney.setText("0"); // set money to 0
        txtaDescription.setText(""); // set description to empty
        txtMoney.requestFocus(); // focus to momey
        tableIndex = -1; // set index table is -1
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTable = new javax.swing.JPanel();
        lblHeader = new javax.swing.JLabel();
        spInOutcome = new javax.swing.JScrollPane();
        tblFinancial = new javax.swing.JTable();
        pnlPocketInfo = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        lblIn = new javax.swing.JLabel();
        lblOut = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblIncome = new javax.swing.JLabel();
        lblOutcome = new javax.swing.JLabel();
        lblTotalMoney = new javax.swing.JLabel();
        txtDate = new org.jdesktop.swingx.JXDatePicker();
        pnlManagement = new javax.swing.JPanel();
        lblInOut = new javax.swing.JLabel();
        txtMoney = new javax.swing.JTextField();
        lblDescription = new javax.swing.JLabel();
        spManagement = new javax.swing.JScrollPane();
        txtaDescription = new javax.swing.JTextArea();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Financial Management");
        setName("frmFinancialManagement"); // NOI18N

        lblHeader.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Income / outcome of 2020-04-02");

        tblFinancial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tblFinancial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFinancialMouseClicked(evt);
            }
        });
        spInOutcome.setViewportView(tblFinancial);

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spInOutcome, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spInOutcome, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlPocketInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pocket's Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        lblDate.setText("Date");

        lblIn.setText("Income");

        lblOut.setText("Outcome");

        lblTotal.setText("Total");

        lblIncome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblIncome.setText("0");

        lblOutcome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblOutcome.setText("0");

        lblTotalMoney.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalMoney.setText("0");

        txtDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtDatePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout pnlPocketInfoLayout = new javax.swing.GroupLayout(pnlPocketInfo);
        pnlPocketInfo.setLayout(pnlPocketInfoLayout);
        pnlPocketInfoLayout.setHorizontalGroup(
            pnlPocketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPocketInfoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlPocketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotal)
                    .addComponent(lblOut)
                    .addComponent(lblIn)
                    .addComponent(lblDate))
                .addGap(18, 18, 18)
                .addGroup(pnlPocketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIncome, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(lblOutcome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalMoney, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        pnlPocketInfoLayout.setVerticalGroup(
            pnlPocketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPocketInfoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlPocketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(pnlPocketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIn)
                    .addComponent(lblIncome))
                .addGap(5, 5, 5)
                .addGroup(pnlPocketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOut)
                    .addComponent(lblOutcome))
                .addGap(5, 5, 5)
                .addGroup(pnlPocketInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(lblTotalMoney))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlManagement.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Management", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18))); // NOI18N

        lblInOut.setText("Income / outcome");

        lblDescription.setText("Description");

        txtaDescription.setColumns(20);
        txtaDescription.setRows(5);
        spManagement.setViewportView(txtaDescription);

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlManagementLayout = new javax.swing.GroupLayout(pnlManagement);
        pnlManagement.setLayout(pnlManagementLayout);
        pnlManagementLayout.setHorizontalGroup(
            pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMoney)
                    .addComponent(spManagement)
                    .addComponent(lblInOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlManagementLayout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlManagementLayout.setVerticalGroup(
            pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblInOut)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMoney, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spManagement, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnDelete)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPocketInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(pnlPocketInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * delete pocket
     *
     * @param evt click
     */
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            if (tableIndex == -1) { // check pocket is selected or not
                JOptionPane.showMessageDialog(this, "You must select any row!");
            } else {
                int choose = JOptionPane.showConfirmDialog(this, "Do you really want to delete this payment?");
                if (choose == 0) {
                    tableIndex = tblFinancial.getSelectedRow();
                    Pocket pocket = pockets.get(tableIndex); // get pocket
                    long pId = pocket.getpId(); // get id account
                    pm.delete(pId);  // delete pocket
                    refreshTable(); // refresh data
                }
            }
        } catch (RemoteException ex) { // show error
            Logger.getLogger(Financial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * add pocket
     *
     * @param evt click
     */
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            try {
                long money = Long.parseLong(txtMoney.getText()); // get money
                String description = txtaDescription.getText(); // get description

                if (description.trim().isEmpty() || money == 0) { // check empty or zero by input of user
                    JOptionPane.showMessageDialog(this, "The payment or receive can't be zero, and description can't be empty!");
                } else {
                    pm.insert(money, description, currentDate, aId); // insert pocket
                    refreshTable(); // refresh data
                }
            } catch (NumberFormatException e) { // show error
                JOptionPane.showMessageDialog(this, "Can't add new data, because your input is invalid!");
            }
        } catch (RemoteException ex) { // show error
            Logger.getLogger(Financial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * Update pocket
     *
     * @param evt click
     */
    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (tableIndex == -1) {// check pocket is selected or not
            JOptionPane.showMessageDialog(this, "You must select any row!");
        } else {
            try {
                tableIndex = tblFinancial.getSelectedRow(); // get index of table when user click
                Pocket pocket = pockets.get(tableIndex); // get pocket

                long pId = pocket.getpId(); // get id pocket
                try {
                    long money = Long.parseLong(txtMoney.getText()); // get money
                    String description = txtaDescription.getText(); // get description

                    if (description.trim().isEmpty() || money == 0) { // check empty or zero by input of user
                        JOptionPane.showMessageDialog(this, "The payment or receive can't be zero, and description can't be empty!");
                    } else {
                        pm.update(pId, money, description); // update pocket
                        refreshTable(); // refresh table
                    }
                } catch (NumberFormatException e) { // show error
                    JOptionPane.showMessageDialog(this, "Can't add update data, because your input is invalid!");
                }
            } catch (RemoteException ex) { // show error
                Logger.getLogger(Financial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    /**
     * Clear data
     *
     * @param evt
     */
    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        clearInput();
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * Check clicked on table
     *
     * @param evt click
     */
    private void tblFinancialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFinancialMouseClicked
        tableIndex = tblFinancial.getSelectedRow(); // get index of row
        Pocket pocket = pockets.get(tableIndex); // get pocket
        txtMoney.setText(pocket.getMoney() + ""); // set money
        txtaDescription.setText(pocket.getDescription()); // set description
    }//GEN-LAST:event_tblFinancialMouseClicked

    /**
     * tracking status of table
     *
     * @param evt click
     */
    private void txtDatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtDatePropertyChange
        currentDate = txtDate.getDate(); // get date
        refreshTable(); // refresh table
    }//GEN-LAST:event_txtDatePropertyChange

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Financial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Financial().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblIn;
    private javax.swing.JLabel lblInOut;
    private javax.swing.JLabel lblIncome;
    private javax.swing.JLabel lblOut;
    private javax.swing.JLabel lblOutcome;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalMoney;
    private javax.swing.JPanel pnlManagement;
    private javax.swing.JPanel pnlPocketInfo;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JScrollPane spInOutcome;
    private javax.swing.JScrollPane spManagement;
    private javax.swing.JTable tblFinancial;
    private org.jdesktop.swingx.JXDatePicker txtDate;
    private javax.swing.JTextField txtMoney;
    private javax.swing.JTextArea txtaDescription;
    // End of variables declaration//GEN-END:variables
}
