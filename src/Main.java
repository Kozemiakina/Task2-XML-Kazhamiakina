/**
 * Created by alisa on 02.12.2016.
 * This class starts validator, marshaling, unmarshaling, parser
 */
import MarshalUnmarshal.Marshalling;
import Parser.StaxWriter;
import Validator.Valid;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {
    public static void main(String[ ] args) throws IOException, XMLStreamException {
        Valid valid=new Valid("xml/Candy.xml","xml/Candy.xsd");//pass on the way to the XML and its schema
        Marshalling marshalling=new Marshalling();
        marshalling.murchal();
        marshalling.unMarchal();
        StaxWriter staxWriter=new StaxWriter("xml/staxCandy.xml");//pass the name of the the future file XML
    }
}