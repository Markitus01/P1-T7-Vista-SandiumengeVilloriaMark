/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.mif.manager.vista;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import org.mif.manager.model.Equip;
import org.mif.manager.model.Jugador;
import org.mif.manager.model.Membre;

/**
 *
 * @author marks
 */
public class EditEquipFrame extends javax.swing.JFrame
{
    private int equipActual;
    
    public EditEquipFrame(int idEquip)
    {
        equipActual = idEquip;
        initComponents();
        
        Equip equip = Utils.obtenirEquipPerId(idEquip);
        if (equip != null)
        {
            nomEquipActualLabel.setText("Gestionant equip: " + equip.getNom());
        }
        else 
        {
            nomEquipActualLabel.setText("Gestionant equip: (desconegut)");
        }
        
        Utils.setJugsDinsEquip(idEquip); // Obtenim els jugadors dins l'equip
        Utils.setJugsInscriptiblesEquip(idEquip); // Obtenim els jugadors inscriptibles a l'equip
        carregarLlistes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        enrereButton = new javax.swing.JButton();
        guardarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        escolliblesTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        membresTable = new javax.swing.JTable();
        afegirJugadorButton = new javax.swing.JButton();
        treureJugadorButton = new javax.swing.JButton();
        afegiblesLabel = new javax.swing.JLabel();
        titularCheck = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        nomEquipActualLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestió d'Equip");
        setResizable(false);

        enrereButton.setText("<");
        enrereButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enrereButtonActionPerformed(evt);
            }
        });

        guardarButton.setBackground(new java.awt.Color(0, 102, 0));
        guardarButton.setText("Desa Canvis");
        guardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarButtonActionPerformed(evt);
            }
        });

        escolliblesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "IdLegal", "Edat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(escolliblesTable);

        membresTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "IdLegal", "Edat", "Titularitat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        membresTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(membresTable);

        afegirJugadorButton.setBackground(new java.awt.Color(0, 102, 102));
        afegirJugadorButton.setText("<<<<<");
        afegirJugadorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afegirJugadorButtonActionPerformed(evt);
            }
        });

        treureJugadorButton.setBackground(new java.awt.Color(153, 102, 0));
        treureJugadorButton.setText(">>>>>");
        treureJugadorButton.setToolTipText("");
        treureJugadorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                treureJugadorButtonActionPerformed(evt);
            }
        });

        afegiblesLabel.setText("Jugadors Afegibles");

        titularCheck.setText("Titular?");

        jLabel1.setText("Jugadors Membres");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(afegirJugadorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(treureJugadorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(afegiblesLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(enrereButton)
                        .addGap(265, 265, 265)
                        .addComponent(nomEquipActualLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titularCheck)
                            .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enrereButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(guardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomEquipActualLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(afegiblesLabel)
                        .addComponent(jLabel1))
                    .addComponent(titularCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(afegirJugadorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(treureJugadorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void afegirJugadorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afegirJugadorButtonActionPerformed
        int escollibleSel = escolliblesTable.getSelectedRow();
    
        if (escollibleSel == -1)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Has de seleccionar un jugador per poder afegir-lo al equip!", "Error de selecció", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        int filaReal = escolliblesTable.convertRowIndexToModel(escollibleSel);
        String jugSel = (String) escolliblesTable.getModel().getValueAt(filaReal, 1); // IdLegal

        Jugador escollit = Utils.obtenirJugadorPerIdLegal(jugSel);
        if (escollit == null)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "No s'ha pogut obtenir el jugador seleccionat.", "Error de selecció", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }


        boolean ferTitular = titularCheck.isSelected();
        Membre nouMembre = new Membre();
        nouMembre.setEquMembre(equipActual);
        nouMembre.setJugMembre(escollit.getId());
        nouMembre.setTitular(ferTitular);

        // NOMÉS SI ES VOL FER TITULAR
        if (ferTitular)
        {
            Integer equipOnTitular = Utils.obtenirEquipOnEsTitular(escollit.getId());
            if (equipOnTitular != null && equipOnTitular != equipActual)
            {
                int resposta = javax.swing.JOptionPane.showConfirmDialog(this,
                    "Aquest jugador ja es titular a un altre equip, vols continuar?",
                    "Atenció", javax.swing.JOptionPane.YES_NO_OPTION, javax.swing.JOptionPane.WARNING_MESSAGE);

                if (resposta != javax.swing.JOptionPane.YES_OPTION) 
                {
                    return;
                } 
                else 
                {
                    Membre membreAntic = new Membre();
                    membreAntic.setEquMembre(equipOnTitular);
                    membreAntic.setJugMembre(escollit.getId());
                    membreAntic.setTitular(true);

                    Utils.modificarTitularitatMembre(membreAntic, false);
                }
            }
        }

        // L'afegim com a membre
        String error = Utils.afegirMembreEquip(nouMembre, equipActual);
        if (error != null)
        {
            if (nouMembre.getTitular())
            {
                javax.swing.JOptionPane.showMessageDialog(this, "No pot ser titular en un equip de categoria diferent!\n" + error, "Error al afegir jugador", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            else 
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Un jugador només pot ser convidat en categories iguals o superiors!\n" + error, "Error al afegir jugador", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
            return;
        }
        carregarLlistes();

    }//GEN-LAST:event_afegirJugadorButtonActionPerformed

    private void treureJugadorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_treureJugadorButtonActionPerformed
        int membreSel = membresTable.getSelectedRow();

        if (membreSel == -1)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "Has de seleccionar un jugador membre per poder treure'l!", "Error de selecció", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        int filaReal = membresTable.convertRowIndexToModel(membreSel);
        String jugSel = (String) membresTable.getModel().getValueAt(filaReal, 1); // IdLegal

        Jugador membre = Utils.obtenirJugadorPerIdLegal(jugSel);
        if (membre == null)
        {
            javax.swing.JOptionPane.showMessageDialog(this, "No s'ha pogut obtenir el jugador seleccionat.", "Error de selecció", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Important! Saber si el jugador és Titular o Convidat per a la clau primaria de la taula membre
        boolean titular = false;
        String tit = (String) membresTable.getModel().getValueAt(filaReal, 3);
        if (tit.equalsIgnoreCase("Titular")) titular = true;

        Membre membreObj = new Membre();
        membreObj.setEquMembre(equipActual);
        membreObj.setJugMembre(membre.getId());
        membreObj.setTitular(titular);

        String error = Utils.eliminarMembreEquip(membreObj, equipActual);
        if (error != null)
        {
            javax.swing.JOptionPane.showMessageDialog(this, error, "Error al treure jugador", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        carregarLlistes();
    }//GEN-LAST:event_treureJugadorButtonActionPerformed

    private void enrereButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enrereButtonActionPerformed
        GestEquipsFrame equipsFrame = new GestEquipsFrame();
        equipsFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_enrereButtonActionPerformed

    private void guardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarButtonActionPerformed
        String error = Utils.confirmarCanvis();
        if (error != null)
        {
            javax.swing.JOptionPane.showMessageDialog(this, error, "Error al desar!", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_guardarButtonActionPerformed

    private void carregarLlistes()
    {
        // Obtenim el table model
        DefaultTableModel membresModel = (DefaultTableModel) membresTable.getModel();
        membresModel.setRowCount(0); // Netejem la taula per evitar duplicació

        for (Jugador membre : Utils.getJugadorsDinsEquip())
        {
            membre.setEdat(Utils.getTemporadaActual().getAnny());
            boolean titular = Utils.esTitular(equipActual, membre.getId());
            
            String txtTitular;
            if (titular)
            {
                txtTitular = "Titular";
            }
            else
            {
                txtTitular = "Convidat";
            }
            
            Object[] row = {
                membre.getNom(),
                membre.getIdLegal(),
                membre.getEdat(),
                txtTitular
            };
            membresModel.addRow(row);
        }

        TableRowSorter<DefaultTableModel> sorterDinsEquip = new TableRowSorter<>(membresModel);
        membresTable.setRowSorter(sorterDinsEquip);

        // LLISTA DELS JUGADORS FORA DE L'EQUIP QUE SIGUIN INSCRIPTIBLES
        DefaultTableModel inscriptiblesModel = (DefaultTableModel) escolliblesTable.getModel();
        inscriptiblesModel.setRowCount(0);

        for (Jugador inscriptible : Utils.getJugadorsInscriptiblesEquip())
        {
            inscriptible.setEdat(Utils.getTemporadaActual().getAnny());
            if (inscriptible.getEdat() >= 5)
            {
                Object[] row = {
                    inscriptible.getNom(),
                    inscriptible.getIdLegal(),
                    inscriptible.getEdat()
                };
                inscriptiblesModel.addRow(row);
            }
        }

        TableRowSorter<DefaultTableModel> sorterInscriptibles = new TableRowSorter<>(inscriptiblesModel);
        escolliblesTable.setRowSorter(sorterInscriptibles);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel afegiblesLabel;
    private javax.swing.JButton afegirJugadorButton;
    private javax.swing.JButton enrereButton;
    private javax.swing.JTable escolliblesTable;
    private javax.swing.JButton guardarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable membresTable;
    private javax.swing.JLabel nomEquipActualLabel;
    private javax.swing.JCheckBox titularCheck;
    private javax.swing.JButton treureJugadorButton;
    // End of variables declaration//GEN-END:variables
}
