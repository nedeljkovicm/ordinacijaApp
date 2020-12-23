/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.uput;

import domen.OpstaDomenskaKlasa;
import domen.Uput;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author minoc
 */
public class SOKreirajUput extends OpstaSistemskaOperacija{

    @Override
    protected void validacija(Object objekat) throws Exception {
        if(!(objekat instanceof Uput)){
       throw new Exception("Neodgovarajuc parametar!");
       
       }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
       db.sacuvaj((OpstaDomenskaKlasa) object);
    }
    
}
