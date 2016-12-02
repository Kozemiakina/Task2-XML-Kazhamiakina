package Validator; /**
 * Created by alisa on 01.12.2016.
 */
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
public class Valid {
    /**
     * The constructor starts to check the XML file
     * @param filename
     * @param schemaName
     */
    public Valid(String filename,String schemaName){
        validXML(filename,schemaName);
    }

    /**
     * Metods check the XML file
     * @param filename
     * @param schemaName
     */
    public static void validXML(String filename,String schemaName) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {
            Schema schema = factory.newSchema(schemaLocation);  //crate validator from shema
            Validator validator = schema.newValidator();       // check XML
             Source source = new StreamSource(filename);
            validator.validate(source);
            System.out.println(filename + " is Validator.valid.");
        } catch (SAXException e) {
            System.err.print("validation "+ filename + " is not Validator.valid because "       + e.getMessage());
        } catch (IOException e) {
            System.err.print(filename + " is not Validator.valid because "       + e.getMessage()); }
    }
}