package MarshalUnmarshal;

import Candypackage.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alisa on 01.12.2016.
 * This class are converted into XML from Java objects
 */
public class Marshalling {
    private static JAXBContext jaxbContext; //provides the client's entry point to the JAXB API

    /**
     * Method create XML document and write from java-class into XML
     */
    public static void murchal() {
        try {
            jaxbContext = JAXBContext.newInstance(Candys.class);
            Marshaller m = jaxbContext.createMarshaller();
            Candys candys = new Candys();

            List<IngredientType> ingredientType = new ArrayList<IngredientType>();
            IngredientType ingredientType1 = new IngredientType();
            ingredientType1.setType(CandyIngredients.WATER);
            ingredientType1.setValue("300");
            IngredientType ingredientType2 = new IngredientType();
            ingredientType.add(ingredientType1);
            ingredientType2.setType(CandyIngredients.SUGAR);
            ingredientType2.setValue("50");
            ingredientType.add(ingredientType2);
            IngredientType ingredientType3 = new IngredientType();
            ingredientType3.setType(CandyIngredients.FRUCTOSE);
            ingredientType3.setValue("50");
            ingredientType.add(ingredientType3);
            IngredientType ingredientType4 = new IngredientType();
            ingredientType4.setType(CandyIngredients.TYPE_CHOCOLATE);
            ingredientType4.setValue("Молочный");
            ingredientType.add(ingredientType4);
            IngredientType ingredientType5 = new IngredientType();
            ingredientType5.setType(CandyIngredients.VANILLIN);
            ingredientType5.setValue("30");
            ingredientType.add(ingredientType5);

            Nutritional nutritional = new Nutritional();
            nutritional.setProteins(3.9);
            nutritional.setFats(33.7);
            nutritional.setCarbohydrates(58.0);

            Ingredients ingredients = new Ingredients();
            ingredients.setIngredient(ingredientType);
            List<CandyType> candyType = new ArrayList<CandyType>();
            CandyType candyType1 = new CandyType();
            candyType1.setId(BigInteger.valueOf(1));
            candyType1.setName("Аэрофлотские");
            candyType1.setCaloric(543);
            candyType1.setCandyType("Вафельная");
            candyType1.setIngredients(ingredients);
            candyType1.setNutritional(nutritional);
            candyType1.setManufacturer("Спартак");
            candyType.add(candyType1);

            candys.setCandy(candyType);

            m.marshal(candys, new FileOutputStream("xml/candy_marsh.xml"));
            System.out.println("\n XML-file is created");
            m.marshal(candys, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("\n XML-file can not be created: " + e);
        } catch (JAXBException e) {
            System.out.println("\n JAXB-wrong context " + e);
        }
    }
    /**
     * Method instance of the class Candys and write from XML  into java-class
     */
    public static void unMarchal() {
        try {
            FileReader reader = new FileReader("xml/Candy.xml");
            jaxbContext = JAXBContext.newInstance(Candys.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Candys candys = (Candys) jaxbUnmarshaller.unmarshal(reader);
            System.out.println("\n Instance of the class Candys is created");
            System.out.println(candys);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
