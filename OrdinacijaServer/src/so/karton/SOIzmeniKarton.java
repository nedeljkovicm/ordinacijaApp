/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.karton;

import domen.Karton;
import domen.OpstaDomenskaKlasa;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author minna
 */
public class SOIzmeniKarton extends OpstaSistemskaOperacija{

    @Override
    protected void validacija(Object objekat) throws Exception {
         if(!(objekat instanceof Karton)){
        throw new Exception("Neodgovarajuci parametar!");
        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        db.izmeni((OpstaDomenskaKlasa) object);
    }
    
}
