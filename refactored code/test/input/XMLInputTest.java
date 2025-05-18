package input;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import data.Salesman;

public class XMLInputTest {

	@Test
	public void testLoadXmlFile() throws Exception {
		Salesman salesman = new Salesman();
		salesman.setName("Vassileios Zarras");
		salesman.setAfm("130456097");
		
		File test= new File("C:\\Users\\user\\eclipse-workspace\\phase1\\test_input_files\\test-XML.xml");
		XMLInput input = new XMLInput(test);
		
		input.readFile();
		assertEquals(salesman.getName(),input.getSalesman().getName());
		assertEquals(salesman.getAfm(),input.getSalesman().getAfm());
	}

}
