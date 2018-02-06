package be.vdab;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class TemperatuurHandler extends DefaultHandler {
	@Override
	public void startElement(String namespaceURI, String sName, String qName,
		Attributes attrs) throws SAXException {
		if("temperature".equals(qName)) {
			System.out.printf("Temperatuur in Brussel: %s°C %n", 
				attrs.getValue("value"));
		}
	}
}
