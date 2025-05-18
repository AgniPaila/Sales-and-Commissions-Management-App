package input;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import data.Agent;
import data.Receipt;
import input.Input;

public class InputTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testAddReceipt() throws Exception{
		File f= new File("C:\\Users\\user\\Desktop\\SoftwareDevelopment\\soft-devII-2024-project-material\\test_input_files\\test");
		
		TXTInput input = new TXTInput(f);
		Receipt receipt = new Receipt();
		Agent agent= new Agent();
		agent.setName("Apostolos Zarras");
		agent.setAfm("130456093");
		
		receipt.setReceiptID(1);			
		receipt.setDate("25/2/2014");
		receipt.setSales(2000);
		receipt.setItems(10);
		receipt.getCompany().setName("Hand Made Clothes");
		receipt.getCompany().getCompanyAddress().setCountry("Greece");
		receipt.getCompany().getCompanyAddress().setCity("Ioannina");
		receipt.getCompany().getCompanyAddress().setStreet("Kaloudi");
		receipt.getCompany().getCompanyAddress().setStreetNumber(10);
		agent.getReceipts().add(receipt);
		
        input.addReceipt();
		//Receipt expectedReceipt = new Receipt(4, "13/12/2023", 50.0f, "Health", new Company("XtremeStores", "Greece", "Ioannina", "Dodonis", 6));
		//assertEquals(expectedReceipt, tpManager.getTaxpayerHashMap().get(130456093).getReceiptHashMap().get(4));
	}
}
