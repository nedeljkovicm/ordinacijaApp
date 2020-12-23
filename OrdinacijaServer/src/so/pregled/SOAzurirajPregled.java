/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.pregled;

import domen.OpstaDomenskaKlasa;
import domen.Pregled;
import domen.Recept;
import domen.Uput;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author minoc
 */
public class SOAzurirajPregled  extends OpstaSistemskaOperacija{

    @Override
    protected void validacija(Object objekat) throws Exception {
         if(!(objekat instanceof Pregled)){
        throw new Exception("Neodgovarajuci parametar!");
        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
       db.izmeni((OpstaDomenskaKlasa) object);
        Pregled p = (Pregled) object;
        List<Uput> uputi = p.getUputi();
        List<Recept> recepti = p.getRecepti();
           for (Uput u : uputi) {
            u.setPregled(p);
            db.sacuvaj(u); 
       }
         for (Recept r : recepti) {
             r.setPregled(p);
            db.sacuvaj(r); 
       }
        
    }
    
}
