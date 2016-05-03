package com.project.xml;

import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Costin on 12/24/2014.
 */
public class GenerateHTML {

    public void xsl(String inputFilename, String outputFilename, String xslFilename) throws Exception {
        TransformerFactory factory = TransformerFactory.newInstance();
        Templates template = factory.newTemplates(new StreamSource(new FileInputStream(xslFilename)));
        Transformer xformer = template.newTransformer();
        Source source = new StreamSource(new FileInputStream(inputFilename));
        Result result = new StreamResult(new FileOutputStream(outputFilename));
        xformer.transform(source, result);
    }
}