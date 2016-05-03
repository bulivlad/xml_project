package com.project.xml;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by Costin on 12/23/2014.
 */
public class XMLView {


    public XMLView( ArrayList<Factura> facturi){
        JFrame jFrame=new JFrame("Main");

        jFrame.setSize(600,400);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("data");
        model.addColumn("preTotal");
        model.addColumn("modDePlata");
        model.addColumn("numeAngajat");
        model.addColumn("prenumeAngajat");
        model.addColumn("functie");
        model.addColumn("varsta");
        model.addColumn("Nume produs");
        model.addColumn("Calitate produs");
        model.addColumn("Furnizor produs");
        model.addColumn("Producator produs");
        model.addColumn("Greutate produs");
        model.addColumn("Pret produs");
        model.addColumn("numarProd");

        for(int i = 0 ; i < facturi.size();i++){
            model.addRow(new Object[] { facturi.get(i).getData(), facturi.get(i).getPretTotal() ,facturi.get(i).getModDePlate(),facturi.get(i).getNumeAngajat(),
                                        facturi.get(i).getPrenumeangajat(),facturi.get(i).getFunctieangajat(),facturi.get(i).getVarstaAngajat(),



                                        facturi.get(i).getProduse().get(0).getNumeProdus(),facturi.get(i).getProduse().get(0).getCalitateProdus(),
                    facturi.get(i).getProduse().get(0).getFurnizor(),facturi.get(i).getProduse().get(0).getProducator(),facturi.get(i).getProduse().get(0).getGreutateProdus(),
                    facturi.get(i).getProduse().get(0).getPretProdus(),facturi.get(i).getNumarProduse() });

            if(facturi.get(i).getProduse().size() > 1){
                for(int j = 1 ; j < facturi.get(i).getProduse().size();j++){
                    model.addRow(new Object[] { "", "" ,"","","","","",
                            facturi.get(i).getProduse().get(j).getNumeProdus(),facturi.get(i).getProduse().get(j).getCalitateProdus(),
                            facturi.get(i).getProduse().get(j).getFurnizor(),facturi.get(i).getProduse().get(j).getProducator(),
                            facturi.get(i).getProduse().get(j).getGreutateProdus(),facturi.get(i).getProduse().get(j).getPretProdus() ,"" });

                }
            }
        }




      //  XMLModel model = new XMLModel(facturi);
       // JTable table = new JTable(model);

        jFrame.add(new JScrollPane(table));
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    // adauga elemente in acea fereastra


}
