//CrewRepository.java
package pairmatching.Domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CrewRepository {
	private static final List<Crew> crews = new ArrayList<>();

	public static void addCrew(Crew crew) {
		crews.add(crew);
	}

	public static List<Crew> getCrews() {
		return crews;
	}

	public static Crew getCrewByName(String name){
		for(Crew crew : crews){
			if(name.equals(crew.getName())){
				return crew;
			}
		}
		return null;
	}

	public static List<String> getCrewNamesByCourse(Course course) {
		List<String> result = new ArrayList<>();
		for (Crew crew : crews) {
			if (crew.getCourse() == course) {
				result.add(crew.getName());
			}
		}
		return result;
	}


	static {
		loadCrews("src/main/resources/backend-crew.md", Course.BACKEND);
		loadCrews("src/main/resources/frontend-crew.md", Course.FRONTEND);
	}

	private static void loadCrews(String fileName, Course course) {
		try {
			File file = new File(fileName);

			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String name = line.trim();

				Crew crew = new Crew(course, name);

				addCrew(crew);
			}

			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
