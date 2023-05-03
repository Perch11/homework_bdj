package com.bdg.homework_xml_json;


import com.bdg.homework_xml_json.xml.XmlValidator;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File xml = new File("src/main/resources/xml/students.xml");
        File xsd = new File("src/main/resources/xml/students.xsd");
        System.out.println(XmlValidator.validate(xml, xsd));
    }
}
