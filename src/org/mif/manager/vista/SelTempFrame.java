/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.mif.manager.vista;

import java.util.List;
import org.mif.manager.model.Temporada;

/**
 *
 * @author marks
 */
public class SelTempFrame extends javax.swing.JFrame {

    /**
     * Carreguem les temporades al obrir la finestrar
     */
    public SelTempFrame() {
        initComponents();
        carregarTemps();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tempsComboBox = new javax.swing.JComboBox<>();
        tempButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleccionar Temporada");
        setResizable(false);

        tempButton.setText("Selecciona");
        tempButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tempButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tempsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tempButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(tempsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(tempButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tempButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempButtonActionPerformed
        Temporada t = (Temporada) tempsComboBox.getSelectedItem();
        
        if (t != null)
        {
            Utils.setTemporadaActual(t);
            SelGestioFrame gestFrame = new SelGestioFrame();
            gestFrame.setVisible(true);
            
            this.dispose();
        }
    }//GEN-LAST:event_tempButtonActionPerformed

    /**
     * Funció per carregar les temporades al comboBox
     */
    private void carregarTemps()
    {
        if (Utils.getTemporades().isEmpty())
        {
            Utils.setTemporades();
        }
        
        List<Temporada> temps = Utils.getTemporades();
        
        System.out.println(temps.toString());
        
        // Bucle for-each l'he vist a https://www.w3schools.com/java/java_foreach_loop.asp
        for (Temporada temp : temps)
        {
            tempsComboBox.addItem(temp);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton tempButton;
    private javax.swing.JComboBox<Temporada> tempsComboBox;
    // End of variables declaration//GEN-END:variables
}