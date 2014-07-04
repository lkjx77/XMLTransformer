import org.dom4j.*;

import java.util.Iterator;
import java.util.List;

/**
 * Created by jizhe on 7/4/2014.
 */
public class XmlVisitorImpl extends VisitorSupport {
    @Override
    public void visit(Document document) {

        Element root = document.getRootElement();
        xpathBuilder(root);


    }

    public void xpathBuilder(Element root){


        // iterate through child elements of root
        for ( Iterator i = root.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            String elmPath = element.getUniquePath(element);

            System.out.println(elmPath);

            xpathBuilder(element);
        }
    }
}
// iterate through child elements of root with element name "foo"
//        for ( Iterator i = root.elementIterator( "foo" ); i.hasNext(); ) {
//            Element foo = (Element) i.next();
//            // do something
//        }
//
//        // iterate through attributes of root
//        for ( Iterator i = root.attributeIterator(); i.hasNext(); ) {
//            Attribute attribute = (Attribute) i.next();
//            // do something
//        }