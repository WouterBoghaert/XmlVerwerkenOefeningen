package be.vdab;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

class MainPizzas {
	private static final Path PATH = Paths.get("/data/pizzas.xml");
	public static void main(String[] args) {
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		try(Scanner scanner = new Scanner(System.in);
			Writer bufferedWriter = Files.newBufferedWriter(PATH)) {
			XMLStreamWriter writer = factory.createXMLStreamWriter(bufferedWriter);
			try {
				writer.writeStartDocument();
				writer.writeStartElement("pizzas");
				System.out.println("naam:");
				for(String naam; !"stop".equalsIgnoreCase(naam = scanner.next());) {
					writer.writeStartElement("pizza");
					System.out.println("waarde:");
					writer.writeAttribute("prijs", scanner.nextBigDecimal().toString());
					writer.writeStartElement("naam");					
					writer.writeCharacters(naam);
					writer.writeEndElement();
					writer.writeEndElement();
					System.out.println("naam:");
				}
				writer.writeEndElement();
			}
			finally {
				writer.close();
			}
		}
		catch(IOException | XMLStreamException ex) {
			ex.printStackTrace();
		}

	}

}
