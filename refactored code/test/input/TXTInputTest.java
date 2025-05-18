package input;

import static org.junit.Assert.*;

import java.io.File;
import org.junit.Test;

import data.Salesman;

public class TXTInputTest {

	@Test
	public void testLoadTxtFile() throws Exception {
		Salesman salesman = new Salesman();
		salesman.setName("Apostolos Zarras");
		salesman.setAfm("130456093");
		
		File test= new File("C:\\Users\\user\\eclipse-workspace\\phase1\\test_input_files\\test-TXT.txt");
		TXTInput input = new TXTInput(test);
		
		input.readFile();
		assertEquals(salesman.getName(),input.getSalesman().getName());
		assertEquals(salesman.getAfm(),input.getSalesman().getAfm());
	}

}


