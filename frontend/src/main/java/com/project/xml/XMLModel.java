package com.project.xml;

import javax.swing.table.AbstractTableModel;
import java.awt.List;
import java.util.*;

/**
 * Created by Costin on 12/23/2014.
 */
public class XMLModel extends AbstractTableModel {
    private java.util.List<Factura> facturi;

    public XMLModel(java.util.List<Factura> facturi) {

        this.facturi = new ArrayList<>(facturi);
    }


    @Override
    public int getRowCount() {
        return facturi.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }
    @Override
    public String getColumnName(int column) {
        String name = "??";

        switch (column) {
            case 0:
                name = "data";
                break;
            case 1:
                name = "preTotal";
                break;
            case 2:
                name = "modDePlate";
                break;
            case 3:
                name = "numeAngajat";
                break;
            case 4:
                name = "prenumeAngajat";
                break;
            case 5:
                name = "functie";
                break;
            case 6:
                name = "varsta";
                break;
            case 7:
                name = "produse";
                break;
            case 8:
                name = "numarProd";
                break;

        }
        return name;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class type = String.class;
        switch (columnIndex) {
            case 0:
            case 1:
                type = Integer.class;
                break;
        }
        return type;
    }
    int varib = 0;

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Factura factura = facturi.get(varib);
        Object value = null;
        String v = "";
        ArrayList<Integer> numberofProd = new ArrayList<>();
        for(int i = 0 ; i < facturi.size();i++){
            numberofProd.add(facturi.get(i).getProduse().size());
        }


        switch (columnIndex) {
            case 0:
                value = factura.getData();
                break;
            case 1:
                value = factura.getPretTotal();
                break;
            case 2:
                value = factura.getModDePlate();
                break;
            case 3:
                value = factura.getNumeAngajat();
                break;
            case 4:
                value = factura.getPrenumeangajat();
                break;
            case 5:
                value = factura.getFunctieangajat();
                break;
            case 6:
                value = factura.getVarstaAngajat();
                break;
            case 7:
                for(int i =0;i < factura.getProduse().size() ;i++){
                    v+= factura.getProduse().get(i).getNumeProdus() + "|\n";
                }
                value =  v;
                break;
            case 8:

                value = factura.getNumarProduse();
                break;

        }

        return value;
    }
}
