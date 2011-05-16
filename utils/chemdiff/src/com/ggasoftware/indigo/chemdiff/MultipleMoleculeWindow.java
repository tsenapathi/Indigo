/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MultipleMoleculeWindow.java
 *
 * Created on May 11, 2011, 4:34:43 PM
 */
package com.ggasoftware.indigo.chemdiff;

import java.awt.Frame;

/**
 *
 * @author rybalkin
 */
public class MultipleMoleculeWindow extends javax.swing.JFrame
{
   /** Creates new form MultipleMoleculeWindow */
   public MultipleMoleculeWindow (Frame parent, MultipleMoleculeItem mol)
   {
      initComponents();
      
      output_table1.setMolecules(mol.getGroup(0));
      if (mol.getGroupCount() == 1)
      {
         output_panel.remove(output_table2);
         output_table1.setTitle("Molecules");
         setSize(getWidth() / 2, getHeight());
      }
      else
         output_table2.setMolecules(mol.getGroup(1));
      
      setLocationRelativeTo(parent);
   }
   
   void setCommonCanonicalCode (String code)
   {
      canonical_code_field.setText(code);
      output_table1.setCommonCanonicalCode(code);
      output_table2.setCommonCanonicalCode(code);   
   }
   
   void setRowHeight (int height)
   {
      output_table1.setRowHeight(height);
      output_table2.setRowHeight(height);
   }

   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      jPanel2 = new javax.swing.JPanel();
      jLabel1 = new javax.swing.JLabel();
      canonical_code_field = new javax.swing.JTextField();
      output_panel = new javax.swing.JPanel();
      output_table1 = new com.ggasoftware.indigo.chemdiff.OutputTable();
      output_table2 = new com.ggasoftware.indigo.chemdiff.OutputTable();

      setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
      setTitle("Molecules within a group");
      getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

      jLabel1.setText("Canonical code:");

      canonical_code_field.setEditable(false);
      canonical_code_field.setMaximumSize(new java.awt.Dimension(2147483647, 20));

      javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
      jPanel2.setLayout(jPanel2Layout);
      jPanel2Layout.setHorizontalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(canonical_code_field, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
            .addContainerGap())
      );
      jPanel2Layout.setVerticalGroup(
         jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(5, 5, 5)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(canonical_code_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addComponent(jLabel1)))
      );

      getContentPane().add(jPanel2);

      output_panel.setLayout(new javax.swing.BoxLayout(output_panel, javax.swing.BoxLayout.LINE_AXIS));

      output_table1.setIdColumnCount(1);
      output_table1.setTitle("From the first set");
      output_panel.add(output_table1);

      output_table2.setIdColumnCount(1);
      output_table2.setTitle("From the second set");
      output_panel.add(output_table2);

      getContentPane().add(output_panel);

      pack();
   }// </editor-fold>//GEN-END:initComponents

   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JTextField canonical_code_field;
   private javax.swing.JLabel jLabel1;
   private javax.swing.JPanel jPanel2;
   private javax.swing.JPanel output_panel;
   private com.ggasoftware.indigo.chemdiff.OutputTable output_table1;
   private com.ggasoftware.indigo.chemdiff.OutputTable output_table2;
   // End of variables declaration//GEN-END:variables
}
