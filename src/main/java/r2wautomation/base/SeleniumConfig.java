package r2wautomation.base;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class SeleniumConfig {
    private static SeleniumConfig instance;

    // Public method to get the single instance of the class
    public static SeleniumConfig getInstance() {
        if (instance == null) {
            instance = new SeleniumConfig();
        }
        return instance;
    }

    // Read configuration from XML file
    public static String configFile = "src/main/resources/selenium-config.xml";
    public String getEnvironmentURL() {
        return getConfigValue(configFile, "environmentURL");
    }
    public String getEnvironmentName() {
        return getConfigValue(configFile, "environmentName");
    }
    public String getBrowserName() {
        return getConfigValue(configFile, "browserName");
    }
    public String getTimeout() {
        return getConfigValue(configFile, "timeout");
    }
    public String getReportName() {
        return getConfigValue(configFile, "reportName");
    }
    public String getHeadlessDriver() {
        return getConfigValue(configFile, "headlessDriver");
    }
    private static String getConfigValue(String configFile, String propertyName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(configFile));

            return document.getElementsByTagName(propertyName).item(0).getTextContent();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
