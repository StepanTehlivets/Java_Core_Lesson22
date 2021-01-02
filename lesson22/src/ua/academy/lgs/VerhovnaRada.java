package ua.academy.lgs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class VerhovnaRada {
	private static VerhovnaRada single_instance = null;
	private ArrayList<Fraction> fractions = new ArrayList<Fraction>();

	private VerhovnaRada() {
	}

	public static VerhovnaRada VerhovnaRada() {
		if (single_instance == null) {
			single_instance = new VerhovnaRada();
		}
		return single_instance;
	}

	Supplier<Fraction> fraction = () -> {
		System.out.println("Enter name of new fraction");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		return new Fraction(name);
	};

	public void addFraction() {
		Consumer<Fraction> addLambda = fraction -> fractions.add(fraction);
		addLambda.accept(fraction.get());
		fractions.forEach(System.out::println);
	}

	public void deleteFraction() {
		Fraction fraction2 = fraction.get();
		Consumer<Fraction> deleteLambda = fraction -> fractions.remove(fraction);
		deleteLambda.accept(fraction2);
		fractions.forEach(System.out::println);

	}

	public void printFraction() {
		fractions.forEach(System.out::println);
	}

	public void showDeputies() {
		System.out.println("Enter name of fraction to show its deputies");
		Fraction fraction2 = fraction.get();
		ChooseFraction frOfVRToShow = (Fraction fraction) -> {
			Iterator<Fraction> iterator = fractions.iterator();
			while (iterator.hasNext()) {
				Fraction fr = iterator.next();
				if (fr.getName().equals(fraction.getName())) {
					fr.printListOfDeputies();
				}
			}
		};
		frOfVRToShow.get(fraction2);
	}

	public void addDeputyToFraction() {
		System.out.println("Enter name of fraction to add deputy");
		Fraction fraction2 = fraction.get();
		ChooseFraction frOfVRToAdd = (Fraction fraction) -> {
			Iterator<Fraction> iterator = fractions.iterator();
			while (iterator.hasNext()) {
				Fraction fr = iterator.next();
				if (fr.getName().equals(fraction.getName())) {
					fr.addDeputy();
				}
			}
		};
		frOfVRToAdd.get(fraction2);
	}

	public void deleteDeputyFromFraction() {
		System.out.println("Enter name of fraction to delete deputy");
		Fraction fraction2 = fraction.get();
		ChooseFraction frOfVRToDelete = (Fraction fraction) -> {
			Iterator<Fraction> iterator = fractions.iterator();
			while (iterator.hasNext()) {
				Fraction fr = iterator.next();
				if (fr.getName().equals(fraction.getName())) {
					fr.deleteDeputy();
					;
				}
			}
		};
		frOfVRToDelete.get(fraction2);
	}

	public void showBribers() {
		System.out.println("Enter name of fraction show its bribers");
		Fraction fraction2 = fraction.get();
		ChooseFraction frOfVRToShowBribers = (Fraction fraction) -> {
			Iterator<Fraction> iterator = fractions.iterator();
			while (iterator.hasNext()) {
				Fraction fr = iterator.next();
				if (fr.getName().equals(fraction.getName())) {
					fr.getListOfBribers();
				}
			}
		};
		frOfVRToShowBribers.get(fraction2);
	}

	public void showBiggestBriber() {
		System.out.println("Enter name of fraction show who take more bribes");
		Fraction fraction2 = fraction.get();
		ChooseFraction frOfVRToShowBiggestBriber = (Fraction fraction) -> {
			Iterator<Fraction> iterator = fractions.iterator();
			while (iterator.hasNext()) {
				Fraction fr = iterator.next();
				if (fr.getName().equals(fraction.getName())) {
					fr.getBiggestBriber();
					;
				}
			}
		};
		frOfVRToShowBiggestBriber.get(fraction2);
	}

	public void clearFraction() {
		System.out.println("Enter name of fraction delete all deputies");
		Fraction fraction2 = fraction.get();
		ChooseFraction frOfVRToClear = (Fraction fraction) -> {
			Iterator<Fraction> iterator = fractions.iterator();
			while (iterator.hasNext()) {
				Fraction fr = iterator.next();
				if (fr.getName().equals(fraction.getName())) {
					fr.getMembers().clear();
				}
			}
		};
		frOfVRToClear.get(fraction2);
	}
}

interface ChooseFraction {
	void get(Fraction fr);
}