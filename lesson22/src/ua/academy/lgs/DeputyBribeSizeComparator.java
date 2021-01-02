package ua.academy.lgs;

import java.util.Comparator;


public class DeputyBribeSizeComparator implements Comparator<Deputy> {

	@Override
	public int compare(Deputy o1, Deputy o2) {
		
		return o1.getBribeSize()<o2.getBribeSize()?1:-1;
	}

}
