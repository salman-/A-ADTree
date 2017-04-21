/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee.ut.smarttool.tree.dialogbox;

import ee.ut.smarttool.DB.DB;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import lu.uni.adtool.ui.canvas.ADTreeCanvas;

/**
 *
 * @author Salman
 */
public class OptionsForDisjunctionNodes extends javax.swing.JPanel {

    /**
     * Creates new form OptionsForDisjunctionNodes
     */
    public OptionsForDisjunctionNodes() {
        initComponents();
    /*    File file = new File(DB.class.getClassLoader().getResource("img/OR-attack.png").getFile());	
	String path=file.getAbsolutePath();
         ImageIcon image = new ImageIcon(path);
        attackIcon.setIcon(image);
        jRadioButton1.setSelected(true);
        
        File counterImageFile = new File(DB.class.getClassLoader().getResource("img/OR-counter.png").getFile());	
	String counterImagePath=counterImageFile.getAbsolutePath();
        ImageIcon counterImage = new ImageIcon(counterImagePath);
        counterIcon.setIcon(counterImage);
        jRadioButton4.setSelected(true);*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                formVetoableChange(evt);
            }
        });

        jLabel1.setText("How Do You Choose Actions in Nodes with Disjunctive Refinements?");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Maximum Probability");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Minimum Cost of Action");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
      ADTreeCanvas.AttackORDecisio=evt.getActionCommand();
      System.out.println(ADTreeCanvas.AttackORDecisio);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void formVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_formVetoableChange
          
    }//GEN-LAST:event_formVetoableChange

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
                    
      ADTreeCanvas.AttackORDecisio=evt.getActionCommand();
      System.out.println(ADTreeCanvas.AttackORDecisio);
    }//GEN-LAST:event_jRadioButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    // End of variables declaration//GEN-END:variables

    public JPanel getPanel() {
        return this;
    }
}