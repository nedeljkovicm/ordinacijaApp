/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.Korisnik;
import domen.OpstaDomenskaKlasa;

/**
 *
 * @author minoc
 */
public class SOPrijava extends OpstaSistemskaOperacija{

    private Korisnik k;
    
    @Override
    protected void validacija(Object objekat) throws Exception {
        if(!(objekat instanceof Korisnik)){
        throw new Exception("Pogresan parametar");
        }
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
        k= (Korisnik) db.vratiJednog((OpstaDomenskaKlasa) object);
    }

    public Korisnik getK() {
        return k;
    }

    public void setK(Korisnik k) {
        this.k = k;
    }
    
}
