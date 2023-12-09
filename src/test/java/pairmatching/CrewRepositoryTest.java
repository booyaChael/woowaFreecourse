package pairmatching;

import org.junit.jupiter.api.Test;
import pairmatching.Domain.Course;
import pairmatching.Domain.Crew;
import pairmatching.Domain.CrewRepository;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CrewRepositoryTest {

	@Test
	void testGetCrewByName() {
		CrewRepository.addCrew(new Crew(Course.BACKEND, "앨리"));
		CrewRepository.addCrew(new Crew(Course.FRONTEND, "은하"));

		Crew backendCrew = CrewRepository.getCrewByName("앨리");
		Crew frontendCrew = CrewRepository.getCrewByName("은하");
		Crew nonExistentCrew = CrewRepository.getCrewByName("줄리");

		assertEquals(Course.BACKEND, backendCrew.getCourse());
		assertEquals(Course.FRONTEND, frontendCrew.getCourse());
		assertNull(nonExistentCrew);
	}

}
