/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.smartadtool.ui;

import ee.ut.smarttool.DB.AssetDBSerivice;
import ee.ut.smarttool.DB.AttackDBService;
import ee.ut.smarttool.DB.ImpactDBService;
import ee.ut.smarttool.DB.VulnerabilityDBService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
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
public class UpdateAtomicAttack extends javax.swing.JFrame {

    VulnerabilityDBService vulDBSerivce;
    AssetDBSerivice assetDBSerivce;
    AttackDBService attackDBService; 
    ImpactDBService impactDBService;

    /**
     * Creates new form UpdateAtomicAttack
     */
    public UpdateAtomicAttack(String id) {
        vulDBSerivce   =new VulnerabilityDBService();
        assetDBSerivce =new AssetDBSerivice();
        attackDBService=new AttackDBService();
        impactDBService=new ImpactDBService();
        initComponents();
        try {
            System.out.println("ID: "+id);
            Map<String, ArrayList<String>> res = attackDBService.select("attack", id);
            attackIDLabel.setText(id);
            attackNameTF.setText((String) res.get("name").toArray()[0]);
            attackDescriptionTA.setText((String) res.get("description").toArray()[0]);
            costOfAttackTF.setText((String) res.get("costOfAttack").toArray()[0]);
            costOfDamageTF.setText((String) res.get("costOfDamage").toArray()[0]);
             res = vulDBSerivce.selectAll("vulnerability");
             DefaultComboBoxModel model = new DefaultComboBoxModel( res.get("name").toArray() );
             vulnerabilityCombo.setModel( model );
             res = assetDBSerivce.selectAll("asset");
             model = new DefaultComboBoxModel( res.get("name").toArray() );
             targetedAssetCombo.setModel( model );
             res=impactDBService.selectAll("impact");
             model = new DefaultComboBoxModel( res.get("name").toArray() );
             impactCombo.setModel( model ); 
        } catch (Exception ex) {
            Logger.getLogger(UpdateAtomicAttack.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        attackNameTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attackDescriptionTA = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        targetedAssetCombo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        vulnerabilityCombo = new javax.swing.JComboBox<>();
        addAtomicAttack = new javax.swing.JButton();
        probabilityjSpinner = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        threatAgentMotivesCombo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        threatAgentCapabilitiesCombo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        threatAgentOpportunitiesCombo = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        threatAgentScore = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        costOfAttackTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        costOfDamageTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        impactCombo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        attackIDLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        jLabel3.setBounds(30, 310, 90, 14);

        jLabel4.setText("Targeted Asset");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 280, 110, 14);

        targetedAssetCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(targetedAssetCombo);
        targetedAssetCombo.setBounds(170, 280, 168, 20);

        jLabel5.setText("Vulnerability");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 250, 100, 14);

        vulnerabilityCombo.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                vulnerabilityComboComponentAdded(evt);
            }
        });
        vulnerabilityCombo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vulnerabilityComboMouseClicked(evt);
            }
        });
        vulnerabilityCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vulnerabilityComboActionPerformed(evt);
            }
        });
        jPanel1.add(vulnerabilityCombo);
        vulnerabilityCombo.setBounds(170, 250, 166, 20);

        addAtomicAttack.setBackground(new java.awt.Color(255, 0, 51));
        addAtomicAttack.setText("Add Atomic Attack");
        addAtomicAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAtomicAttackActionPerformed(evt);
            }
        });
        jPanel1.add(addAtomicAttack);
        addAtomicAttack.setBounds(60, 400, 270, 40);

        probabilityjSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        probabilityjSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                probabilityjSpinnerStateChanged(evt);
            }
        });
        jPanel1.add(probabilityjSpinner);
        probabilityjSpinner.setBounds(260, 310, 80, 20);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(40, 200, 300, 10);

        jLabel6.setText("Threat Agent Motives");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(370, 30, 140, 20);

        threatAgentMotivesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Curiosity", "Personal Fame", "Personal Gain", "Revenge", "National Interest", "Ideology" }));
        jPanel1.add(threatAgentMotivesCombo);
        threatAgentMotivesCombo.setBounds(560, 30, 110, 20);

        jLabel7.setText("Threat Agent Capabilities");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(370, 70, 160, 14);

        threatAgentCapabilitiesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Beginner", "Undergraduate", "Master", "Specialist" }));
        jPanel1.add(threatAgentCapabilitiesCombo);
        threatAgentCapabilitiesCombo.setBounds(560, 70, 110, 20);

        jLabel8.setText("Threat Agent Opportunities");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(370, 110, 170, 14);

        threatAgentOpportunitiesCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "Finite", "Infinite" }));
        jPanel1.add(threatAgentOpportunitiesCombo);
        threatAgentOpportunitiesCombo.setBounds(560, 110, 110, 20);

        jLabel9.setText("Threat Agent Means");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(410, 160, 120, 14);

        jCheckBox1.setText("Computer Means");
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(400, 190, 140, 23);

        jCheckBox2.setText("People As Means");
        jPanel1.add(jCheckBox2);
        jCheckBox2.setBounds(400, 220, 140, 23);

        jCheckBox3.setText("Process As Means");
        jPanel1.add(jCheckBox3);
        jCheckBox3.setBounds(560, 190, 170, 23);

        jCheckBox4.setText("Intangible Assets");
        jPanel1.add(jCheckBox4);
        jCheckBox4.setBounds(560, 220, 150, 23);

        jCheckBox5.setText("Step Stone Assets");
        jPanel1.add(jCheckBox5);
        jCheckBox5.setBounds(400, 250, 130, 23);

        jButton1.setBackground(new java.awt.Color(204, 255, 51));
        jButton1.setText("Apply Threat Agent Profile on Probability");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(400, 310, 270, 40);

        threatAgentScore.setText("Threat Agent Score");
        jPanel1.add(threatAgentScore);
        threatAgentScore.setBounds(570, 250, 140, 14);

        jLabel10.setText("Cost of Attack");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 340, 80, 20);
        jPanel1.add(costOfAttackTF);
        costOfAttackTF.setBounds(260, 340, 80, 20);

        jLabel11.setText("Cost of Damage (Gain)");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(30, 370, 140, 14);
        jPanel1.add(costOfDamageTF);
        costOfDamageTF.setBounds(260, 370, 80, 20);

        jLabel12.setText("Impact");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(30, 220, 40, 14);

        impactCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(impactCombo);
        impactCombo.setBounds(170, 220, 170, 20);

        jLabel13.setText("Attack ID: ");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(400, 400, 90, 14);

        attackIDLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        attackIDLabel.setText("Attack ID");
        jPanel1.add(attackIDLabel);
        attackIDLabel.setBounds(520, 400, 100, 17);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 705, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vulnerabilityComboComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_vulnerabilityComboComponentAdded

    }//GEN-LAST:event_vulnerabilityComboComponentAdded

    private void vulnerabilityComboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vulnerabilityComboMouseClicked

        System.out.println("Error happened");// TODO add your handling code here:
    }//GEN-LAST:event_vulnerabilityComboMouseClicked

    private void vulnerabilityComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vulnerabilityComboActionPerformed

    }//GEN-LAST:event_vulnerabilityComboActionPerformed

    private void addAtomicAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAtomicAttackActionPerformed
        try {

            String name=attackNameTF.getText();
            String description=attackDescriptionTA.getText();
            String costOfAttack=costOfAttackTF.getText();
            String costOfDamage=costOfDamageTF.getText();
            String probaility=probabilityjSpinner.getValue().toString();

            String asset=targetedAssetCombo.getSelectedItem().toString();
            String assetId=assetDBSerivce.selectIdFromField("asset","name",asset);

            String impactName=impactCombo.getSelectedItem().toString();
            String impactId=assetDBSerivce.selectIdFromField("impact","name",impactName);

            String vulnerability=vulnerabilityCombo.getSelectedItem().toString();
            String vulnerabilityId=assetDBSerivce.selectIdFromField("vulnerability","name",vulnerability);

            attackDBService.insertAttack(name,description,probaility,costOfDamage,costOfAttack, assetId,impactId,vulnerabilityId);

        } catch (Exception ex) {
            Logger.getLogger(AtomicAttack.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addAtomicAttackActionPerformed

    private void probabilityjSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_probabilityjSpinnerStateChanged
        chartDrawer(Integer.valueOf(probabilityjSpinner.getValue().toString()));
        this.getContentPane().validate();
        this.getContentPane().repaint();
    }//GEN-LAST:event_probabilityjSpinnerStateChanged

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
            Logger.getLogger(AtomicAttack.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Path not found");
        } 
    }
    
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAtomicAttack;
    private javax.swing.JTextArea attackDescriptionTA;
    private javax.swing.JLabel attackIDLabel;
    private javax.swing.JTextField attackNameTF;
    private javax.swing.JTextField costOfAttackTF;
    private javax.swing.JTextField costOfDamageTF;
    private javax.swing.JComboBox<String> impactCombo;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner probabilityjSpinner;
    private javax.swing.JComboBox<String> targetedAssetCombo;
    private javax.swing.JComboBox<String> threatAgentCapabilitiesCombo;
    private javax.swing.JComboBox<String> threatAgentMotivesCombo;
    private javax.swing.JComboBox<String> threatAgentOpportunitiesCombo;
    private javax.swing.JLabel threatAgentScore;
    private javax.swing.JComboBox<String> vulnerabilityCombo;
    // End of variables declaration//GEN-END:variables
}
