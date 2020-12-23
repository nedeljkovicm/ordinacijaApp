/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.analiza;

import domen.OpstaDomenskaKlasa;
import domen.TipAnalize;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author minoc
 */
public class SOVratiListuAnaliza extends OpstaSistemskaOperacija{
    
    private List<OpstaDomenskaKlasa> analize;

    @Override
    protected void validacija(Object objekat) throws Exception {
        
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        analize=db.vratiSve((OpstaDomenskaKlasa) object);
    }

    public List<OpstaDomenskaKlasa> getAnalize() {
        return analize;
    }

    
    
}
