/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.karton;


import domen.OpstaDomenskaKlasa;
import java.util.ArrayList;
import java.util.List;
import so.OpstaSistemskaOperacija;

/**
 *
 * @author minoc
 */
public class SOVratiOdredjeneKartone extends OpstaSistemskaOperacija{
    
    private List<OpstaDomenskaKlasa> lista;

    public SOVratiOdredjeneKartone() {
        lista= new ArrayList<>();
    }
    
    
    @Override
    protected void validacija(Object objekat) throws Exception {
       
    }

    @Override
    protected void izvrsi(Object object) throws Exception {
         lista=db.vratiVise((OpstaDomenskaKlasa) object);
    }

    public List<OpstaDomenskaKlasa> getLista() {
        return lista;
    }
    
}
