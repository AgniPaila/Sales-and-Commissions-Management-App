package output;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import data.Salesman;

public class TXTReportTest {
	
	@Test
	public void exportTXTReportTest() throws IOException {
		
		Salesman salesman = new Salesman();
		salesman.setAfm("123456789");
		salesman.setName("Agni Paila");
		
		TXTReportGeneration report = new TXTReportGeneration(salesman);
		report.saveFile("123456789_SALES");
		
		String expected = "Name: Agni Paila" + "AFM: 123456789" + "Total Sales: 0.0" + "Trousers Sales: 0.0" + "Skirts Sales: 0.0" +
							"Shirts Sales: 0.0" + "Coats Sales: 0.0" + "Commission: 0.0";
				
		String actual = "";
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\eclipse-workspace\\phase1\\Reports\\123456789_SALES.txt"));
        String line = reader.readLine();
		while (line != null) {
			actual += line;
			line = reader.readLine();
		}
		reader.close();

		assertEquals(expected, actual);	
	}

}
