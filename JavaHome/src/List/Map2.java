package List;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
public class Map2 {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		ArrayList<String> names = new ArrayList<String>();
		
	names.add("Orxan");
	names.add("Hesen");
	names.add("Adil");
	names.add("Senan");
	names.add("Kenan");
	names.add("Polad");
	names.add("Hesen");
	names.add("Eli");
	names.add("Senan");
	names.add("Elsen");
	for(String name : names) {
		if(map.containsKey(name)) {
			Integer count = map.get(name);
			count++;
			map.replace(name, count);
		}else 
			map.put(name, 1);
		}
	System.out.println(map);
	System.out.println(map.size());// adlarin sayi
	}
}
