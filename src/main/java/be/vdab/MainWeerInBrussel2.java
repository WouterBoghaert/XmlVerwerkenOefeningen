package be.vdab;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

class MainWeerInBrussel2 {
	private static final String URL = 
			"http://api.openweathermap.org/data/2.5/weather?q=Brussels&mode=xml&APPID=0230ad3f9a1e2dcd23256b8f8c7858fe&units=metric";

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(URL, new TemperatuurHandler());
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
