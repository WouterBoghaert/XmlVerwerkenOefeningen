package be.vdab;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

class MainWeerInBrussel {
	private static final String URL = 
		"http://api.openweathermap.org/data/2.5/weather?q=Brussels&mode=xml&APPID=0230ad3f9a1e2dcd23256b8f8c7858fe&units=metric";
	public static void main(String[] args) {
		XMLInputFactory factory = XMLInputFactory.newInstance();
		try(InputStream stream = new URL(URL).openStream();
			InputStream bufferedStream = new BufferedInputStream(stream)) {
			XMLStreamReader reader = null;
			try {
				reader = factory.createXMLStreamReader(bufferedStream);
				while(reader.hasNext()) {
					if(reader.next() == XMLStreamConstants.START_ELEMENT
						&& "temperature".equals(reader.getLocalName())) {
						System.out.printf("Temperatuur in Brussel: %s%n", 
							reader.getAttributeValue(null, "value"));
						break;
					}
				}
			}
			finally {
				if(reader != null) {
					try {
						reader.close();
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
