package pairmatching.Domain;

public class Mission {
	Course course;
	Level level;
	String missionName;

	public Mission(Course course, Level level, String missionName) {
		this.course = course;
		this.level = level;
		this.missionName = missionName;
	}
	public Course getCourse() {
		return course;
	}

	public Level getLevel() {
		return level;
	}

	public String getMissionName() {
		return missionName;
	}


}
