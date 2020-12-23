/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author minoc
 */
public class KlijentskiZahtev implements Serializable{
    
    private Object parametar;
    private int operacija;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(Object parametar, int operacija) {
        this.parametar = parametar;
        this.operacija = operacija;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public Object getParametar() {
        return parametar;
    }

    public void setParametar(Object parametar) {
        this.parametar = parametar;
    }
    
    @Override
    public String toString() {
        return "Zahtev{" + "operacija=" + operacija + ", parametar=" + parametar + '}';
    }
    
    
}
