/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import util.PodesavanjaKonekcije;

/**
 *
 * @author minoc
 */
public class KomunikacijaSaServerom {
    
    static KomunikacijaSaServerom instanca;
    Socket s;

    public KomunikacijaSaServerom() {
        try {
            int port = Integer.parseInt(PodesavanjaKonekcije.getInstanca().getProperty("port"));
            String adresa = PodesavanjaKonekcije.getInstanca().getProperty("adresa");
            s= new Socket(adresa,port);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Greska prilikom uspostavljanja konekcije", "Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            //Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static KomunikacijaSaServerom getInstanca() {
        if(instanca==null)
            instanca= new KomunikacijaSaServerom();
        return instanca;
    }

    public void posaljiZahtev(KlijentskiZahtev kz) throws IOException {
        try {
            ObjectOutputStream oos= new ObjectOutputStream(s.getOutputStream());
            oos.writeObject(kz);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Greska sa serverom!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
           
           // Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ServerskiOdgovor primiOdgovor() throws IOException {
        ServerskiOdgovor so= new ServerskiOdgovor();
        try {
            ObjectInputStream ois= new ObjectInputStream(s.getInputStream());
            so=(ServerskiOdgovor) ois.readObject();
        } catch (Exception ex) {
            //Logger.getLogger(KomunikacijaSaServerom.class.getName()).log(Level.SEVERE, null, ex);
          
        }
        return so;
    }
    
    
    
    
}
