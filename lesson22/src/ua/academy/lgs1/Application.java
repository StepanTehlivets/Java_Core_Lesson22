package ua.academy.lgs1;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {
	public static void main(String[] args) {
		Set<Game> listOfGames = new LinkedHashSet<>();

		listOfGames.add(new Game("GTA 3", 2002));
		listOfGames.add(new Game("Fallout 3", 2007));
		listOfGames.add(new Game("The Sims 4", 2013));
		listOfGames.add(new Game("Fifa 14", 2014));
		listOfGames.add(new Game("The Sims 3", 2008));
		listOfGames.add(new Game("Fallout 2", 2000));
		listOfGames.add(new Game("The Sims 2", 2004));
		listOfGames.add(new Game("The Sims 1", 2001));
		listOfGames.add(new Game("DAO", 2016));
		listOfGames.forEach(System.out::println);
		System.out.println("");
		
		List<Game> collect = listOfGames.stream().sorted(new GameNameComparator()).collect(Collectors.toList());
		collect.forEach(System.out::println);
		System.out.println("");
		
		List<Game> collect1 =listOfGames.stream().sorted().collect(Collectors.toList());
		collect1.forEach(System.out::println);
	}
}
