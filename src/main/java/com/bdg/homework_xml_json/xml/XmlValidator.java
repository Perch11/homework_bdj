package com.bdg.homework_xml_json.xml;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class XmlValidator {
    /**
     * Validates an XML file against an XSD schema.
     * @param xmlFile the XML file to validate
     * @param xsdFile the XSD file to validate against
     * @return true if validation passes, false otherwise
     * @throws NullPointerException if either xmlFile or xsdFile is null
     * @throws RuntimeException if an error occurs while validating
     */
    public static boolean validate(File xmlFile, File xsdFile) {

        Objects.requireNonNull(xmlFile, "xmlFile must not be null");
        Objects.requireNonNull(xsdFile, "xsdFile must not be null");

        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsdFile);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFile));
            return true;
        } catch (SAXException e) {
            String message = "XML document is not valid against XSD: " + e.getMessage();
            throw new RuntimeException(message, e);
        } catch (IOException e) {
            String message = "Error occurred while reading file: " + e.getMessage();
            throw new RuntimeException(message, e);
        }
    }
}
