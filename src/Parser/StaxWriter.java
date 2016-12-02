package Parser;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by alisa on 02.12.2016.
 */
public class StaxWriter {
    /**
     * The constructor starts parser
     * @param way
     */
    public StaxWriter(String way){
        try {
            staxWrite(way);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parser writes data to the XML file
     * @param way
     * @throws IOException
     * @throws XMLStreamException
     */
    public static void staxWrite(String way) throws IOException, XMLStreamException {
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter(way));
            // root element cndys
            writer.writeStartDocument("1.0");
            writer.writeCharacters("\n");
            writer.writeStartElement("candys");
            writer.writeCharacters("\n");
            // create multiple candys
            for (int i = 0; i < 5; i++) {
                // Write candy
                writer.writeStartElement("candy");
                writer.writeAttribute("id", String.valueOf(i));
                writer.writeCharacters("\n\t");

                // Write all for this candy
                // Name
                writer.writeStartElement("name");
                writer.writeCharacters("Аэрофлотские");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t");
                // Caloric
                writer.writeStartElement("caloric");
                writer.writeCharacters("543");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t");
                // Candy Type
                writer.writeStartElement("candyType");
                writer.writeCharacters("Вафельная");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t");
                // Ingredients
                writer.writeStartElement("ingredients");
                writer.writeCharacters("\n\t\t\t");
                //Ingredients have more ingredient
                //Ingredient-water
                writer.writeStartElement("ingredient");
                writer.writeAttribute("type","water");
                writer.writeCharacters("\n\t\t\t\t");
                writer.writeStartElement("value");
                writer.writeCharacters("300");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t\t");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t");
                //Ingredient-sugar
                writer.writeStartElement("ingredient");
                writer.writeAttribute("type","sugar");
                writer.writeCharacters("\n\t\t\t\t");
                writer.writeStartElement("value");
                writer.writeCharacters("50");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t\t");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t");
                // Ingredient-fructose
                writer.writeStartElement("ingredient");
                writer.writeAttribute("type","fructose");
                writer.writeCharacters("\n\t\t\t\t");
                writer.writeStartElement("value");
                writer.writeCharacters("50");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t\t");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t");
                // Ingredient-type Chocolate
                writer.writeStartElement("ingredient");
                writer.writeAttribute("type","typeChocolate");
                writer.writeCharacters("\n\t\t\t\t");
                writer.writeStartElement("value");
                writer.writeCharacters("Молочный");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t\t");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t");
                //Ingredient-type vanillin
                writer.writeStartElement("ingredient");
                writer.writeAttribute("type","vanillin");
                writer.writeCharacters("\n\t\t\t\t");
                writer.writeStartElement("value");
                writer.writeCharacters("30");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t\t");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t");
                //Close ingredients
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t");
                //Write nutritional
                writer.writeStartElement("nutritional");
                writer.writeCharacters("\n\t\t");
                //Nutritional have their element
                //Proteins
                writer.writeStartElement("proteins");
                writer.writeCharacters("3.9");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t");
                //Fats
                writer.writeStartElement("fats");
                writer.writeCharacters("33.7");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t");
                //Carbohydrates
                writer.writeStartElement("carbohydrates");
                writer.writeCharacters("58.0");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t\t");
                //Close nutritional
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t");
                //Write manufacturer
                writer.writeStartElement("manufacturer");
                writer.writeCharacters("Спартак");
                writer.writeEndElement();
                writer.writeCharacters("\n\t\t");
                // Close Candy
                writer.writeEndElement();
                writer.writeCharacters("\n\t");
            }
            // Close Cadys
            writer.writeEndElement();
            // Close XML
            writer.writeEndDocument();
            writer.flush();
            System.out.println("STAX parser was create XML");
        } catch (XMLStreamException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
