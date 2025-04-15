package List;
import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {  //Növbə (birinci daxil olan birinci çıxır) prinsipinə əsaslanır.
	
	 
	    public static void main(String[] args) {
	        Queue<String> queue = new LinkedList<>();

	        queue.add("Mübariz");
	        queue.add("Rahid");
	        queue.offer("Ayşə");

	        System.out.println("Queue: " + queue); // [Mübariz, Rahid, Ayşə]

	        System.out.println("Peek: " + queue.peek()); // Mübariz
	        System.out.println("Poll: " + queue.poll()); // Mübariz çıxır
	        System.out.println("Queue after poll: " + queue); // [Rahid, Ayşə]
	    }
	}

	

