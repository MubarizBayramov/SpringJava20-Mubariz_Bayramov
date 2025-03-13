package ders28;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main1 {

	

	public static void main(String[] args) {
		
		
	List<String> myList new ArrayList<>();
		myList.add("kia");
		myList.add("ford");
		myList.add("al");
		myList.add("de");
		myList.add("asd");
		myList.add("fg");
		myList.add("rt");
		
		
			
		
		
		
		MyGenerik<Integer> o1 = new MyGenerik<>();
		o1.toy = 33;

		MyGenerik<String> o2 = new MyGenerik<>();
		o2.toy = "Apple";

		List<String> myList = new ArrayList<>();
		myList.add("kia");
		myList.add("ford");
		myList.add("bmw");
		myList.add("byd");
		myList.add("opel");
		myList.add("nissan");
		myList.add("mercedes");
		myList.add("toyota");
		myList.add("bmw");
		myList.add("tesla");
		System.out.println(myList);

		String e = myList.get(2); /// ikinci indeksdekini verir
		System.out.println(e);  // 0 indeksi verir
		
		myList.remove("nissan"); // nissan; silir
		System.out.println(myList.size()); // siyahini verir
		myList.contains("nissan"); // elementin var olub olmadigini yoxlayir
		myList.remove(0); /// indekse gore silinme

		
		Set<String> mySet = new HashSet<>();
		
 		
		
		
		Set<String> mySet = new HashSet<>();
		mySet.add("toyota");
		mySet.add("bmw");
		mySet.add("tesla");
		mySet.add("bmw");
		System.out.println(mySet); //adlari tekrarlamadan siyahini verir/ bmv nin birini gostermir

		Set<String> treeSet = new TreeSet<>();
		treeSet.add("toyota");
		treeSet.add("bmw");
		treeSet.add("tesla");
		treeSet.add("bmw");
		treeSet.addAll(myList); 

		System.out.println(treeSet);// unikoda gore tekrarsiz ardicilligi verir 

	}

}