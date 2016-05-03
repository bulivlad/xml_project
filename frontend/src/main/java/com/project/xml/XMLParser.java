package com.project.xml;

import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLParser {

    public ArrayList<Factura> getFacturi(String filename) {
        ArrayList<Factura> facturi = new ArrayList<Factura>();
        ArrayList<Produs> produse = new ArrayList<Produs>();
        try {

            File fXmlFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("factura");
            int temp1 = 0;
            int beenHere = 0;
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + snNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) nNode;
                    String cod = element.getElementsByTagName("data").item(0).getTextContent();//product_desc
                    int preTotal = Integer.parseInt(element.getElementsByTagName("pretTotal").item(0).getTextContent());
                    String modDePlate = element.getElementsByTagName("modDePlata").item(0).getTextContent();
                    String numeAngajat = element.getElementsByTagName("numeAngajat").item(0).getTextContent();
                    String prenumeAngajat = element.getElementsByTagName("prenumeAngajat").item(0).getTextContent();
                    String functie = element.getElementsByTagName("functie").item(0).getTextContent();
                    int varsta = Integer.parseInt(element.getElementsByTagName("varsta").item(0).getTextContent());

                    int numarProd = Integer.parseInt(element.getElementsByTagName("numarProduse").item(0).getTextContent());//product_desc
                    //calculez produse pentru fiecare factura

                    numarProd = numarProd + temp1;
                    NodeList nList1 = doc.getElementsByTagName("produs");
                    for ( temp1 = ( beenHere == 0 ? 0 : temp1); temp1 < numarProd; temp1++) {

                        Node nNode1 = nList1.item(temp1);
                        beenHere = 1;
                        if (nNode1.getNodeType() == Node.ELEMENT_NODE)
                        {
                            Element element1 = (Element) nNode1;

                            String numeProdus =  element1.getElementsByTagName("nume").item(0).getTextContent();
                            int pretProdus = Integer.parseInt(element1.getElementsByTagName("pret").item(0).getTextContent());
                            String producator =  element1.getElementsByTagName("producator").item(0).getTextContent();
                            String calitate =  element1.getElementsByTagName("calitate").item(0).getTextContent();
                            String greutate =  element1.getElementsByTagName("pret").item(0).getTextContent();
                            String furnizor =  element1.getElementsByTagName("furnizor").item(0).getTextContent();

                            Produs prod = new Produs(numeProdus,pretProdus,calitate,greutate,furnizor,producator);
                            produse.add(prod);
                        }
                    }

                    Factura factura =  new Factura( cod,  preTotal, modDePlate,  numeAngajat, prenumeAngajat,  functie,  varsta,  produse,Integer.parseInt(element.getElementsByTagName("numarProduse").item(0).getTextContent()));
                    facturi.add(factura);
                    produse.clear();





                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return facturi;
    }
}
