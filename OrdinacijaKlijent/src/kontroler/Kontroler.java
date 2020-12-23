/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Karton;
import domen.Korisnik;
import domen.Lek;
import domen.Pregled;
import domen.Recept;
import domen.TipAnalize;
import domen.Uput;
import forme.GlavnaForma;
import java.util.ArrayList;
import java.util.List;
import komunikacija.KomunikacijaSaServerom;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer.util.Operacija;
import transfer.util.StatusOdgovora;

/**
 *
 * @author minoc
 */
public class Kontroler {
    
    private static Kontroler instanca;
    private GlavnaForma forma;

    public Kontroler() {
    }

    public static Kontroler getInstanca() {
        if(instanca==null)
            instanca= new Kontroler();
        return instanca;
    }

    public GlavnaForma getForma() {
        return forma;
    }

    public void setForma(GlavnaForma forma) {
        this.forma = forma;
    }

    public Korisnik prijavaNaSistem(String korIme, String lozinka) throws Exception {
       Korisnik k= new Korisnik();
       k.setUsername(korIme);
       k.setPassword(lozinka);
        System.out.println(k.getUsername()+" "+k.getPassword());
        KlijentskiZahtev kz= new KlijentskiZahtev();
        kz.setOperacija(Operacija.PRIJAVA);
        kz.setParametar(k);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        ServerskiOdgovor so= KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            sesija.Sesija.getInstanca().setKorisnik((Korisnik) so.getOdgovor());
            System.out.println(sesija.Sesija.getInstanca().getKorisnik());
            
            return (Korisnik) so.getOdgovor();

        }
        
        //Korisnik ulogovaniLekar=(Korisnik) so.getOdgovor();
//        System.out.println(ulogovaniLekar.getIme()+" "+ulogovaniLekar.getPrezime());
//        return ulogovaniLekar;
          Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public String odjavaSaSistema(Korisnik korisnik) throws Exception {
        //System.out.println(korisnik);
        KlijentskiZahtev kz = new KlijentskiZahtev(korisnik,Operacija.ODJAVA);

        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if(so.getStatus() == StatusOdgovora.OK){
            return (String) so.getOdgovor();
        }
        throw (Exception)so.getGreska();
    }

    public String unesiKarton(Karton k) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(k,Operacija.UNESI_KARTON);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) so.getOdgovor();
            return poruka;
        }
        Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public String unesiLek(Lek l) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(l,Operacija.UNESI_LEK);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) so.getOdgovor();
            return poruka;
        }
        Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public List<TipAnalize> vratiTipoveAnaliza() throws Exception {
         KlijentskiZahtev kz = new KlijentskiZahtev(new TipAnalize(),Operacija.VRATI_TIPOVE_ANALIZA);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            List<TipAnalize> analize = new ArrayList<>();
            analize = (ArrayList<TipAnalize>) so.getOdgovor();
            System.out.println(analize);
            return analize;
        }
        Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public String unesiUput(Uput u) throws Exception {
        System.out.println(u);
        KlijentskiZahtev kz = new KlijentskiZahtev(u,Operacija.UNESI_UPUT);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) so.getOdgovor();
            return poruka;
        }
        Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public List<Karton> vratiSveKartone() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(new Karton(),Operacija.VRATI_SVE_KARTONE);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            List<Karton> kartoni = new ArrayList<>();
            kartoni = (ArrayList<Karton>) so.getOdgovor();
            System.out.println(kartoni);
            return kartoni;
        }
        Exception ex = (Exception) so.getGreska();
        throw ex;
    }
    
    public List<Pregled> vratiSvePreglede() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(new Pregled(),Operacija.VRATI_SVE_PREGLEDE);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            List<Pregled> pregledi = new ArrayList<>();
            pregledi = (ArrayList<Pregled>) so.getOdgovor();
            System.out.println(pregledi);
            return pregledi;
        }
        Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public String unesiPregled(Pregled p) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(p,Operacija.UNESI_PREGLED);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) so.getOdgovor();
            return poruka;
        }
        Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public String izmeniKarton(Karton k) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(k,Operacija.IZMENI_KARTON);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) so.getOdgovor();
            return poruka;
        }
        Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public List<Karton> vratiKartone(Karton kart) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(kart,Operacija.VRATI_ODREDJENE_KARTONE);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if(so.getStatus()==StatusOdgovora.OK){
        List<Karton> lista = new ArrayList<>();
        lista = (List<Karton>) so.getOdgovor();
        return lista;}
         Exception ex = (Exception) so.getGreska();
        throw ex;
    }


    public List<Pregled> vratiPreglede(Pregled pr) throws Exception {
       KlijentskiZahtev kz = new KlijentskiZahtev(pr,Operacija.VRATI_ODREDJENE_PREGLEDE);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if(so.getStatus()==StatusOdgovora.OK){
        List<Pregled> lista = new ArrayList<>();
        lista = (List<Pregled>) so.getOdgovor();
        return lista;}
         Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public String unesiRecept(Recept r) throws Exception {
         System.out.println(r);
        KlijentskiZahtev kz = new KlijentskiZahtev(r,Operacija.UNESI_RECEPT);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) so.getOdgovor();
            return poruka;
        }
        Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public List<Lek> vratiLekove(Lek l) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(l,Operacija.VRATI_ODREDJENE_LEKOVE);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if(so.getStatus()==StatusOdgovora.OK){
        List<Lek> lista = new ArrayList<Lek>();
        lista = (List<Lek>) so.getOdgovor();
        return lista;}
         Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public List<Lek> vratiSveLekove() throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(new Lek(),Operacija.VRATI_SVE_LEKOVE);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            List<Lek> lekovi = new ArrayList<>();
            lekovi = (ArrayList<Lek>) so.getOdgovor();
            System.out.println(lekovi);
            return lekovi;
        }
        Exception ex = (Exception) so.getGreska();
        throw ex;
    }

    public String izmeniPregled(Pregled pr) throws Exception {
        KlijentskiZahtev kz = new KlijentskiZahtev(pr,Operacija.IZMENI_PREGLED);
        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
        System.out.println(kz);
        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
        if (so.getStatus() == StatusOdgovora.OK) {
            String poruka = (String) so.getOdgovor();
            return poruka;
        }
        Exception ex = (Exception) so.getGreska();
        throw ex;
    }

//    public List<Uput> vratiUputeZaKarton(Pregled p) throws Exception {
//        KlijentskiZahtev kz = new KlijentskiZahtev(p,Operacija.VRATI_ODREDJENE_UPUTE);
//        KomunikacijaSaServerom.getInstanca().posaljiZahtev(kz);
//        System.out.println(kz);
//        ServerskiOdgovor so = KomunikacijaSaServerom.getInstanca().primiOdgovor();
//        if(so.getStatus()==StatusOdgovora.OK){
//        List<Uput> lista = new ArrayList<>();
//        lista = (List<Uput>) so.getOdgovor();
//        return lista;}
//         Exception ex = (Exception) so.getGreska();
//        throw ex;
//    }
    
    
    
}
