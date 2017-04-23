/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.smartadtool.ui;

import ee.ut.smartadtool.service.DataPopulator;
import ee.ut.smarttool.DB.AssetDBSerivice;
import ee.ut.smarttool.DB.AttackDBService;
import ee.ut.smarttool.DB.IDGenerator;
import ee.ut.smarttool.DB.ImpactDBService;
import ee.ut.smarttool.DB.VulnerabilityDBService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.PieStyler.AnnotationType;
import org.knowm.xchart.style.Styler.ChartTheme;

/**
 *
 * @author Salman
 */
public class AtomicAttack extends javax.swing.JFrame {

    VulnerabilityDBService vulDBSerivce;
    AssetDBSerivice assetDBSerivce;
    AttackDBService attackDBService; 
    ImpactDBService impactDBService;
    private String id;
    private String asset;
    private String assetId;
    private String impactName;
    private String impactId;
    private String vulnerability;
    private String vulnerabilityId;
    /**
     * Creates new form AtomicAttack
     */
    public AtomicAttack() {
        vulDBSerivce   =new VulnerabilityDBService();
        assetDBSerivce =new AssetDBSerivice();
        attackDBService=new AttackDBService();
        impactDBService=new ImpactDBService();
        initComponents();
        try {
            Map<String, ArrayList<String>> res =null;
             res = assetDBSerivce.selectAll("asset");
            DefaultComboBoxModel model = new DefaultComboBoxModel( res.get("name").toArray() );
             targetedAssetCombo.setModel( model );
          
        } catch (Exception ex) {
         //   Logger.getLogger(AtomicAttack.class.getName()).log(Level.SEVERE, null, ex);
        };
    

//   chartImage.setIcon(new ImageIcon("C://pie-pic/img.png")); 
 
    }
    
    public void chartDrawer(int success){
        PieChart chart = new PieChartBuilder().width(300).height(210).title("Failure Vs Success").theme(ChartTheme.GGPlot2).build();

    // Customize Chart
    chart.getStyler().setLegendVisible(false);
    chart.getStyler().setAnnotationType(AnnotationType.LabelAndPercentage);
    chart.getStyler().setAnnotationDistance(1.15);
    chart.getStyler().setPlotContentSize(.7);
    chart.getStyler().setStartAngleInDegrees(90);

    // Series
    chart.addSeries("Success", success);
    chart.addSeries("Failure", (100-success));


        try {
            // Show it
             new SwingWrapper(chart).displayChart();
             
            BitmapEncoder.saveBitmap(chart, "C://pie-pic/img.png", BitmapFormat.PNG);
        } catch (IOException ex) {
            Logger.getLogger(AtomicAttack.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Path not found");
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

        attackTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        attackNameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attackDescriptionTA = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        targetedAssetCombo = new javax.swing.JComboBox<>();
        addAtomicAttack = new javax.swing.JButton();
        probabilityjSpinner = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        costOfAttackTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        costOfDamageTF = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atomic Attack");

        attackTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                attackTabbedPaneStateChanged(evt);
            }
        });

        jPanel1.setLayout(null);

        jLabel1.setText("Attack");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(35, 25, 60, 14);
        jPanel1.add(attackNameTF);
        attackNameTF.setBounds(140, 30, 190, 20);

        jLabel2.setText("Description");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(35, 98, 70, 14);

        attackDescriptionTA.setColumns(20);
        attackDescriptionTA.setRows(5);
        jScrollPane1.setViewportView(attackDescriptionTA);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(121, 60, 230, 130);

        jLabel3.setText("Probability");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(390, 90, 90, 14);

        jLabel4.setText("Targeted Asset");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(390, 40, 110, 14);

        targetedAssetCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(targetedAssetCombo);
        targetedAssetCombo.setBounds(500, 40, 168, 20);

        addAtomicAttack.setBackground(new java.awt.Color(255, 0, 51));
        addAtomicAttack.setText("Add Atomic Attack");
        addAtomicAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAtomicAttackActionPerformed(evt);
            }
        });
        jPanel1.add(addAtomicAttack);
        addAtomicAttack.setBounds(220, 270, 270, 40);

        probabilityjSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        probabilityjSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                probabilityjSpinnerStateChanged(evt);
            }
        });
        jPanel1.add(probabilityjSpinner);
        probabilityjSpinner.setBounds(520, 80, 80, 20);

        jLabel10.setText("Cost of Attack");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(390, 130, 80, 20);
        jPanel1.add(costOfAttackTF);
        costOfAttackTF.setBounds(520, 130, 110, 20);

        jLabel11.setText("Cost of Damage (Gain)");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(390, 180, 140, 14);
        jPanel1.add(costOfDamageTF);
        costOfDamageTF.setBounds(520, 170, 80, 20);

        attackTabbedPane.addTab("Add Atomic Attack", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Name", "Description", "Asset", "Impact", "Vulnerability", "Probability", "Cost of Attack", "Cost of Damage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jButton2.setBackground(new java.awt.Color(255, 0, 51));
        jButton2.setText("Delete Attack");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 255));
        jButton3.setText("Update Attack");
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 64, Short.MAX_VALUE))
        );

        attackTabbedPane.addTab("Edit Atomic Attack", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(attackTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(attackTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void probabilityjSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_probabilityjSpinnerStateChanged
       /*  chartDrawer(Integer.valueOf(probabilityjSpinner.getValue().toString())); 
         this.getContentPane().validate();
         this.getContentPane().repaint(); */
    }//GEN-LAST:event_probabilityjSpinnerStateChanged

    private void addAtomicAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAtomicAttackActionPerformed
        try {
          
            String name=attackNameTF.getText();
            String description=attackDescriptionTA.getText();
            String costOfAttack=costOfAttackTF.getText();
            String costOfDamage=costOfDamageTF.getText();
            String probaility=probabilityjSpinner.getValue().toString();
            probaility=Double.toString(Integer.parseInt(probaility)/100.0);
            
            if(targetedAssetCombo.getSelectedItem().toString()!=null){
                asset=targetedAssetCombo.getSelectedItem().toString();
                assetId=assetDBSerivce.selectIdFromField("asset","name","'"+asset+"'");
           
           //     id =IDGenerator.nextId();
           //     int res = attackDBService.insertAttack(id,name,description,probaility,costOfDamage,costOfAttack, assetId);
                 int res = attackDBService.insertAttack(name,description,probaility,costOfDamage,costOfAttack, assetId);
            
               JOptionPane.showMessageDialog(null, "The record is inserted successfully.", "Success",JOptionPane.INFORMATION_MESSAGE );
            }else
                JOptionPane.showMessageDialog(null, "Make sure you have inserted asset records and try again", "Failure",JOptionPane.ERROR_MESSAGE );
                      
        } catch (Exception ex) {
          //  Logger.getLogger(AtomicAttack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addAtomicAttackActionPerformed

    private void attackTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_attackTabbedPaneStateChanged
        try {
            if(attackTabbedPane.getSelectedIndex()==1){
                System.out.println("It's the 2nd tab.");
                Object[][] Data= DataPopulator.DataPreprocessor(attackDBService.selectAllAttack());
                String[] columns= DataPopulator.getColumn(attackDBService.selectAllAttack());
                jTable1.setModel(new javax.swing.table.DefaultTableModel(Data,columns) );
            }

        } catch (Exception e1) {
          //  Logger.getLogger(Asset.class.getName()).log(Level.SEVERE, null, e1);
        }

    }//GEN-LAST:event_attackTabbedPaneStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new UpdateAtomicAttack(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString()).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String id= jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString();
            attackDBService.delete("attack",id );
            Object[][] assetData= DataPopulator.DataPreprocessor(attackDBService.selectAllAttack());
            String[] columns= DataPopulator.getColumn(attackDBService.selectAllAttack());
            jTable1.setModel(new javax.swing.table.DefaultTableModel(assetData,columns) );
        } catch (Exception ex) {
            Logger.getLogger(AtomicAttack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAtomicAttack;
    private javax.swing.JTextArea attackDescriptionTA;
    private javax.swing.JTextField attackNameTF;
    private javax.swing.JTabbedPane attackTabbedPane;
    private javax.swing.JTextField costOfAttackTF;
    private javax.swing.JTextField costOfDamageTF;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner probabilityjSpinner;
    private javax.swing.JComboBox<String> targetedAssetCombo;
    // End of variables declaration//GEN-END:variables
}
