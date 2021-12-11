package org.github.zsun.java.puruantraining.javabasics.chapter4;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParseXmlBySax extends DefaultHandler {
    private String tagName;

    public static void main(String[] args) {
        String path = ParseXmlBySax.class.getClassLoader().getResource("books.xml").getPath();
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            ParseXmlBySax myParser = new ParseXmlBySax();
            SAXParser saxParser = parserFactory.newSAXParser();
            saxParser.parse(path, myParser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void endDocument() throws SAXException {
        System.out.println("endDocument");
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        tagName = null;
    }

    public void startDocument() throws SAXException {
        System.out.println("startDocument");
    }

    public void startElement(String uri, String localName, String name,
                             Attributes attributes) throws SAXException {

        if ("book".equals(name)) {
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println("attribute name is: " + attributes.getLocalName(i)
                        + "  attribute value: " + attributes.getValue(i));
            }
        }
        tagName = name;
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        if (this.tagName != null) {
            String val = new String(ch, start, length);

            if ("name".equals(tagName)) {
                System.out.println("name is: " + val);
            }
            if ("price".equals(tagName)) {
                System.out.println("price is: " + val);
            }
            if ("memo".equals(tagName)) {
                System.out.println("memo is: " + val);
            }
        }
    }
}
