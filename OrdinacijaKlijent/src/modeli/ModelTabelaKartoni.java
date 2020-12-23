/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Karton;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author minna
 */
public class ModelTabelaKartoni extends AbstractTableModel{
    
    private List<Karton> lista;
    String[] kolone={"Prezime","Ime","JMBG","Prvi pregled","Poslednji pregled","Dijagnoza"};

   
    public ModelTabelaKartoni() {
        lista= new ArrayList<Karton>();
    }

    public ModelTabelaKartoni(List<Karton> lista) {
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
        Karton k=lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return k.getPrezime();
            case 1: return k.getIme();
            case 2: return k.getJMBG();
            case 3: return k.getPrviPregled();
            case 4: return k.getPoslednjiPregled();
            case 5: return k.getDijagnoza();
            default: return "Greska";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column]; 
    }
    
    public List<Karton> getLista() {
        return lista;
    }

    public void setLista(List<Karton> lista) {
        this.lista = lista;
    }

    public void ubaci(Karton k) {
         if(!lista.contains(k)){
        lista.add(k);
        lista.sort(Comparator.comparing(Karton  :: getPrezime));
        fireTableDataChanged();
        }
    }
    
}
