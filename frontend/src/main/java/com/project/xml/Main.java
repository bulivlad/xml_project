package com.project.xml;

import com.project.xml.service.XmlToHtmlConvertor;
import com.sun.deploy.xml.XMLParser;

import javax.swing.*;
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
    private static DefaultListModel<Factura> model= new DefaultListModel<Factura>();
    public static ArrayList<Factura> facturi = new ArrayList();

    public JTextField jTextField=new JFormattedTextField();
    public static JTextField jTextField1=new JFormattedTextField();
    public static JButton jButton = new JButton("Alege xml");
    public static JButton jButton1 = new JButton("Afisare din xml");
    public static JButton jButton2 = new JButton("Afisare din xsl");
    public static JButton jButton3 = new JButton("Alege xsl");
    public static JList jList1 = new JList();
    public static String savedValue ="";

    //Mainul aplicatie de aici porneste
    public static void main(String[] args) {


        //Creaza fereastra la dimensiunea..
        JFrame jFrame=new JFrame("Main");

        jFrame.setSize(600,400);

        // adauga elemente in acea fereastra

        jFrame.setLayout(new GridLayout(5,1));
        jFrame.add(jTextField1);
        jFrame.add(jButton);jFrame.add(jButton3);
        jFrame.add(jButton1);jFrame.add(jButton2);
        jList1.setModel(model);
        model.clear();
        //buton de browse
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("C:/"));
//                FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                        "XML Files", "xml");
//                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    jTextField1.setText(chooser.getSelectedFile().getPath());
                }
            }
        });
        //salvez html
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File("C:/"));
//                FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                        "XSL Files", "xsl");
//                chooser.setFileFilter(filter);
                int returnVal = chooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION) {
                    savedValue =  chooser.getSelectedFile().getPath() ;
                }
                String filename = chooser.getSelectedFile().getPath().substring(0,chooser.getSelectedFile().getPath().length()-3);

            }
        });

        //buton de parsare xml
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                com.project.xml.XMLParser parser = new com.project.xml.XMLParser();
                facturi = parser.getFacturi(jTextField1.getText());
                new XMLView(facturi);

            }
        });

        //buton de parsare cu xsl
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                GenerateHTML converter = new GenerateHTML();
                XmlToHtmlConvertor convertor = new XmlToHtmlConvertor();
                try {
                    String filename = jTextField1.getText().substring(0,jTextField1.getText().length()-3)+"html";
                    converter.xsl(jTextField1.getText() ,filename, savedValue);
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

        jFrame.setVisible(true);




    }
}
