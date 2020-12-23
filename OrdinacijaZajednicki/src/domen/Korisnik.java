/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author minoc
 */
public class Korisnik implements Serializable,OpstaDomenskaKlasa{
    
    private int korisnikID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Korisnik() {
    }

    public Korisnik(int korisnikID, String ime, String prezime, String username, String password) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(int korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "dr "+ime+" "+prezime;
    }

    @Override
    public String vratiImeKlase() {
        return "Korisnik";
    }

    @Override
    public String vratiUslovZaJednog() {
       return "Username='" + username + "' and Password='" + password + "'";
    }

    @Override
    public OpstaDomenskaKlasa napuni(ResultSet rs) throws Exception {
       
        if (rs.next()) {
            int korisnikID1 = rs.getInt("KorisnikID");
             String ime1 = rs.getString("Ime");
              String prezime1 = rs.getString("Prezime");
            String username1 = rs.getString("Username");
            String password1 = rs.getString("Password");
           
            return new Korisnik(korisnikID1, ime1, prezime1, username1, password1);

        }
        
        throw new Exception("Uneli ste pogresne podatke, nema korisnika sa ovim podacima!");
    }

    @Override
    public List<OpstaDomenskaKlasa> napuniListu(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String postaviVrednostiAtributa() {
         return "KorisnikID=" + korisnikID + ", " + "Ime=" + "'" + ime + "', " + "Prezime='" + prezime + "', " + "Username='" + username + "Password='" + password +"'";
    }

    @Override
    public String vratiVrednostiAtributa() {
        return korisnikID + ", " + (username == null ? null : "'" + username + "'") + ", " + (password == null ? null : "'" + password + "'") + ", " + (ime == null ? null : "'" + ime + "'")+ ", " + (prezime == null ? null : "'" + prezime + "'");

    }

    @Override
    public String vratiNazivKolone(int kolona) {
       String[] kolone = {"KorisnikID", "Ime", "Prezime", "Username", "Password"};
        return kolone[kolona];
    }

    @Override
    public String vratiUslovZaVise() {
        return "Username='" + username + "' and Password='" + password + "'";
    }

    @Override
    public String vratiSortiranje() {
        return OpstaDomenskaKlasa.super.vratiSortiranje(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSpajanje() {
        return OpstaDomenskaKlasa.super.vratiSpajanje(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        return true;
    }
    
    
}
