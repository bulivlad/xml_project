package com.project.xml.service;

import com.project.xml.utils.TransformerFactory;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by vbulimac on 03/05/16.
 */
public class XmlToHtmlConvertor {

    String xslName;
    String xmlName;
    String htmlName;

    public XmlToHtmlConvertor() {
    }

    public XmlToHtmlConvertor(String xslName, String xmlName, String htmlName) {
        this.xslName = xslName;
        this.xmlName = xmlName;
        this.htmlName = htmlName;
    }

    public void setXslName(String xslName) {
        this.xslName = xslName;
    }

    public void setXmlName(String xmlName) {
        this.xmlName = xmlName;
    }

    public void setHtmlName(String htmlName) {
        this.htmlName = htmlName;
    }

    public String getXslName() {
        return xslName;
    }

    public String getXmlName() {
        return xmlName;
    }

    public String getHtmlName() {
        return htmlName;
    }

    public void transform(){
        javax.xml.transform.TransformerFactory transformerFactory = TransformerFactory.getTransformerFactoryInstance();
        transformerFactory.setAttribute("indent-number", 4);

        try {
            Transformer transformer = transformerFactory.newTransformer(new StreamSource("backend/src/resources/" + xslName));

            transformer.transform(new javax.xml.transform.stream.StreamSource("backend/src/resources/" + xmlName),
                    new javax.xml.transform.stream.StreamResult(new FileOutputStream("backend/src/resources/" + htmlName)));
        } catch (TransformerConfigurationException e) {
            e.getMessage();
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (TransformerException e) {
            e.getMessage();
        }
    }

}
