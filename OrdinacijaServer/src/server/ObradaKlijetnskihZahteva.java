/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Karton;
import domen.Korisnik;
import domen.Lek;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.util.Operacija;
import kontroler.Kontroler;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import domen.OpstaDomenskaKlasa;
import domen.Pregled;
import domen.Recept;
import domen.Uput;
import java.util.List;
import transfer.util.StatusOdgovora;

/**
 *
 * @author minoc
 */
public class ObradaKlijetnskihZahteva extends Thread {
    
    private Socket soket;
    private boolean kraj=false;
    private Korisnik k;
  
    public ObradaKlijetnskihZahteva(Socket s) {
        this.soket = s;
   
    }

    public Socket getSoket() {
        return soket;
    }

    public void setSoket(Socket soket) {
        this.soket = soket;
    }
    
    
    public boolean isKraj() {
        return kraj;
    }

    public void setKraj(boolean kraj) {
        this.kraj = kraj;
    }

    public Korisnik getK() {
        return k;
    }

    public void setK(Korisnik k) {
        this.k = k;
    }

    @Override
    public void run() {
        try{
        
            while(!kraj){
            
                KlijentskiZahtev kz=primiZahtev();
                System.out.println(kz);
                ServerskiOdgovor so= new ServerskiOdgovor();
                List<OpstaDomenskaKlasa> lista= new ArrayList<>();
           
                try{
                
                switch(kz.getOperacija()){
                    
                    case Operacija.PRIJAVA:
                        
                        k=(Korisnik) kz.getParametar();
                        k = Kontroler.getInstanca().prijavi(k);
                        so.setOdgovor(k);
                           System.out.println(k);
                        so.setStatus(StatusOdgovora.OK);
                        Kontroler.getInstanca().getPrijavljeniKorisnici().add(this);
                        Kontroler.getInstanca().getForma().dodajPrijavljenogKorisnika(k);
                        break;
                    
                    case Operacija.UNESI_KARTON:

                            Karton k = (Karton) kz.getParametar();
                            System.out.println(k);
                            Kontroler.getInstanca().ubaciKarton(k);
                            so.setOdgovor("Uspesno ste uneli karton!");
                            so.setStatus(StatusOdgovora.OK);

                        break;
                        
                        
                        case Operacija.UNESI_PREGLED:

                           Pregled p = (Pregled) kz.getParametar();
                            System.out.println(p);
                            Kontroler.getInstanca().ubaciPregled(p);
                            so.setOdgovor("Uspesno ste uneli pregled!");
                            so.setStatus(StatusOdgovora.OK);

                        break;
                        
                    case Operacija.UNESI_LEK:

                            Lek l = (Lek) kz.getParametar();
                            System.out.println(l);
                            Kontroler.getInstanca().ubaciLek(l);
                            so.setOdgovor("Uspesno ste uneli lek!");
                            so.setStatus(StatusOdgovora.OK);

                        break;    
                    
                    case Operacija.VRATI_TIPOVE_ANALIZA:

                            List<OpstaDomenskaKlasa> analize = Kontroler.getInstanca().vratiSveTipove();
                            so.setOdgovor(analize);
                            so.setStatus(StatusOdgovora.OK);

                        break;     
                    
//                     case Operacija.UNESI_UPUT:
//
//                            Uput u = (Uput) kz.getParametar();
//                            System.out.println(u);
//                            Kontroler.getInstanca().ubaciUput(u);
//                            so.setOdgovor("Uspesno ste uneli uput!");
//                            so.setStatus(StatusOdgovora.OK);
//
//                        break; 
//                        
//                         case Operacija.UNESI_RECEPT:
//
//                             Recept r = (Recept) kz.getParametar();
//                            System.out.println(r);
//                            Kontroler.getInstanca().ubaciRecept(r);
//                            so.setOdgovor("Uspesno ste uneli recept!");
//                            so.setStatus(StatusOdgovora.OK);
//
//                        break;
                        
                        
                     case Operacija.VRATI_SVE_KARTONE:

                            List<OpstaDomenskaKlasa> kartoni = Kontroler.getInstanca().vratiSveKartone();
                            so.setOdgovor(kartoni);
                            so.setStatus(StatusOdgovora.OK);

                        break;     
                    
                    case Operacija.VRATI_ODREDJENE_KARTONE:

                            lista = Kontroler.getInstanca().vratiOdredjeneKartone((Karton) kz.getParametar());
                            so.setOdgovor(lista);
                            so.setStatus(StatusOdgovora.OK);

                            break;
                            
                      case Operacija.IZMENI_KARTON:

                           k = (Karton) kz.getParametar();
                            Kontroler.getInstanca().izmeniKarton(k);
                            so.setOdgovor("Uspesno ste izmenili karton!");
                            so.setStatus(StatusOdgovora.OK);


                            break;
                            
                    case Operacija.VRATI_SVE_PREGLEDE:

                            List<OpstaDomenskaKlasa> pregledi = Kontroler.getInstanca().vratiSvePreglede();
                            so.setOdgovor(pregledi);
                            so.setStatus(StatusOdgovora.OK);

                     break;     
                    
                    case Operacija.VRATI_ODREDJENE_PREGLEDE:

                            lista = Kontroler.getInstanca().vratiOdredjenePreglede((Pregled) kz.getParametar());
                            so.setOdgovor(lista);
                            so.setStatus(StatusOdgovora.OK);

                     break;
                     
                          
                     case Operacija.VRATI_SVE_LEKOVE:

                            List<OpstaDomenskaKlasa> lekovi = Kontroler.getInstanca().vratiSveLekove();
                            so.setOdgovor(lekovi);
                            so.setStatus(StatusOdgovora.OK);

                        break;     
                     
                      
                    case Operacija.VRATI_ODREDJENE_LEKOVE:

                            lista = Kontroler.getInstanca().vratiOdredjeneLekove((Lek) kz.getParametar());
                            so.setOdgovor(lista);
                            so.setStatus(StatusOdgovora.OK);

                            break;
                     
                            
                       case Operacija.IZMENI_PREGLED:

                           p = (Pregled) kz.getParametar();
                            Kontroler.getInstanca().izmeniPregled(p);
                            so.setOdgovor("Uspesno ste izmenili pregled!");
                            so.setStatus(StatusOdgovora.OK);


                            break;

                            
                     case Operacija.ODJAVA:
                        
                        if (kz.getParametar()== null) {
                                Kontroler.getInstanca().getPrijavljeniKorisnici().remove(this);
                                kraj = true;
                                break;
                            } else {
                                Korisnik kor = (Korisnik) kz.getParametar();
                                Kontroler.getInstanca().odjaviKorisnika(kor);
                                so.setStatus(StatusOdgovora.OK);
                                so.setOdgovor("Uspesno ste se odjavili sa servera!");
                            }
           
                }
                
                }catch(Exception ex){
                    so.setStatus(StatusOdgovora.GRESKA);
                    so.setGreska(ex);
                }
                System.out.println(so);
                posaljiOdgovor(so);
       
            }
        
        
        }catch(Exception e){
        //            e.printStackTrace();

        }
        System.out.println("Klijent odjavljen");
    }

    private KlijentskiZahtev primiZahtev() throws IOException {
        KlijentskiZahtev kz= new KlijentskiZahtev();
        try {
            ObjectInputStream ois= new ObjectInputStream(soket.getInputStream());
            kz= (KlijentskiZahtev) ois.readObject();
        } catch (Exception ex) {
//            System.out.println("greska1");
//            ex.printStackTrace();
           // Logger.getLogger(ObradaKlijetnskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return kz;
    }

    public void posaljiOdgovor(ServerskiOdgovor so) throws IOException {
        try {
            ObjectOutputStream oos= new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(so);
        } catch (Exception ex) {
//             System.out.println("greska2");
//            ex.printStackTrace();

           // Logger.getLogger(ObradaKlijetnskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


}
