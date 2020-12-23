/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import skladiste.DBBrokerInterfejs;
import skladiste.baza.DBBroker;
import skladiste.baza.konekcija.DBKonekcija;

/**
 *
 * @author minoc
 */
public abstract class OpstaSistemskaOperacija {
    
    
    protected DBBrokerInterfejs db;

    public OpstaSistemskaOperacija() {
        db= new DBBroker();
    }
    
        public final void opsteIzvrsenje(Object objekat) throws Exception {
        try {
            validacija(objekat);
            try {
                zapocniTransakciju();
                izvrsi(objekat);
                commit();
            } catch (Exception ex) {
                System.out.println("ROLLBACK");
                
                rollback();
                throw ex;

            }
        } catch (Exception ex) {
           ex.printStackTrace();
            throw ex;
        }

    }
        
    
    protected abstract void validacija(Object objekat) throws Exception;

    private void zapocniTransakciju() throws Exception {
        DBKonekcija.getInstanca().zapocniTransakciju();
    }

    protected abstract void izvrsi(Object object) throws Exception;

    private void commit() throws Exception {

        DBKonekcija.getInstanca().commit();
    }

    private void rollback() throws Exception {

        DBKonekcija.getInstanca().rollback();

    }
    
    
}
