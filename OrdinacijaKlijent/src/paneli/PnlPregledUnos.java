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
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import kontroler.Kontroler;

/**
 *
 * @author minna
 */
public class PnlPregledUnos extends javax.swing.JPanel implements IPanel{

    Karton pacijent;
    FrmMod mod;
    
    
    /**
     * Creates new form PnlPregledUnos
     */
    public PnlPregledUnos() {
        initComponents();
        spremiVreme();
        lblZak.setEditable(false);
        
        
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
        btnSacuvaj = new javax.swing.JButton();
        datPregleda = new datechooser.beans.DateChooserCombo();
        btnPretragaKartona = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblPrezime = new javax.swing.JLabel();
        lblIme = new javax.swing.JLabel();
        lblJMBG = new javax.swing.JLabel();
        lblPrviPregl = new javax.swing.JLabel();
        lblPoslednjiPregl = new javax.swing.JLabel();
        lblDijagnoza = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbSat = new javax.swing.JComboBox<>();
        cmbMin = new javax.swing.JComboBox<>();
        pnlZakazani = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lblZak = new javax.swing.JTextArea();

        setBorder(javax.swing.BorderFactory.createTitledBorder("Zakazivanje pregleda"));

        jLabel2.setText("Datum pregleda: ");

        btnSacuvaj.setText("Sacuvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        datPregleda.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                datPregledaOnSelectionChange(evt);
            }
        });

        btnPretragaKartona.setText("Pretraga kartona");
        btnPretragaKartona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretragaKartonaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pacijent"));

        lblPrezime.setText("Prezime:");

        lblIme.setText("Ime:");

        lblJMBG.setText("JMBG:");

        lblPrviPregl.setText("Prvi pregled:");

        lblPoslednjiPregl.setText("Poslednji pregled:");

        lblDijagnoza.setText("Dijagnoza:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPrezime)
                    .addComponent(lblIme)
                    .addComponent(lblPrviPregl)
                    .addComponent(lblPoslednjiPregl)
                    .addComponent(lblDijagnoza)
                    .addComponent(lblJMBG))
                .addContainerGap(396, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPrezime)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIme)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJMBG)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPrviPregl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPoslednjiPregl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDijagnoza)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel1.setText("Vreme:");

        jLabel3.setText(":");

        cmbSat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbMin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        pnlZakazani.setBorder(javax.swing.BorderFactory.createTitledBorder("Zakazani termini"));

        lblZak.setColumns(20);
        lblZak.setRows(5);
        jScrollPane1.setViewportView(lblZak);

        javax.swing.GroupLayout pnlZakazaniLayout = new javax.swing.GroupLayout(pnlZakazani);
        pnlZakazani.setLayout(pnlZakazaniLayout);
        pnlZakazaniLayout.setHorizontalGroup(
            pnlZakazaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlZakazaniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlZakazaniLayout.setVerticalGroup(
            pnlZakazaniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlZakazaniLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPretragaKartona, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datPregleda, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlZakazani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbSat, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnPretragaKartona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(datPregleda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(cmbSat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlZakazani, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSacuvaj))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
 

        Date datum= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            datum = java.sql.Date.valueOf(sdf.format(datPregleda.getSelectedDate().getTime()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Morate uneti datum!");
            return;

        }
        
        String vreme=(String) cmbSat.getSelectedItem()+":"+(String) cmbMin.getSelectedItem();
        System.out.println(vreme);
        
        boolean val=validacija(datum,vreme);
        
        if(val){
            System.out.println(pacijent);
        Pregled p = new Pregled(0, datum, pacijent.getDijagnoza(), false, vreme, pacijent, new ArrayList<Uput>(), new ArrayList<Recept>());
        try {
            String poruka = Kontroler.getInstanca().unesiPregled(p);
            JOptionPane.showMessageDialog(this, poruka);
            sesija.Sesija.getInstanca().getMapa().put("trenutniPregled", p); 
            System.out.println(p);
          
                if (((SwingUtilities.getWindowAncestor((FrmForma) SwingUtilities.getWindowAncestor(this)))) instanceof GlavnaForma) {
                    return;
                }
            ((FrmForma) SwingUtilities.getWindowAncestor(this)).dispose();
           (((FrmForma) SwingUtilities.getWindowAncestor((FrmForma) SwingUtilities.getWindowAncestor(this)))).getPanel().popuniPodatke();
          
        } catch (NullPointerException e) {
            System.out.println("Greska - pregled cuvanje");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Neuspesno cuvanje");
           Logger.getLogger(PnlPregledUnos.class.getName()).log(Level.SEVERE, null, ex);
        }

        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void datPregledaOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_datPregledaOnSelectionChange
       
        
        Date izabraniDat= new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            izabraniDat = java.sql.Date.valueOf(sdf.format(datPregleda.getSelectedDate().getTime()));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Morate uneti datum!");
            return;

        }
        
        String zakazaniTermini="";
        
         try {
            List<Pregled> lista = kontroler.Kontroler.getInstanca().vratiSvePreglede();
            for (Pregled p : lista) {
                if(p.getDatum().equals(izabraniDat))
                    zakazaniTermini+=p.getVreme()+" "+p.getKarton()+" ["+p.getKarton().getDijagnoza()+"]\n";
                    
                    
            }
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(PnlPregledUnos.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        lblZak.setText(zakazaniTermini);
         
    }//GEN-LAST:event_datPregledaOnSelectionChange

    private void btnPretragaKartonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretragaKartonaActionPerformed
       
        PnlKartonPretraga panel = new PnlKartonPretraga();
        panel.izaberi();
        //FrmDialog forma = new FrmDialog((Frame) SwingUtilities.getWindowAncestor(this), true, panel);
        FrmForma forma = new FrmForma(panel);
        forma.setParent((Frame) SwingUtilities.getWindowAncestor(this));
        forma.setVisible(true);
    }//GEN-LAST:event_btnPretragaKartonaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPretragaKartona;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<String> cmbMin;
    private javax.swing.JComboBox<String> cmbSat;
    private datechooser.beans.DateChooserCombo datPregleda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDijagnoza;
    private javax.swing.JLabel lblIme;
    private javax.swing.JLabel lblJMBG;
    private javax.swing.JLabel lblPoslednjiPregl;
    private javax.swing.JLabel lblPrezime;
    private javax.swing.JLabel lblPrviPregl;
    private javax.swing.JTextArea lblZak;
    private javax.swing.JPanel pnlZakazani;
    // End of variables declaration//GEN-END:variables

    
     @Override
    public void popuniPodatke() {
        pacijent = (Karton) sesija.Sesija.getInstanca().getMapa().get("trenutniKarton");
        if (pacijent != null) {
            lblPrezime.setText("Prezime: " + pacijent.getPrezime());
            lblIme.setText("Ime: " + pacijent.getIme());
            lblJMBG.setText("JMBG: " + pacijent.getJMBG());
            lblPrviPregl.setText("Prvi pregled: " + pacijent.getPrviPregled());
            lblPoslednjiPregl.setText("Poslednji pregled: " + pacijent.getPoslednjiPregled());
            lblDijagnoza.setText("Dijagnoza: " + pacijent.getDijagnoza());
        } else {
            JOptionPane.showMessageDialog(this,"Karton pacijenta nije izabran!");
            return;
        }
    }

    public FrmMod getMod() {
        return mod;
    }

    public void setMod(FrmMod mod) {
        this.mod = mod;
    }

    private boolean validacija( Date datum, String vreme) {
       if (!datum.after(new Date())) {
            JOptionPane.showMessageDialog(this, "Pregled mora biti zakazan najranije na sutrasnji datum!");
            return false;
        }
       
       boolean zauzetTermin=proveriTermin(datum,vreme);
        if (zauzetTermin) {
            JOptionPane.showMessageDialog(this, "Termin nije slobodan!");
            return false;
        }
        
        if (vreme.equals("00:00")) {
            JOptionPane.showMessageDialog(this, "Morate izabrati vreme pregleda!");
            return false;
        }
       
        
        
        return true;
    }

    private void spremiVreme() {
        cmbMin.removeAllItems();
        cmbSat.removeAllItems();
        
        for (int i =0; i < 25; i++) {
            if(i<10){
                cmbSat.addItem("0"+String.valueOf(i));
                continue;
            }
            cmbSat.addItem(String.valueOf(i));
        }
         for (int i =0; i < 60; i+=15) {
             if(i<10){
                cmbMin.addItem("0"+String.valueOf(i));
                continue;
            }
            cmbMin.addItem(String.valueOf(i));
        }
         
        
    }

    private boolean proveriTermin(Date datum, String vreme) {
         try {
            List<Pregled> lista = kontroler.Kontroler.getInstanca().vratiSvePreglede();
            for (Pregled p : lista) {
                if(p.getDatum().equals(datum) && p.getVreme().equals(vreme)){
                    return true;
                }
                   
            }
           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(PnlPregledUnos.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
        return false;
    }
}
