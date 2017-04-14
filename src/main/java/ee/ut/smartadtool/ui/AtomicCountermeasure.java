/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.smartadtool.ui;

import ee.ut.smartadtool.service.DataPopulator;
import ee.ut.smarttool.DB.CountermeasureDBService;
import ee.ut.smarttool.DB.IDGenerator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.PieStyler;
import org.knowm.xchart.style.Styler;

/**
 *
 * @author Salman
 */
public class AtomicCountermeasure extends javax.swing.JFrame {

    /**
     * Creates new form AtomicCountermeasure
     */
    CountermeasureDBService countermeasureDBService;
    
    public AtomicCountermeasure() {
        countermeasureDBService=new CountermeasureDBService();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        attackTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        countermeasureNameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        countermeasureDescriptionTA = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        addAtomicAttack = new javax.swing.JButton();
        probabilityjSpinner = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        countermeasureCostTF = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        attackTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                attackTabbedPaneStateChanged(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel1.setText("Countermeasure");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 30, 100, 14);
        jPanel1.add(countermeasureNameTF);
        countermeasureNameTF.setBounds(170, 30, 180, 20);

        jLabel2.setText("Description");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(35, 98, 70, 14);

        countermeasureDescriptionTA.setColumns(20);
        countermeasureDescriptionTA.setRows(5);
        jScrollPane1.setViewportView(countermeasureDescriptionTA);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(121, 60, 230, 130);

        jLabel3.setText("Probability");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(410, 70, 90, 14);

        addAtomicAttack.setBackground(new java.awt.Color(0, 153, 204));
        addAtomicAttack.setText("Add Atomic Attack");
        addAtomicAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAtomicAttackActionPerformed(evt);
            }
        });
        jPanel1.add(addAtomicAttack);
        addAtomicAttack.setBounds(260, 280, 310, 40);

        probabilityjSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        probabilityjSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                probabilityjSpinnerStateChanged(evt);
            }
        });
        jPanel1.add(probabilityjSpinner);
        probabilityjSpinner.setBounds(570, 70, 80, 20);

        jLabel10.setText("Cost");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(420, 160, 80, 20);
        jPanel1.add(countermeasureCostTF);
        countermeasureCostTF.setBounds(570, 160, 80, 20);

        attackTabbedPane.addTab("Add Atomic Countermeasure", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Description", "Probability", "Cost"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setText("Delete Countermeasure");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 255));
        jButton3.setText("Update Countermeasure");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 32, Short.MAX_VALUE))
        );

        attackTabbedPane.addTab("Edit Atomic Countermeasure", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(attackTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(attackTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addAtomicAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAtomicAttackActionPerformed
        try {

            String name=countermeasureNameTF.getText();
            String description=countermeasureDescriptionTA.getText();
            String cost=countermeasureCostTF.getText();
          //  String costOfDamage=countermeasureCostTF.getText();
            String probaility=probabilityjSpinner.getValue().toString();
          //   String id =IDGenerator.nextId();
            countermeasureDBService.insertAtomicCountermeasure(name,description,probaility,cost);
            JOptionPane.showMessageDialog(null, "The record is inserted successfully.", "Success",JOptionPane.INFORMATION_MESSAGE );

        } catch (Exception ex) {
            Logger.getLogger(AtomicAttack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addAtomicAttackActionPerformed
    public void chartDrawer(int success){
        PieChart chart = new PieChartBuilder().width(300).height(210).title("Failure Vs Success").theme(Styler.ChartTheme.GGPlot2).build();

    // Customize Chart
    chart.getStyler().setLegendVisible(false);
    chart.getStyler().setAnnotationType(PieStyler.AnnotationType.LabelAndPercentage);
    chart.getStyler().setAnnotationDistance(1.15);
    chart.getStyler().setPlotContentSize(.7);
    chart.getStyler().setStartAngleInDegrees(90);

    // Series
    chart.addSeries("Success", success);
    chart.addSeries("Failure", (100-success));


        try {
            // Show it
             new SwingWrapper(chart).displayChart();
             
            BitmapEncoder.saveBitmap(chart, "C://pie-pic/img.png", BitmapEncoder.BitmapFormat.PNG);
        } catch (IOException ex) {
         //   Logger.getLogger(AtomicAttack.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Path not found");
        } 
    }
    
    private void probabilityjSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_probabilityjSpinnerStateChanged
 //        chartDrawer(Integer.valueOf(probabilityjSpinner.getValue().toString()));
 //       this.getContentPane().validate();
  //      this.getContentPane().repaint();
    }//GEN-LAST:event_probabilityjSpinnerStateChanged

    private void attackTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_attackTabbedPaneStateChanged
        try {
            if(attackTabbedPane.getSelectedIndex()==1){
                System.out.println("It's the 2nd tab.");
                Object[][] assetData= DataPopulator.DataPreprocessor(countermeasureDBService.selectAll("countermeasure"));
                String[] columns= DataPopulator.getColumn(countermeasureDBService.selectAll("countermeasure"));
                jTable1.setModel(new javax.swing.table.DefaultTableModel(assetData,columns) );
            }

        } catch (Exception e1) {}
    }//GEN-LAST:event_attackTabbedPaneStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       try{
        new UpdateAtomicCountermeasure(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()).setVisible(true);
       }
       catch(Exception e){
            JOptionPane.showMessageDialog(null, "Operation fialed.Select a row and try again.", "Failure",JOptionPane.ERROR_MESSAGE );
       }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String id= jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            countermeasureDBService.delete("countermeasure",id );
            Object[][] assetData= DataPopulator.DataPreprocessor(countermeasureDBService.selectAll("countermeasure"));
            String[] columns= DataPopulator.getColumn(countermeasureDBService.selectAll("countermeasure"));
            jTable1.setModel(new javax.swing.table.DefaultTableModel(assetData,columns) );
        } catch (Exception ex) {
         //   Logger.getLogger(AtomicAttack.class.getName()).log(Level.SEVERE, null, ex);
         JOptionPane.showMessageDialog(null, "Operation fialed.Select a row and try again.", "Failure",JOptionPane.ERROR_MESSAGE );
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAtomicAttack;
    private javax.swing.JTabbedPane attackTabbedPane;
    private javax.swing.JTextField countermeasureCostTF;
    private javax.swing.JTextArea countermeasureDescriptionTA;
    private javax.swing.JTextField countermeasureNameTF;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner probabilityjSpinner;
    // End of variables declaration//GEN-END:variables
}
