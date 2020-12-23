/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Korisnik;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author minna
 */
public class ModelTabeleKorisnici extends AbstractTableModel{
    
    private List<Korisnik> lista;
    String[] kolone=new String[]{"Ime", "Prezime","Korisnicko ime"};

    public ModelTabeleKorisnici() {
        lista= new ArrayList<>();
    }

    public ModelTabeleKorisnici(List<Korisnik> lista) {
        this.lista = lista;
    }
    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
       return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Korisnik k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getIme();
            case 1:
                return k.getPrezime();
            case 2:
                return k.getUsername();
            default:
                return "N/A";

        }
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    
    

    public List<Korisnik> getLista() {
        return lista;
    }

    public void setLista(List<Korisnik> lista) {
        this.lista = lista;
    }

    public void izbaciKorisnika(Korisnik kor) {
        lista.remove(kor);
        fireTableDataChanged();
    }

    public Korisnik izbaciRed(int index) {
        Korisnik k = lista.get(index);
        lista.remove(index);
        fireTableDataChanged();
        return k;
        
    }

    public void dodajKorisnika(Korisnik k) {
       lista.add(k);
        fireTableDataChanged();
    }
    
}
