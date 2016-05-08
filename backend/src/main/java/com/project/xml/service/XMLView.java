package com.project.xml.service;

import com.project.xml.domain.Animal;
import com.project.xml.domain.Food;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * Created by Costin on 12/23/2014.
 */
public class XMLView {


    public XMLView() {

    }

    public XMLView(ArrayList<Animal> animals, Boolean x){
        JFrame jFrame=new JFrame("Main");

        jFrame.setSize(600,400);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("Name");
        model.addColumn("Specie");
        model.addColumn("Gender");
        model.addColumn("Breed");
        model.addColumn("Size");
        model.addColumn("Details");

        for(int i = 0 ; i < animals.size();i++){
            model.addRow(new Object[] { animals.get(i).getName(), animals.get(i).getSpecies() ,animals.get(i).getGender(),
                    animals.get(i).getBreed(), animals.get(i).getSize(), animals.get(i).getDetails()});
        }




      //  XMLModel model = new XMLModel(facturi);
       // JTable table = new JTable(model);

        jFrame.add(new JScrollPane(table));
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public XMLView( ArrayList<Food> food){
        JFrame jFrame=new JFrame("Main");

        jFrame.setSize(600,400);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);

        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Amount");
        model.addColumn("Discount");
        model.addColumn("Species");

        for(int i = 0 ; i < food.size();i++){
            model.addRow(new Object[] { food.get(i).getName(), food.get(i).getPrice() ,food.get(i).getAmount(),
                    food.get(i).getDiscount(), food.get(i).getSpecies()});
        }




        //  XMLModel model = new XMLModel(facturi);
        // JTable table = new JTable(model);

        jFrame.add(new JScrollPane(table));
        jFrame.pack();
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }


}
