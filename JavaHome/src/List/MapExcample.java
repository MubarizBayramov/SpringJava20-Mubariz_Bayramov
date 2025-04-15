package List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapExcample {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>(); // Map

		ArrayList<String> names = new ArrayList<String>();// List
		names.add("Hesen");

		
		map.put("Adil", 2);
		map.put("Asef", 2);
		
		System.out.println(names); // list
		System.out.println(map); //map
	}

	
	
}

