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
public class Lek implements Serializable,OpstaDomenskaKlasa{
    
    private int lekID;
    private String naziv;
    private String koncentracija;
    private String grupaLekova;
    private String namena;
    private String sastav;
    private String kontraindikacije;

    public Lek() {
    }

    public Lek(int lekID, String naziv, String koncentracija, String grupaLekova, String namena, String sastav, String kontraindikacije) {
        this.lekID = lekID;
        this.naziv = naziv;
        this.koncentracija = koncentracija;
        this.grupaLekova = grupaLekova;
        this.namena = namena;
        this.sastav = sastav;
        this.kontraindikacije = kontraindikacije;
    }

    public String getKontraindikacije() {
        return kontraindikacije;
    }

    public void setKontraindikacije(String kontraindikacije) {
        this.kontraindikacije = kontraindikacije;
    }

    public int getLekID() {
        return lekID;
    }

    public void setLekID(int lekID) {
        this.lekID = lekID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getKoncentracija() {
        return koncentracija;
    }

    public void setKoncentracija(String koncentracija) {
        this.koncentracija = koncentracija;
    }

    public String getGrupaLekova() {
        return grupaLekova;
    }

    public void setGrupaLekova(String grupaLekova) {
        this.grupaLekova = grupaLekova;
    }

    public String getNamena() {
        return namena;
    }

    public void setNamena(String namena) {
        this.namena = namena;
    }

    public String getSastav() {
        return sastav;
    }

    public void setSastav(String sastav) {
        this.sastav = sastav;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Lek other = (Lek) obj;
        if (this.lekID != other.lekID) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String vratiImeKlase() {
        return "Lek";
    }

    @Override
    public String vratiUslovZaJednog() {
        return "SifraLek= " + lekID;
    }

    @Override
    public String vratiUslovZaVise() {
        return " WHERE Naziv LIKE '%" + naziv + "%'";
    }
    
    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
       if (!rs.next()) {
            throw new Exception("Nema lekova koji odgovaraju unetim kriterijumima");
        }
        rs.beforeFirst();
        List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int lekid = rs.getInt("SifraLek");
                String naz = rs.getString("Naziv");
                String konc = rs.getString("Koncentracija");
                String gr = rs.getString("GrupaLekova");
                String nam = rs.getString("Namena");
                String sast = rs.getString("Sastav");
                String kontraind = rs.getString("Kontraindikacije");
               
                Lek l= new Lek(lekid, naz, konc, gr, nam, sast, kontraind);
                
                lista.add(l);
            }
        } catch (SQLException ex) {

            
            throw ex;
        }
        return lista;
    }

    @Override
    public String postaviVrednostiAtributa() {
         return "SifraLek=" + lekID + ",Naziv='" + naziv + "',Koncentracija='" + koncentracija + "',GrupaLekova='" + grupaLekova 
            + "',Namena='" + namena  + "',Sastav='" + sastav
            + "',Kontraindikacije='" + kontraindikacije +  "'";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return lekID + ", " + (naziv == null ? null : "'" + naziv + "'")+ ", "
                + (koncentracija == null ? null : "'" + koncentracija + "'") 
                + ", " + (grupaLekova == null ? null : "'" + grupaLekova + "'") + ", "
                + (namena == null ? null : "'" + namena + "'")
                + ", " + (sastav == null ? null : "'" + sastav + "'") + ", "
                + (kontraindikacije == null ? null : "'" + kontraindikacije + "'");
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
