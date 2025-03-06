package az.devolopia.librarian_mubariz_bayramov.util;


import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.stereotype.Component;

import az.devolopia.librarian_mubariz_bayramov.exception.MyException;



@Component
public class MyFileReader {

	public String readFromFile(String fileName) throws MyException {
		String line = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("files/" + fileName));
			line = br.readLine();
			br.close();
		} catch (Exception e) {
			throw new MyException("fayldan oxunmadi", null, e.getMessage());
		}

		return line;
	}
}
