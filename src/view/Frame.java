package view;

import controller.ActionListenerOfAll;
import controller.HeaderSelectionListener;
import model.HeaderModel;
import model.HeaderTabelModel;
import model.LineModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;

public class Frame extends javax.swing.JFrame {
    public Frame() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        headersTable = new javax.swing.JTable();
        createInvoiceButton = new javax.swing.JButton();
        deleteInvoiceButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        invoiceDateLabel = new javax.swing.JLabel();
        invoiceNumberLabel = new javax.swing.JLabel();
        invoiceTotalLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        linesTable = new javax.swing.JTable();
        createLineButton = new javax.swing.JButton();
        deleteLineButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(250, 150));
        setSize(new java.awt.Dimension(900, 600));

        headersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        headersTable.getSelectionModel().addListSelectionListener(selectionListener);
        jScrollPane1.setViewportView(headersTable);

        createInvoiceButton.setText("New Invoice");
        createInvoiceButton.addActionListener(actionListener);

        deleteInvoiceButton.setText("Delete Invoice");
        deleteInvoiceButton.addActionListener(actionListener);

        jLabel1.setText("Invoice No.");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        linesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(linesTable);

        createLineButton.setText("New Line");
        createLineButton.addActionListener(actionListener);

        deleteLineButton.setText("Delete Line");
        deleteLineButton.addActionListener(actionListener);

        jMenu1.setText("File");

        loadMenuItem.setText("Load File");
        loadMenuItem.addActionListener(actionListener);
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        saveMenuItem.addActionListener(actionListener);
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(createInvoiceButton)
                .addGap(67, 67, 67)
                .addComponent(deleteInvoiceButton)
                .addGap(136, 136, 136)
                .addComponent(createLineButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteLineButton)
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(invoiceTotalLabel)
                            .addComponent(invoiceNumberLabel)
                            .addComponent(invoiceDateLabel)
                            .addComponent(customerNameLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invoiceNumberLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(invoiceDateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(customerNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(invoiceTotalLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createInvoiceButton)
                    .addComponent(deleteInvoiceButton)
                    .addComponent(createLineButton)
                    .addComponent(deleteLineButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createInvoiceButton;
    private javax.swing.JButton createLineButton;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JButton deleteInvoiceButton;
    private javax.swing.JButton deleteLineButton;
    private javax.swing.JTable headersTable;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JLabel invoiceNumberLabel;
    private javax.swing.JLabel invoiceTotalLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable linesTable;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration//GEN-END:variables
    private ActionListenerOfAll actionListener = new ActionListenerOfAll(this);
    public ActionListenerOfAll getActionListener() {
        return actionListener;
    }
    private ArrayList<HeaderModel> headersArray;
    public void setHeadersArray(ArrayList<HeaderModel> headersArray) {
        this.headersArray = headersArray;
    }
    public ArrayList<HeaderModel> getHeadersArray() {
        return headersArray;
    }
    private ArrayList<LineModel> linesArray;
    public ArrayList<LineModel> getLinesArray() {
        return linesArray;
    }
    public void setLinesArray(ArrayList<LineModel> linesArray) {
        this.linesArray = linesArray;
    }
    private HeaderTabelModel headerTableModel;
    public HeaderTabelModel getHeaderTableModel() {
        return headerTableModel;
    }
    public void setHeaderTableModel(HeaderTabelModel headerTableModel) {
        this.headerTableModel = headerTableModel;
    }
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private HeaderSelectionListener selectionListener = new HeaderSelectionListener(this);

    public HeaderModel getObject(int number) {
        for (HeaderModel header : headersArray) {
            if (header.getHeaderNumber() == number) {
                return header;
            }
        }
        return null;
    }
    public JTable getHeadersTable() {
        return headersTable;
    }
    public JTable getLinesTable() {
        return linesTable;
    }
    public JLabel getCustomerNameLabel() {
        return customerNameLabel;
    }
    public JLabel getInvoiceDateLabel() {
        return invoiceDateLabel;
    }
    public JLabel getInvoiceNumberLabel() {
        return invoiceNumberLabel;
    }
    public JLabel getInvoiceTotalLabel() {
        return invoiceTotalLabel;
    }
}
