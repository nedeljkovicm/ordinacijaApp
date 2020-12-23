/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author minoc
 */
public class Pregled implements Serializable, OpstaDomenskaKlasa {

    private int pregledID;
    private Date datum;
    private String dijagnoza;
    private boolean realizacija;
    private String vreme;

    private Karton karton;

    private List<Uput> uputi;
    private List<Recept> recepti;

    public Pregled() {
    }

    public Pregled(int pregledID, Date datum, String dijagnoza, boolean realizacija, String vreme, Karton karton, List<Uput> uputi, List<Recept> recepti) {
        this.pregledID = pregledID;
        this.datum = datum;
        this.dijagnoza = dijagnoza;
        this.realizacija = realizacija;
        this.vreme = vreme;
        this.karton = karton;
        this.uputi = uputi;
        this.recepti = recepti;
    }


    public List<Recept> getRecepti() {
        return recepti;
    }

    public void setRecepti(List<Recept> recepti) {
        this.recepti = recepti;
    }

    public int getPregledID() {
        return pregledID;
    }

    public void setPregledID(int pregledID) {
        this.pregledID = pregledID;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getDijagnoza() {
        return dijagnoza;
    }

    public void setDijagnoza(String dijagnoza) {
        this.dijagnoza = dijagnoza;
    }

    public boolean isRealizacija() {
        return realizacija;
    }

    public void setRealizacija(boolean realizacija) {
        this.realizacija = realizacija;
    }

    public Karton getKarton() {
        return karton;
    }

    public void setKarton(Karton karton) {
        this.karton = karton;
    }

    public List<Uput> getUputi() {
        return uputi;
    }

    public void setUputi(List<Uput> uputi) {
        this.uputi = uputi;
    }

    @Override
    public String toString() {
        return "Pregled ["+datum+"   "+vreme+"]";
        //return "Pregled ["+datum+"]     Pacijent:"+karton+" [JMBG "+karton.getJMBG()+"]";
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
        final Pregled other = (Pregled) obj;
        if (this.pregledID != other.pregledID) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String vratiImeKlase() {
        return "pregled";
    }

    @Override
    public String vratiUslovZaJednog() {
       return "SifraPregled= "+pregledID;
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSpajanje() {
        return " p join karton k on p.SifraKarton=k.SifraKarton ";
    }

    @Override
    public String vratiSortiranje() {
       return " order by k.Prezime,k.Ime ";
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
          List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt("p.SifraPregled");
            Date dat = rs.getDate("p.Datum");
            String dijagn = rs.getString("p.Dijagnoza");
            boolean realiz=rs.getBoolean("p.Realizacija");
            String vr = rs.getString("p.Vreme");
            
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
            
            Pregled p = new Pregled(id, dat, dijagn, realiz,vr, kart, null, null);
            lista.add(p);
        }
        return lista;
    }

    @Override
    public String postaviVrednostiAtributa() {
       return " Datum='" + datum + "',Dijagnoza= '" + dijagnoza + "' , Realizacija=" + realizacija  + " , Vreme= '" + vreme  + "' ,SifraKarton=" + karton.getKartonID();
    }

    @Override
    public String vratiVrednostiAtributa() {
        return pregledID + ", " + (datum == null ? null : "'" + datum + "'") + ", "
                + (dijagnoza == null ? null : "'" + dijagnoza + "'")
                + ", " + realizacija + ", '" + vreme + "' , "
                + karton.getKartonID();
    }

    @Override
    public String vratiUslovZaVise() {
        if(karton==null){
        return "where Datum= '"+datum+"'";
        }
        
        return "where p.SifraKarton="+karton.getKartonID();
        
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setPonudaID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getVreme() {
        return vreme;
    }

    public void setVreme(String vreme) {
        this.vreme = vreme;
    }

}
