package xyz.vimtool.chapter18.section13;


import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

/**
 * 序列化到xml
 *
 * @author zhangzheng
 * @version 1.0
 * @since jdk1.8
 * @date 2018-2-8
 */
public class Person {

    private String first, last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    /**
     * Produce an XML Element from this Person Object:
     */
    public Element getXML() {
        Element person = new Element("person");

        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);

        person.appendChild(firstName);
        person.appendChild(lastName);
        return person;
    }

    /**
     * Constructor to restore a Person from an XML Element
     */
    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
    }

    @Override
    public String toString() {
        return first + " " + last;
    }

    /**
     * Make it human-readable
     */
    public static void format(OutputStream out, Document doc) throws Exception {
        Serializer serializer = new Serializer(out, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    public static void main(String[] args) throws Exception {
        List<Person> people = Arrays.asList(new Person("Dr. Bunsen", "Honeydew"),
                new Person("Gonzo", "The Great"), new Person("Phillip J.", "Fry"));
        System.out.println(people);
        //构建xml最外层
        Element root = new Element("people");
        for (Person person : people) {
            root.appendChild(person.getXML());
        }
        Document doc = new Document(root);
        format(System.out, doc);
        format(new BufferedOutputStream(new FileOutputStream("People.xml")), doc);
    }
}
