/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import transfer.util.StatusOdgovora;

/**
 *
 * @author minoc
 */
public class ServerskiOdgovor implements Serializable{
    
    private Object odgovor;
    private Object greska;
    private StatusOdgovora status;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object odgovor, Object greska) {
        this.odgovor = odgovor;
        this.greska = greska;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public Object getGreska() {
        return greska;
    }

    public void setGreska(Object greska) {
        this.greska = greska;
    }

    public StatusOdgovora getStatus() {
        return status;
    }

    public void setStatus(StatusOdgovora status) {
        this.status = status;
    }
    
     @Override
    public String toString() {
        return "Odgovor{" + "status=" + status + ", podaci=" + odgovor + ", greska=" + greska + '}';
    }

    
    
}
