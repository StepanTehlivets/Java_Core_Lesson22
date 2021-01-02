package ua.academy.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Fraction {
	private String name;
	private ArrayList<Deputy> members = new ArrayList<Deputy>();

	public Fraction(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Deputy> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Deputy> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Fraction [name=" + name + "]";
	}

	public Fraction() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((members == null) ? 0 : members.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	Supplier<Deputy> createDeputy = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter deputy surname");
		String surname = sc.next();
		System.out.println("Enter deputy name");
		String name = sc.next();
		System.out.println("Enter deputy age");
		int age = sc.nextInt();

		System.out.println("Does deputy take bribes?(Y/N)");
		boolean briberCheck = false;
		String briber = sc.next();

		while (true) {
			switch (briber) {
			case "Y": {
				briberCheck = true;
				break;
			}
			case "y": {
				briberCheck = true;
				break;
			}
			case "N": {
				briberCheck = false;
				break;
			}
			case "n": {
				briberCheck = false;
				break;
			}
			default: {
				System.out.println("Whong input");
				
			}
			}
			break;
		}

		return new Deputy(surname, name, age, briberCheck);

	};

	public void giveBribeToDeputy() {
		System.out.println("Please enter data of deputy to whom you want to give bribe");

		Deputy newDeputy = createDeputy.get();
		Bribe bribe = () -> {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter bribe size");
			int giveBribe = sc.nextInt();
			sc.close();
			return giveBribe;
		};
		int size = bribe.bribe();
		GiveBribe gb = () -> {
			Iterator<Deputy> iterator = members.iterator();

			while (iterator.hasNext()) {
				Deputy deputyToBribe = iterator.next();
				if (deputyToBribe.equals(newDeputy)) {
					deputyToBribe.giveBribe(size);
				}

			}

		};
		gb.bribe();
	}

	public void addDeputy() {
		System.out.println("Please enter needed data to add deputy");

		Deputy newDeputy = createDeputy.get();
		Consumer<Deputy> addLambda = deputy -> members.add(deputy);
		addLambda.accept(newDeputy);
		members.forEach(System.out::println);
	}

	public void deleteDeputy() {
		System.out.println("Please enter needed data to delete deputy");

		Deputy newDeputy = createDeputy.get();
		Consumer<Deputy> deleteLambda = deputy -> members.remove(deputy);
		deleteLambda.accept(newDeputy);
		members.forEach(System.out::println);

	}

	public void getListOfBribers() {
		List<Deputy> depList = members.stream().filter(deputy -> deputy.isBriber()).collect(Collectors.toList());
		depList.forEach(System.out::println);

	}

	public void getBiggestBriber() {
		Optional<Deputy> theBiggestBriber = members.stream().max(new DeputyBribeSizeComparator());
		System.out.println(theBiggestBriber);
	}

	public void printListOfDeputies() {

		members.forEach(System.out::println);

	}
}

interface Bribe {
	int bribe();
}

interface GiveBribe {
	void bribe();
}
