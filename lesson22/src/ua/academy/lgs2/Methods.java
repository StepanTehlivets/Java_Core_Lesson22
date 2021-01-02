package ua.academy.lgs2;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Methods {
	static Supplier<Commodity> create = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter commodity name");
		String name = sc.next();
		System.out.println("Enter commodity width");
		Double width = sc.nextDouble();
		System.out.println("Enter commodity length");
		Double length = sc.nextDouble();
		System.out.println("Enter commodity weight");
		Double weight = sc.nextDouble();

		Commodity comm = new Commodity(name, width, length, weight);
		return comm;
	};
	static Manipulator add = (set) -> {
		Commodity commodity = create.get();
		set.add(commodity);
		set.forEach(System.out::println);
	};

	static Manipulator remove = (set) -> {
		Commodity commodity = create.get();
		set.remove(commodity);
		set.forEach(System.out::println);
	};

	static Manipulator switchCommodity = (set) -> {
		System.out.println("Enter data of commodity to be subtracted");
		remove.manipulate(set);
		System.out.println("Enter data new commodity");
		add.manipulate(set);
		set.forEach(System.out::println);
	};

	static Manipulator sortByLength = (set) -> {
		List<Commodity> sorted = set.stream().sorted(new CommodityLengthComparator()).collect(Collectors.toList());
		set.clear();
		set.addAll(sorted);
		set.forEach(System.out::println);
	};

	static Manipulator sortByWeight = (set) -> {
		List<Commodity> sorted = set.stream().sorted(new CommodityWeightComparator()).collect(Collectors.toList());
		set.clear();
		set.addAll(sorted);
		set.forEach(System.out::println);
	};
	static Manipulator sortByName = (set) -> {
		List<Commodity> sorted = set.stream().sorted(new CommodityNameComparator()).collect(Collectors.toList());
		set.clear();
		set.addAll(sorted);
		set.forEach(System.out::println);
	};
	static Manipulator sortByWidth = (set) -> {
		List<Commodity> sorted = set.stream().sorted(new CommodityWidthComparator()).collect(Collectors.toList());
		set.clear();
		set.addAll(sorted);
		set.forEach(System.out::println);
	};
	static Manipulator showIElement = (set) -> {
		System.out.println("Enter number of element you want to print(range from 0 to " + (set.size() - 1) + ")");
		Scanner sc = new Scanner(System.in);
		int index = sc.nextInt();
		LinkedList<Commodity> ll = new LinkedList<Commodity>();
		ll.addAll(set);
		System.out.println(ll.get(index));

	};

}

interface Manipulator {
	void manipulate(LinkedHashSet<Commodity> set);
}