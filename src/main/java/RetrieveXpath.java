/**
 *
 * This class will be used to retrieve <xpath, value> pairs
 * out of any XML document.
 *
 * Created by jizhe on 7/4/2014.
 */
import java.net.URL;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

public class RetrieveXpath {

    public Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }

    public void foo(Document doc) {

        // lets use the Visitor Pattern to
        // navigate the document for entities

        Visitor visitor = new VisitorSupport() {
            public void visit(Entity entity) {
                System.out.println(
                        "Entity name: " + entity.getName()
                                + " text: " + entity.getText()
                );
            }
        };

        doc.accept( visitor );
    }
}
