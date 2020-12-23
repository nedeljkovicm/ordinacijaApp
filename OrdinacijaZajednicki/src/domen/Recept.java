/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author minoc
 */
public class Recept implements Serializable,OpstaDomenskaKlasa{
    
    private int sifraRecepta;
    private String uputstvo;
    private String potpisLekara;
    
    private Lek lek;
    
    private Pregled pregled;

    public Recept() {
    }

    public Recept(int sifraRecepta, String uputstvo, String potpisLekara, Lek lek) {
        this.sifraRecepta = sifraRecepta;
        this.uputstvo = uputstvo;
        this.potpisLekara = potpisLekara;
        this.lek = lek;
    }

    public Lek getLek() {
        return lek;
    }

    public void setLek(Lek lek) {
        this.lek = lek;
    }

    public int getSifraRecepta() {
        return sifraRecepta;
    }

    public void setSifraRecepta(int sifraRecepta) {
        this.sifraRecepta = sifraRecepta;
    }

    public String getUputstvo() {
        return uputstvo;
    }

    public void setUputstvo(String uputstvo) {
        this.uputstvo = uputstvo;
    }

    public String getPotpisLekara() {
        return potpisLekara;
    }

    public void setPotpisLekara(String potpisLekara) {
        this.potpisLekara = potpisLekara;
    }

    public Pregled getPregled() {
        return pregled;
    }

    public void setPregled(Pregled pregled) {
        this.pregled = pregled;
    }
    
    
    @Override
    public String toString() {
        return "Recept za "+lek;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recept other = (Recept) obj;
        if (this.sifraRecepta != other.sifraRecepta) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String vratiImeKlase() {
       return "recept";
    }

    @Override
    public String vratiUslovZaJednog() {
         return "r.SifraPregled="+pregled.getPregledID()+ " and r.SifraRecept="+sifraRecepta;
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        //           if (!rs.next()) {
//            throw new Exception("Nema uputa koji odgovaraju unetim kriterijumima");
//        }
        rs.beforeFirst();
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int idP = rs.getInt("p.SifraPregled");
            Date datP = rs.getDate("p.Datum");
            String dijagnP = rs.getString("p.Dijagnoza");
            boolean realizP=rs.getBoolean("p.Realizacija");
            String vrP = rs.getString("p.Vreme");
            
           int kartID = rs.getInt("k.SifraKarton");
                String jmbg = rs.getString("k.JMBG");
                String prez = rs.getString("k.Prezime");
                String im = rs.getString("k.Ime");
                String tel = rs.getString("k.KontaktTelefon");
                Date datRodj = rs.getDate("k.DatumRodjenja");
                KrvnaGrupa krvnaGr =KrvnaGrupa.valueOf(rs.getString("k.KrvnaGrupa"));
                String zan = rs.getString("k.Zanimanje");
                Date datPrvi = rs.getDate("k.PrviPregled");
                Date datPosl = rs.getDate("k.PoslednjiPregled");
                String lbo = rs.getString("k.LBO");
                String dij = rs.getString("k.Dijagnoza");
                String alerg = rs.getString("k.Alergije");
                String nap = rs.getString("k.Napomene");
                
            Karton kart= new Karton(kartID, jmbg, prez, im,tel, datRodj, krvnaGr, zan, datPrvi, datPosl, lbo, dij, alerg, nap);
            
            Pregled p = new Pregled(idP, datP, dijagnP, realizP, vrP, kart, null, null);
            
             
                int lekid = rs.getInt("l.SifraLek");
                String naz = rs.getString("l.Naziv");
                String konc = rs.getString("l.Koncentracija");
                String gr = rs.getString("l.GrupaLekova");
                String nam = rs.getString("l.Namena");
                String sast = rs.getString("l.Sastav");
                String kontraind = rs.getString("l.Kontraindikacije");
               
                Lek l= new Lek(lekid, naz, konc, gr, nam, sast, kontraind);
                
                    
              int id = rs.getInt("r.SifraRecept");
                String uputs = rs.getString("r.Uputstvo");
                String potp = rs.getString("r.PotpisLekara");
                
               Recept r= new Recept(id, uputs, potp, l);
                r.setPregled(p);
                
                lista.add(r);

            }
        } catch (SQLException ex) {
           // Logger.getLogger(TipRadnogMesta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiAtributa() {
          return pregled.getPregledID()+ ", "+ sifraRecepta + ", " + (uputstvo == null ? null : "'" + uputstvo + "'")+ ", "
                + (potpisLekara == null ? null : "'" + potpisLekara + "'")
                + ", " + lek.getLekID();
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaVise() {
       return " where r.SifraPregled="+pregled.getPregledID();
    }

    @Override
    public String vratiSpajanje() {
        return " r join lek l on r.SifraLek=l.SifraLek join pregled p on p.SifraPregled=r.SifraPregled join karton k on p.SifraKarton=k.SifraKarton";
    }

    
    
}
