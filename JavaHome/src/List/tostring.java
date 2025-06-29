package List;

public class tostring {

	
	    public static void main(String[] args) {
	        StringBuilder sb = new StringBuilder("Salam");
	        sb.append(" Dünya");
	        sb.insert(6, "Java ");
	        sb.replace(0, 5, "Hello");
	        sb.reverse();

	        System.out.println(sb.toString());
	    }
	}


