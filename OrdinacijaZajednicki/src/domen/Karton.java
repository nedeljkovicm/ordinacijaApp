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
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minoc
 */


public class Karton implements Serializable,OpstaDomenskaKlasa {
    
    private int kartonID;
    private String JMBG;
    private String prezime;
    private String ime;
    private String kontaktTelefon;
    private Date datumRodjenja;
    private KrvnaGrupa kg;   
    private String zanimanje;
    private Date prviPregled;
    private Date poslednjiPregled;
    private String LBO;
    private String dijagnoza;
    private String alergije;
    private String napomene;

    public Karton() {
    }

    public Karton(int kartonID, String JMBG, String prezime, String ime, String kontaktTelefon, Date datumRodjenja, KrvnaGrupa kg, String zanimanje, Date prviPregled, Date poslednjiPregled, String LBO, String dijagnoza, String alergije, String napomene) {
        this.kartonID = kartonID;
        this.JMBG = JMBG;
        this.prezime = prezime;
        this.ime = ime;
        this.kontaktTelefon = kontaktTelefon;
        this.datumRodjenja = datumRodjenja;
        this.kg = kg;
        this.zanimanje = zanimanje;
        this.prviPregled = prviPregled;
        this.poslednjiPregled = poslednjiPregled;
        this.LBO = LBO;
        this.dijagnoza = dijagnoza;
        this.alergije = alergije;
        this.napomene = napomene;
    }

    public String getNapomene() {
        return napomene;
    }

    public void setNapomene(String napomene) {
        this.napomene = napomene;
    }

    public int getKartonID() {
        return kartonID;
    }

    public void setKartonID(int kartonID) {
        this.kartonID = kartonID;
    }

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getKontaktTelefon() {
        return kontaktTelefon;
    }

    public void setKontaktTelefon(String kontaktTelefon) {
        this.kontaktTelefon = kontaktTelefon;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public KrvnaGrupa getKg() {
        return kg;
    }

    public void setKg(KrvnaGrupa kg) {
        this.kg = kg;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public Date getPrviPregled() {
        return prviPregled;
    }

    public void setPrviPregled(Date prviPregled) {
        this.prviPregled = prviPregled;
    }

    public Date getPoslednjiPregled() {
        return poslednjiPregled;
    }

    public void setPoslednjiPregled(Date poslednjiPregled) {
        this.poslednjiPregled = poslednjiPregled;
    }

    public String getLBO() {
        return LBO;
    }

    public void setLBO(String LBO) {
        this.LBO = LBO;
    }

    public String getDijagnoza() {
        return dijagnoza;
    }

    public void setDijagnoza(String dijagnoza) {
        this.dijagnoza = dijagnoza;
    }

    public String getAlergije() {
        return alergije;
    }

    public void setAlergije(String alergije) {
        this.alergije = alergije;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
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
        final Karton other = (Karton) obj;
        if (this.kartonID != other.kartonID) {
            return false;
        }
        return true;
    }
    
    
    

    @Override
    public String vratiImeKlase() {
        return "Karton";
    }

    @Override
    public String vratiUslovZaJednog() {
        return "SifraKarton= " + kartonID;
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSpajanje() {
        return OpstaDomenskaKlasa.super.vratiSpajanje(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSortiranje() {
        return OpstaDomenskaKlasa.super.vratiSortiranje(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        if (!rs.next()) {
            throw new Exception("Nema kartona koji odgovaraju unetim kriterijumima");
        }
        rs.beforeFirst();
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int kartID = rs.getInt("SifraKarton");
                String jmbg = rs.getString("JMBG");
                String prez = rs.getString("Prezime");
                String im = rs.getString("Ime");
                String tel = rs.getString("KontaktTelefon");
                Date datRodj = rs.getDate("DatumRodjenja");
                KrvnaGrupa krvnaGr =KrvnaGrupa.valueOf(rs.getString("KrvnaGrupa"));
                String zan = rs.getString("Zanimanje");
                Date datPrvi = rs.getDate("PrviPregled");
                Date datPosl = rs.getDate("PoslednjiPregled");
                String lbo = rs.getString("LBO");
                String dij = rs.getString("Dijagnoza");
                String alerg = rs.getString("Alergije");
                String nap = rs.getString("Napomene");
                Karton k= new Karton(kartID, jmbg, prez, im,tel, datRodj, krvnaGr, zan, datPrvi, datPosl, lbo, dij, alerg, nap);
                lista.add(k);
            }
        } catch (SQLException ex) {

            
            throw ex;
        }
        return lista;
    }

    @Override
    public String postaviVrednostiAtributa() {
       return "SifraKarton=" + kartonID + ",JMBG='" + JMBG + "',Prezime='" + prezime + "',Ime='" + ime 
            + "',KontaktTelefon='" + kontaktTelefon  + "',DatumRodjenja='" + datumRodjenja
            + "',KrvnaGrupa='" + kg + "',Zanimanje='" + zanimanje + "',jmbg='" + JMBG
            + "',PrviPregled='" + prviPregled + "',PoslednjiPregled='" + poslednjiPregled + "',LBO='" + LBO
            + "',Dijagnoza='" + dijagnoza + "',Alergije='" + alergije + "',Napomene='" + napomene + "'";
    }

    @Override
    public String vratiVrednostiAtributa() {
          return kartonID + ", " + (JMBG == null ? null : "'" + JMBG + "'")+ ", "
                + (prezime == null ? null : "'" + prezime + "'") 
                + ", " + (ime == null ? null : "'" + ime + "'") + ", "
                + (kontaktTelefon == null ? null : "'" + kontaktTelefon + "'")
                + ", " + (datumRodjenja == null ? null : "'" + datumRodjenja + "'") + ", "
                + (kg == null ? null : "'" + kg + "'") + ", "
                + (zanimanje == null ? null : "'" + zanimanje + "'") + ", "
                + (prviPregled == null ? null : "'" + prviPregled + "'") + ", "
                + (poslednjiPregled == null ? null : "'" + poslednjiPregled + "'") + ", "
                + (LBO == null ? null : "'" + LBO + "'") + ", "
                + (dijagnoza == null ? null : "'" + dijagnoza + "'") + ", "
                + (alergije == null ? null : "'" + alergije + "'") + ", "
                + (napomene == null ? null : "'" + napomene + "'");
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaVise() {
        return " WHERE Prezime LIKE '%" + prezime + "%'";
    }
    
    
    
    
    
}
