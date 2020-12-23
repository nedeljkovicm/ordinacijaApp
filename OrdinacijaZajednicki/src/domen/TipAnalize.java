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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minoc
 */
public class TipAnalize implements Serializable,OpstaDomenskaKlasa{
    
    private int tipAnalizeID;
    private String nazivAnalize;

    public TipAnalize() {
    }

    public TipAnalize(int tipAnalizeID, String nazivAnalize) {
        this.tipAnalizeID = tipAnalizeID;
        this.nazivAnalize = nazivAnalize;
    }

    public int getTipAnalizeID() {
        return tipAnalizeID;
    }

    public void setTipAnalizeID(int tipAnalizeID) {
        this.tipAnalizeID = tipAnalizeID;
    }

    public String getNazivAnalize() {
        return nazivAnalize;
    }

    public void setNazivAnalize(String nazivAnalize) {
        this.nazivAnalize = nazivAnalize;
    }

    @Override
    public String toString() {
        return nazivAnalize;
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
        final TipAnalize other = (TipAnalize) obj;
        if (this.tipAnalizeID != other.tipAnalizeID) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String vratiImeKlase() {
        return "TipAnalize";
    }

    @Override
    public String vratiUslovZaJednog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
         List<OpstaDomenskaKlasa> lista = new ArrayList<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("SifraAnaliza");
                String op = rs.getString("NazivAnaliza");
                TipAnalize ta = new TipAnalize(id, op);
                lista.add(ta);

            }
        } catch (SQLException ex) {
            Logger.getLogger(TipAnalize.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    @Override
    public String postaviVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiAtributa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiNazivKolone(int kolona) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
