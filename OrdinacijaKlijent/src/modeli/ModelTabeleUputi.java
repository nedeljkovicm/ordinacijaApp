/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Uput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author minna
 */
public class ModelTabeleUputi extends AbstractTableModel{
    
    private List<Uput> lista;
    String[] kolone= new String[]{"Tip analize", "Opis"};

    public ModelTabeleUputi() {
        lista= new ArrayList<Uput>();
    }

    public ModelTabeleUputi(List<Uput> lista) {
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
        
        Uput u= lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return u.getTipAnalize();
            case 1: return u.getOpis();
            default: return "Greska";
        }
    }

    @Override
    public String getColumnName(int col) {
        return kolone[col];
    }
    
    

    public List<Uput> getLista() {
        return lista;
    }

    public void setLista(List<Uput> lista) {
        this.lista = lista;
    }

    public void ubaci(Uput u) {
          if(!lista.contains(u)){
        lista.add(u);
       // lista.sort(Comparator.comparing(Uput  :: getTipAnalize));
        fireTableDataChanged();
        }
    }

    public void ubaciUTabelu(Uput u) {
        if(!lista.contains(u)){
            lista.add(u);
            dodeliRB();
        }
        fireTableDataChanged();
//       lista.add(u);
//       lista.sort(Comparator.comparing(Recept::getLek));
//
//       fireTableDataChanged();
    }


    private void dodeliRB() {
        int rb = 1;
        for (Uput u : lista) {
            u.setUputID(rb);
            rb++;
        }
    }
    
}
