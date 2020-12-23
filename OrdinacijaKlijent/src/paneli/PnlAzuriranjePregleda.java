/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paneli;

import domen.Karton;
import domen.Pregled;
import domen.Recept;
import domen.Uput;
import forme.FrmDialog;
import forme.FrmForma;
import forme.FrmMod;
import forme.GlavnaForma;
import forme.IPanel;
import java.awt.Frame;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import kontroler.Kontroler;
import modeli.ModelTabeleRecepti;
import modeli.ModelTabeleUputi;

/**
 *
 * @author minna
 */
public class PnlAzuriranjePregleda extends javax.swing.JPanel implements IPanel{
    
    
    FrmMod mod;
    Karton k;
    Pregled p;
    
    
    ModelTabeleUputi modelUputi;
    ModelTabeleRecepti modelRecepti;

    /**
     * Creates new form PnlAzuriranjePregleda
     */
    public PnlAzuriranjePregleda() {
        initComponents();
        p=(Pregled) sesija.Sesija.getInstanca().getMapa().get("trenutniPregled");
        pripremiFormu();
        
       
//         Calendar c = Calendar.getInstance();
//        c.setTime(p.getDatum());
//        datDatum.setCurrent(c);
        
        txtDijagnoza.setEditable(false);
        btnNoviRecept.setVisible(false);
        btnNoviUput.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDijagnoza = new javax.swing.JTextArea();
        pnlUput = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUputi = new javax.swing.JTable();
        btnDetaljiUput = new javax.swing.JButton();
        btnNoviUput = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblPrezime = new javax.swing.JLabel();
        lblIme = new javax.swing.JLabel();
        lblJMBG = new javax.swing.JLabel();
        lblPrviPr = new javax.swing.JLabel();
        lblPoslPr = new javax.swing.JLabel();
        lblDijagnoza = new javax.swing.JLabel();
        lblAlergije = new javax.swing.JLabel();
        lblNapomene = new javax.swing.JLabel();
        lblLBO = new javax.swing.JLabel();
        lblZanimanje = new javax.swing.JLabel();
        lblKrvnaGrupa = new javax.swing.JLabel();
        lbl = new javax.swing.JLabel();
        pnlRecept = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRecepti = new javax.swing.JTable();
        btnNoviRecept = new javax.swing.JButton();
        btnDetaljiRecept = new javax.swing.JButton();
        cbRealizovan = new javax.swing.JCheckBox();
        btnSacuvaj = new javax.swing.JButton();
        lblDatum = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblVr = new javax.swing.JLabel();

        jLabel2.setText("Realizovan:");

        jLabel3.setText("Dijagnoza:");

        txtDijagnoza.setColumns(20);
        txtDijagnoza.setRows(5);
        jScrollPane1.setViewportView(txtDijagnoza);

        pnlUput.setBorder(javax.swing.BorderFactory.createTitledBorder("Uputi"));

        tblUputi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblUputi);

        btnDetaljiUput.setText("Detaljan prikaz");
        btnDetaljiUput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiUputActionPerformed(evt);
            }
        });

        btnNoviUput.setText("Novi uput");
        btnNoviUput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoviUputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlUputLayout = new javax.swing.GroupLayout(pnlUput);
        pnlUput.setLayout(pnlUputLayout);
        pnlUputLayout.setHorizontalGroup(
            pnlUputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUputLayout.createSequentialGroup()
                .addGroup(pnlUputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlUputLayout.createSequentialGroup()
                        .addContainerGap(67, Short.MAX_VALUE)
                        .addComponent(btnNoviUput, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDetaljiUput, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlUputLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnlUputLayout.setVerticalGroup(
            pnlUputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUputLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlUputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetaljiUput)
                    .addComponent(btnNoviUput))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pacijent"));

        lblPrezime.setText("Prezime:");

        lblIme.setText("Ime:");

        lblJMBG.setText("JMBG:");

        lblPrviPr.setText("Prvi pregled:");

        lblPoslPr.setText("Poslednji pregled:");

        lblDijagnoza.setText("Dijagnoza:");

        lblAlergije.setText("Alergije:");

        lblNapomene.setText("Napomene:");

        lblLBO.setText("LBO:");

        lblZanimanje.setText("Zanimanje:");

        lblKrvnaGrupa.setText("Krvna grupa:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKrvnaGrupa)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrezime)
                            .addComponent(lblIme)
                            .addComponent(lblJMBG)
                            .addComponent(lblLBO)
                            .addComponent(lblZanimanje))
                        .addGap(302, 302, 302)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPrviPr)
                            .addComponent(lblDijagnoza)
                            .addComponent(lblPoslPr)
                            .addComponent(lblAlergije)
                            .addComponent(lblNapomene))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrezime)
                    .addComponent(lblPrviPr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIme)
                    .addComponent(lblPoslPr))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJMBG)
                    .addComponent(lblDijagnoza))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAlergije)
                    .addComponent(lblLBO))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNapomene)
                    .addComponent(lblZanimanje))
                .addGap(18, 18, 18)
                .addComponent(lblKrvnaGrupa)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        lbl.setText("Datum:");

        pnlRecept.setBorder(javax.swing.BorderFactory.createTitledBorder("Recepti"));

        tblRecepti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblRecepti);

        btnNoviRecept.setText("Novi recept");
        btnNoviRecept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoviReceptActionPerformed(evt);
            }
        });

        btnDetaljiRecept.setText("Detaljan prikaz");
        btnDetaljiRecept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiReceptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlReceptLayout = new javax.swing.GroupLayout(pnlRecept);
        pnlRecept.setLayout(pnlReceptLayout);
        pnlReceptLayout.setHorizontalGroup(
            pnlReceptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceptLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlReceptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReceptLayout.createSequentialGroup()
                        .addComponent(btnNoviRecept, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDetaljiRecept, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlReceptLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        pnlReceptLayout.setVerticalGroup(
            pnlReceptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlReceptLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlReceptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDetaljiRecept)
                    .addComponent(btnNoviRecept))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbRealizovan.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                cbRealizovanStateChanged(evt);
            }
        });
        cbRealizovan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRealizovanActionPerformed(evt);
            }
        });

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        lblDatum.setText("jLabel1");

        jLabel1.setText("Vreme:");

        lblVr.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlRecept, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jLabel1)
                                    .addGap(34, 34, 34)
                                    .addComponent(lblVr, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbRealizovan)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlUput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl)
                    .addComponent(lblDatum)
                    .addComponent(jLabel1)
                    .addComponent(lblVr))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbRealizovan)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlRecept, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlUput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnSacuvaj)
                .addGap(13, 13, 13))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbRealizovanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRealizovanActionPerformed
       
    }//GEN-LAST:event_cbRealizovanActionPerformed

    private void btnDetaljiReceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiReceptActionPerformed
        pripremiFormuRecept(mod.pregled);
    }//GEN-LAST:event_btnDetaljiReceptActionPerformed

    private void btnNoviUputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoviUputActionPerformed
        pripremiDialogUput(mod.unos);
    }//GEN-LAST:event_btnNoviUputActionPerformed

    private void btnNoviReceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoviReceptActionPerformed
        pripremiFormuRecept(mod.unos);
    }//GEN-LAST:event_btnNoviReceptActionPerformed

    private void btnDetaljiUputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiUputActionPerformed
        pripremiDialogUput(mod.pregled);
    }//GEN-LAST:event_btnDetaljiUputActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        if(cbRealizovan.isSelected()){
            if(!txtDijagnoza.getText().isEmpty()){
           k.setDijagnoza(txtDijagnoza.getText());
           p.setDijagnoza(txtDijagnoza.getText());
            }
           p.setRealizacija(true);
           k.setPoslednjiPregled(((Pregled) sesija.Sesija.getInstanca().getMapa().get("trenutniPregled")).getDatum());
            try {
                String poruka = Kontroler.getInstanca().izmeniKarton(k);
                
                System.out.println(poruka);
                JOptionPane.showMessageDialog(this, poruka);
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(this, "Neuspesna izmena kartona");
                Logger.getLogger(PnlAzuriranjePregleda.class.getName()).log(Level.SEVERE, null, ex);
            }
               
           
        }
        
        modelUputi=(ModelTabeleUputi) tblUputi.getModel();
        List<Uput> uputi=modelUputi.getLista();
        System.out.println(uputi);
        modelRecepti=(ModelTabeleRecepti)tblRecepti.getModel();
        List<Recept> recepti=modelRecepti.getLista();
        System.out.println(recepti);
        
        p.setRecepti(recepti);
        p.setUputi(uputi);
        
        
        System.out.println(p);
        
         
        try{
            
        String poruka = Kontroler.getInstanca().izmeniPregled(p);
                System.out.println(poruka);
                JOptionPane.showMessageDialog(this, poruka);
                sesija.Sesija.getInstanca().getMapa().put("trenutniPregled", p);
                ((FrmForma) SwingUtilities.getWindowAncestor(this)).dispose();
                  if (((SwingUtilities.getWindowAncestor((FrmForma) SwingUtilities.getWindowAncestor(this)))) instanceof GlavnaForma) {
                    return;
                }
                (((FrmForma) SwingUtilities.getWindowAncestor((FrmForma) SwingUtilities.getWindowAncestor(this)))).getPanel().popuniPodatke();  
            } catch (NullPointerException e) {
                 System.out.println("Greska - izmena pregleda");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Neuspesna izmena");
                Logger.getLogger(PnlKartonUnosIzmena.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void cbRealizovanStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbRealizovanStateChanged
        if(cbRealizovan.isSelected()){
        txtDijagnoza.setEditable(true);
        //datDatum.setEnabled(false);
        btnNoviRecept.setVisible(true);
        btnNoviUput.setVisible(true);
        
        } else {
        txtDijagnoza.setEditable(false);
        btnNoviRecept.setVisible(false);
        btnNoviUput.setVisible(false);
        }
    }//GEN-LAST:event_cbRealizovanStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetaljiRecept;
    private javax.swing.JButton btnDetaljiUput;
    private javax.swing.JButton btnNoviRecept;
    private javax.swing.JButton btnNoviUput;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JCheckBox cbRealizovan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel lblAlergije;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblDijagnoza;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblJMBG;
    private javax.swing.JLabel lblKrvnaGrupa;
    private javax.swing.JLabel lblLBO;
    private javax.swing.JLabel lblNapomene;
    private javax.swing.JLabel lblPoslPr;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblPrviPr;
    private javax.swing.JLabel lblVr;
    private javax.swing.JLabel lblZanimanje;
    private javax.swing.JPanel pnlRecept;
    private javax.swing.JPanel pnlUput;
    private javax.swing.JTable tblRecepti;
    private javax.swing.JTable tblUputi;
    private javax.swing.JTextArea txtDijagnoza;
    // End of variables declaration//GEN-END:variables

    private void pripremiDialogUput(FrmMod frmMod) {
        if (frmMod != FrmMod.unos) {
            int index = tblUputi.getSelectedRow();

            if (index == -1) {

                JOptionPane.showMessageDialog(this, "Morate izabrati red!");
                return;
            }
             Uput u = modelUputi.getLista().get(index);
            sesija.Sesija.getInstanca().getMapa().put("trenutniUput",u);
        }
        
        PnlIzdavanjeUputa panel = new PnlIzdavanjeUputa(frmMod);
        FrmDialog dialog= new FrmDialog((Frame) SwingUtilities.getWindowAncestor(this), true, panel);
        dialog.setVisible(true);
    }

    private void pripremiFormuRecept(FrmMod frmMod) {
         if (frmMod != FrmMod.unos) {
            int index = tblRecepti.getSelectedRow();

            if (index == -1) {

                JOptionPane.showMessageDialog(this, "Morate izabrati red!");
                return;
            }
             Recept r = modelRecepti.getLista().get(index);
             sesija.Sesija.getInstanca().getMapa().put("trenutniRecept",r);
        }
        
        PnlIzdavanjeRecepta panel = new PnlIzdavanjeRecepta(frmMod);
        FrmForma forma= new FrmForma(panel);
        forma.setParent((Frame) SwingUtilities.getWindowAncestor(this));
        forma.setVisible(true);
        
        
    }

    private void pripremiFormu() {
            
        k=(Karton) sesija.Sesija.getInstanca().getMapa().get("trenutniKarton");
        p=(Pregled) sesija.Sesija.getInstanca().getMapa().get("trenutniPregled");
        
            lblPrezime.setText("Prezime: "+k.getPrezime());
            lblIme.setText("Ime: "+k.getIme());
            lblJMBG.setText("JMBG: "+k.getJMBG());
            lblLBO.setText("LBO: "+k.getLBO());
            lblZanimanje.setText("Zanimanje: "+k.getZanimanje());
            lblKrvnaGrupa.setText("Krvna grupa: "+k.getKg().toString());
            lblPrviPr.setText("Prvi pregled: "+k.getPrviPregled().toString());
            lblPoslPr.setText("Poslednji pregled: "+k.getPoslednjiPregled().toString());
            lblDijagnoza.setText("Dijagnoza: "+k.getDijagnoza());
            lblAlergije.setText("Alergije: "+k.getAlergije());
            lblNapomene.setText("Napomene: "+k.getNapomene());
            
            lblDatum.setText(" "+p.getDatum());
            lblVr.setText(" "+p.getVreme());
        
        
        
       modelRecepti= new ModelTabeleRecepti();
       tblRecepti.setModel(modelRecepti);
      // napuniRecepte(k);
       
       modelUputi= new ModelTabeleUputi();
       tblUputi.setModel(modelUputi);
     //  napuniUpute(k);
       
    } 

    @Override
    public void popuniPodatke() {
        
        modelUputi= (ModelTabeleUputi) tblUputi.getModel();
        if(sesija.Sesija.getInstanca().getMapa().get("trenutniUput")!=null){
        modelUputi.ubaciUTabelu((Uput) sesija.Sesija.getInstanca().getMapa().get("trenutniUput"));
        }
        
        modelRecepti= (ModelTabeleRecepti) tblRecepti.getModel();
        if(sesija.Sesija.getInstanca().getMapa().get("trenutniRecept")!=null){
        modelRecepti.ubaciUTabelu((Recept) sesija.Sesija.getInstanca().getMapa().get("trenutniRecept"));
        }
  
//        
//          if(!sesija.Sesija.getInstanca().getRecepti().isEmpty()){
//        modelRecepti.getLista().remove(sesija.Sesija.getInstanca().getRecepti());
//        modelRecepti.ubaci((Recept) sesija.Sesija.getInstanca().getMapa().get("trenutniRecept"));
//        }
//          
//        if(!sesija.Sesija.getInstanca().getUputi().isEmpty()){
//        modelUputi.getLista().remove(sesija.Sesija.getInstanca().getUputi());
//        modelUputi.ubaci((Uput) sesija.Sesija.getInstanca().getMapa().get("trenutniUput"));
//        }
    }

    void ubaciUTabelu(Uput u) {
        ModelTabeleUputi model = (ModelTabeleUputi) tblUputi.getModel();
        model.ubaciUTabelu(u);
    }

    private void napuniRecepte(Karton k) {
         Pregled pr= new Pregled();
        pr.setKarton(k);
        
        List<Pregled> preglediZaKarton;
        List<Recept> lista = new ArrayList<>();
        modelRecepti= new ModelTabeleRecepti();
        try {
            preglediZaKarton = kontroler.Kontroler.getInstanca().vratiPreglede(pr);
            tblRecepti.setModel(modelRecepti);
            for (Pregled pzk : preglediZaKarton) {
                if(pzk.getRecepti()!=null){
                    lista=pzk.getRecepti();
                    for (int i = 0; i < lista.size(); i++) {
                          modelRecepti.ubaci( lista.get(i));  
                    }
              
                }
                
            }
            tblRecepti.setModel(modelRecepti);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(PnlAzuriranjePregleda.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    private void napuniUpute(Karton k) {
        Pregled pr= new Pregled();
        pr.setKarton(k);
        
        List<Pregled> preglediZaKarton;
        List<Uput> lista = new ArrayList<>();
        modelUputi= new ModelTabeleUputi();
        try {
            preglediZaKarton = kontroler.Kontroler.getInstanca().vratiPreglede(pr);
            tblUputi.setModel(modelUputi);
            for (Pregled pzk : preglediZaKarton) {
                if(pzk.getUputi()!=null){
                    lista=pzk.getUputi();
                    for (int i = 0; i < lista.size(); i++) {
                          modelUputi.ubaci( lista.get(i));  
                    }
              
                }
                
            }
            tblUputi.setModel(modelUputi);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(PnlAzuriranjePregleda.class.getName()).log(Level.SEVERE, null, ex);

        }
  }
    
    
}
