package be.vdab;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

class MainWeerInBrussel3 {
	private static final String URL = 
			"http://api.openweathermap.org/data/2.5/weather?q=Brussels&mode=xml&APPID=0230ad3f9a1e2dcd23256b8f8c7858fe&units=metric";
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(URL);
			NodeList nodeList = document.getElementsByTagName("temperature");
			Element element = (Element) nodeList.item(0);
			String temperatuur = element.getAttribute("value");
			if(!temperatuur.isEmpty()) {
				System.out.printf("De temperatuur in Brussel is %s°C",
					temperatuur);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
