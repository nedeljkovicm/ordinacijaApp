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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minoc
 */
public class Uput implements Serializable,OpstaDomenskaKlasa{
    
    private int uputID;
    private String opis;
    
    private TipAnalize tipAnalize;
    
    private Pregled pregled;

    public Uput() {
        tipAnalize= new TipAnalize();
    }

    public Uput(int uputID, String opis, TipAnalize tipAnalize) {
        this.uputID = uputID;
        this.opis = opis;
        this.tipAnalize = tipAnalize;
    }

    public TipAnalize getTipAnalize() {
        return tipAnalize;
    }

    public void setTipAnalize(TipAnalize tipAnalize) {
        this.tipAnalize = tipAnalize;
    }

    public int getUputID() {
        return uputID;
    }

    public void setUputID(int uputID) {
        this.uputID = uputID;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
    
    
    public Pregled getPregled() {
        return pregled;
    }

    public void setPregled(Pregled pregled) {
        this.pregled = pregled;
    }

    @Override
    public String toString() {
        return "Uput za "+tipAnalize;
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
        final Uput other = (Uput) obj;
        if (this.uputID != other.uputID) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String vratiImeKlase() {
        return "uput";
    }

    @Override
    public String vratiUslovZaJednog() {
        return "u.SifraPregled="+pregled.getPregledID()+ " and u.SifraUput="+uputID;
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
                
              int id = rs.getInt("u.SifraUput");
                String op = rs.getString("u.Opis");
                int tipid = rs.getInt("a.SifraAnaliza");
                String nazivA = rs.getString("a.NazivAnaliza");
                TipAnalize tipA= new TipAnalize(tipid, nazivA);
                Uput u= new Uput(id,op,tipA);
                u.setPregled(p);
                
                lista.add(u);

            }
        } catch (SQLException ex) {
           // Logger.getLogger(TipRadnogMesta.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;
    }

   
    @Override
    public String vratiVrednostiAtributa() {
        return pregled.getPregledID()+ ", " + uputID + ", '" + opis+ "' , " + tipAnalize.getTipAnalizeID();
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaVise() {
//        return " where SifraUput=" + uputID +" and SifraPregled="+pregled.getPregledID();
       return " where u.SifraPregled= "+pregled.getPregledID();
    }

    @Override
    public String vratiSpajanje() {
//        return " u join tipanalize a on u.SifraAnaliza=a.SifraAnaliza";
        return " u join tipanalize a on u.SifraAnaliza=a.SifraAnaliza join pregled p on p.SifraPregled=u.SifraPregled join karton k on p.SifraKarton=k.SifraKarton";
    }

    
    
    
}
