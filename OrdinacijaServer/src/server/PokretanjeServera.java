/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import util.PodesavanjaKonekcije;

/**
 *
 * @author minoc
 */
public class PokretanjeServera extends Thread{
    
   private ServerSocket ss; 
   boolean kraj=false;
  // List<ObradaKlijetnskihZahteva> klijenti= new ArrayList<>();

   
    @Override
    public void run() {
        int port = Integer.parseInt(PodesavanjaKonekcije.getInstanca().getProperty("port"));
          try {
              ss=new ServerSocket(port);
              System.out.println("Server pokrenut");
              Kontroler.getInstanca().getForma().postaviStatus("Server pokrenut na portu: " + port, false);
              while(!kraj){
                Socket s= ss.accept();
                ObradaKlijetnskihZahteva okz= new ObradaKlijetnskihZahteva(s);
                okz.start();
                Kontroler.getInstanca().getPrijavljeniKorisnici().add(okz);
               // System.out.println("Klijent povezan");
            }
            } catch (SocketException ex) {
                Kontroler.getInstanca().getForma().postaviStatus("Server nije pokrenut ", true);    
                // Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
               
                kraj=true;
            } catch (Exception ex) {
                Kontroler.getInstanca().getForma().postaviStatus("Server nije pokrenut ", true);    
               // Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Neodgovarajuci broj porta!");
                kraj=true;
       }
           
           System.out.println("GOTOVO");
    }
    

    
    public void zaustavi() {
       try {
           
           for (ObradaKlijetnskihZahteva pk : Kontroler.getInstanca().getPrijavljeniKorisnici()) {
               pk.setKraj(true);
             pk.getSoket().close();  
           }
           kraj=true;
           ss.close();
           Kontroler.getInstanca().getForma().srediTabelu();
           System.out.println("Server je zaustavljen");
           Kontroler.getInstanca().getForma().postaviStatus("Server nije pokrenut",true);
       } catch (IOException ex) {
           Logger.getLogger(PokretanjeServera.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    
}
