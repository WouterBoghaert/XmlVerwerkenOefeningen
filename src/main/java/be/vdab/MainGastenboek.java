package be.vdab;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSSerializer;

class MainGastenboek {
	private static final Path PATH = Paths.get("/data/gastenboek.xml");

	public static void main(String args[]) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element element = document.createElement("gastenboek");
			document.appendChild(element);
			try(Scanner scanner = new Scanner(System.in)) {
				System.out.println("Naam?");
				String naam = scanner.nextLine();
				while(!naam.equalsIgnoreCase("stop")) {
					System.out.println("Opmerking?");
					String opmerking = scanner.nextLine();
					Element elementNaam = document.createElement("naam");
					elementNaam.setTextContent(naam);
					Element elementOpmerking = document.createElement("opmerking");
					elementOpmerking.setTextContent(opmerking);
					Element elementEntry = document.createElement("entry");
					elementEntry.appendChild(elementNaam);
					elementEntry.appendChild(elementOpmerking);
					document.getDocumentElement().appendChild(elementEntry);
					System.out.println("Naam? Tijp stop om te stoppen");
					naam = scanner.nextLine();
				}
				DOMImplementationRegistry registry = 
					DOMImplementationRegistry.newInstance();
				DOMImplementationLS implementation = 
					(DOMImplementationLS) registry.getDOMImplementation("LS");
				LSSerializer serializer = implementation.createLSSerializer();
				serializer.getDomConfig().setParameter("format-pretty-print", true);
				LSOutput output = implementation.createLSOutput();
				try(Writer bufferedWriter = Files.newBufferedWriter(PATH)) {
					output.setCharacterStream(bufferedWriter);
					serializer.write(document, output);
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Gastenboek is aangemaakt.");
	}
}
