package sk.stuba.fei.oop;

import sk.stuba.fei.oop.generated.Document;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {

            File file = new File("C:/Users/marti/Desktop/zadanie.xml"); //todo: from file chooser
            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Document document = (Document) jaxbUnmarshaller.unmarshal(file);


            System.out.println(document);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
