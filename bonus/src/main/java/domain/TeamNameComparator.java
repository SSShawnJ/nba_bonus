package domain;

import java.util.Comparator;

public class TeamNameComparator implements Comparator<Team> {

	public int compare(Team t1, Team t2) {
		return  t1.getTeam_name().compareTo(t2.getTeam_name());
	}

	


}
