package input;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import data.Agent;
import input.TXTInput;

public class TXTInputTest {


	@Test
	public void testLoadTxtFile() throws Exception {
		Agent agent = new Agent();
		agent.setName("Apostolos Zarras");
		agent.setAfm("130456093");
		
		File test= new File("C:\\Users\\user\\Desktop\\SoftwareDevelopment\\soft-devII-2024-project-material\\test_input_files\\test-TXT.txt");
		TXTInput input = new TXTInput(test);
		
		input.readFile();
		assertEquals(agent.getName(),input.getAgent().getName());
		assertEquals(agent.getAfm(),input.getAgent().getAfm());
	}

}


