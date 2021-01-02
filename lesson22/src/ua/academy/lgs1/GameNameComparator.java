package ua.academy.lgs1;

import java.util.Comparator;

public class GameNameComparator implements Comparator<Game> {

	@Override
	public int compare(Game o1, Game o2) {
		if (o1.getName().compareTo(o2.getName()) > 0) {
			return 1;
		} else if (o1.getName().compareTo(o2.getName()) < 0) {
			return -1;
		}
		return 0;
	}

}
