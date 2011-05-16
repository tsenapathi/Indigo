/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SelectIDColumnDialog.java
 *
 * Created on May 10, 2011, 4:01:18 PM
 */
package com.ggasoftware.indigo.chemdiff;

import com.ggasoftware.indigo.IndigoException;
import com.ggasoftware.indigo.IndigoObject;
import com.ggasoftware.indigo.controls.IndigoCheckedException;
import com.ggasoftware.indigo.controls.RenderableObject;
import java.awt.Frame;
import java.util.Collection;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author rybalkin
 */
public class SelectIDColumnDialog extends javax.swing.JDialog
{
   List<? extends RenderableObject> _molecules;
   int _active_index;
   boolean _show_name, _show_serial;
   boolean _canceled = false;
   
   
   public static final String SERIAL_NUMBER_ID = "$Serial number$";
   public static final String NAME_ID = "$Name$";
   
   /** Creates new form SelectIDColumnDialog */
   public SelectIDColumnDialog (Frame parent,
           List<? extends RenderableObject> molecules, 
           boolean show_name, 
           boolean show_serial)
   {
      super(parent);
      initComponents();
      
      _show_name = show_name;
      _show_serial = show_serial;
      
      _molecules = molecules;
      _active_index = 0;
      showCurrent();
      
      done_button.requestFocus();
      setLocationRelativeTo(parent);
      
      pack();
   }

   public String getSelectedProperty ()
   {
      return molecule_with_properties.getSelectedPropertyName();
   }
   
   public void setSelectedPropertyIndex (int index)
   {
      molecule_with_properties.setSelectedPropertyIndex(index);
   }
   
   /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents() {

      molecule_with_properties = new com.ggasoftware.indigo.controls.IndigoObjectWithPropertiesViewPanel();
      prev_button = new javax.swing.JButton();
      next_button = new javax.swing.JButton();
      done_button = new javax.swing.JButton();
      help_info = new javax.swing.JLabel();

      setTitle("Select ID field");
      setModal(true);
      addWindowListener(new java.awt.event.WindowAdapter() {
         public void windowClosing(java.awt.event.WindowEvent evt) {
            formWindowClosing(evt);
         }
      });

      prev_button.setText("Prev");
      prev_button.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            prev_buttonActionPerformed(evt);
         }
      });

      next_button.setText("Next");
      next_button.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            next_buttonActionPerformed(evt);
         }
      });

      done_button.setText("Done");
      done_button.addActionListener(new java.awt.event.ActionListener() {
         public void actionPerformed(java.awt.event.ActionEvent evt) {
            done_buttonActionPerformed(evt);
         }
      });

      help_info.setText("<html>Choose a properties field that will be used as an identificator. This property will be used as an identifire for the all molecules. </html>");

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
      getContentPane().setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
               .addComponent(molecule_with_properties, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
               .addGroup(layout.createSequentialGroup()
                  .addComponent(prev_button, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(next_button, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 236, Short.MAX_VALUE)
                  .addComponent(done_button, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
               .addComponent(help_info, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
            .addContainerGap())
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(help_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(molecule_with_properties, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
               .addComponent(done_button)
               .addComponent(prev_button)
               .addComponent(next_button))
            .addContainerGap())
      );

      pack();
   }// </editor-fold>//GEN-END:initComponents

   private void done_buttonActionPerformed (java.awt.event.ActionEvent evt)//GEN-FIRST:event_done_buttonActionPerformed
   {//GEN-HEADEREND:event_done_buttonActionPerformed
      if (molecule_with_properties.getSelectedPropertyName() == null)
         JOptionPane.showMessageDialog(this, "You need to select property field");
      else
         setVisible(false);
   }//GEN-LAST:event_done_buttonActionPerformed

   private void prev_buttonActionPerformed (java.awt.event.ActionEvent evt)//GEN-FIRST:event_prev_buttonActionPerformed
   {//GEN-HEADEREND:event_prev_buttonActionPerformed
      _active_index--;
      showCurrent();
   }//GEN-LAST:event_prev_buttonActionPerformed

   private void next_buttonActionPerformed (java.awt.event.ActionEvent evt)//GEN-FIRST:event_next_buttonActionPerformed
   {//GEN-HEADEREND:event_next_buttonActionPerformed
      _active_index++;
      showCurrent();
   }//GEN-LAST:event_next_buttonActionPerformed

   private void formWindowClosing (java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosing
   {//GEN-HEADEREND:event_formWindowClosing
      _canceled = true;
   }//GEN-LAST:event_formWindowClosing

   public boolean isCanceled ()
   {
      return _canceled;
   }
   
   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton done_button;
   private javax.swing.JLabel help_info;
   private com.ggasoftware.indigo.controls.IndigoObjectWithPropertiesViewPanel molecule_with_properties;
   private javax.swing.JButton next_button;
   private javax.swing.JButton prev_button;
   // End of variables declaration//GEN-END:variables

   public String getSerialNumber (int index)
   {
      return String.format("#%d", index + 1);
   }
   
   public String getMoleculeID (RenderableObject rend_obj, int index) throws IndigoCheckedException
   {
      String prop = molecule_with_properties.getSelectedPropertyName();
      if (prop.equals(SERIAL_NUMBER_ID))
         return getSerialNumber(index);
      try
      {
         IndigoObject ind_obj = rend_obj.getRenderableObject();
         if (ind_obj == null)
            return getSerialNumber(index);
         if (prop.equals(NAME_ID))
            return ind_obj.name();
         return ind_obj.getProperty(prop);
      }
      catch (IndigoException ex)
      {
         throw new IndigoCheckedException(ex.getMessage());
      }
              
   }
   
   private void showCurrent ()
   {
      if (_active_index >= _molecules.size())
         throw new RuntimeException("Internal error");
      
      int selected = molecule_with_properties.getSelectedPropertyIndex();
      
      RenderableObject rend_obj = _molecules.get(_active_index);
      final IndigoObject ind_obj = rend_obj.getRenderableObject();
      molecule_with_properties.setObject(ind_obj, rend_obj.getIndigoRenderer());
      molecule_with_properties.setInformationMessage(rend_obj.getErrorMessageToRender());
      
      if (_show_serial)
      {
         molecule_with_properties.addCustomProperty(0, 
                 "$Serial number$", getSerialNumber(_active_index));
         // Select serial number by default
         if (selected == -1)
            molecule_with_properties.setSelectedPropertyIndex(0);
      }
      if (_show_name && ind_obj != null)
         molecule_with_properties.addCustomProperty(0, 
                 "$Name$", ind_obj.name());
      
      if (selected >= 0 && selected < molecule_with_properties.getPropertiesCount())
         molecule_with_properties.setSelectedPropertyIndex(selected);
      
      next_button.setEnabled(_active_index < _molecules.size() - 1);
      prev_button.setEnabled(_active_index > 0);
   }
}
