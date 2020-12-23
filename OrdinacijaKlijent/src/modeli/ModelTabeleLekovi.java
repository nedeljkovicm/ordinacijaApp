/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeli;

import domen.Lek;
import domen.Recept;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author minna
 */
public class ModelTabeleLekovi extends AbstractTableModel{
    
    private List<Lek> lista;
    String[] kolone =new String[]{"Naziv","Koncentracija","Grupa lekova","Namena","Sastav","Kontraindikacije"};

    public ModelTabeleLekovi() {
        lista=new ArrayList<>();
    }

    public ModelTabeleLekovi(List<Lek> lista) {
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
         Lek l=lista.get(rowIndex);
        
        switch(columnIndex){
            case 0: return l.getNaziv();
            case 1: return l.getKoncentracija();
            case 2: return l.getGrupaLekova();
            case 3: return l.getNamena();
            case 4: return l.getSastav();
            case 5: return l.getKontraindikacije();
            default: return "Greska";
        }
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    
    

    public List<Lek> getLista() {
        return lista;
    }

    public void setLista(List<Lek> lista) {
        this.lista = lista;
    }

    public void ubaci(Lek l) {
        if(!lista.contains(l)){
            lista.add(l);
            lista.sort(Comparator.comparing(Lek::getNaziv));

            fireTableDataChanged();
        }
    }
    
}
