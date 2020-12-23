/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.OpstaDomenskaKlasa;

/**
 *
 * @author minna
 */
public interface IPanel {
    
    default void popuniPolja(OpstaDomenskaKlasa odk){};

   default public void popuniPodatke(){};
    
    
}
