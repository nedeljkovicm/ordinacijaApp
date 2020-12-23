/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package skladiste;

import domen.OpstaDomenskaKlasa;
import java.util.List;

/**
 *
 * @author minoc
 */
public interface DBBrokerInterfejs {
    public OpstaDomenskaKlasa vratiJednog(OpstaDomenskaKlasa ok)throws Exception;
    public List<OpstaDomenskaKlasa> vratiSve(OpstaDomenskaKlasa ok) throws Exception;

    public List<OpstaDomenskaKlasa> vratiVise(OpstaDomenskaKlasa ok)throws Exception;
    public int sacuvaj(OpstaDomenskaKlasa ok) throws Exception;
    public void izmeni(OpstaDomenskaKlasa ok) throws Exception;

    //public List<OpstaDomenskaKlasa> vratiVise1(OpstaDomenskaKlasa opstaDomenskaKlasa);
}
