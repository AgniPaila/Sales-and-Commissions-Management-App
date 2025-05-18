package input;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import data.Agent;
import input.XMLInput;

public class XMLInputTest {


	@Test
	public void testLoadXmlFile() throws Exception {
		Agent agent = new Agent();
		agent.setName("Vassileios Zarras");
		agent.setAfm("130456097");
		
		File test= new File("C:\\Users\\user\\Desktop\\SoftwareDevelopment\\soft-devII-2024-project-material\\test_input_files\\test-XML.xml");
		XMLInput input = new XMLInput(test);
		
		input.readFile();
		assertEquals(agent.getName(),input.getAgent().getName());
		assertEquals(agent.getAfm(),input.getAgent().getAfm());
	}

}
