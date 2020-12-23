/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesija;

import domen.Korisnik;
import domen.OpstaDomenskaKlasa;
import domen.Recept;
import domen.Uput;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.sound.midi.Receiver;

/**
 *
 * @author minna
 */
public class Sesija {
    
    private static Sesija instanca;
    private static Korisnik korisnik;
    private final Map<String,OpstaDomenskaKlasa> mapa;
    private List<Uput> uputi;
    private List<Recept> recepti;

    public Sesija() {
        mapa = new HashMap<>();
        uputi= new LinkedList<>();
        recepti= new LinkedList<>();
    }
    
    public static Sesija getInstanca() {
        if(instanca==null)
            instanca=new Sesija();
        return instanca;
    }

    public List<Uput> getUputi() {
        return uputi;
    }

    public void setUputi(List<Uput> uputi) {
        this.uputi = uputi;
    }

    public List<Recept> getRecepti() {
        return recepti;
    }

    public void setRecepti(List<Recept> recepti) {
        this.recepti = recepti;
    }
     
    public static Korisnik getKorisnik() {
        return korisnik;
    }

    public static void setKorisnik(Korisnik aKorisnik) {
        korisnik = aKorisnik;
    }

    public Map<String,OpstaDomenskaKlasa> getMapa() {
        return mapa;
    }

    
}
