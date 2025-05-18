package input;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import data.Salesman;

public class HTMLInputTest {

	@Test
	public void testLoadHtmlFile() throws Exception {
		Salesman salesman = new Salesman();
		salesman.setName("Nikos Zarras");
		salesman.setAfm("130456093");
		
		File test= new File("C:\\Users\\user\\eclipse-workspace\\phase1\\test_input_files\\test-HTML.html");
		HTMLInput input = new HTMLInput(test);
		
		input.readFile();
		assertEquals(salesman.getName(),input.getSalesman().getName());
		assertEquals(salesman.getAfm(),input.getSalesman().getAfm());
	}

}
