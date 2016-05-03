package com.project.xml.utils;

/**
 * Created by vbulimac on 03/05/16.
 */
public class SanitizeFileName {

    public static String sanitizeXslName(String xslName){
        if(xslName.endsWith(".xsl")){
            return xslName;
        }
        return xslName.concat(".xsl");
    }

    public static String sanitizeXmlName(String xmlName){
        if(xmlName.endsWith(".xml")){
            return xmlName;
        }
        return xmlName.concat(".xml");
    }

    public static String sanitizeHtmlName(String htmlName){
        if(htmlName.endsWith(".html")){
            return htmlName;
        }
        return htmlName.concat(".html");
    }

}
