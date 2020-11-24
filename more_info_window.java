/*
JAKUB WAWAK
ALL RIGHTS RESERVED.
kubawawak@gmail.com
 */

package clipper;

import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

/**
 *
 * @author jakubwawak
 */
public class more_info_window extends javax.swing.JDialog {

    Text_Object data;
    Data_Handler data_contener;
    int index;
    
    /**
     * Creates new form more_info_window
     */
    public more_info_window(java.awt.Frame parent, boolean modal,Data_Handler to_show, int index) {
        super(parent, modal);
        data = to_show.get(index);
        data_contener = to_show;
        this.index = index;
        initComponents();
        save_edits_button.setVisible(false);
        category_label.setText(category_label.getText()+" " + data.give_category());
        data_textfield.setText(data.raw_data);
        date_label.setText(date_label.getText() + " " + data.date_show());
        setVisible(true);
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
        data_textfield = new javax.swing.JTextArea();
        date_label = new javax.swing.JLabel();
        category_label = new javax.swing.JLabel();
        copy_to_c_button = new javax.swing.JButton();
        save_edits_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("More Info");

        data_textfield.setColumns(20);
        data_textfield.setRows(5);
        data_textfield.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                data_textfieldMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(data_textfield);

        date_label.setText("Date:");

        category_label.setText("Category: ");

        copy_to_c_button.setText("Copy to clipboard");
        copy_to_c_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copy_to_c_buttonActionPerformed(evt);
            }
        });

        save_edits_button.setText("Save edits");
        save_edits_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_edits_buttonActionPerformed(evt);
            }
        });

        delete_button.setText("Delete");
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(category_label)
                        .addContainerGap(379, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(delete_button)
                                .addGap(18, 18, 18)
                                .addComponent(save_edits_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(copy_to_c_button, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(date_label)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(date_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(category_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete_button)
                    .addComponent(save_edits_button)
                    .addComponent(copy_to_c_button))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void data_textfieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_data_textfieldMouseClicked
        save_edits_button.setVisible(true);
        copy_to_c_button.setText("Copy to clipboard");
    }//GEN-LAST:event_data_textfieldMouseClicked

    /**
     * Event handler - button "save edits" pressed
     * @param evt 
     */
    private void save_edits_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_edits_buttonActionPerformed
        if(!data_textfield.getText().equals(data.raw_data)){
            if (data_contener.update(data_textfield.getText(), index)){
                data_textfield.setEditable(false);
                save_edits_button.setText("Saved");
                save_edits_button.setEnabled(false);
                data_contener.show();
            }
            else{
                save_edits_button.setText("Failed");

                data_textfield.setEditable(false);
                save_edits_button.setEnabled(false);
            }
        }
        else{
            save_edits_button.setText("Nothing changed");
            data_textfield.setEditable(false);
            save_edits_button.setEnabled(false);
        }
    }//GEN-LAST:event_save_edits_buttonActionPerformed

    /**
     * Event handler - button "delete" pressed
     * @param evt 
     */
    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        data_contener.delete(index);
        data_textfield.setEditable(false);
        save_edits_button.setVisible(false);
        delete_button.setVisible(true);
        delete_button.setText("Deleted");
        copy_to_c_button.setVisible(false);
    }//GEN-LAST:event_delete_buttonActionPerformed

    /**
     * Event handler - button "copy to clipboard" pressed
     * @param evt 
     */
    private void copy_to_c_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copy_to_c_buttonActionPerformed
        StringSelection stringSelection = new StringSelection(data.raw_data);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        copy_to_c_button.setText("Copied");
    }//GEN-LAST:event_copy_to_c_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel category_label;
    private javax.swing.JButton copy_to_c_button;
    private javax.swing.JTextArea data_textfield;
    private javax.swing.JLabel date_label;
    private javax.swing.JButton delete_button;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton save_edits_button;
    // End of variables declaration//GEN-END:variables
}
