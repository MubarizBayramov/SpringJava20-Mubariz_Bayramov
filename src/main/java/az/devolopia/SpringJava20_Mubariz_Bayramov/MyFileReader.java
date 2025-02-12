package az.devolopia.SpringJava20_Mubariz_Bayramov;



import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.stereotype.Component;

@Component
public class MyFileReader {

	public String readFromFile(String fileName) throws Exception {

		BufferedReader br = new BufferedReader(new FileReader("files/" + fileName));
		String line = br.readLine();
		br.close();
		return line;
	}
}