package com.project.xml.service;

import com.project.xml.domain.Animal;
import com.project.xml.domain.Food;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XMLParser {

    public ArrayList<Animal> getAnimals(String filename) {
        ArrayList<Animal> animals = new ArrayList<>();

        try {

            File fXmlFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("animal");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) nNode;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String species = element.getElementsByTagName("species").item(0).getTextContent();
                    String gender = element.getElementsByTagName("sex").item(0).getTextContent();
                    String breed = element.getElementsByTagName("breed").item(0).getTextContent();
                    String size = element.getElementsByTagName("type").item(0).getTextContent();
                    String details = element.getElementsByTagName("details").item(0).getTextContent();

                    Animal animal =  new Animal(name, species, gender, breed, size, details);
                    animals.add(animal);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return animals;
    }

    public ArrayList<Food> getFood(String filename) {
        ArrayList<Food> foodList = new ArrayList<>();

        try {

            File fXmlFile = new File(filename);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("food");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) nNode;
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String price = element.getElementsByTagName("price").item(0).getTextContent();
                    if(element.getElementsByTagName("price").item(0).getAttributes().getLength() > 0) {
                        price += " " + element.getElementsByTagName("price").item(0).getAttributes().item(0).getTextContent();
                    }
                    String amount = element.getElementsByTagName("amount").item(0).getTextContent();
                    if(element.getElementsByTagName("amount").item(0).getAttributes().getLength() > 0) {
                        amount += " " + element.getElementsByTagName("amount").item(0).getAttributes().item(0).getTextContent();
                    }
                    String discount = element.getElementsByTagName("discount").item(0).getTextContent();
                    if(element.getElementsByTagName("discount").item(0).getAttributes().getLength() > 0) {
                        if(element.getElementsByTagName("discount").item(0).getAttributes().item(0).getTextContent().equals("percent")) {
                            discount += " %";
                        } else {
                            discount += " " + element.getElementsByTagName("price").item(0).getAttributes().item(0).getTextContent();
                        }
                    }
                    String species = element.getElementsByTagName("species").item(0).getTextContent();

                    Food food = new Food(name, price, amount, discount, species);
                    foodList.add(food);

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return foodList;
    }
}
