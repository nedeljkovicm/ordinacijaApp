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
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author minna
 */
public class SOVratiOdredjenePreglede extends OpstaSistemskaOperacija{
    
    List<OpstaDomenskaKlasa> lista;

    public List<OpstaDomenskaKlasa> getLista() {
        return lista;
    }

    @Override
    protected void validacija(Object objekat) throws Exception {
        if (!(objekat instanceof Pregled)) {
            throw new Exception("Pogresni parametri");

        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
      // lista=db.vratiVise((OpstaDomenskaKlasa) object);
      
    
         lista = db.vratiVise((OpstaDomenskaKlasa) object);
        for (OpstaDomenskaKlasa odk : lista) {
            Pregled p = (Pregled) odk;
            Uput u= new Uput();
            Recept r= new Recept();
            u.setPregled(p);
            r.setPregled(p);
            List<OpstaDomenskaKlasa> lista1 = db.vratiVise(u);
            List<Uput> uputi = new ArrayList<>();
            for (OpstaDomenskaKlasa o : lista1) {
                u = (Uput) o;
                uputi.add(u);
            }
            p.setUputi((ArrayList<Uput>) uputi);
            
            List<OpstaDomenskaKlasa> lista2= db.vratiVise(r);
            List<Recept> recepti = new ArrayList<>();
            
            for (OpstaDomenskaKlasa o : lista2) {
                r = (Recept) o;
                recepti.add(r);
            }
            p.setRecepti((ArrayList<Recept>) recepti);
        }
    }
    
}
