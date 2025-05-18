package output;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import data.Salesman;

public class HTMLReportTest {

	@Test
	public void exportHTMLReportTest() throws IOException {
		
		Salesman salesman = new Salesman();
		salesman.setAfm("123456789");
		salesman.setName("Agni Paila");
		
		HTMLReportGeneration report = new HTMLReportGeneration(salesman);
		report.saveFile("123456789_SALES.html");
		
		String expected = "<html><h2>Name: Agni Paila</h2>" + "<h3>AFM: 123456789</h3>" + "<p>Total Sales: 0.0</p>" + "<p>Trousers Sales: 0.0</p>" +
		"<p>Skirts Sales: 0.0</p>" + "<p>Shirts Sales: 0.0</p>" + "<p>Coats Sales: 0.0</p>" + "<p>Commission: 0.0</p></html>";
				
		String actual = "";
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\eclipse-workspace\\phase1\\Reports\\123456789_SALES.html"));
        String line = reader.readLine();
		while (line != null) {
			actual += line;
			line = reader.readLine();
		}
		reader.close();

		assertEquals(expected, actual);	
	}

}