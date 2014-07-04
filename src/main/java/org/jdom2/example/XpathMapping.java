package org.jdom2.example;

import org.jdom2.Attribute;
import org.jdom2.Element;
import org.jdom2.Content;
import org.jdom2.xpath.XPathHelper;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by jizhe on 7/4/2014.
 */
public class XpathMapping {

    public void createXpathMapping(Element root, Map<String, String> xpathMapping){

        String defaultVal = "";
        // Fill up a hash map with unique xpath expression and the value(default="none")


        xpathMapping.put(XPathHelper.getAbsolutePath(root), defaultVal);


//        System.out.println(XPathHelper.getAbsolutePath(root));
        // iterate through child elements of root
        for(Element elm: root.getChildren()){
//            System.out.println(XPathHelper.getAbsolutePath(elm));

            xpathMapping.put(XPathHelper.getAbsolutePath(elm), defaultVal);

            for(Attribute attr: elm.getAttributes()) {
//                System.out.println("attr:" + XPathHelper.getAbsolutePath(attr));

                xpathMapping.put(XPathHelper.getAbsolutePath(attr), defaultVal);
            }
            // recursive call to iterate whole elements
            createXpathMapping(elm, xpathMapping);
        }
    }
}
