package org.jdom2.example;

import com.ganesh.transformer.FileManager;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPath;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;
import org.jdom2.xpath.XPathHelper;
import org.xml.sax.InputSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by jizhe on 7/4/2014.
 */
public class XmlPerger {
    public static void main(String[] args) {

        try {
            String sourceXML = FileManager.getStringFromFile("SourceOrder.xml");
            InputSource inputSource = new InputSource(new ByteArrayInputStream(sourceXML.getBytes("utf-8")));

            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputSource);

            Element element = document.getRootElement();

            for(Element elm: element.getChildren()){
               System.out.println(XPathHelper.getAbsolutePath(elm));

                for(Element child: elm.getChildren()){
                    for(Attribute attr: child.getAttributes()) {
                        System.out.println("attr:" + XPathHelper.getAbsolutePath(attr));
                        System.out.println(XPathHelper.getAbsolutePath(child));

                    }
//                    System.out.println(XPathHelper.getAbsolutePath(child));

                }
            }


//            XPathFactory xpathFactory = XPathFactory.instance();
//            String titelTextPath = "root/deep/tag/other/text()";
//            XPathExpression<Object> expr = xpathFactory.compile(titelTextPath);
//            List<Object> xPathSearchedNodes = expr.evaluate(document);
//            for (int i = 0; i < xPathSearchedNodes.size(); i++) {
//                Content content = (Content) xPathSearchedNodes.get(i);
//            }

        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
