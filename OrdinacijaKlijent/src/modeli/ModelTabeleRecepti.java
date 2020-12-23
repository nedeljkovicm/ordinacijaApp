/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Recept;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author minna
 */
public class ModelTabeleRecepti extends AbstractTableModel{
    
    private List<Recept> lista;
    String[] kolone= new String[]{"Lek","Koncentracija","Uputstvo","Lekar"};

    public ModelTabeleRecepti() {
        lista= new ArrayList<>();
    }

    public ModelTabeleRecepti(List<Recept> lista) {
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
        Recept r=lista.get(rowIndex);
        switch(columnIndex){
            case 0: return r.getLek();
            case 1: return r.getLek().getKoncentracija();
            case 2: return r.getUputstvo();
            case 3: return r.getPotpisLekara();
            default: return "Greska";
        }
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    
    

    public List<Recept> getLista() {
        return lista;
    }

    public void setLista(List<Recept> lista) {
        this.lista = lista;
    }
    
    public void ubaciUTabelu(Recept r){
      if(!lista.contains(r)){
        lista.add(r);
       // lista.sort(Comparator.comparing(Recept  :: getLek));
       dodeliRB();
        }
       fireTableDataChanged();
    }

    public void ubaci(Recept r) {
          if(!lista.contains(r)){
        lista.add(r);
       // lista.sort(Comparator.comparing(Recept  :: getLek));
        fireTableDataChanged();
        }
    }

    private void dodeliRB() {
         int rb = 1;
        for (Recept r : lista) {
            r.setSifraRecepta(rb);
            rb++;
        }
    }
}
