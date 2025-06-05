package utils;

import com.microsoft.playwright.Page;
import io.qameta.allure.Allure;
import utils.driver.PlaywrightDriver;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class AllureFunctions {

    public static void saveScreenshot() {
        Page page = PlaywrightDriver.getPage();
        byte[] screenshot = page.screenshot();
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
    }

    public static void saveFileTXT(String nameFile, String document) {
        Allure.addAttachment(nameFile, "text/plain", document);
    }

    public static void allureEnvironmentWriter(Map<String, String> environmentValuesSet, String customResultsPath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element environment = doc.createElement("environment");
            doc.appendChild(environment);
            for (Map.Entry<String, String> entry : environmentValuesSet.entrySet()) {
                Element parameter = doc.createElement("parameter");
                Element key = doc.createElement("key");
                Element value = doc.createElement("value");
                key.appendChild(doc.createTextNode(entry.getKey()));
                value.appendChild(doc.createTextNode(entry.getValue()));
                parameter.appendChild(key);
                parameter.appendChild(value);
                environment.appendChild(parameter);
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            File allureResultsDir = new File(customResultsPath);
            if (!allureResultsDir.exists()) allureResultsDir.mkdirs();
            StreamResult result = new StreamResult(
                    new File(customResultsPath + "/environment.xml"));
            transformer.transform(source, result);
            System.out.println("Allure environment data saved.");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    @Deprecated
    public static void addDescription(String description) {
        // Deprecated: implement if needed or remove
    }

    public static void createCategoriesReport() {
        String json = "[{ \"name\": \"Testes Ignorados\", \"matchedStatuses\": [\"skipped\"]}," +
                "{ \"name\": \"Problemas de Infraestrutura\", \"matchedStatuses\": [\"broken\", \"failed\"], \"messageRegex\": \".*bye-bye.*\"}," +
                "{ \"name\": \"Teste Desatualizado\", \"matchedStatuses\": [\"broken\"], \"traceRegex\": \".*FileNotFoundException.*\"}," +
                "{ \"name\": \"Defeito de Produto\", \"matchedStatuses\": [\"failed\"]}," +
                "{ \"name\": \"Defeito de Teste\", \"matchedStatuses\": [\"broken\"]}]";
        try {
            FileWriter file = new FileWriter("target/allure-results/categories.json");
            file.write(json);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}