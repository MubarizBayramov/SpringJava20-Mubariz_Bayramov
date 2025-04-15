package List;

import java.util.LinkedList;
public class ListMisallar {

	public static void main(String[] args) {
		LinkedList<String> l1 = new LinkedList<String>();
		cemle(2, 3, 6, 7);
	}

	// O(1)
	public static void cemle(int... a) {
		int cem = 0;
		for (int g : a) {
			cem += g;
		}
		for (int i = 1; i <= 100; i++) {
			System.out.println("salam");
		}
		System.out.println(cem);

	}

	// O(n^2)
	public static void cemle2(int... a) {
		int u = 0;
		int[] massivim = new int[a.length];
		for (int g : a) {
			massivim[u++] = g;
		}
		for (int i = 1; i <= 100; i++) {
			System.out.println("salam");
		}

	}

}