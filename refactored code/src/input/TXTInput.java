package input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TXTInput extends Input{

	public TXTInput(File recieptFileTXT){
		this.inputFile = recieptFileTXT;
		inputFilePath =  inputFile.getAbsolutePath();
	}
	
	public void readFile()  {
		BufferedReader br = null;
	    try {	
			br = new BufferedReader(new FileReader(inputFilePath));
		} catch (FileNotFoundException e1) {
				e1.printStackTrace();
		}
	    String line;
	    
	    try {
	    	name = readFieldFromFile(br);
	    	afm = readFieldFromFile(br);
			addSalesman();
			
			line = skipLinesWithoutContent(br); 
			while(line.startsWith("Receipt ID")){
				receiptID = (Integer.parseInt(line.substring(line.indexOf(":") + 1).trim()));
				date = readFieldFromFile(br);
				kind = readFieldFromFile(br);
				sales = (Double.parseDouble(readFieldFromFile(br)));
				items = (Integer.parseInt(readFieldFromFile(br)));
				companyName = readFieldFromFile(br);
				companyCountry =  readFieldFromFile(br);
				companyCity =  readFieldFromFile(br);
				companyStreet =  readFieldFromFile(br);
				companyStreetNumber =  (Integer.parseInt(readFieldFromFile(br)));
				addReceipt();
				 
				if (( br.readLine()) != null) {
					line = br.readLine();
					System.out.println(line);
				}else {
					break;
				}	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	    try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String skipLinesWithoutContent(BufferedReader br) throws IOException {
		String line = br.readLine();;
		for(int i=0; i<3; i++) {
			line = br.readLine();
		}
		return line;
	}

	private String readFieldFromFile(BufferedReader br) throws IOException {
		String line;
		line = br.readLine();
		return (line.substring(line.indexOf(":") + 1).trim());
	}
	
}
