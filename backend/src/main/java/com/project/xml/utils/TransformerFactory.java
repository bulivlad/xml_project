package com.project.xml.utils;

/**
 * Created by vbulimac on 03/05/16.
 */
public class TransformerFactory {

    private static volatile javax.xml.transform.TransformerFactory transformerFactory;

    private TransformerFactory() {
        this.transformerFactory = javax.xml.transform.TransformerFactory.newInstance();
    }

    public static javax.xml.transform.TransformerFactory getTransformerFactoryInstance(){
        if(transformerFactory != null) {
            return transformerFactory;
        } else {
            new TransformerFactory();
            return transformerFactory;
        }
    }

}
