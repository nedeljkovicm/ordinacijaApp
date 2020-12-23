/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.lek;

import domen.Lek;
import domen.OpstaDomenskaKlasa;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author minoc
 */
public class SOKreirajLek extends OpstaSistemskaOperacija{

    @Override
    protected void validacija(Object objekat) throws Exception {
           if(!(objekat instanceof Lek)){
    throw new Exception("Pogresan parametar");
    }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        db.sacuvaj((OpstaDomenskaKlasa)object);
    }
    
}
