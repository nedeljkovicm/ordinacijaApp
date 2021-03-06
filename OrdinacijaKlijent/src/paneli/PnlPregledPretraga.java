/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneli;

import domen.Karton;
import domen.Pregled;
import forme.FrmDialog;
import forme.FrmForma;
import forme.FrmMod;
import forme.IPanel;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import kontroler.Kontroler;
import modeli.ModelTabelePregledi;

/**
 *
 * @author minna
 */
public class PnlPregledPretraga extends javax.swing.JPanel implements IPanel{
    
    ModelTabelePregledi model;
    Date datumPregleda;

    /**
     * Creates new form PnlPregledPretraga
     */
    public PnlPregledPretraga() {
        initComponents();
        this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Zakazani pregledi",TitledBorder.LEFT, TitledBorder.TOP));
        spremiFormu();
//        srediTabelu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnPretrazi = new javax.swing.JButton();
        btnAzuriraj = new javax.swing.JButton();
        btnZakazi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPregledi = new javax.swing.JTable();
        datPregleda = new datechooser.beans.DateChooserCombo();
        btnPrikaziSve = new javax.swing.JButton();

        jLabel1.setText("Datum:");

        btnPretrazi.setText("Pretrazi");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnAzuriraj.setText("Azuriraj pregled");
        btnAzuriraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajActionPerformed(evt);
            }
        });

        btnZakazi.setText("Zakazi novi pregled");
        btnZakazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZakaziActionPerformed(evt);
            }
        });

        tblPregledi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPregledi);

        btnPrikaziSve.setText("Prikazi sve");
        btnPrikaziSve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziSveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnZakazi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAzuriraj, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(datPregleda, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnPrikaziSve, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(datPregleda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrikaziSve)
                            .addComponent(btnPretrazi))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZakazi)
                    .addComponent(btnAzuriraj))
                .addGap(26, 26, 26))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnZakaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZakaziActionPerformed
        PnlPregledUnos panel = new PnlPregledUnos();
        FrmForma forma = new FrmForma(panel);
        forma.setParent((Frame) SwingUtilities.getWindowAncestor(this));
        forma.setVisible(true);
    }//GEN-LAST:event_btnZakaziActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        Pregled p = new Pregled();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            datumPregleda = java.sql.Date.valueOf(sdf.format(datPregleda.getSelectedDate().getTime()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Morate uneti datum za pretragu!");
            return;

        }
        
        p.setDatum(datumPregleda);
       
        List<Pregled> lista;
        model = new ModelTabelePregledi();
        model.setSvi(false);
        
        try {

            lista = kontroler.Kontroler.getInstanca().vratiPreglede(p);
        if(lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ne postoje rezultati pretrage");
                tblPregledi.setModel(model);
            }
            
            
            for (Pregled pr : lista) {

                model.ubaci(pr);
            }
            tblPregledi.setModel(model);
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(PnlPregledPretragaclass.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_btnPretraziActionPerformed

    private void btnPrikaziSveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziSveActionPerformed
try {
            List<Pregled> lista = kontroler.Kontroler.getInstanca().vratiSvePreglede();
            System.out.println("Pregledi: "+lista);
            model = new ModelTabelePregledi();
            model.setSvi(true);
            for (Pregled p : lista) {
                model.ubaci(p);

            }
            System.out.println("Broj pregleda u bazi:"+lista.size());
            tblPregledi.setModel(model);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(PnlPregledPretraga.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }//GEN-LAST:event_btnPrikaziSveActionPerformed

    private void btnAzurirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajActionPerformed
        int index = tblPregledi.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Morate selektovati red u tabeli");
            return;
        }
        Pregled p = model.getLista().get(index);
        Karton k=p.getKarton();
        sesija.Sesija.getInstanca().getMapa().put("trenutniPregled", p);
        sesija.Sesija.getInstanca().getMapa().put("trenutniKarton", k);
        System.out.println(p);
        PnlAzuriranjePregleda panel = new PnlAzuriranjePregleda();
        FrmForma forma= new FrmForma(panel);
        forma.setVisible(true);
//        (((FrmForma) SwingUtilities.getWindowAncestor((FrmForma) SwingUtilities.getWindowAncestor(this)))).getPanel().popuniPodatke();
//       ((FrmForma) SwingUtilities.getWindowAncestor(this)).dispose();

//        PnlAzuriranjePregleda panel = new PnlAzuriranjePregleda(FrmMod.izmena);
//        FrmForma forma = new FrmForma((IPanel) panel);
//        forma.setParent((Frame) SwingUtilities.getWindowAncestor(this));
//        forma.setVisible(true);
    }//GEN-LAST:event_btnAzurirajActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzuriraj;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JButton btnPrikaziSve;
    private javax.swing.JButton btnZakazi;
    private datechooser.beans.DateChooserCombo datPregleda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPregledi;
    // End of variables declaration//GEN-END:variables

    private void srediTabelu() {
       model= new ModelTabelePregledi();
       tblPregledi.setModel(model);
    }

    private void spremiFormu() {
        model = new ModelTabelePregledi();
        tblPregledi.setModel(model);
//   try {
//            model = new ModelTabelePregledi();
//            tblPregledi.setModel(model);
//            List<Pregled> lista = Kontroler.getInstanca().vratiSvePreglede();
//            System.out.println("Pregledi: "+lista);
//            model.setLista(lista);
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(PnlPregledPretraga.class.getName()).log(Level.SEVERE, null, ex);
//        }       
//
  }
}
