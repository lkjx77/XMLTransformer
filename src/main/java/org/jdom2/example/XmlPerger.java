package org.jdom2.example;

import com.ganesh.transformer.FileManager;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPath;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.xpath.XPathHelper;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by jizhe on 7/4/2014.
 */
public class XmlPerger {
    public static void main(String[] args) throws Exception {

        try {
            String sourceXML = FileManager.getStringFromFile("User1.xml");
            InputSource inputSource = new InputSource(new ByteArrayInputStream(sourceXML.getBytes("utf-8")));
            InputSource inputSource2 = new InputSource(new ByteArrayInputStream(sourceXML.getBytes("utf-8")));
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputSource);

            org.w3c.dom.Document sourceDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputSource2);

            Element element = document.getRootElement();

            XpathMapping xm = new XpathMapping();

            Map<String, String> xpathMapping = new HashMap();
            xm.createXpathMapping(element, xpathMapping);

            XPathFactory xpfac = XPathFactory.instance();

            for(Entry<String, String> entry: xpathMapping.entrySet()){
                String targetXpath = entry.getKey();

                try {
                    javax.xml.xpath.XPath xpath = javax.xml.xpath.XPathFactory.newInstance().newXPath();
                    javax.xml.xpath.XPathExpression expression = xpath.compile(targetXpath);
                    String value = expression.evaluate(sourceDoc);
                    System.out.println("xpath:" + targetXpath + " = " + value);

                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                }

//                try {
//                    XPathExpression xp = xpfac.compile(targetXpath);
//                    String value = xp.evaluate(document);
//                    System.out.println("my value:" + value);
//
//                } catch (XPathExpressionException e) {
//                    e.printStackTrace();
//                }
//                XPathExpression xp = xpfac.compile(targetXpath, Filters.element());

//                List<Element> elmList = xp.evaluate(document);
//                for (Element e : elmList) {
//                    System.out.println(targetXpath);
//                    System.out.println("value=" + e.getValue());
//                }
//
//
//
//                xp = xpfac.compile(targetXpath, Filters.attribute());
//                List<Attribute> attrList = xp.evaluate(document);
//                for (Attribute att : attrList) {
//                    System.out.println("We have target " + att.getValue());
//                }

//                System.out.println(targetXpath);
            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
