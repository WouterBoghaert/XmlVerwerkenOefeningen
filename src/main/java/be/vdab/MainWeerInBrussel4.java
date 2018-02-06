package be.vdab;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;

class MainWeerInBrussel4 {
	private static final String URL = 
		"http://api.openweathermap.org/data/2.5/weather?q=Brussels&mode=xml&APPID=0230ad3f9a1e2dcd23256b8f8c7858fe&units=metric";
	private static final String XPATH_EXPR = "//temperature/@value";
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(URL);
			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath xPath = xPathFactory.newXPath();
			String value = xPath.evaluate(XPATH_EXPR, document);
			if(value.isEmpty()) {
				System.out.println("Temperatuur niet gevonden");
			}
			else {
				System.out.printf("Temperatuur in Brussel: %s°C%n", value);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
