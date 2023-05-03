package com.bdg.homework_xml_json.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

public class JAXBStudent {
    /**
     * Marshals a Student object to an XML file using JAXB.
     * @param student The Student object to be marshalled.
     * @param path The file path to which the XML data will be written.
     * @throws RuntimeException if there is a JAXBException during marshalling.
     */
    public void marshall(Student student,File path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Marshaller marshall = jaxbContext.createMarshaller();
            marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshall.marshal(student,path);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Marshals a list of StudentWithoutMarks objects to an XML file using JAXB.
     * @param list The list of StudentWithoutMarks objects to be marshalled.
     * @param path The file path to which the XML data will be written.
     * @throws RuntimeException if there is a JAXBException during marshalling.
     */
    public void marshallList(List<StudentWithoutMarks> list,File path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ListStudent.class);
            Marshaller marshall = jaxbContext.createMarshaller();
            marshall.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ListStudent students = new ListStudent();
            students.setStudents(list);
            marshall.marshal(students, path);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Unmarshalls a Student object from an XML file using JAXB.
     * @param path The file path from which the XML data will be read.
     * @return The unmarshalled Student object.
     * @throws RuntimeException if there is a JAXBException during unmarshalling.
     */
    public Student unmarshall(File path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
            Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
            return (Student) unmarshall.unmarshal(path);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Unmarshalls a ListStudent object from an XML file using JAXB.
     * @param path The file path from which the XML data will be read.
     * @return The unmarshalled ListStudent object.
     * @throws RuntimeException if there is a JAXBException during unmarshalling.
     */
    public ListStudent unmarshallList(File path) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ListStudent.class);
            Unmarshaller unmarshall = jaxbContext.createUnmarshaller();
            return (ListStudent) unmarshall.unmarshal(path);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

}
