package input;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import data.Salesman;
import data.Receipt;

public class InputTest {

	@Test
	public void testAddReceiptTXT() throws Exception {
		File f = new File("C:\\Users\\user\\eclipse-workspace\\phase1\\test_input_files\\test-TXT.txt");
		
		TXTInput input = new TXTInput(f);
		input.readFile();
		Salesman salesman = input.getSalesman();
		
		Receipt receipt = new Receipt("Coat");
		
		receipt.setReceiptID(2);			
		receipt.setDate("25/2/2014");
		receipt.setSales(2000);
		receipt.setItems(10);
		receipt.getCompany().setName("Hand Made Clothes");
		receipt.getCompany().getCompanyAddress().setCountry("Germany");
		receipt.getCompany().getCompanyAddress().setCity("Ioannina");
		receipt.getCompany().getCompanyAddress().setStreet("Kaloudi");
		receipt.getCompany().getCompanyAddress().setStreetNumber(10);
		
		salesman.getReceipts().add(receipt);
        input.addReceipt();
		
		assertEquals(receipt, salesman.getReceipts().get(1));
	}
	
	@Test
	public void testAddReceiptXML() throws Exception {
		File f = new File("C:\\Users\\user\\eclipse-workspace\\phase1\\test_input_files\\test-XML.xml");
		
		XMLInput input = new XMLInput(f);
		input.readFile();
		Salesman salesman = input.getSalesman();
		
		Receipt receipt = new Receipt("Coat");
		
		receipt.setReceiptID(2);			
		receipt.setDate("25/2/2014");
		receipt.setSales(2000);
		receipt.setItems(10);
		receipt.getCompany().setName("Hand Made Clothes");
		receipt.getCompany().getCompanyAddress().setCountry("Germany");
		receipt.getCompany().getCompanyAddress().setCity("Ioannina");
		receipt.getCompany().getCompanyAddress().setStreet("Kaloudi");
		receipt.getCompany().getCompanyAddress().setStreetNumber(10);
		
		salesman.getReceipts().add(receipt);
        input.addReceipt();
        
		assertEquals(receipt, salesman.getReceipts().get(1));
	}
}
