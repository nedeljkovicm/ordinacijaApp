/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.karton;

import domen.OpstaDomenskaKlasa;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author minoc
 */
public class SOVratiSveKartone extends OpstaSistemskaOperacija{
    
    
     private List<OpstaDomenskaKlasa> kartoni;
     
    @Override
    protected void validacija(Object objekat) throws Exception {
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        kartoni=db.vratiSve((OpstaDomenskaKlasa) object);
    }

    public List<OpstaDomenskaKlasa> getKartoni() {
        return kartoni;
    }
    
}
