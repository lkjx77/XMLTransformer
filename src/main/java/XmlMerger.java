import com.ganesh.transformer.FileManager;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Visitor;

/**
 * Created by jizhe on 7/4/2014.
 */
public class XmlMerger {
    public static void main(String[] args) {
        try {
            String sourceXML = FileManager.getStringFromFile("SourceOrder.xml");

            Document document = DocumentHelper.parseText(sourceXML);

            Visitor visitor = new XmlVisitorImpl();
            document.accept(visitor);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
