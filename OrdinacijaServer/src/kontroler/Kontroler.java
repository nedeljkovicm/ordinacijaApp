/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Karton;
import skladiste.baza.DBBroker;
import domen.Korisnik;
import domen.Lek;
import domen.OpstaDomenskaKlasa;
import domen.Pregled;
import domen.Recept;
import domen.TipAnalize;
import domen.Uput;
import forme.FrmServer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.ObradaKlijetnskihZahteva;
import so.OpstaSistemskaOperacija;
import so.SOPrijava;
import so.analiza.SOVratiListuAnaliza;
import so.karton.SOIzmeniKarton;
import so.karton.SOKreirajKarton;
import so.karton.SOVratiOdredjeneKartone;
import so.karton.SOVratiSveKartone;
import so.lek.SOKreirajLek;
import so.lek.SOVratiOdredjeneLekove;
import so.lek.SOVratiSveLekove;
import so.pregled.SOAzurirajPregled;
import so.pregled.SOKreirajPregled;
import so.pregled.SOVratiOdredjenePreglede;
import so.pregled.SOVratiSvePreglede;
import so.recept.SOKreirajRecept;
import so.uput.SOKreirajUput;
import so.uput.SOVratiOdredjeneUpute;
import transfer.ServerskiOdgovor;
import transfer.util.StatusOdgovora;

/**
 *
 * @author minoc
 */
public class Kontroler {

    private static Kontroler instanca;
    private FrmServer forma;
    private ArrayList<ObradaKlijetnskihZahteva> prijavljeniKorisnici;
    
        public static Kontroler getInstanca() {
        if(instanca==null)
            instanca=new Kontroler();
        return instanca;
    }
    
    public Kontroler() {
        
        prijavljeniKorisnici = new ArrayList<>();
    }


    public FrmServer getForma() {
        return forma;
    }

    public void setForma(FrmServer forma) {
        this.forma = forma;
    }

    public ArrayList<ObradaKlijetnskihZahteva> getPrijavljeniKorisnici() {
        return prijavljeniKorisnici;
    }

    public void setPrijavljeniKorisnici(ArrayList<ObradaKlijetnskihZahteva> prijavljeniKorisnici) {
        this.prijavljeniKorisnici = prijavljeniKorisnici;
    }
    
        

    public Korisnik prijavi(Korisnik k) throws Exception {
        OpstaSistemskaOperacija oso = new SOPrijava();
        oso.opsteIzvrsenje(k);
        return ((SOPrijava) oso).getK();
    }

    public void odjaviKorisnika(Korisnik kor) {
        forma.odjaviKorisnika(kor);
  
    }

    public void ubaciKarton(Karton k) throws Exception {
        OpstaSistemskaOperacija oso = new SOKreirajKarton();
        oso.opsteIzvrsenje(k);
    }

    public void ubaciLek(Lek l) throws Exception {
        OpstaSistemskaOperacija oso = new SOKreirajLek();
        oso.opsteIzvrsenje(l);
    }

    public List<OpstaDomenskaKlasa> vratiSveTipove() throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiListuAnaliza();
        oso.opsteIzvrsenje(new TipAnalize());
        return ((SOVratiListuAnaliza) oso).getAnalize();

    }

//    public void ubaciUput(Uput u) throws Exception {
//          OpstaSistemskaOperacija oso = new SOKreirajUput();
//        oso.opsteIzvrsenje(u);
//    }

    public List<OpstaDomenskaKlasa> vratiSveKartone() throws Exception {
       OpstaSistemskaOperacija oso = new SOVratiSveKartone();
        oso.opsteIzvrsenje(new Karton());
        return ((SOVratiSveKartone) oso).getKartoni();
    }
    
    
    public ArrayList<OpstaDomenskaKlasa> vratiOdredjeneLekove(Lek lek) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiOdredjeneLekove();
        oso.opsteIzvrsenje(lek);
        return (ArrayList<OpstaDomenskaKlasa>) ((SOVratiOdredjeneLekove) oso).getLista();
    }

    public List<OpstaDomenskaKlasa> vratiSveLekove() throws Exception {
         OpstaSistemskaOperacija oso = new SOVratiSveLekove();
        oso.opsteIzvrsenje(new Lek());
        return ((SOVratiSveLekove) oso).getLekovi();
    }
    

    public void ubaciPregled(Pregled p) throws Exception {
        OpstaSistemskaOperacija oso = new SOKreirajPregled();
        oso.opsteIzvrsenje(p);
    }

    public ArrayList<OpstaDomenskaKlasa> vratiOdredjeneKartone(Karton karton) throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiOdredjeneKartone();
        oso.opsteIzvrsenje(karton);
        return (ArrayList<OpstaDomenskaKlasa>) ((SOVratiOdredjeneKartone) oso).getLista();
    }

    public void izmeniKarton(Karton k) throws Exception {
          OpstaSistemskaOperacija oso = new SOIzmeniKarton();
        oso.opsteIzvrsenje(k);
    }

    public List<OpstaDomenskaKlasa> vratiSvePreglede() throws Exception {
        OpstaSistemskaOperacija oso = new SOVratiSvePreglede();
        oso.opsteIzvrsenje(new Pregled());
        return ((SOVratiSvePreglede) oso).getLista();
    }

    public ArrayList<OpstaDomenskaKlasa> vratiOdredjenePreglede(Pregled pregled) throws Exception {
         OpstaSistemskaOperacija oso = new SOVratiOdredjenePreglede();
        oso.opsteIzvrsenje(pregled);
        return (ArrayList<OpstaDomenskaKlasa>) ((SOVratiOdredjenePreglede) oso).getLista();
    }

    public void izbaciKorisnika(Korisnik k) throws IOException {
        for (int i = 0; i < prijavljeniKorisnici.size(); i++) {
            if (prijavljeniKorisnici.get(i).getK().equals(k)) {
                ServerskiOdgovor so = new ServerskiOdgovor();
                so.setGreska("Gotovo");
                so.setOdgovor("Gotovo! Odjavljeni ste sa sistema!");
                so.setStatus(StatusOdgovora.KRAJ_RADA);
                System.out.println(so);
                prijavljeniKorisnici.get(i).posaljiOdgovor(so);
                prijavljeniKorisnici.get(i).setKraj(true);
                try {
                    prijavljeniKorisnici.get(i).getSoket().close();
                } catch (IOException ex) {
                    Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
                }
                prijavljeniKorisnici.remove(i);

            }

        }
    }

    public void izmeniPregled(Pregled p) throws Exception {
        OpstaSistemskaOperacija oso = new SOAzurirajPregled();
        oso.opsteIzvrsenje(p);
    }
//
//    public void ubaciRecept(Recept r) throws Exception {
//         OpstaSistemskaOperacija oso = new SOKreirajRecept();
//        oso.opsteIzvrsenje(r);
//    }

//    public ArrayList<OpstaDomenskaKlasa> vratiUputeZaKarton(Pregled pregled) throws Exception {
//         OpstaSistemskaOperacija oso = new SOVratiOdredjeneUpute();
//        oso.opsteIzvrsenje(pregled);
//        return (ArrayList<OpstaDomenskaKlasa>) ((SOVratiOdredjeneUpute) oso).getLista();
//    }

    
}
