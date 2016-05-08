package com.project.xml;

import com.project.xml.domain.Animal;
import com.project.xml.domain.Food;
import com.project.xml.service.XMLParser;
import com.project.xml.service.XMLView;
import com.project.xml.service.XmlToHtmlConvertor;
import com.project.xml.utils.SanitizeFileName;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by vbulimac on 03/05/16.
 */
public class Main {

    //  static Connection con;
    // static  Statement s;
    private static DefaultListModel<Animal> modelAnimal= new DefaultListModel<>();
    private static DefaultListModel<Food> modelFood= new DefaultListModel<>();
    public static ArrayList<Animal> animals = new ArrayList();
    public static ArrayList<Food> food= new ArrayList();

    public static JTextField jTextFieldXmlPath=new JFormattedTextField();
    public static JTextField jTextFieldXslPath=new JFormattedTextField();
    public static JButton jButton = new JButton("Alege xml");
    public static JButton jButton1 = new JButton("Afisare din xml");
    public static JButton jButton2 = new JButton("Afisare din xsl");
    public static JButton jButton3 = new JButton("Alege xsl");
    public static JList jListAnimal = new JList();
    public static JList jListFood = new JList();
    public static String savedValue ="";

    public static String xmlFilename;
    public static String xslFilename;
    public static String htmlFilename;

    //Mainul aplicatie de aici porneste
    public static void main(String[] args) {


        //Creaza fereastra la dimensiunea..
        JFrame jFrame=new JFrame("Main");

        jFrame.setSize(600,400);
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(),BoxLayout.Y_AXIS));


        // adauga elemente in acea fereastra

        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.Y_AXIS));



        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new JLabel("Path to XML"));
        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        BoundedRangeModel brm = jTextFieldXmlPath.getHorizontalVisibility();
        scrollBar.setModel(brm);
        panel.add(jTextFieldXmlPath);
        panel.add(scrollBar);

        panel.add(new JLabel("Path to XSLR"));
        JScrollBar scrollBar1 = new JScrollBar(JScrollBar.HORIZONTAL);
        BoundedRangeModel brm1 = jTextFieldXslPath.getHorizontalVisibility();
        scrollBar1.setModel(brm1);
        panel.add(jTextFieldXslPath);
        panel.add(scrollBar1);
        parentPanel.add(panel);

        parentPanel.add(panel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,1));
        buttonPanel.setSize(600,400);

        buttonPanel.add(jButton);buttonPanel.add(jButton3);
        buttonPanel.add(jButton1);buttonPanel.add(jButton2);

        parentPanel.add(buttonPanel);

        jListAnimal.setModel(modelAnimal);
        modelAnimal.clear();

        jListFood.setModel(modelFood);
        modelFood.clear();

        //buton de browse
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Choose xml file");
                chooser.setFileFilter(new FileNameExtensionFilter("XML", "xml"));
                chooser.setCurrentDirectory(new File("/Users/vladbulimac/projects/xml_project"));
                chooser.setAutoscrolls(true);

                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    jTextFieldXmlPath.setText(chooser.getSelectedFile().getPath());
                    xmlFilename = chooser.getSelectedFile().getPath().substring(0,chooser.getSelectedFile().getPath().length()-4);
                }
            }
        });
        //browse xsl
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Choose xsl file");
                chooser.setFileFilter(new FileNameExtensionFilter("XSL", "xsl"));
                chooser.setCurrentDirectory(new File("/Users/vladbulimac/projects/xml_project"));

                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    savedValue = chooser.getSelectedFile().getPath();
                    jTextFieldXslPath.setText(chooser.getSelectedFile().getPath());
                    xslFilename = chooser.getSelectedFile().getPath().substring(0,chooser.getSelectedFile().getPath().length()-4);
                }

            }
        });

        //buton de parsare xml
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                XMLParser parser = new XMLParser();
                animals = parser.getAnimals(jTextFieldXmlPath.getText());
                food = parser.getFood(jTextFieldXmlPath.getText());
                new XMLView(animals, true);
                new XMLView(food);

            }
        });

        //buton de parsare cu xsl
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                XmlToHtmlConvertor convertor = new XmlToHtmlConvertor();
                try {
                    String filename = jTextFieldXslPath.getText().substring(0,jTextFieldXslPath.getText().length()-3)+"html";
                    convertor.setXslName(SanitizeFileName.sanitizeXslName(xslFilename));
                    convertor.setXmlName(SanitizeFileName.sanitizeXmlName(xmlFilename));
                    if(xmlFilename.endsWith(".xml")){
                        htmlFilename = xmlFilename.substring(0, xmlFilename.length() - 4);
                    } else {
                        htmlFilename = xmlFilename;
                    }
                    convertor.setHtmlName(SanitizeFileName.sanitizeHtmlName(htmlFilename));
                    convertor.transform();
                    Object[] options = { "OK" };
                    JOptionPane.showOptionDialog(null, "Generarea HTML a reusit!", "Succes",

                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,null, options, options[0]);
                } catch (Exception ex) {
                    System.out.println(ex.toString());
                    JOptionPane.showMessageDialog(null, "Generarea HTML a esuat. Verificati ca fisierele XML si XSL exista si sunt valide","Eroare!",JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        //seteaza fereastra vizibila


        jFrame.add(parentPanel);
        jFrame.setVisible(true);


    }
}
