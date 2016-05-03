package com.project.xml;

import com.project.xml.service.XmlToHtmlConvertor;
import com.project.xml.utils.SanitizeFileName;

/**
 * Created by vbulimac on 03/05/16.
 */
public class Main {

    public static void main(String[] args) {
        XmlToHtmlConvertor convertor = new XmlToHtmlConvertor();

        String xslName = null;
        String xmlName = null;
        String htmlName = null;

        if(args.length > 0 && args.length != 3){
            System.out.println("Invalid number of parameters");
            System.out.println("The parameters should be xsl name, xml name, html name");

            throw new RuntimeException();
        }

        if(args.length == 0){
            System.out.println("No file name was specified. Continue with default file names");
            xslName = SanitizeFileName.sanitizeXslName("default");
            xmlName = SanitizeFileName.sanitizeXmlName("default");
            htmlName = SanitizeFileName.sanitizeHtmlName("default");
        }

        if(args.length == 3){
            xslName = SanitizeFileName.sanitizeXslName(args[0]);
            xmlName = SanitizeFileName.sanitizeXmlName(args[1]);
            htmlName = SanitizeFileName.sanitizeHtmlName(args[2]);
        }

        convertor.setXslName(xslName);
        convertor.setXmlName(xmlName);
        convertor.setHtmlName(htmlName);

        System.out.println("Trying to transform xml " + xmlName);

        convertor.transform();

        System.out.println("xml " + convertor.getXmlName() + " transformation done. Please see " + convertor.getHtmlName());
    }

}
