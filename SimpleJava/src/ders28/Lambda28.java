package ders28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Lambda28 {
	
	public static void main(String[] args) {
		
	
		List<String> names = new ArrayList<>();
		names.add("Adil");
		names.add("Babek");
		names.add("cavad");
		names.add("Cemil");
		names.add("Malik");

		
		
	 names.stream().forEach(System.out::println);
		
		 Predicate<String> p = new Predicate<String>() {

			 @Override
			public boolean test(String n) {

				return n.startsWith("C");
			}
		};
		
		

		 // names.stream().filter(p).map(n -> n.toUpperCase()). forEach(System.out::println);
		// names.stream().forEach(name->System.out.println(name));

//		for (String name : names) {
//			System.out.println(name);
//		}

	}

}


