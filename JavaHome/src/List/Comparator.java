package List;

import java.util.ArrayList;
import java.util.Collections;

public class Comparator {
	public static void main(String[] args) {
		Car kia1 = new Car(20, "k5");
		Car kia2 = new Car(24, "k1");
		Car kia3 = new Car(12, "k3");
		Car ford = new Car(34, "fusion");

		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Orxan");
		names.add("Hesen");
		names.add("Adil");
		names.add("Senan");
		names.add("Kenan");
		System.out.println(names);
		Collections.sort(names);
		System.out.println(names);

		ArrayList<Car> cars = new ArrayList<Car>();
		cars.add(kia1);
		cars.add(kia2);
		cars.add(kia3);
		cars.add(ford);
		System.out.println(cars);
		Collections.sort(cars, (o1, o2) -> o1.getPrice() - o2.getPrice());
		System.out.println(cars);
		Collections.sort(cars, (o1, o2) -> o1.getModel().compareTo(o2.getModel()));
		System.out.println(cars);

	}

}


