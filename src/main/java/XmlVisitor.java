import org.dom4j.Document;
import org.dom4j.Visitor;

/**
 * Created by jizhe on 7/4/2014.
 */
public interface XmlVisitor extends Visitor {
    public void visit(Document doc);
}
