package List;

	import java.util.ArrayList;

	public class StreamApi {

		public static void main(String[] args) {

			ArrayList<String> names = new ArrayList<String>();

	names.add("Orxan");
	names.add("Hesen");
	names.add("Adil");
	names.add("Senan");
	names.add("Kenan");
	for(String name : names) {
		System.out.println(name);
		
	
		
	}
	
	names.stream().forEach(System.out::println); //stream(axin) api
	
	
	names.stream().filter(e -> e.startsWith("R")).map(e -> e.toUpperCase()).forEach(System.out::println);

}
	}