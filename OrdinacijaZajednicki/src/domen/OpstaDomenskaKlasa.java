/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author minoc
 */
public interface OpstaDomenskaKlasa extends Serializable{


    public String vratiImeKlase();

    public String vratiUslovZaJednog();

    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception;

    default String vratiSpajanje(){return "";};

    default String vratiSortiranje(){return "";};

    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception;

    public String postaviVrednostiAtributa();

    public String vratiVrednostiAtributa();

    default String vratiUslovZaVise(){return "";};
    
    String vratiNazivKolone(int kolona);

   
    
    
}
