/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.recept;

import domen.OpstaDomenskaKlasa;
import domen.Recept;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author minoc
 */
public class SOKreirajRecept extends OpstaSistemskaOperacija{

    @Override
    protected void validacija(Object objekat) throws Exception {
         if(!(objekat instanceof Recept)){
       throw new Exception("Neodgovarajuc parametar!");
       
       }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
         db.sacuvaj((OpstaDomenskaKlasa) object);
    }
    
}
