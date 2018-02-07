package be.vdab;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import be.vdab.entities.Boek;
import be.vdab.entities.Boeken;
import be.vdab.entities.Curriculum;

class MainBoeken {
	private final static Path PATH = Paths.get("/data/boeken.xml");
	
	public static void main(String[] args) {
		try(Reader reader = Files.newBufferedReader(PATH)) {
			JAXBContext context = JAXBContext.newInstance(Boeken.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Boeken boeken = (Boeken) unmarshaller.unmarshal(reader);
			for(Boek boek : boeken.getBoek()) {
				System.out.printf("%s%n", boek.getTitel());
				for(Curriculum curriculum : boek.getCurriculums().getCurriculum()) {
					System.out.printf("\t%s%n", curriculum.getNaam());
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
