package List;

import java.util.ArrayList;
import java.util.Iterator;

public class iterator {
	public static void main(String[] args) {
	
	ArrayList<String> names = new ArrayList<String>();
	
	names.add("Orxan");
	names.add("Hesen");
	names.add("Adil");
	names.add("Senan");
	names.add("Kenan");
	
	for (String n: names) {
	System.out.println(n);
}
	///// iterator - tekrarlayici
	Iterator <String> it = names.iterator();
	while (it.hasNext()) {
		String n = it.next();
		System.out.println(n);
	}
	
}
}


