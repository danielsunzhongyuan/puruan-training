package org.github.zsun.java.puruan_training.java_basics.chapter4;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.net.URL;

public class ParseXmlByDom {
    public static void main(String[] args) {
        DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
        URL resource = ParseXmlByDom.class.getClassLoader().getResource("books.xml");
        String path = resource.getPath();

        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            DocumentBuilder documentBuilder = domFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(fileInputStream);
            Element root = document.getDocumentElement();
            NodeList books = root.getChildNodes();
            for (int i = 0, bookCount = books.getLength(); i < bookCount; i++) {
                Node book = books.item(i);
                if (book.getNodeType() ==  Node.ELEMENT_NODE) {
                    String id = book.getAttributes().getNamedItem("id").getNodeValue();
                    System.out.println("id is : " + id);
                    for (Node node = book.getFirstChild(); node != null; node = node.getNextSibling()) {
                        if (node.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println(node.getNodeName() + " is: " + node.getFirstChild().getNodeValue());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
