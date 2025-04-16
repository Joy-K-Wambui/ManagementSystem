/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package customerserviceticketingsystemswing;

import javax.swing.table.DefaultTableModel;
import customerserviceticketingsystemswing.DAO.TicketManager;
import customerserviceticketingsystemswing.DAO.Ticket;

/**
 *
 * @author Adimn
 */
public class ViewOpenTicketsPanel extends javax.swing.JPanel {
    private TicketManager ticketManager;

    /**
     * Creates new form ViewOpenTicketsPanels
     */
    public ViewOpenTicketsPanel(TicketManager ticketManager) {
        this.ticketManager = ticketManager;
        initComponents();
        loadTickets();
    }

    public void loadTickets() {
        DefaultTableModel model = (DefaultTableModel) ticketsTable.getModel();
        model.setRowCount(0);
        
        for (Ticket ticket : ticketManager.getAllTickets()) {
            model.addRow(new Object[]{
                ticket.getTicketId(),
                ticket.getCustomerName(),
                ticket.getIssue(),
                ticket.getPriority(),
                ticket.getStatus()
            });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        ticketsTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));

        ticketsTable.setBackground(new java.awt.Color(204, 204, 255));
        ticketsTable.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        ticketsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Ticket ID", "Customer Name", "Issue Summary", "Priority", "Description"
            }
        ));
        ticketsTable.setRowHeight(75);
        jScrollPane1.setViewportView(ticketsTable);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Open Tickets");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(367, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(330, 330, 330))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ticketsTable;
    // End of variables declaration//GEN-END:variables
}
