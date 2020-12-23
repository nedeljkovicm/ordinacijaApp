/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Pregled;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author minoc
 */
public class ModelTabelePregledi extends AbstractTableModel{
    
    private List<Pregled> lista;
    String[] kolone= new String[]{"Vreme", "Ime i prezime pacijenta","Poslednji pregled","Dijagnoza","Kontakt"};
    String[] koloneSvi= new String[]{"Zakazani datum ", "Vreme", " Ime i prezime pacijenta","Poslednji pregled","Dijagnoza","Kontakt"};
    private boolean svi=false;

    public ModelTabelePregledi() {
        lista= new ArrayList<>();
    }

    public ModelTabelePregledi(ArrayList<Pregled> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        if(svi){
        return koloneSvi.length;
        }
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Pregled p=lista.get(rowIndex);
        
            if(svi){
                switch(columnIndex){
                    case 0: return p.getDatum();
                    case 1: return p.getVreme();
                    case 2: return p.getKarton().getIme()+" "+p.getKarton().getPrezime();
                    case 3: return p.getKarton().getPoslednjiPregled();
                    case 4: return p.getKarton().getDijagnoza();
                    case 5: return p.getKarton().getKontaktTelefon();
//                    case 5:
//                       Timestamp ts= new Timestamp(p.getDatum().getTime());
//                       return ts;
                    default: return "err";
        
                }
            }
        
        switch(columnIndex){
            case 0: return p.getVreme();
            case 1: return p.getKarton().getIme()+" "+p.getKarton().getPrezime();
            case 2: return p.getKarton().getPoslednjiPregled();
            case 3: return p.getKarton().getDijagnoza();
            case 4: return p.getKarton().getKontaktTelefon();
//            case 5:
//                Timestamp ts= new Timestamp(p.getDatum().getTime());
//                return ts;
            default: return "err";
        
        }
    }

    @Override
    public String getColumnName(int column) {
        if(svi){
        return koloneSvi[column];
        }
        return kolone[column];
    }

    
    public List<Pregled> getLista() {
        return lista;
    }

    public void setLista(List<Pregled> lista) {
        this.lista = lista;
    }

    public void ubaci(Pregled p) {
         if (!lista.contains(p) && p != null) {
            lista.add(p);
           // lista.sort(Comparator.comparing(Pregled :: getDatum));

            fireTableDataChanged();

        }
    }

    public void setSvi(boolean svi) {
        this.svi = svi;
    }
    
   
    
}
