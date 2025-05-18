package output;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


import org.junit.Test;

import data.Salesman;

public class XMLReportTest {
	
	@Test
	public void exportXMLReportTest() throws IOException {
		
		Salesman salesman = new Salesman();
		salesman.setAfm("987654321");
		salesman.setName("Konstantina Stergiou");
		
		XMLReportGeneration report = new XMLReportGeneration(salesman);
		report.saveFile("987654321_SALES");
		
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + "<Agent>" + "<Name>Konstantina Stergiou</Name>" 
							+ "<AFM>987654321</AFM>" + "<TotalSales>0.0</TotalSales>" + "<TrouserSales>0.0</TrouserSales>" 
							+ "<SkirtsSales>0.0</SkirtsSales>" + "<ShirtsSales>0.0</ShirtsSales>" + "<CoatsSales>0.0</CoatsSales>" 
							+ "<Commission>0.0</Commission>" + "</Agent>" ;

		String actual = "";
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\user\\eclipse-workspace\\phase1\\Reports\\987654321_SALES.xml"));
        String line = reader.readLine();
		while (line != null) {
			actual += line.trim();
			line = reader.readLine();
		}
		reader.close();

		assertEquals(expected, actual);	
	}

}